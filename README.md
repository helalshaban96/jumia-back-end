# Jumia task
Jumia the implementation of a basic business logic related to the validation of international phone numbers

## Project Frameworks

* Gradle
* Spring boot
* H2
* npm 

## Test Frameworks
* JUnit
* Mockito
* MockMvc

## Build Instructions
Windows : `gradlew.bat clean build`,
Others: `./gradlew clean build`
Inside the project root dir, where is build.gradle file is located.

## Import instructions
To load the project,
1. Open IntelliJ IDEA
2. Click on "Open or Import" menu in the welcome screen. (or File->Import in main screen)
3. Navigate to the project folder and select the build.gradle file.
4. Click OK, and in the next prompt, choose "Open as project"
5. To download the dependencies, expand the Gradle panel in the top right section of the IDEA main window,
and click on "Reimport all gradle projects" icon.
6. This should download all dependencies and build the project.

## Required Tools
Please note that, all tools are already pre installed on the host.
* Gradle
* Java
* IntelliJ IDEA
* H2 database

## Build Instructions
Windows : `gradlew.bat clean build`

Linux  &  OSX : `./gradlew clean build`
inside the project root dir, where is build.gradle file is located.
	

## Steps to run the project from cmd
1. extract the file into your machine 
2. navigate to jumia-back-end
3. run 'gradlew build' then 'gradlew :bootRun' 
4. the project will run on port 8080, and to check that it is running open http://localhost:8080/api/v2/countries from your browser 
5. now you can use postman or any other client to use the API
6. Go back to jumia-front-end folder open cmd there and run  'npm install' wait untill finish downloading dependencies
7. After finishing downloading run 'ng serve'
7. Go to browser and visit 'http://localhost:4200/'

## Steps to run the project from IntelliJ IDEA
1- Run RestServiceApplication.java main method from your IDE and to check that it is running open http://localhost:8080/api/v2/countries from your browser

## Note
make sure that port 8080 is not in use.
