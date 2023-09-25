# MongoDB

## Installation

```
docker build -t mongo-starter .
docker run -p 27017:27017 -d mongo-starter

mongosh -u root

test> use demo
demo> db.createUser({ user: "root", pwd: "toor", roles: [{role: "readWrite", db: "demo"}] });
```