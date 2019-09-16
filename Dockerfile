FROM java:8
COPY target/ var/www/java
WORKDIR /var/www/java
EXPOSE 8080
CMD ["java" , "-jar", "TodoList-0.0.1-SNAPSHOT.jar"]