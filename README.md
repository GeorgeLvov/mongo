# Spring Boot with MongoDB
Simple CRUD-application based on Spring-Boot with MongoDB

# Mongo installation

Start a container with MongoDB:

```
docker run -d -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=secret mongo:6.0
```

# Requests

1. Create company:

```
POST http://localhost:8080/companies
```
``` json
{
    "name": "International Business Machines",
    "acronym": "IBM",
    "address": {
    "city": "New-York",
    "postalCode": "10001",
    "street": "590 Madison Avenue"
}
```

2. Create employees:

```
POST http://localhost:8080/employees
```
``` json
{
    "name": "Robert",
    "birthDate": "1992-02-05",
    "gender": "male",
    "external": true
}
```
```
POST http://localhost:8080/employees
```
``` json
{
    "name": "Anna",
    "birthDate": "1988-01-23",
    "gender": "female",
    "external": false
}
```

3. Add employees to company:
```
POST http://localhost:8080/companies/64b430a53d5acc5ce7f22e22/employees
```
``` json
[
    "64b430bd3d5acc5ce7f22e23",
    "64b430ca3d5acc5ce7f22e24"
]
```