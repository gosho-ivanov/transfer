from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from fastapi import Query
from pydantic import BaseModel
import mysql.connector

app = FastAPI()

# ---------- CORS ----------
app.add_middleware(
    CORSMiddleware,
    allow_origins=[
        "http://127.0.0.1:5500",
        "http://localhost:5500"
    ],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# ---------- DB CONNECTION ----------
db = mysql.connector.connect(
    host="localhost",
    user="root",
    password="",
    database="softuni",
    unix_socket="/tmp/mysql.sock"
)

cursor = db.cursor(dictionary=True)

# ---------- MODELS ----------
class EmployeeCreate(BaseModel):
    first_name: str
    middle_name: str | None = None
    last_name: str
    job_title: str
    department_id: int
    salary: float
    address_id: int | None = None
    manager_id: int | None = None


# ---------- GET ALL EMPLOYEES ----------
@app.get("/employees")
def get_employees(
    sort: str | None = Query(None),
    order: str = Query("asc"),
    limit: int | None = None
):
    # Whitelisted sortable columns
    sort_columns = {
        "employee_id": "e.employee_id",
        "full_name": "CONCAT_WS(' ', e.first_name, e.middle_name, e.last_name)",
        "job_title": "e.job_title",
        "department": "d.name",
        "salary": "e.salary",
        "address_text": "a.address_text",
        "town": "t.name"
    }

    try:
        sql = """
        SELECT 
            e.employee_id,
            CONCAT_WS(' ', e.first_name, e.middle_name, e.last_name) AS full_name,
            e.job_title,
            d.name AS department,
            e.salary,
            a.address_text,
            t.name AS town
        FROM employees e
        LEFT JOIN departments d ON d.department_id = e.department_id
        LEFT JOIN addresses a ON a.address_id = e.address_id
        LEFT JOIN towns t ON t.town_id = a.town_id
        """

        # ✅ ONLY add ORDER BY if user requested sorting
        if sort and sort in sort_columns:
            direction = "ASC" if order.lower() == "asc" else "DESC"
            sql += f" ORDER BY {sort_columns[sort]} {direction}"

        if limit:
            sql += " LIMIT %s"
            cursor.execute(sql, (limit,))
        else:
            cursor.execute(sql)

        return cursor.fetchall()

    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

# ---------- GET EMPLOYEE BY ID ----------
@app.get("/employees/{employee_id}")
def get_employee(employee_id: int):
    cursor.execute(
        "SELECT * FROM employees WHERE employee_id = %s",
        (employee_id,)
    )
    employee = cursor.fetchone()

    if not employee:
        raise HTTPException(status_code=404, detail="Employee not found")

    return employee


# ---------- CREATE EMPLOYEE ----------
@app.post("/employees", status_code=201)
def create_employee(emp: EmployeeCreate):
    try:
        sql = """
        INSERT INTO employees
        (first_name, middle_name, last_name, job_title, department_id, salary, address_id, manager_id)
        VALUES (%s, %s, %s, %s, %s, %s, %s, %s)
        """
        cursor.execute(sql, (
            emp.first_name,
            emp.middle_name,
            emp.last_name,
            emp.job_title,
            emp.department_id,
            emp.salary,
            emp.address_id,
            emp.manager_id
        ))
        db.commit()

        return {
            "employee_id": cursor.lastrowid,
            **emp.dict()
        }

    except mysql.connector.Error as e:
        raise HTTPException(status_code=400, detail=str(e))


# ---------- UPDATE EMPLOYEE ----------
@app.put("/employees/{employee_id}")
def update_employee(employee_id: int, emp: EmployeeCreate):
    cursor.execute(
        "SELECT employee_id FROM employees WHERE employee_id = %s",
        (employee_id,)
    )
    if not cursor.fetchone():
        raise HTTPException(status_code=404, detail="Employee not found")

    try:
        sql = """
        UPDATE employees
        SET
            first_name=%s,
            middle_name=%s,
            last_name=%s,
            job_title=%s,
            department_id=%s,
            salary=%s,
            address_id=%s,
            manager_id=%s
        WHERE employee_id=%s
        """
        cursor.execute(sql, (
            emp.first_name,
            emp.last_name,
            emp.job_title,
            emp.department_id,
            emp.salary,
            emp.address_id,
            emp.manager_id,
            employee_id
        ))
        db.commit()

        return {"message": "Employee updated"}

    except mysql.connector.Error as e:
        raise HTTPException(status_code=400, detail=str(e))


# ---------- DELETE EMPLOYEE ----------
@app.delete("/employees/{employee_id}")
def delete_employee(employee_id: int):
    cursor.execute(
        "SELECT employee_id FROM employees WHERE employee_id = %s",
        (employee_id,)
    )
    if not cursor.fetchone():
        raise HTTPException(status_code=404, detail="Employee not found")

    try:
        cursor.execute(
            "DELETE FROM employees WHERE employee_id = %s",
            (employee_id,)
        )
        db.commit()
        return {"message": "Employee deleted"}

    except mysql.connector.Error as e:
        raise HTTPException(status_code=400, detail=str(e))
