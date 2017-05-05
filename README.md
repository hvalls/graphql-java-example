# GraphQL Java Example
Example of a GraphQL HTTP server using Spring Boot and H2 database

## Running the server

```
$ git clone https://github.com/hvalls/graphql-java-example/

$ cd graphql-java-example

$ ./mvnw clean package spring-boot:run
```

## Querying

Unlike REST-based APIs, in GraphQL there is only one endpoint `/graphql` that accepts only one HTTP method: `POST` or `GET`.
In this example, `POST` requests (with `application/json` as content type) are expected. Query objects are passed in the 
request body.

### Fetch all the users

#### Request
```
POST /graphql
ContentType: application/json

{
    users {
        id
        name
        email
    }
}
```

#### Response

```
{
    "users": [
        {
            "id": 1,
            "name": "admin",
            "email": "admin@admin.com"
        },
        {
            "id": 2,
            "name": "john",
            "email": "john@gmail.com"
        },
        {
            "id": 3,
            "name": "sham",
            "email": "sham@yahoo.com"
        }
    ]
}
```

### Fetch one user by ID 

#### Request
```
POST /graphql
ContentType: application/json

{
    user(id: 1) {
        name
        email
    }
}
```

#### Response

```
{
    "user": {
        "name": "admin",
        "email": "admin@admin.com"
    }
}
```
