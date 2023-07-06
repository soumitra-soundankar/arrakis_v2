# Dogs APIs

![dogs](dogs_api.jpg)

In this example, we are creating crud operations and exposing them through REST APIs so that UI clients can invoke these operations. The demo operations enable the clients to modify the dogs records in database.

The purpose of this demo is to showcase the nuts and bolts, which make this interaction possible, not covering the complexity in business logic involved in real world applications.


# Let's get the back-end running!


## Prerequisites


### (You should already have most of this set up during training)

1.Download and Install OpenJDK 13 ([OpenJDK](http://jdk.java.net/java-se-ri/13)). For installation instructions, refer this [link](https://www.codejava.net/java-se/download-and-install-jdk-13-openjdk-and-oracle-jdk)

Make sure following Environment Variables are defined:

	JAVA_HOME = G:\JDK\OpenJDK\jdk-13
	
	PATH = %JAVA_HOME%\bin;…

2.Download and Install ([Maven](https://maven.apache.org/install.html))

   
# Getting Started
In this example, we’re gonna build a Spring Boot Rest CRUD API example with Maven that use Spring Data JPA to interact with MySQL/H2 database. You will know:

a. How to configure Spring Data, JPA, Hibernate to work with Database

b. How to define Data Models and Repository interfaces

c. Way to create Spring Rest Controller to process HTTP requests

d. Way to use Spring Data JPA to interact with H2/MySQL Database

# Project Flow

![This is an image](Business-Service-Controller-and-Repository.jpg)


# What is the CRUD operation?
The CRUD stands for Create, Read/Retrieve, Update, and Delete. These are the four basic functions of the persistence storage.

The CRUD operation can be defined as user interface conventions that allow view, search, and modify information through computer-based forms and reports. CRUD is data-oriented and the standardized use of HTTP action verbs. HTTP has a few important verbs.

Within a database, each of these operations maps directly to a series of commands. However, their relationship with a RESTful API is slightly more complex.

Standard CRUD Operation:

![curd](curd.PNG)

The CRUD operations refer to all major functions that are implemented in relational database applications. Each letter of the CRUD can map to a SQL statement and HTTP methods.

# Database 

H2 is an open-source lightweight Java database. It can be embedded in Java applications or run in the client-server mode

**Schema**

For this example we have a table called dog. Table is automatically created when springboot application starts using following schema.sql

	java-api\src\main\resources\schema.sql

You can modify this file to add new database tables.

**Data**

To populate data into table dog, we have used data.sql which has insert statements.

	java-api\src\main\resources\data.sql

**Database Connection Details**

Connection details are mentioned in the application.properties 

	java-api\src\main\resources\application.properties


# Steps to run the project on local machine

Git clone the code to local machine

	DELL@DESKTOP-ORE3T13 MINGW64 /c/DEV/GITHUB/project-arrakis/skeleton/java-api (java-skeleton)
	$ pwd
	/c/DEV/GITHUB/project-arrakis/skeleton/java-api

To run the maven project use following mvn command

	DELL@DESKTOP-ORE3T13 MINGW64 /c/DEV/GITHUB/project-arrakis/skeleton/java-api (java-skeleton)
	$ mvn clean spring-boot:run

**Once project is running :**

**REST API are exposed as:**

	http://localhost:8080/api/v1/dogs

![REST API](REST_API_URL.PNG)

**H2 Database Console:**

	http://localhost:8080/h2-console
	
![H2 Console](H2_CONSOLE.PNG)

![H2 Console 2](H2_CONSOLE2.PNG)


**Swagger Console**

Swagger2 is an open source project used to generate the REST API documents for RESTful web services. It provides a user interface to access our RESTful web services via the web browser. 

You also test the APIs using this.

![Swagger](SWAGGER.PNG)
	

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

