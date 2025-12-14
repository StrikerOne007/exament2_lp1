FROM tomcat:10.1-jdk21-temurin

WORKDIR /usr/local/tomcat

RUN rm -rf webapps/*

COPY dist/cinefix.war webapps/ROOT.war

ENV PORT=8000

RUN sed -i 's/port="8080"/port="8000"/g' conf/server.xml

EXPOSE 8000

CMD ["catalina.sh", "run"]
