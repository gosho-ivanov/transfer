# PharmacyDB

## 📦 Общо описание на базата данни

`PharmacyDB` е примерна MongoDB база данни, създадена с цел симулация и управление на информация, свързана с аптека. Тя съдържа данни за лекарства, клиенти, рецепти, служители и продажби. Базата поддържа CRUD операции и агрегиращи заявки, които демонстрират реални бизнес сценарии като проследяване на наличности, обобщаване на продажби и анализ на рецепти.

---

## 🗃️ Колекции и структура на документите

### 🧪 `medicines`
Съдържа информация за лекарства.

```json
{
  "medicineId": Number,
  "name": String,
  "category": String,
  "price": Number,
  "stock": Number,
  "ingredients": [String]
}
```

---

### 👥 `customers`
Съдържа данни за клиентите на аптеката.

```json
{
  "customerId": Number,
  "name": String,
  "phone": String,
  "prescriptions": [Number],
  "allergies": [String]
}
```

---

### 📄 `prescriptions`
Представя рецепти, предписани от лекари.

```json
{
  "prescriptionId": Number,
  "customerId": Number,
  "medicineId": Number,
  "prescribedDate": String,
  "quantity": Number,
  "doctor": String
}
```

---

### 👨‍⚕️ `employees`
Съдържа информация за служителите в аптеката.

```json
{
  "employeeId": Number,
  "name": String,
  "position": String,
  "fullTime": Boolean,
  "salary": Number
}
```

---

### 💰 `sales`
Съхранява информация за направените продажби.

```json
{
  "saleId": Number,
  "medicineId": Number,
  "customerId": Number,
  "quantity": Number,
  "saleDate": String,
  "totalPrice": Number
}
```

---

## 🛠️ Инструкции за инсталиране и стартиране

### 1. Инсталиране на MongoDB
Уверете се, че имате инсталирана MongoDB Community Server. Може да се изтегли от: https://www.mongodb.com/try/download/community

### 2. Стартиране на MongoDB сървъра
```bash
mongod
```

### 3. Стартиране на Mongo Shell или MongoDB Compass

### 4. Импортиране на базата данни

- Отворете Mongo Shell:
```bash
mongosh
```

- Изпълнете следната команда за използване на базата:
```js
use("pharmacyDB");
```

- Копирайте и изпълнете съдържанието на `insert.js`, за да създадете и напълните базата с данни.

### 5. Изпълнение на заявки

- Изпълнете съдържанието на `queries.js`, за да приложите различни заявки – четене, обновяване, изтриване и агрегиране.

---

## 📂 Файлове

- `insert.js` – Създаване и пълнене на колекциите с документи.
- `queries.js` – CRUD + Aggregate заявки за всяка колекция.
- `README.md` – Документация и инструкции.