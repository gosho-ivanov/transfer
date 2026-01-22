const BASE_URL = 'http://localhost:8000/products';

async function loadProducts() {
  const status = document.getElementById('status');
  status.textContent = 'Loading...';
  const tbody = document.getElementById('productTableBody');
  tbody.innerHTML = '';
  try {
    const res = await fetch(BASE_URL);
    if (!res.ok) {
      status.textContent = 'Failed to load products.';
      return;
    }
    const data = await res.json();
    data.forEach(function (p) {
      const tr = document.createElement('tr');
      const tdId = document.createElement('td');
      tdId.textContent = p.id;
      const tdTitle = document.createElement('td');
      tdTitle.textContent = p.title;
      const tdPrice = document.createElement('td');
      tdPrice.textContent = p.price;
      const tdDesc = document.createElement('td');
      tdDesc.textContent = p.description;
      const tdActions = document.createElement('td');
      const editBtn = document.createElement('button');
      editBtn.textContent = 'Edit';
      editBtn.addEventListener('click', function () {
        window.open('edit.html?id=' + encodeURIComponent(p.id), 'Edit Product', 'width=420,height=620');
      });
      const delBtn = document.createElement('button');
      delBtn.textContent = 'Delete';
      delBtn.style.backgroundColor = '#8b2e2e';
      delBtn.addEventListener('click', async function () {
        const ok = confirm('Delete product ' + p.id + '?');
        if (!ok) return;
        alert("Deleted product successfully.");
        await deleteProduct(p.id);
        loadProducts();
      });
      tdActions.appendChild(editBtn);
      tdActions.appendChild(delBtn);
      tr.appendChild(tdId);
      tr.appendChild(tdTitle);
      tr.appendChild(tdPrice);
      tr.appendChild(tdDesc);
      tr.appendChild(tdActions);
      tbody.appendChild(tr);
    });
    status.textContent = '';
  } catch (error) {
    status.textContent = 'Error loading products.';
  }
}

async function getProductById(id) {
  try {
    const res = await fetch(BASE_URL + '/' + encodeURIComponent(id));
    if (!res.ok) return null;
    return await res.json();
  } catch (e) {
    return null;
  }
}

async function createProduct(product) {
  const res = await fetch(BASE_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(product)
  });
  if (!res.ok) throw new Error('create failed');
  return await res.json();
}

async function updateProduct(id, product) {
  const res = await fetch(BASE_URL + '/' + encodeURIComponent(id), {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(product)
  });
  if (!res.ok) throw new Error('update failed');
  return await res.json();
}

async function deleteProduct(id) {
  const res = await fetch(BASE_URL + '/' + encodeURIComponent(id), {
    method: 'DELETE'
  });
  return res.ok;
}

window.loadProducts = loadProducts;
window.getProductById = getProductById;
window.createProduct = createProduct;
window.updateProduct = updateProduct;
window.deleteProduct = deleteProduct;
