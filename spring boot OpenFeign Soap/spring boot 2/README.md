# OpenFeign - SOAP

--------------------

PREREQUISITE

- IDE (Java 17, Spring Boot 2.7.x, Maven, OpenFeign)
- SOAP UI

--------------------

MAVEN DEPENDENCIES and PLUGINS

        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-soap</artifactId>
            <version>11.8</version>
        </dependency>
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-hc5</artifactId>
            <version>11.8</version>
        </dependency>
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
        </dependency>
        <dependency>
            <groupId>com.sun.xml.bind</groupId>
            <artifactId>jaxb-impl</artifactId>
            <version>2.3.1</version>
        </dependency>
        <dependency>
            <groupId>javax.activation</groupId>
            <artifactId>activation</artifactId>
            <version>1.1</version>
        </dependency>
        <dependency>
            <groupId>com.sun.istack</groupId>
            <artifactId>istack-commons-runtime</artifactId>
            <version>4.1.1</version>
        </dependency>
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-slf4j</artifactId>
            <version>11.8</version>
        </dependency>


        <plugin>
            <groupId>org.jvnet.jaxb2.maven2</groupId>
            <artifactId>maven-jaxb2-plugin</artifactId>
            <version>0.14.0</version>
            <executions>
                <execution>
                    <goals>
                        <goal>generate</goal>
                    </goals>
                    <configuration>
                        <schemaDirectory>${project.basedir}/src/main/resources/wsdl</schemaDirectory>
                        <schemaIncludes>*.wsdl</schemaIncludes>
                    </configuration>
                </execution>
            </executions>
        </plugin>


--------------------

SOAP UI Instructions

1. Run Jar file attached in Jira in cmd 
    "java -jar rmsoapv2-0.0.1-SNAPSHOT".
2. In SoapUI, create a new SOAP Project with Initial WSDLs:
   http://localhost:8080/v1/ntt/openfeign/soap/calculatorDemo.wsdl
   http://localhost:8080/v1/ntt/openfeign/soap/numberToWordsDemo.wsdl
3. Test calculator (local) and number conversion (url).

--------------------

REFERENCES

- Invoking a SOAP Web Service in Spring - https://www.baeldung.com/spring-soap-web-service
- Number Conversion Service - https://www.dataaccess.com/webservicesserver/NumberConversion.wso
- Publish a SOAP Web Service With Spring Boot - https://medium.com/swlh/publish-a-soap-web-service-with-spring-boot-b561a4142d81