# Fitbits

Design
------

- Directions:

  ^ - N

  v - S

  \> - E

  < - W


- Pitch of Dimension - X Y will be treated as :

(0,Y)\_\_..\_\_(X,Y)

 \|.....................\|
 
  ........................
 
 \|......................\|
 
 (0,0)\_\_..\_\_(X,0) 
  
  
- Assumption
 
   -- Input file has the data as per the problem specification
  
- Function Specification
  	
  	-- Pitch with dimensions X Y where X<=0 or Y <=0 will result in end of program execution with IllegalArgumentException.
 	-- For an invalid placement of trainee - beyond pitch boundary the program outputs empty line.
 	-- During the training , any instruction that causes trainee to move beyond the pitch will be silently ignored and subsequent instruction will be processed.

Prerequisites
-------------
- Set up JAVA_HOME env variable to point to JDK1.8 home dir
- Ensure JAVA_HOME/bin is on PATH environment variable

Build
-----
- From the root of project , execute below :
  - WINDOWS :  mvnw clean install 
  - Linux   : ./mvnw clean install

Execute
-------
- Execute using the generated jar as :
     java -jar target/fitbits-0.0.1-SNAPSHOT.jar <AbsolutePathToInputFile>

OR

- Execute directly using maven as : 
  - WINDOWS : mvnw -q exec:java -Dexec.args="<AbsolutePathToInputFile>"
  - LINUX : ./mvnw -q exec:java -Dexec.args="<AbsolutePathToInputFile>"

OR

- Execute from IDE by Running Java main class=>com.github.inv3r53.fitbits.Main passing a Java arg as <AbsolutePathToInputFile>


Tests
-----
- Run mvnw test
