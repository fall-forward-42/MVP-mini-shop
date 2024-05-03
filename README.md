
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
- The controller folder contains classes that handle incoming HTTP requests, process the requests, and return appropriate responses.
- Controllers use annotations like @RestController and @RequestMapping to define endpoints and map request URLs to specific methods.
- Controllers interact with services to delegate business logic execution.
### Service:
- The service folder houses classes that contain business logic and perform specific operations on the data.
- Services encapsulate the application's business logic and are responsible for processing data, applying rules, and interacting with repositories.
- Services are typically called by controllers to handle business operations.

