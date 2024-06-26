# Midterm Project of Java Technology - Le Hai Tien - 52101002 
# Introduce
The LishiShop Web Application is a comprehensive e-commerce platform that combines the power of Spring Boot, Spring Security, Spring Data JPA, MySQL, ReactJS, and Redux Toolkit to provide a secure and user-friendly shopping experience.
The backend of the application is built using Spring Boot, which exposes a set of APIs to handle various functionalities, such as user authentication, product management, and order processing. Spring Security with JWT (JSON Web Token) authentication is integrated to ensure the security of the application, allowing only authorized users to access sensitive information and perform critical actions.
The data management of the application is handled by Spring Data JPA, which provides an efficient and easy-to-use way to interact with the MySQL database, a robust and scalable relational database management system.
The frontend of the application is built using ReactJS, a popular JavaScript library for building user interfaces. ReactJS allows the creation of reusable UI components and efficient management of the application's state. To further enhance the state management, Redux Toolkit, a powerful library, is integrated to simplify the handling of complex state-related tasks.
The combination of these technologies creates a robust and scalable solution for the LishiShop Web Application, providing a secure and efficient API layer on the backend and a visually appealing and user-friendly interface on the frontend.
Users can browse the available products, add them to their shopping carts, and place orders, with the application's security measures ensuring the protection of user data and transactions.
Overall, the LishiShop Web Application is designed to cater to the needs of food enthusiasts, restaurant owners, and home cooks, offering a trusted and reliable platform for their culinary needs.
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
#### Explain for security folder:
##### JWTAuthFilter:
- This is a custom filter that extends OncePerRequestFilter and is responsible for validating and authenticating incoming requests using JWT tokens.
- It extracts the JWT token from the request header, validates the token, and sets the user's authentication in the SecurityContextHolder if the token is valid.
- This filter is used to ensure that requests are authenticated before they are processed by the application.
##### JWTutils:
- This is a utility class that provides methods for generating, validating, and extracting information from JWT tokens.
- It has a private SecretKey field that is used to sign and verify the tokens.
- The class provides methods for generating access tokens and refresh tokens, extracting claims from tokens, and validating token expiration.
- This utility class is used by the JWTAuthFilter to handle the JWT-related operations.
##### SecurityConfig:
- This is the Spring Security configuration class that sets up the security filter chain and defines the authorization rules for the application.
- It configures the CSRF and CORS settings, sets the session management policy to be stateless, and registers the authenticationProvider and 
##### jwtAuthFilter:
- The authorization rules are defined to allow public access to certain endpoints, restrict access to specific roles for other endpoints, and require authentication for all other requests.
- The configuration also sets up the DaoAuthenticationProvider and BCryptPasswordEncoder for user authentication and password hashing.



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
# API endpoints and UI
## All of endpoints:
- POST: /api/auth/register: Register a new account.
- POST: /api/auth/login: Log in to the system.• GET: /api/users: Get a list of users.
- GET: /api/users/single: Get information of a specific user.
- GET: /api/categories: Get a list of product categories.
- GET: /api/products: Get a list of products.• POST: /api/products: Create a new product.
- POST: /api/products/search-by-category: Search for products by category.
- DELETE: /api/products/{id}: Delete a specific product by ID.
- POST: /api/carts: Add a product to the shopping cart.
- GET: /api/carts: Get a list of products in the shopping cart.
- PUT: /api/carts/update-quantity-item: Update the quantity of a product in the shopping cart.
- DELETE: /api/carts/delete-item: Remove a product from the shopping cart.
- GET: /api/carts/submit: Place an order and make payment from the shopping cart.
- GET: /api/orders/: Get a list of all orders for a user.
- GET: /api/orders/{id}: Get detailed information of a specific order by ID.
=> These API endpoints define the various operations that can be performed in the system. They allow users to register and log in, manage user accounts, retrieve lists of users, categories, and products, create and search for products, manage the shopping cart, place orders, and retrieve order information.
## Practise in Postman
- Endpoint:
```
localhost:8080/api/auth/register
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/99e1ad6a-6440-49af-9cf1-d298ea373983)


- Endpoint:
```
localhost:8080/api/auth/login
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/9bafb8e4-0e1b-4534-ab27-f16786c1b5d9)


- Endpoint:
```
localhost:8080/api/users/single
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/72039d82-09ec-4e8c-83de-00107916ff90)


- Endpoint:
```
localhost:8080/api/categories
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/d3acbfe1-784b-447b-a534-397be1f8c506)


- Endpoint:
```
localhost:8080/api/categories
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/18d1c209-553a-41c8-a51d-3e2a4d9b2248)


- Endpoint:
```
localhost:8080/api/products
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/9480c0bc-6352-43d3-9cef-ba645b2a24ca)

- Endpoint:
```
localhost:8080/api/products
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/ea96dbc2-e9e9-4f85-bd0b-df303673cd79)



- Endpoint:
```
localhost:8080/api/products/search-by-category
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/f9453764-9eaf-4f55-a0c1-24dee1c2ab3a)

- Endpoint:
```
localhost:8080/api/products/{id}
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/7dc45f91-4141-4310-8a42-14fabb4383ad)

- Endpoint:
```
localhost:8080/api/carts (If it is not exist any item in your cart, create new cart)
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/40aae0f8-efd7-4f8b-abef-b7f526ee7f32)

- Endpoint:
```
localhost:8080/api/carts
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/a24f1e46-e841-4370-9526-5d0643f88b00)

- Endpoint:
```
localhost:8080/api/carts/update-quantity-item (change quantity from 2 into 7) 
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/cb1129e5-b752-4907-a287-295935e31710)

- Endpoint:
```
localhost:8080/carts/delete-item
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/83970efb-6ad6-44f4-86f4-53da70127466)

- Endpoint:
```
localhost:8080/api/carts/submit
```
- Explaint: System will get all items in your recent cart and make an order for this cart, then the previous cart will be deleted.
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/77e83f91-f28f-4d99-9c99-066e292d341b)

- Endpoint:
```
localhost:8080/api/orders/{id}
```
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/fdc50d65-1b61-41bf-9653-51bd881b6d85)

## User Interface (In progress)
## Follow this repo: https://github.com/fall-forward-42/MVP-lihishop-UI 
#### Login
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/818fc2bd-9840-4518-a60d-765a0d419943)
#### Products List
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/c789a528-207f-45fe-ae9b-8c4ceadaae1b)
#### The toast after choose item into your cart
[image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/82bef503-8523-4715-bf32-4960323e6477)
#### Show your cart
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/a7ba2798-a3b7-4fdf-84aa-8bfef7b8e941)

#### Show your Orders
![image](https://github.com/fall-forward-42/MVP-mini-shop/assets/89197595/09d95b9a-1d55-498d-9ec7-aed7de9a9a00)


