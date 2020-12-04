# OrdersManagement

Orders Management is application using Spring Boot, Maven and PostgreSQL. It was created for manage transport orders for Freight forwarding company.

### Prerequisites

[Java 11](https://adoptopenjdk.net/)

If your OS is Windows you need to install [Docker Desktop for Windows](https://docs.docker.com/docker-for-windows/install-windows-home/).


## Getting Started

To install this OrdersManagement application, run the following commands:

```
git clone https://github.com/barbara-tyndorf/OrdersManagement.git
cd OrdersManagement
```

This will get a copy of the project installed locally.

Then start Docker Desktop to run docker on your system.

Next go back to command line in OrdersManagement directory and type:

```
docker-compose up -d
```

When docker container is running, you need to build project and resolving maven dependencies. Run:

```
mvnw package
```

That is it! You can start project with:

```
mvnw spring-boot:run
```

## Environments

To manage database in PostgreSQL Adminer please go to http://localhost:8085/ in your browser and set:

- `SYSTEM`: **PostgreSQL**
- `SERVER`: **postgres**
- `USERNAME`: **postgres**
- `PASSWORD`: **secret**
- `DATABASE` **orders**

Then Login. Now you can manage orders database.

## Relationships in orders database

![uml](https://user-images.githubusercontent.com/55435936/101206683-c20f8980-366f-11eb-88d2-f59bdd354a2c.jpg)

## Web

You can do every CRUD operations. I recomended to use [SwaggerUI](http://localhost:8080/swagger-ui.html#/).

For **findBy** and **update** methods better way to work with is  [Postman](https://www.postman.com/downloads/).



Available Methods:

- `ADDRESS`:

  - getAll,
  - add,
  - findById,
  - findByName,
  - update,
  - delete

- `CONTRACTOR`, `FORWARDER`, `ORDER`:

  - getAll,

  - add,

  - findById,

  - findBy - you can choose pair of params

    - for `CONTRACTOR`:

      *name* = "your value"

      *vatId* = "your value"

    - for `FORWARDER`:

      *firstName* = "your value" 

      *lastName* = "your value"

      *branch* = "your value"

    - for `ORDER`:

      customer = "your value" 

      carrier = "your value"

      loading_place = "provide loading place id (Long)"

      unloading_place = "provide unloading place id (Long)"

      forwarderId = "provide forwarder id (String)"

  - update (also with params)

  - delete

## Built With

- [Spring](https://start.spring.io/) - The Java framework used
- [Maven](https://maven.apache.org/) - Dependency Management
- [PostgreSQL](https://hub.docker.com/_/postgres) - Database from Docker Image

## Author

- **Barbara Tyndorf** - [LinkedIn Profile](https://www.linkedin.com/in/barbara-tyndorf/)