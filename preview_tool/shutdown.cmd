@echo off

set here=%~dp0
cd %here%

set CATALINA_HOME=%here%\tomcat\apache-tomcat-9.0.37
set JAVA_HOME=%here%\jre\jdk-11.0.8+10-jre

tomcat\apache-tomcat-9.0.37\bin\shutdown.bat
