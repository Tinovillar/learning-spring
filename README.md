# *Learning Spring*

## Spring Core

First of all, we have different concepts in spring like Beans, Spring Context, Inversion of Control (IoC), Life Cycle, etc...

### Inversion of Control (IoC)

Has the ability to separate the concern of writing the code to take action from the concern of declaring when to take that action. This comes in handy when we are developing a complex system and we want to keep it clean and maintainable. Use the annotation @GetMapping is a good example, we dont worry about how to intercept the GET request but worry about what to do with it. This pattern allows us to separate what we want to do from when we want to do it with each part knowing as little as possible about the other, thus simplifying our design.

### Dependency Injection

Is a design pattern and a core feature that allows you to define the relationships between classes externally, rather than having the classes create their dependencies within themselves.

Overview of what can do for us in Spring context:

* Decoupling
* Reusability
* Testability
* Flexibility
* Scalability
* Centralized Configuration
* Reduced Boilerplate Code

#### Related Annotations:

@Autowired, @Component, @Qualifier, @Primary, @Resource, etc.

### Bean

A bean is an object that is instantiated, assembled, and managed by Spring IoC container. They represent the various components of the application, such as services, data sources, controllers, repositories, etc

#### Related Annotations:

@Component, @Service, @Repository, @Controller, etc.

### Spring Context

Is a container that manages the lifecycle of beans and their dependencies in a Spring application. It is the heart of Spring framework and provides the fundamental infrastructure for managing components (beans) and their relationships. Its created in different ways depending on the specific Spring application type. Glues together many components, facilitating the development of robus and scalable applications.

Is responsible for:

* Bean Instantiation
* Dependency Injection
* Lifecycle Management
* Scoping
* Configuration Management
* AOP (Aspect Oriented Programming)

#### Related Annotations:

@Configuration, @ComponentScan, etc.

# Soon...

## SPring Boot

## Spring Data

## Spring MVC

## Spring Security

## Spring AOP

## Spring Testing

## Spring RESTful Web Services
