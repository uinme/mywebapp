@echo off

rem Set path
set here=%~dp0
cd %here%

rem Required package url
set jre_url=https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.8%%2B10/OpenJDK11U-jre_x86-32_windows_hotspot_11.0.8_10.zip
set tomcat_url=https://ftp.jaist.ac.jp/pub/apache/tomcat/tomcat-9/v9.0.37/bin/apache-tomcat-9.0.37-windows-x86.zip

rem Prepare directories
if not exist tmp mkdir tmp
if not exist jre mkdir jre
if not exist tomcat mkdir tomcat

rem Download packages
if not exist tmp\OpenJDK11U-jre_x86-32_windows_hotspot_11.0.8_10.zip bin\wget.exe -P tmp\ %jre_url%
if not exist tmp\apache-tomcat-9.0.37-windows-x86.zip bin\wget.exe -P tmp\ %tomcat_url%

rem Unpack archives
for /f "usebackq" %%A in (`dir jre /AD /B ^| find /c /v ""`) do set n=%%A 
if %n% lss 1 (
	bin\7z.exe x -y -ojre\ tmp\OpenJDK11U-jre_x86-32_windows_hotspot_11.0.8_10.zip
)
for /f "usebackq" %%A in (`dir tomcat /AD /B ^| find /c /v ""`) do set n=%%A 
if %n% lss 1 (
	bin\7z.exe x -y -otomcat\ tmp\apache-tomcat-9.0.37-windows-x86.zip
)

pause
