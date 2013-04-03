@echo off

:::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::  This script runs Groovy examples for JMX information
::  Requires a JVM be running locally that has the JMX
::  port enabled.  The JVM is found via the PID rather
::  than the port number.
::
::  Author Jon Austen April 2013
::
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::

SET "JAVA_HOME=C:\AeroFS\Java32\jdk1.6.0_38"
SET ARG=

IF "%~1"=="" (
  ECHO Script requires that you pass a PID of a running Java process which
  ECHO has JMX listener enabled on it.
  ECHO.
  ECHO It appears that a the following PIDs may be running right now:
  wmic.exe process list brief | find /i "java"
  ECHO.
  SET /P ARG=Enter a PID number to query:
  ECHO.
) ELSE (
  SET ARG=%~1
)

IF NOT DEFINED GROOVY_HOME (
  ECHO Script requires that a GROOVY_HOME variable be defined that points
  ECHO to an existing Groovy installation on your system.
  ECHO.
  GOTO :ERROR
)

SET "PATH=.;%JAVA_HOME%\bin;%PATH%;%GROOVY_HOME%\bin"
CLS
cmd.exe /C groovy.bat -version
ECHO.

cmd.exe /C groovy.bat displayBootClasspath.groovy %ARG%
cmd.exe /C groovy.bat displayClasspath.groovy %ARG%
cmd.exe /C groovy.bat displayInputArguments.groovy %ARG%
cmd.exe /C groovy.bat displayJVMUptime.groovy %ARG%
cmd.exe /C groovy.bat displayLibraryPath.groovy %ARG%
cmd.exe /C groovy.bat displaySystemProperties.groovy %ARG%

GOTO :END
:ERROR
ECHO ERROR occurred.
ECHO.
pause
:END
ECHO Script ended.
timeout 5
