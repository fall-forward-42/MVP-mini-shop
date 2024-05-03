
# Theoretical foundation



# Technologies used:
## Spring Boot
Spring Boot is a framework that simplifies the development of Java applications, especially web applications. It provides a streamlined way to set up and configure Spring-based applications with minimal boilerplate code. Spring Boot includes features such as auto-configuration, which automatically configures dependencies based on the classpath, and embedded servers, which allow applications to be run without the need for a separate server installation.
## Spring Security  (JWT Authentication used)
Spring Security is a powerful and highly customizable security framework for Java applications. It provides authentication and authorization functionalities to secure your application. In this project, JWT (JSON Web Token) authentication is used, which is a stateless and secure way to authenticate and authorize users. JWTs are used to securely transmit information between parties as a JSON object.
## Spring Data JPA
Spring Data JPA is a part of the Spring Data project that provides an easy and efficient way to interact with databases using the Java Persistence API (JPA). It simplifies the implementation of data access layers by providing automatic repository implementation, query generation, and transaction management. Spring Data JPA reduces the amount of boilerplate code required for database operations.
## MySQL
MySQL is an open-source relational database management system (RDBMS) that is widely used for web applications. It provides a robust and scalable database solution with support for ACID (Atomicity, Consistency, Isolation, Durability) properties. MySQL is compatible with various programming languages and frameworks, including Java and Spring Boot.
## ReactJs
ReactJS is a JavaScript library for building user interfaces. It allows developers to create reusable UI components and build complex user interfaces efficiently. ReactJS follows a component-based architecture, where each component manages its own state and updates the UI efficiently using a virtual DOM. ReactJS is widely used for building single-page applications and provides a smooth and responsive user experience.
## Redux Toolkits
Redux Toolkit is a package that simplifies the management of state in React applications. It provides a set of tools and utilities to manage the global state of an application, including actions, reducers, and the Redux store. Redux Toolkit helps to eliminate boilerplate code and improves developer productivity by providing a more intuitive and efficient way to handle application state.
These technologies were chosen for their effectiveness, scalability, and compatibility with each other. They work together to create a robust and secure web application with efficient data handling and a responsive user interface.

# What is Annotation in Spring Boot and the common Annotations used in the project:
## What is Annotation in Spring Boot?
In Spring Boot, Annotations are a way to provide metadata to your source code, helping the framework understand how to implement the components of your application. This enables Spring Boot to automatically configure and manage the components easily.
## Common Annotations used in the project:
- @RestController:
Annotates a Controller to handle RESTful requests.
Combines both @Controller and @ResponseBody.
- @RequestMapping:
  Maps HTTP requests to a handling method in the Controller.
  Defines the URI and HTTP method (GET, POST, PUT, DELETE) for the handling.
- @Autowired:
  Specifies that a field or method will be injected with a dependency by the Spring container.
- @Service, @Repository, @Component:
- @Service: Specifies that a class is a service.
- @Repository: Specifies that a class is a repository, typically used for accessing a database.
- @Component: Marks a class as a Spring component, which can be managed and have dependencies managed.
- @Configuration, @Bean:
- @Configuration: Marks a class that contains methods to create Beans.
- @Bean: Marks a method that returns an object managed by Spring.
- @PostMapping, @GetMapping, @PutMapping, @DeleteMapping:
  Corresponding to the HTTP methods POST, GET, PUT, DELETE.

  # Database Design:
  ## Physical-level ERD:
  ![Untitled](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/352728df-af32-4191-b8c5-e00733209fd7)
  ### Explain:
  The Entity-Relationship Diagram (ERD) provided illustrates the relationships between various entities in the database schema. The relationships depicted in the ERD showcase how different tables interact with each other. For instance, the relationship between "Categories" and "Products" is established as a one-to-many relationship, where each category can have multiple products. This is facilitated by the "category_id" in the "Products" table, which acts as a foreign key referencing the primary key "category_id" in the "Categories" table. Similarly, relationships such as "Users" and "Carts," "Users" and "Orders," "Products" and "Cart Items," "Orders" and "Order Items," and "Carts" and "Cart Items" are defined to maintain data consistency and integrity. These relationships help in organizing and managing data effectively, ensuring that related entities are interconnected and can be accessed cohesively within the database system.

  # Project Directory Structure:
  # General Structure:
![allstruct](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/fe7caa1b-f408-451d-82fe-28db74b2924b)

### Controller:
![controller](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/856ba7a8-4e6e-4364-8917-35dbb8139e48)
- The controller folder contains classes that handle incoming HTTP requests, process the requests, and return appropriate responses.
- Controllers use annotations like @RestController and @RequestMapping to define endpoints and map request URLs to specific methods.
- Controllers interact with services to delegate business logic execution.
  
### Service:
![service](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/1f979d41-c47b-4760-9427-0b1e0e76a1ce)

- The service folder houses classes that contain business logic and perform specific operations on the data.
- Services encapsulate the application's business logic and are responsible for processing data, applying rules, and interacting with repositories.
- Services are typically called by controllers to handle business operations.
### Security:
![secu](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/d3179cc1-df2c-4cc7-a687-332935afcf4f)
- The security folder contains classes related to security configurations and settings in the application.
- Security classes define authentication, authorization, and access control rules using Spring Security features.
- Security configurations ensure that endpoints are secure and define roles and permissions for users.



### Repository:
![repo](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/5cb3535a-ac13-49a7-916d-cbbf5410a3a0)
- The repository folder contains classes that interact with the database, typically using Spring Data JPA.
- Repository classes define database operations such as querying, saving, updating, and deleting entities.

- Repositories are responsible for data access and communication with the underlying database.


### DTO (Data Transfer Object):
![dto](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/95aa4498-56f9-4ae5-813b-d7f094820b6a)
- The DTO folder contains classes that represent data transfer objects used for transferring data between layers of the application.
- DTO classes define the structure of data exchanged between the frontend, backend, and external systems.
- DTOs help in decoupling the data model from the presentation layer.


### Mapper:
![mapper](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/6c639ae4-2c16-49c1-8a34-73c78d55321f)
- The mapper folder contains classes that handle mapping between different data structures, such as entities and DTOs.
- Mapper classes convert data from one format to another, facilitating communication between layers of the application.
- Mappers help in transforming data to meet the requirements of different components.

### Entity:
![entity](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/77e55773-df62-45ed-8cc1-9419000b4697)
- The entity folder contains classes that represent database entities or domain objects.
- Entity classes map to database tables and define the structure of the data stored in the database.

- Entities are typically annotated with JPA annotations to define relationships and mappings.



### Config:
![config](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/3831c24f-37f4-49d0-ac42-4f582b7fb1b7)
- The config folder contains classes that define configuration settings for the application.

- Configuration classes set up beans, define properties, and configure various aspects of the application.
- Configuration classes are used to customize the behavior of the application.

### Exception:
![ex](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/a2baaf51-c316-4592-b31c-155ada109067)
- The exception folder contains classes that handle exceptions and errors that occur during the application's execution.
- Exception classes define custom exception types, handle error responses, and provide meaningful error messages to users.
- Exception handling classes help in gracefully managing errors and maintaining application stability.

# Run project
1. Initial Database in MySQL
```
CREATE DATABASE lihiShop
```

2. Change your application.properties
```
spring.application.name=lihitiShop
spring.datasource.url=jdbc:mysql://[127.0.0.1:3306 or your localhost]/lihishop
spring.datasource.username=root
spring.datasource.password=[your password]
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```
3. Run procject in IDE
4. Url for APIs:
```
localhost:8080
```
# API endpoints
## All of endpoints:
• POST: /api/auth/register: Register a new account.
• POST: /api/auth/login: Log in to the system.• GET: /api/users: Get a list of users.
• GET: /api/users/single: Get information of a specific user.
• GET: /api/categories: Get a list of product categories.
• GET: /api/products: Get a list of products.• POST: /api/products: Create a new product.
• POST: /api/products/search-by-category: Search for products by category.
• DELETE: /api/products/{id}: Delete a specific product by ID.
• POST: /api/carts: Add a product to the shopping cart.
• GET: /api/carts: Get a list of products in the shopping cart.
• PUT: /api/carts/update-quantity-item: Update the quantity of a product in the shopping cart.
• DELETE: /api/carts/delete-item: Remove a product from the shopping cart.
• GET: /api/carts/submit: Place an order and make payment from the shopping cart.
• GET: /api/orders/: Get a list of all orders for a user.
• GET: /api/orders/{id}: Get detailed information of a specific order by ID.
=> These API endpoints define the various operations that can be performed in the system. They allow users to register and log in, manage user accounts, retrieve lists of users, categories, and products, create and search for products, manage the shopping cart, place orders, and retrieve order information.
## Practise in Postman
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/80b39307-5256-411c-8a8d-a1dc60ab2e01)
Method: GET
Endpoint:
```
localhost:8080/api/auth/register
```

