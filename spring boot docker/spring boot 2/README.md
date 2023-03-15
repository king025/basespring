# Building using docker-maven-plugin
This plugin is used to serve as the docker file

> This will help us in building our docker images placing our java application in a container

First a brief background about docker. Docker helps us containerize our software application to simply reduce the amount of VM's being maintained and utilize resources for scalability and high availability. Thru, Containerization we are able to deploy our services with ease and have a good production grade lifecycle and version control.

## How to Integrate docker-maven-plugin in our POM.XML
1. Open our POM.xml and traverse to the `<build>` Section
2. Inside the `<plugins>` add the following code
    ```
    <plugin>
        <groupId>io.fabric8</groupId>
        <artifactId>docker-maven-plugin</artifactId>
        <version>0.40.1</version>
        <configuration>
            <pushRegistry>localhost:5000</pushRegistry> (Example Registry like hub.docker.com)
            <containerNamePattern>%n</containerNamePattern> (container name sanitation)
            <images>
                <image>
                    <alias>maven-demo</alias> 
                    <name>${project.name}:${project.version}</name>
                    <build>
                        <from>openjdk:17-alpine</from>
                        <assemblies>
                            <assembly>
                                <mode>dir</mode>
                                <descriptorRef>artifact</descriptorRef>
                            </assembly>
                        </assemblies>
                        <entryPoint>
                            <exec>
                                <arg>java</arg>
                                <arg>-jar</arg>
                                <arg>maven/${project.artifactId}-${project.version}.jar</arg>
                            </exec>
                        </entryPoint>
                    </build>
                    <run>
                        <ports>
                            <port>8080:8080</port>
                        </ports>
                    </run>
                </image>
            </images>
        </configuration>
        <executions>
            <execution>
                <id>build-image</id>
                <phase>install</phase>
                <goals>
                    <goal>build</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
    ```
3. After adding the following code, open the maven tab and go to the lifecycle and click install.
4. Open windows terminal / commandprompt / powershell and then type docker images. here is an example: 

| Repository | TAG | Image ID | Created | Size |
| ----------- | ----------- | ----------- | ----------- | ----------- | 
|spring2demo |  0.0.1 | bf81df67a91a | 8 seconds ago | 343MB |
| mongo | latest | 5cefe1229065 | 7 days ago | 700MB |

## How to Run your docker image in the container
> Use the command `docker run -p [exposed port ]:[application port] [image name]:[tag]`
here is an example for the command
> `docker run -p 8080:8080 spring2demo:0.0.1`

[![HoBak11.md.png](https://iili.io/HoBak11.md.png)](https://freeimage.host/i/HoBak11)
