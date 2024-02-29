FROM eclipse-temurin:21-jre

WORKDIR /opt/app
COPY build/jline3-stack-overflow-FAT.jar .
CMD ["java", "-jar", "jline3-stack-overflow-FAT.jar"]
