# Backbase Transaction Service #

This Service acts as a proxy application between backbase and OpenApi. The aim is to fetch transactional
 data from OpenApi and map that to Backbase field then present this info to clients via the following 
 Apis:
 * Get List of Transactions
 * Get List of Transactions Via Transaction Type
 * Total Amount of all Transactions
 
 The following frameworks were used:
* [Spring](https://spring.io/projects/spring-boot)
* [Dependencies] Managed by [gradle](https://gradle.org/)  

### Starting the Service? ###
This service uses Tomcat and is set to run on port 5000 which can also be reconfigured. The Application 
properties can be [found here](/src/main/resources/application.yaml)


### Starting the application
The main class you need to run is **com.bring.transaction.TransactionApplication**. The App will run on default profile if not set but you can configure the specific Spring for profile for this purpose. For that you'll need to add the following _VM option_:
```
-Dspring.profiles.active=dev
```

or expose this environment variable :
```
export SPRING_PROFILES_ACTIVE=dev
```

(Remember to restart your IDE for these settings to take effect)


If you are able to access http://localhost:5000/login everything is started correctly, and you're good to go. 
To login the service while running see your terminal console, spring generates a password for you to use. The user name is 
```
usename: user
password: see terminal is a generate value
```


### Api Use and Docs ###
All the apis in the service are well document and can be accessed via http://localhost:5000/swagger-ui.html. This may at time land you to the login page
if that's the case see the login instruction above. Once authenticated, you will have access to swagger, and you can make calls to the api bit clicking 
on the transaction controller, select api and click Try out the select Execute Now.


### Running Test ###
Part of the application behaviour is to ensure both unit and integration test for various business cases are properly tested and everything is running as expected.
To run the test run 
```
./gradlew clean build
```
We use gradle to run test and ensure the application is in a Running states. If the BUILD IS SUCCESSFUL then all test passed and application can run correctly.
### Who do I talk to? ###

* Repo owner :
 ```
Victor Abedi Nyangweso 
Ph: 254791013102
Email: iamvictorabedi@gmail.com
Linkedin: https://www.linkedin.com/in/iamvictorabedi/
```
