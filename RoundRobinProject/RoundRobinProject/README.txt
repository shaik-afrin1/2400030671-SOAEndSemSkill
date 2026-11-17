ROUND-ROBIN LOAD BALANCING - VS CODE PROJECT

REQUIREMENTS
- JDK 17
- Maven (or use the Maven wrapper if you add one)
- Internet connection for Maven to download dependencies

OPENING
1. Extract RoundRobinProject.zip.
2. In VS Code, choose File > Open Folder and select the extracted RoundRobinProject folder.
3. Open 5 terminals. In each terminal, run the command from the project folder shown below.

START IN THIS ORDER

Terminal 1 - Eureka Server:
  cd eureka-server
  mvn spring-boot:run

Terminal 2 - Driver instance 1:
  cd driver-service
  mvn spring-boot:run

Terminal 3 - Driver instance 2:
  cd driver-service
  mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8082"

Terminal 4 - Driver instance 3:
  cd driver-service
  mvn spring-boot:run "-Dspring-boot.run.arguments=--server.port=8083"

Terminal 5 - API Gateway:
  cd api-gateway
  mvn spring-boot:run

NOTE: Run each command in a separate terminal. Terminal 2 uses the default port 8081.
Wait until all applications finish starting.

CHECK EUREKA:
Open http://localhost:8761
You should see DRIVER-SERVICE with three registered instances.

TEST:
Send repeated GET requests to:
  http://localhost:8080/drivers

The response shows which Driver Service port handled the request.
Round-robin order can vary initially depending on registration timing and load-balancer state.

STOP:
Press Ctrl+C in each terminal.

TROUBLESHOOTING
- If 'mvn' is not recognized, install Maven or use VS Code's Maven support.
- If a port is already in use, stop the application using it.
- If Gateway returns 503, check that all three Driver Service instances are registered in Eureka.
- Keep all three projects on the same Java version and compatible Spring Boot/Spring Cloud versions.
