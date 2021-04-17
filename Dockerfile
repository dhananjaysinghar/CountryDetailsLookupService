FROM java:8
EXPOSE 8080
ADD target/IdentityService-0.0.1-SNAPSHOT.jar identity-service
ENTRYPOINT ["java", "-jar", "identity-service"]

# Important commands Docker
#----------------------------
#docker build -f Dockerfile -t identity-service .
#docker images
#docker run -d -p 8080:8080 identity-service