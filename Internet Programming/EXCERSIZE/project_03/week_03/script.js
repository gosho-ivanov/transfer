const baseUrl = 'https://api.escuelajs.co/api/v1/products';

// 🧩 GET all products
async function getAllProducts() {
  try {
    const res = await fetch(baseUrl);
    const data = await res.json();
    return data;
  } catch (err) {
    alert('Грешка при зареждане на продукти!');
    console.error(err);
    return [];
  }
}

// 🧩 GET product by ID
async function getProductById(id) {
  try {
    const res = await fetch(`${baseUrl}/${id}`);
    return await res.json();
  } catch (err) {
    alert('Грешка при зареждане на продукт!');
    return null;
  }
}

// 🧩 POST create product
async function createProduct(product) {
  if (!validateProduct(product)) return false;
  try {
    const res = await fetch(baseUrl, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        title: product.title,
        price: product.price,
        description: product.description,
        categoryId: 1,
        images: ["https://placeimg.com/640/480/any"]
      })
    });
    if (!res.ok) throw new Error('Неуспешно създаване');
    alert('✅ Продуктът е създаден успешно!');
    return true;
  } catch (err) {
    alert('Грешка при създаване!');
    console.error(err);
    return false;
  }
}

// 🧩 PUT update product
async function updateProduct(id, product) {
  if (!validateProduct(product)) return false;
  try {
    const res = await fetch(`${baseUrl}/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        title: product.title,
        price: product.price,
        description: product.description,
      })
    });
    if (!res.ok) throw new Error('Неуспешно обновяване');
    alert('✅ Продуктът е обновен успешно!');
    return true;
  } catch (err) {
    alert('Грешка при обновяване!');
    console.error(err);
    return false;
  }
}

// 🧩 DELETE product
async function deleteProduct(id) {
  if (!confirm('Сигурни ли сте, че искате да изтриете този продукт?')) return;
  try {
    const res = await fetch(`${baseUrl}/${id}`, { method: 'DELETE' });
    if (res.status === 200 || res.status === 204) {
      alert(`✅ Продуктът с ID ${id} е изтрит успешно!`);
      window.location.reload();
    } else {
      alert('❌ Неуспешно изтриване!');
    }
  } catch (err) {
    alert('Грешка при изтриване!');
  }
}

// 🧩 Validation
function validateProduct({ title, price, description }) {
  if (!title || !description || isNaN(price) || price <= 0) {
    alert('Моля, въведете валидни данни!');
    return false;
  }
  return true;
}
