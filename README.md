groovy-jmx-windows
==================
Groovy scripts to check JMX info on Windows.

URL of this project
==================
[http://djangofan.github.com/groovy-jmx-windows/](http://djangofan.github.com/groovy-jmx-windows/)

How to run this project
==================

    1. Download the .zip distro of this project.
    2. Run the runALL.bat and follow the instructions.

JMX Configuration on Java
==================
To enable JMX on a Oracle Java JVM, pass it these parameters.  The default JMX(RMI) port is 1099 but
I use 9999 here so it doesn't conflict with another JVM RMI port on my system.

    -Dcom.sun.management.jmxremote.port=9999
    -Dcom.sun.management.jmxremote.authenticate=false
    -Dcom.sun.management.jmxremote.ssl=false

And using IBM JRockit, you may need options like these:

    -Dcom.sun.management.jmxremote.port=1099
    -Dcom.sun.management.jmxremote.authenticate=false
    -Dcom.sun.management.jmxremote.local.only=false
    -Dcom.sun.management.enableThreadContentionMonitoring
    -Dcom.sun.management.jmxremote.ssl=false

NOTES
==================
More information here: [http://groovy.codehaus.org/Groovy+JmxBuilder](http://groovy.codehaus.org/Groovy+JmxBuilder)
