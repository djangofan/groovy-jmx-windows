#!/usr/bin/env groovy
def pid = args[0]
def javaRuntime = new javax.management.ObjectName("java.lang:type=Runtime")
def bootClasspath = JmxServer.retrieveServerConnection(pid).getAttribute(javaRuntime, "BootClassPath")
println "\nBoot Classpath for Java pid (${pid}):\n${bootClasspath}\n"
