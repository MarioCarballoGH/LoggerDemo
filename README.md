# Logger Demo
Code Review / Refactoring exercise

## How to Run

### Prerequisites
* [Git](https://www.digitalocean.com/community/tutorials/how-to-contribute-to-open-source-getting-started-with-git)    
* [Java 1.8](https://www.oracle.com/technetwork/java/javase/overview/index.html)   
* [Maven 3.x](https://maven.apache.org/install.html)

### Steps

* ##### Clone source code from git.
```
$  git clone https://gitlab.com/MakoCarballo/carritocompra.git 
```

* ##### Create `tiendacarrito` database.

* ##### Build the project by running `$ mvn clean install` inside the project folder.

* ##### Run SpringBoot project by using one of the following commands:
```
// With Maven:
$ mvn spring-boot:run
```
or
```
// With Java:
$ java -jar .\target\demo-0.0.1-SNAPSHOT.jar
```


* ##### Test application.
```
$ curl http://localhost:8080/actuator/health
```

The respone should be:
```
{"status":"UP","components":{"db":{"status":"UP","details":{"database":"PostgreSQL","validationQuery":"isValid()"}},"diskSpace":{"status":"UP","details":{"total":499579633664,"free":315522486272,"threshold":10485760,"exists":true}},"ping":{"status":"UP"}}}
```
"# LoggerDemo" 
