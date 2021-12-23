FROM openjdk:8
ADD build/libs/jumia-back-end-0.0.1-SNAPSHOT.jar jumia.jar
ENTRYPOINT ["java", "-jar","jumia.jar"]