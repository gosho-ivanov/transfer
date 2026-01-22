from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
import mysql.connector

app = FastAPI()

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
    user="root",
    password="",
    database="rest_api_db",
    unix_socket="/tmp/mysql.sock"
)

cursor = db.cursor(dictionary=True)

# ---------- MODELS ----------
class Product(BaseModel):
    title: str
    price: float
    description: str

# ---------- GET ALL (+ limit) ----------
@app.get("/products")
def get_products(limit: int | None = None):
    try:
        sql = "SELECT * FROM products"
        if limit:
            sql += " LIMIT %s"
            cursor.execute(sql, (limit,))
        else:
            cursor.execute(sql)

        return cursor.fetchall()
    except:
        raise HTTPException(status_code=500, detail="DB error")

# ---------- GET BY ID ----------
@app.get("/products/{product_id}")
def get_product(product_id: int):
    cursor.execute("SELECT * FROM products WHERE id = %s", (product_id,))
    product = cursor.fetchone()

    if not product:
        raise HTTPException(status_code=404, detail="Item not found")

    return product

# ---------- CREATE ----------
@app.post("/products", status_code=201)
def create_product(product: Product):
    try:
        sql = """
        INSERT INTO products (title, price, description)
        VALUES (%s, %s, %s)
        """
        cursor.execute(sql, (product.title, product.price, product.description))
        db.commit()

        return {
            "id": cursor.lastrowid,
            **product.dict()
        }
    except:
        raise HTTPException(status_code=500, detail="DB error")

# ---------- UPDATE ----------
@app.put("/products/{product_id}")
def update_product(product_id: int, product: Product):
    cursor.execute("SELECT * FROM products WHERE id = %s", (product_id,))
    if not cursor.fetchone():
        raise HTTPException(status_code=404, detail="Item not found")

    try:
        sql = """
        UPDATE products
        SET title=%s, price=%s, description=%s
        WHERE id=%s
        """
        cursor.execute(sql, (
            product.title,
            product.price,
            product.description,
            product_id
        ))
        db.commit()

        return {
            "id": product_id,
            **product.dict()
        }
    except:
        raise HTTPException(status_code=500, detail="DB error")

# ---------- DELETE ----------
@app.delete("/products/{product_id}")
def delete_product(product_id: int):
    cursor.execute("SELECT * FROM products WHERE id = %s", (product_id,))
    if not cursor.fetchone():
        raise HTTPException(status_code=404, detail="Item not found")

    try:
        cursor.execute("DELETE FROM products WHERE id = %s", (product_id,))
        db.commit()
        return {"message": "Item deleted"}
    except:
        raise HTTPException(status_code=500, detail="DB error")
