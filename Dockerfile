# Use a base image that includes OpenJDK 17 for ARM64
FROM arm64v8/openjdk:17-oracle

# Add a volume pointing to /tmp (if needed)
VOLUME /tmp

# Copy the packaged JAR file into the docker image
COPY target/PortalApplication.jar PortalApplication.jar

# Expose port 8021
EXPOSE 8021

# Run the JAR file
ENTRYPOINT ["java", "-jar", "PortalApplication.jar"]
