FROM tomcat:10.1-jdk17-temurin

WORKDIR /usr/local/tomcat

RUN rm -rf webapps/*

COPY dist/cinefix.war webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
