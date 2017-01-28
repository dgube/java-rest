# java-rest
## Synopsis

Project contatins one JUnit test case that is using following rest API https://jsonplaceholder.typicode.com/ and:
* Gets a random user (userID) , print its address to output and verifies email format is correct
* Gets associated posts for the user above and verifies they contain a valid id, title and body
* Does a post using same userID with a valid title and body


## Libraries used 

- [junit](https://mvnrepository.com/artifact/junit/junit)
- [jersey-client](https://mvnrepository.com/artifact/com.sun.jersey/jersey-client)
- [jackson-core](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core)
- [jackson-annotations](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
- [jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
- [commons-validator](https://mvnrepository.com/artifact/commons-validator/commons-validator)
- [log4j](https://mvnrepository.com/artifact/log4j/log4j)
- [commons-lang](https://mvnrepository.com/artifact/commons-lang/commons-lang)


## Installation

The project is a simple maven projet hosted on github.
To install a a git client go to [Git](https://git-scm.com/downloads)
To install/configure maven plese check: [Maven installation](http://maven.apache.org/install.html)  
  
  
Once setup is done just checkout the project by running:

**_git clone https://github.com/dgube/java-rest.git_**

The test can be found under /java-rest/src/test/java/edu/test/javarest/AppTest.java  
  
  
To run the tests just change to root folder of the project and execute:  

**_mvn test_**


If everything was ok you shoulud see the test being executed and the following summary:  

====================================================================================================  
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.005 sec  

Results :  

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0  

[INFO] ------------------------------------------------------------------------  
[INFO] BUILD SUCCESS  
[INFO] ------------------------------------------------------------------------  
[INFO] Total time: 7.191 s  
[INFO] Finished at: 2017-01-28T12:11:07+02:00  
[INFO] Final Memory: 10M/245M  
[INFO] ------------------------------------------------------------------------  

