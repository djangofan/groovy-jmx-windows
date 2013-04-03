#!/usr/bin/env groovy
def pid = args[0]
def javaRuntime = new javax.management.ObjectName("java.lang:type=Runtime")
def libraryPath = JmxServer.retrieveServerConnection(pid).getAttribute(javaRuntime, "LibraryPath")
println "\nLibrary Path for Java pid (${pid}):\n${libraryPath}\n"
