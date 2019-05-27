## Setup

```
git clone https://github.com/trushev/demo.git
```

```
cd demo
```

```
./mvnw install dockerfile:build
```

```
docker run -p 8080:8080 -t springio/demo
```

## Endpoint

* POST /users

```
{
  "name": "user",
  "password": "123"
}
```

* POST /products

```
{
  "name": "product",
  "price": 400,
  "inStock": 5
}
```

* POST /orders

```
{
  "amount": 4,
  "userId": 1,
  "productId": 2
}
```
