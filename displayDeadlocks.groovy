#!/usr/bin/env groovy
def pid = args[0]
def javaThreads = new javax.management.ObjectName("java.lang:type=Threading")
def server = JmxServer.retrieveServerConnection(pid)
long[] deadlockedThreadIds = server.invoke(javaThreads, "findDeadlockedThreads", null, null)
deadlockedThreadIds.each
{ threadId ->
   Object[] parameters = [threadId, 10]
   String[] signature = [Long.TYPE, Integer.TYPE]
   def threadInfo = server.invoke(javaThreads, "getThreadInfo", parameters, signature)
   print "\nThread '${threadInfo.threadName}' [${threadInfo.threadId}] is "
   print "${threadInfo.threadState} on thread '${threadInfo.lockOwnerName}' ["
   println "${threadInfo.lockOwnerId}]:\n"
   println "Java stack information for the threads listed above:"
   println "==================================================="
   println "'${threadInfo.threadName}':"
   threadInfo.stackTrace.each
   { compositeData ->
      print "\tat ${compositeData.className}.${compositeData.methodName}("
      println "${compositeData.fileName}:${compositeData.lineNumber})"
   }
   println "\n\n"
}

