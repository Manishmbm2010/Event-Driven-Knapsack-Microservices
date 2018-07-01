##Author

* **Manish Jain**

## Project : Event Driven Knapsack Micorservice (Knapsack solution as a Service) 

## Technology stack

1. Spring Boot for writing Microservice
2. Kafka for Event Store
3. STS(Spring tool suite) for code development
4. Maven for dependency management
5. Docker for containerizing the solution

##Microservice Archtiecture##

Solution contain 4 microservices running in separate docker containers.

1. User facing Input Microservice to get the knapsack problem in and provide the status and solution of individual problem.
2. Solution Microservice that just process the process the problem and post the solution back to kafka.
3. Admin Microservice , that always read for first two micorservice for new knapsack problem and any update on existing problem and update its state accordingly.

##Code provide "knapsack solution" as a service that runs in a docker container.
You can do below things via rest services
##
1. Submit knapsack probelm.
2. Retrive the task status and their solutions.
3. Get the complete list of tasks and the stage in which they are currently running.(stages = submitted ,started,completed).
 
### Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deploymentnotes to deploy the project on a live system.

### Prerequisites

Docker machine should be up and running and docker-compose should be installed

### Deployment

1. git clone https://github.com/Manishmbm2010/Event-Driven-Knapsack-Microservices.git
2. cd Event-Driven-Knapsack-Microservices
3. cd KnapSackInput/
4. docker run -it --rm -v "$PWD":/usr/src/app/ --volume "$HOME"/.m2:/root/.m2 -w /usr/src/app/ maven:3-jdk-8-alpine mvn clean install
5. cd ../KnapSackSolution/
6. docker run -it --rm -v "$PWD":/usr/src/app/ --volume "$HOME"/.m2:/root/.m2 -w /usr/src/app/ maven:3-jdk-8-alpine mvn clean install
7. cd ../KnapSackAdmin/
8. docker run -it --rm -v "$PWD":/usr/src/app/ --volume "$HOME"/.m2:/root/.m2 -w /usr/src/app/ maven:3-jdk-8-alpine mvn clean install
9. docker-compose up --build


### Rest end points

Input/Output Json format has been attached in separate file withe examples , Please have a look end_point_input_output_format.txt

* http://localhost:8090/knapsack/tasks 			(method=POST)
* http://localhost:8090/knapsack/tasks/{id}		(method=GET)
* http://localhost:8090/knapsack/solutions/{id}		(method=GET) 
* http://localhost:8080/knapsack/admin/tasks/		(method=GET)

Yet to Be configure:
* http://localhost:8080//knapsack/admin/logs		(method=GET)
* http://localhost:8080//knapsack/admin/health		(method=GET)
* http://localhost:8080//knapsack/admin/shutdown 	(method=POST)
* http://localhost:8080/v2/api-docs			(method=GET)
* http://localhost:8080/swagger-ui.html     

### Running the tests

Automated test case suit has not been added with the project.

### Time complexity for calculating the solution

Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


### Acknowledgments

* Find we few best resources for finalizing the design and completeing the project
* https://www.toptal.com/java/spring-boot-rest-api-error-handling
* https://spring.io/guides/gs/spring-boot-docker/
* Java Brains :  Spring Boot tutorail Series
* Sample youtube link :  https://www.youtube.com/watch?v=msXL2oDexqw&list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x


### Scope for improvement 

* This solution can be extended with the usage of persistent storage for real time production system, currently it uses system RAM/swap
* Currently solution has been designed with embedded derby database , can be updated with separate database image with persistent storage.
* Exception handling can be extended further.
* Logging can be enhanced.
* Comments can be added at many places to make the maintenace of code much simpler.



