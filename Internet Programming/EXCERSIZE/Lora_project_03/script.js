const API_URL = "https://api.escuelajs.co/api/v1/products";

/* ============================
   GET ALL PRODUCTS
============================ */
async function getProducts() {
    const tbody = document.getElementById("productBody");
    tbody.innerHTML = "<tr><td colspan='5'>Loading...</td></tr>";

    try {
        const response = await fetch(API_URL);
        const products = await response.json();

        tbody.innerHTML = "";

        products.forEach(p => {
            const row = document.createElement("tr");

            row.innerHTML = `
                <td>${p.title}</td>
                <td>$${p.price}</td>
                <td>${p.description}</td>
                <td>${p.category?.name || "N/A"}</td>
                <td>
                    <a href="edit.html?id=${p.id}" class="link-btn" style="padding:6px 10px;">Edit</a>
                    <button onclick="deleteProduct(${p.id})" style="padding:6px 10px;">Delete</button>
                </td>
            `;

            tbody.appendChild(row);
        });

    } catch (error) {
        tbody.innerHTML = "<tr><td colspan='5'>Error loading products.</td></tr>";
        console.error(error);
    }
}


/* ============================
   ADD PRODUCT (POST)
============================ */
async function addProduct() {
    const title = document.getElementById("title").value.trim();
    const price = document.getElementById("price").value.trim();
    const description = document.getElementById("description").value.trim();
    const msg = document.getElementById("addMessage");
    const categoryId = document.getElementById("category").value;


    // Validation
    if (!title || !price || !description || !categoryId) {
        msg.textContent = "All fields are required.";
        msg.style.color = "red";
        return;
    }

    if (price <= 0) {
        msg.textContent = "Price must be a positive number.";
        msg.style.color = "red";
        return;
    }
    
    const newProduct = {
        title,
        price: Number(price),
        description,
        categoryId: Number(categoryId),
        images: ["https://placeimg.com/640/480/any"]
    };


    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newProduct)
        });

        const data = await response.json();
        msg.textContent = "Product added successfully!";
        msg.style.color = "green";

        console.log("Added:", data);

        // Redirect after a short delay
        setTimeout(() => {
            window.location.href = "index.html";
        }, 800);

    } catch (error) {
        msg.textContent = "Error adding product.";
        msg.style.color = "red";
        console.error(error);
    }
}

/* ============================
   UPDATE PRODUCT (PUT)
============================ */
async function updateProduct() {
    const id = document.getElementById("productId").value.trim();
    const title = document.getElementById("title").value.trim();
    const price = document.getElementById("price").value.trim();
    const description = document.getElementById("description").value.trim();
    const msg = document.getElementById("editMessage");
    const categoryId = document.getElementById("category").value;


    // Validation
    if (!id || !title || !price || !description || !categoryId) {
        msg.textContent = "All fields are required.";
        msg.style.color = "red";
        return;
    }

    if (price <= 0) {
        msg.textContent = "Price must be a positive number.";
        msg.style.color = "red";
        return;
    }

    const updatedProduct = {
        title,
        price: Number(price),
        description,
        categoryId: Number(categoryId)
    };

    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(updatedProduct)
        });

        const data = await response.json();
        msg.textContent = "Product updated successfully!";
        msg.style.color = "green";

        console.log("Updated:", data);
        setTimeout(() => {
            window.location.href = "index.html";
        }, 800);
    } catch (error) {
        msg.textContent = "Error updating product.";
        msg.style.color = "red";
        console.error(error);
    }
}

/* ============================
   DELETE PRODUCT
============================ */
async function deleteProduct(id) {
    if (!confirm(`Delete product #${id}?`)) return;

    try {
        await fetch(`${API_URL}/${id}`, { method: "DELETE" });
        alert("Product deleted.");
        getProducts(); // Refresh list
    } catch (error) {
        alert("Error deleting product.");
        console.error(error);
    }
}

/* ============================
   AUTO-FILL EDIT PAGE IF ?id=
============================ */
document.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);
    const productId = params.get("id");

    if (productId && document.getElementById("productId")) {
        document.getElementById("productId").value = productId;
    }
});


/* ============================
   AUTO-FILL EDIT PAGE IF ?id=
============================ */
document.addEventListener("DOMContentLoaded", async () => {
    const params = new URLSearchParams(window.location.search);
    const productId = params.get("id");

    if (productId && document.getElementById("productId")) {
        const productIdInput = document.getElementById("productId");
        productIdInput.value = productId;

        // Fetch product details
        try {
            const response = await fetch(`${API_URL}/${productId}`);
            const product = await response.json();

            document.getElementById("title").value = product.title;
            document.getElementById("price").value = product.price;
            document.getElementById("description").value = product.description;

            // Set category select if exists
            const categorySelect = document.getElementById("category");
            if (categorySelect) {
                categorySelect.value = product.category?.id || "";
            }

        } catch (error) {
            console.error("Error fetching product:", error);
        }
    }

    // Populate categories in add/edit forms
    const categorySelects = document.querySelectorAll("select.category-select");
    if (categorySelects.length) {
        try {
            const catResponse = await fetch("https://api.escuelajs.co/api/v1/categories");
            const categories = await catResponse.json();

            categorySelects.forEach(select => {
                select.innerHTML = categories.map(c => `<option value="${c.id}">${c.name}</option>`).join("");
            });
        } catch (error) {
            console.error("Error fetching categories:", error);
        }
    }
});
