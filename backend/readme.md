# 📦 Spring Boot + MongoDB (Docker) – Complete Setup Guide

This project demonstrates how to run a **Spring Boot backend** with **MongoDB using Docker** and automatically load data from a JSON file at application startup.

---

# 🚀 Prerequisites

Make sure you have:

- ✅ Java 17+
- ✅ Maven
- ✅ Docker

---

# 🐳 Step 1: Run MongoDB using Docker

Run MongoDB container (no authentication):

```bash
docker run -d \
  --name mongodb \
  -p 27017:27017 \
  mongo:latest

docker ps

✅ Verify MongoDB Container
Shelldocker ps 
Expected Output
CONTAINER ID   IMAGE         COMMAND                  STATUS         PORTS
xxxxxxx        mongo:latest  "docker-entrypoint..."   Up             0.0.0.0:27017->27017/tcp


⚙️ Step 2: Configure Spring Boot
Update src/main/resources/application.properties:
.propertiesspring.data.mongodb.host=127.0.0.1spring.data.mongodb.port=27017spring.data.mongodb.database=productDb 

📂 Step 3: Add JSON Data
Create file:
src/main/resources/data/products.json

Example JSON
JSON[  { "name": "Laptop", "price": 50000 },  { "name": "Phone", "price": 20000 },  { "name": "Tablet", "price": 30000 },  { "name": "Headphones", "price": 5000 },  { "name": "Smartwatch", "price": 15000 }] 

▶️ Step 4: Run Application
Shellmvn clean spring-boot:run 

✅ Expected Application Logs
✅ ACTUAL DB: productDb
🚀 DummyDataLoader started...
✅ Loaded JSON records: 5
✅ Inserted count: 5


🧪 Step 5: Verify Data in MongoDB
Login to MongoDB shell:
docker exec -it mongodb mongosh 

test> use productDb
switched to db productDb

productDb> show collections
products

productDb> db.products.countDocuments()
500

productDb> db.products.find().limit(5).pretty()


✅ Fetch Data
JavaScriptdb.products.find().pretty() 
Output
[
  {
    _id: ObjectId('6a21130ef531f31836161856'),
    name: 'Laptop',
    price: 50000,
    _class: 'com.demo.db.dto.Product'
  },
  {
    _id: ObjectId('6a21130ef531f31836161857'),
    name: 'Phone',
    price: 20000,
    _class: 'com.demo.db.dto.Product'
  },
  {
    _id: ObjectId('6a21130ef531f31836161858'),
    name: 'Tablet',
    price: 30000,
    _class: 'com.demo.db.dto.Product'
  },
  {
    _id: ObjectId('6a21130ef531f31836161859'),
    name: 'Headphones',
    price: 5000,
    _class: 'com.demo.db.dto.Product'
  },
  {
    _id: ObjectId('6a21130ef531f3183616185a'),
    name: 'Smartwatch',
    price: 15000,
    _class: 'com.demo.db.dto.Product'
  }
]