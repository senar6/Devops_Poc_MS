FROM tomcat:7-jre8
ADD ./target/SpringMVCHibernate.war /usr/local/tomcat/webapps/SpringMVCHibernate.war
EXPOSE 8080
CMD ["catalina.sh", "run"]

