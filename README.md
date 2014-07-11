<h1>ABOUT</h1>
A simple example of Hazelcast JCA connection.
 
<h2>Requirements</h2>
You should have installed JBoss AS or JBoss EAP and Apache Maven on your system. There are other requirements already in this repo.


`JBoss AS 7+` or `JBoss EAP 6+` - Choose free JBoss-AS or choose paid JBoss-EAP<br />
`Apache Maven 3+`<br />
`Hazelcast 3+`<br />

<h2>JBoss Configuration</h2>
* `git clone https://github.com/hazelcastInternsSummer14/hazelcast-jca-example.git` - Clone repo into the local
* `cd hazelcast-jca-example`
* `cp -R jboss/* $JBOSS_HOME/` - copy all JBoss requirements.
* `mvn install war:war` - Create war file for example
* `cp target hazelcast-jca-example.war $JBOSS_HOME/standalone/deployments/` - Copy war to JBoss


<h2>How to Run Sample Application</h2>
* `$JBOSS_HOME/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 -c standalone-full.xml` - Run JBoss
* Browse to `http://localhost:8080/hazelcast-jca-example/Hello`