For Consumer and Producer
Run the  Apache Zookeeper server
Run the  Apache Kafka  server
Listen to the messages coming from the new topics

C:\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
C:\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties
C:\kafka>.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic NewTopic --from-beginning

to Run the Producer Create a Postman (POST) request and run this endpoint http://localhost:8081/publish/{Sample Message}