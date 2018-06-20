/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/bin/java

-Djava.library.path=/Users/Ross/IdeaProjects/sqljdbc_6.4/enu/auth/x64

"-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=61683:/Applications/IntelliJ IDEA CE.app/Contents/bin"
-Dfile.encoding=UTF-8


-classpath
/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre
/lib/charsets.jar:/lib/deploy.jar:/lib/ext/cldrdata.jar:/lib/ext/dnsns.jar:/lib/ext/jaccess.jar:/lib/ext/jfxrt.jar:/lib/ext/localedata.jar:/lib/ext/nashorn.jar:/lib/ext/sunec.jar:/lib/ext/sunjce_provider.jar:/lib/ext/sunpkcs11.jar:/lib/ext/zipfs.jar:/lib/javaws.jar:/lib/jce.jar:/lib/jfr.jar:/lib/jfxswt.jar:/lib/jsse.jar:/lib/management-agent.jar:/lib/plugin.jar:/lib/resources.jar:/lib/rt.jar

:/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/lib
/ant-javafx.jar:/dt.jar:/javafx-mx.jar:/jconsole.jar:/packager.jar:/sa-jdi.jar:/tools.jar:/Users/Ross/IdeaProjects/sqljdbc_6.4/dist/production/sqljdbc_6.4

:/Users/Ross/IdeaProjects/sqljdbc_6.4/enu/
mssql-jdbc-6.4.0.jre7.jar:mssql-jdbc-6.4.0.jre8.jar:mssql-jdbc-6.4.0.jre9.jar

connectDS localhost 1433 master



-Djava.library.path=/Users/Ross/IdeaProjects/sqljdbc_6.4/enu/auth/x64


/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/bin/java

-classpath /Users/Ross/IdeaProjects/sqljdbc_6.4/enu/mssql-jdbc-6.4.0.jre8.jar

connectDS.java 1 2 3


java -classpath /Users/Ross/IdeaProjects/sqljdbc_6.4/enu/mssql-jdbc-6.4.0.jre8.jar connectDS.java 1 2 3




$ pwd
/Users/Ross/IdeaProjects/sqljdbc_6.4/enu/samples/connections


$ javac -classpath /Users/Ross/IdeaProjects/sqljdbc_6.4/enu/mssql-jdbc-6.4.0.jre8.jar connectDS.java


$ java -classpath ./:/Users/Ross/IdeaProjects/sqljdbc_6.4/enu/mssql-jdbc-6.4.0.jre8.jar connectDS
Usage:
serverName portNumber databaseName
Example:
localhost 1433 databaseName


$ java -classpath ./:/Users/Ross/IdeaProjects/sqljdbc_6.4/enu/mssql-jdbc-6.4.0.jre8.jar connectDS localhost 1433 master