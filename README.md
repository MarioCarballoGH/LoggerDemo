# Logger Demo
Code Review / Refactoring exercise

## How to Run

### Prerequisites
* [Git](https://www.digitalocean.com/community/tutorials/how-to-contribute-to-open-source-getting-started-with-git)    
* [Java 1.8](https://www.oracle.com/technetwork/java/javase/overview/index.html)   
* [Maven 3.x](https://maven.apache.org/install.html)
* [Docker](https://www.docker.com/)   
### Steps

* ##### Clone source code from git.
```
$  git clone https://github.com/MarioCarballoGH/LoggerDemo.git 
```

* ##### Build the project by running `$ mvn clean install` inside the project folder.

* ##### Run project with Maven:
```
// Use using the following command:
$ mvn compile exec:java -Dexec.mainClass="org.example.App" -Dexec.cleanupDaemonThreads=false
```
* ##### Or with Docker:
```
// Build and start the container by running :
$ docker-compose up

// Stop Docker Container
$ docker-compose down
```
