# Cinema project
# Table of Contents
* [Purpose of the project](#purpose)
* [Structure of the project](#structure)
* [For developers](#for-developers)
* [Authors of the project](#authors)
<a name="purpose"></a>
# Purpose
This project is an implementation of a movie tickets booking system written in Java.
***
There are two roles for registered users: USER and ADMIN.
The following actions are available to everyone:
* login
* logout
* create a user account

Actions available to admins only:
* add new movies to the database
* manage movie sessions in the cinema
* manage cinema halls
* view all users' order history

Actions available to users only:
* view all available movie sessions
* add tickets to the shopping cart and create orders

<a name="stucture"></a>
# Structure
* Java 11
* Maven 4.0.0
* javax.annotation-api 1.3.2
* log4j 1.2.17
* spring-orm 5.2.7.RELEASE
* spring-webmvc 5.2.7.RELEASE
* spring-context 5.2.7.RELEASE
* spring-security-core 5.2.7.RELEASE
* spring-security-web 5.2.7.RELEASE
* javax.servlet-api 3.0.1
* mysql-connector-java 8.0.20
<a name="for-developers"></a>
# For developers
Clone this project into some folder on your computer.
Open the project in your IDE.

Configure Tomcat Server.

Add SDK 13.0.1 to the project structure.

Change your log file path in src/main/resources/log4j2.xml on line 10.

Configure your database properties in the db.properties file located in the resources folder.

Make sure MySQL server is running when launching the application.

<a name="authors"></a>
# Authors
[Anastasiia Kosiak](https://github.com/AnastasiiaKosiak)

