const BASE_URL = 'http://localhost:8000/employees';

// ---------------- SORT STATE ----------------
let currentSortKey = null;
let sortAsc = true;

// ---------------- LOAD EMPLOYEES ----------------
async function loadEmployees(sort = null, order = 'asc') {
  const status = document.getElementById('status');
  const tbody = document.getElementById('employeeTableBody');

  status.textContent = 'Loading...';

  try {
    let url = BASE_URL;
    if (sort) {
      url += `?sort=${encodeURIComponent(sort)}&order=${order}`;
    }

    const res = await fetch(url);
    if (!res.ok) {
      status.textContent = 'Failed to load employees.';
      return;
    }

    const data = await res.json();

    // ✅ Build rows OFF-DOM to prevent flicker
    const fragment = document.createDocumentFragment();

    data.forEach(e => {
      const tr = document.createElement('tr');

      const td = (value) => {
        const cell = document.createElement('td');
        cell.textContent = value ?? '';
        return cell;
      };

      tr.appendChild(td(e.employee_id));
      tr.appendChild(td(e.full_name));
      tr.appendChild(td(e.job_title));
      tr.appendChild(td(e.department));
      tr.appendChild(td(e.salary));
      tr.appendChild(td(e.address_text));
      tr.appendChild(td(e.town));

      // ---------- ACTIONS ----------
      const tdActions = document.createElement('td');

      const editBtn = document.createElement('button');
      editBtn.textContent = 'Edit';
      editBtn.classList.add('edit');
      editBtn.addEventListener('click', () => {
        window.open(
          `edit.html?id=${encodeURIComponent(e.employee_id)}`,
          'Edit Employee',
          'width=420,height=620'
        );
      });

      const delBtn = document.createElement('button');
      delBtn.textContent = 'Delete';
      delBtn.classList.add('delete');
      delBtn.addEventListener('click', async () => {
        const ok = confirm(`Delete employee #${e.employee_id}?`);
        if (!ok) return;

        const success = await deleteEmployee(e.employee_id);
        if (success) {
          loadEmployees(currentSortKey, sortAsc ? 'asc' : 'desc');
        } else {
          alert('Delete failed.');
        }
      });

      tdActions.appendChild(editBtn);
      tdActions.appendChild(delBtn);
      tr.appendChild(tdActions);

      fragment.appendChild(tr);
    });

    // ✅ Swap rows in ONE operation → no flicker
    tbody.replaceChildren(fragment);
    status.textContent = '';

  } catch (err) {
    status.textContent = 'Error loading employees.';
  }
}

// ---------------- SORT HANDLERS ----------------
document.addEventListener('DOMContentLoaded', () => {
  // Attach sorting to table headers
  document.querySelectorAll('th[data-key]').forEach(th => {
    th.style.cursor = 'pointer';
    th.addEventListener('click', () => {
      const key = th.dataset.key;

      if (currentSortKey === key) {
        sortAsc = !sortAsc;
      } else {
        currentSortKey = key;
        sortAsc = true;
      }

      loadEmployees(key, sortAsc ? 'asc' : 'desc');
    });
  });
});

// ---------------- API HELPERS ----------------
async function getEmployeeById(id) {
  try {
    const res = await fetch(`${BASE_URL}/${encodeURIComponent(id)}`);
    if (!res.ok) return null;
    return await res.json();
  } catch {
    return null;
  }
}

async function createEmployee(employee) {
  const res = await fetch(BASE_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(employee)
  });

  if (!res.ok) throw new Error('Create failed');
  return await res.json();
}

async function updateEmployee(id, employee) {
  const res = await fetch(`${BASE_URL}/${encodeURIComponent(id)}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(employee)
  });

  if (!res.ok) throw new Error('Update failed');
  return await res.json();
}

async function deleteEmployee(id) {
  const res = await fetch(`${BASE_URL}/${encodeURIComponent(id)}`, {
    method: 'DELETE'
  });
  return res.ok;
}

// ---------------- EXPORTS ----------------
window.loadEmployees = loadEmployees;
window.getEmployeeById = getEmployeeById;
window.createEmployee = createEmployee;
window.updateEmployee = updateEmployee;
window.deleteEmployee = deleteEmployee;
