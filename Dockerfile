FROM tomcat:10.1-jdk21-temurin

WORKDIR /usr/local/tomcat

RUN rm -rf webapps/*

COPY dist/cinefix.war webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
