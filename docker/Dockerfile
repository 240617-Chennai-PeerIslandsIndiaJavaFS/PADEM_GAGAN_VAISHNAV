FROM eclipse-temurin:22-jre
WORKDIR /app
COPY target/*.jar /app/myapp.jar
EXPOSE 8000
CMD ["java","-jar","/app/myapp.jar"]