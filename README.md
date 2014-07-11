<h1>ABOUT</h1>
A simple example of Hazelcast JCA connection.
 
<h2>Prerequisites</h2>
You should have installed JBoss AS or JBoss EAP and Apache Maven on your system. There are other requirements already in this repo.


`JBoss AS 7+` or `JBoss EAP 6+` - Choose free JBoss-AS or choose paid JBoss-EAP<br />
`Apache Maven 3+`<br />
`Hazelcast 3+`<br />

<h2>JBoss Configuration</h2>

<ul>
	<li>`git clone https://github.com/hazelcastInternsSummer14/hazelcast-jca-example.git` - Clone repo into the local</li>
	<li>`cd hazelcast-jca-example`</li>
	<li>`cp -R jboss/* $JBOSS_HOME/` - copy all JBoss requirements.</li>
	<li>`mvn install war:war` - Create war file for example</li>
	<li>`cp target hazelcast-jca-example.war $JBOSS_HOME/standalone/deployments/` - Copy war to JBoss</li>
</ul>


<h2>How to Run Sample Application</h2>
<ul>
	<li>`$JBOSS_HOME/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 -c standalone-full.xml` - Run JBoss</li>
	<li>Browse to `http://localhost:8080/hazelcast-jca-example/Hello`</li>
</ul>