#!/usr/bin/env groovy
def pid = args[0]
def javaRuntime = new javax.management.ObjectName("java.lang:type=Runtime")
def systemProperties = JmxServer.retrieveServerConnection(pid).getAttribute(javaRuntime, "SystemProperties")
println "\nSystem Properties for Java pid (${pid}):\n${systemProperties}\n"
