#!/usr/bin/env groovy
def pid = args[0]
def javaRuntime = new javax.management.ObjectName("java.lang:type=Runtime")
def server = JmxServer.retrieveServerConnection(pid)
def startTime = server.getAttribute(javaRuntime, "StartTime")
def uptime = server.getAttribute(javaRuntime, "Uptime")
println "\nJava process pid (${pid}) was started at ${new Date(startTime)} and has been up for ${uptime} ms.\n"
