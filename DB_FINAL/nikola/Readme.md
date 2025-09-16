# ClothingStoreDB

## Общо описание на базата данни

`ClothingStoreDB` е MongoDB база данни, предназначена за управление на онлайн или физически магазин за дрехи. Тя поддържа основните функции на търговията на дребно като съхранение на продукти, клиенти, поръчки, служители и категории. Проектът е структуриран така, че да поддържа CRUD операции, филтриране, агрегации и аналитични заявки.

## Колекции и структура на документите

### 1. `products`
Съхранява информация за артикулите, предлагани в магазина.
- `name`: Име на продукта (string)
- `category`: Категория (string)
- `price`: Цена (number)
- `sizes`: Размери (array of strings)
- `tags`: Тагове (array of strings)
- `stock`: Наличност (number)
- `supplier`: Обект с информация за доставчика (name, country)
- Може да съдържа допълнителни полета като `reviews`, `discount`, `availableColors`, `seasonal`, `limitedEdition`

### 2. `customers`
Запазва информация за клиентите на магазина.
- `name`: Име на клиента (string)
- `email`: Имейл адрес (string)
- `address`: Обект с `city` и `street`
- `phone`: Телефонен номер (string)
- Допълнителни полета: `wishlist`, `preferences`, `subscribed`, `birthday`, `reviews`, `loyaltyPoints`, `interests`

### 3. `orders`
Съдържа направените поръчки.
- `customerId`: ID на клиента (number)
- `products`: Масив с имена на продукти (array of strings)
- `total`: Обща сума (number)
- `status`: Статус на поръчката (string)
- `payment`: Обект със `method` и `date`
- Може да съдържа `reason` за отказ

### 4. `employees`
Данни за служителите на магазина.
- `name`: Име на служителя (string)
- `role`: Длъжност (string)
- `salary`: Заплата (number)
- `schedule`: Обект с начало и край на работен ден (start, end)
- `fullTime` / `partTime`: Булеви стойности
- Може да съдържа `departments` и `shift`

### 5. `categories`
Описание на различни категории продукти.
- `name`: Име на категорията (string)
- `description`: Описание (string)
- Допълнителни атрибути: `popular`, `featured`, `seasonal`

## Инсталация и стартиране

1. Уверете се, че MongoDB е инсталиран и работи локално.

2. Клонирайте или изтеглете проекта и отворете терминал в папката му.

3. Стартирайте Mongo shell:
```bash
mongo
```

4. Изпълнете базовата инициализация:
```js
load("insert.js")
load("queries.js")
```

Това ще създаде базата от данни, ще добави примерни данни и ще изпълни основни заявки върху нея.

## Поддръжка и разширения
Може лесно да се разшири с нови колекции като `suppliers`, `returns`, `promotions` и да се свърже с front-end или back-end система чрез MongoDB драйвери или ORM библиотеки.
