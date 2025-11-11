FROM amazoncorretto:21
VOLUME /tmp
COPY target/crm-0.0.1-SNAPSHOT.jar helix-gpo-crm.jar
ENTRYPOINT ["java", "-jar", "/helix-gpo-crm.jar"]