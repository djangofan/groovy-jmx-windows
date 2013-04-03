#!/usr/bin/env groovy
def pid = args[0]
def javaRuntime = new javax.management.ObjectName("java.lang:type=Runtime")
def inputArguments = JmxServer.retrieveServerConnection(pid).getAttribute(javaRuntime, "InputArguments")
println "\nInput Arguments for Java pid (${pid}):\n${inputArguments}\n"
