Toll Payment Processing System
Overview
This project is a Spring Boot application that simulates toll gate payment processing for vehicles on a highway. It includes RESTful APIs and a simple user interface built with Thymeleaf templates. The system allows managing toll gates, processing vehicle journeys with VAT discounts, and tracking payments and revenues.

The project demonstrates backend development with Spring Boot, database persistence with MySQL, and frontend templating with Thymeleaf.

Features
Manage toll gates with configurable charges per vehicle type

Process vehicle journeys with toll calculations and VIP discounts

Track journeys and total toll amounts paid per vehicle

REST APIs for journey submission and data retrieval

Simple interactive web UI using Thymeleaf templates

Persistent storage with MySQL and Spring Data JPA

Installation and Running
Download or clone the repository to your local machine.

Create a MySQL database named tolldb and update application.properties with your DB credentials.

Navigate to the project root directory in terminal.

Build the project with Maven:

text
mvn clean install
Run the Spring Boot application:

text
mvn spring-boot:run
Open your browser and visit:

text
http://localhost:8080/
to access the web UI.

API Endpoints
Method	Endpoint	Description
POST	/api/journey	Submit a new vehicle journey (via query params)
GET	/api/vehicles	Get list of all vehicles and their journeys
GET	/api/tollgates	Get toll gates information and revenue data
Example API Request
POST request to start journey:

text
POST http://localhost:8080/api/journey?vehicleNo=TN123&vehicleType=CAR&isVip=false&start=0&destination=1
Controls (Using UI)
Navigate via homepage links

Submit journey details with form inputs for vehicle no, type, VIP status, start and destination toll index

View vehicles and their journeys

View toll gate revenue and charges

Project Structure
text
project-root/
└── src/
    ├── main/
    │   ├── java/com/toll/api/
    │   │    ├── controller/    
    │   │    ├── model/        
    │   │    └── service/
    │   └── resources/
    │        ├── templates/    
    │        └── application.properties
    └── pom.xml                
Screenshots



![Home page with navigation links](images/toll1.png)  
![Form to submit a vehicle journey](images/toll2.png)  
![Displays vehicles and their journeys](images/toll3.png)  
![Shows toll gate charges and revenue](images/toll4.png)  

Api Testing 

![Api testing 1](images/tollapi1.png) 
![Api test 2](images/tollapi2.png) 
![Api test 3](images/tollapi3.png) 

Future Improvements
Add next-piece preview and hold piece functionality

Implement advanced routing options and toll calculations

Add user authentication and role-based access

Improve UI with modern frontend frameworks

Add detailed reports and analytics of toll usage
