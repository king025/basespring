# emy
# Springboot 2
Sample Springboot 2 project to demonstrate Springboot with ELK Stack

## Pre-requisites

The following should be setup before attempting to import and run this project

* IDE
* JDK 17
* Maven
* Postman
* ElasticSearch
* Kibana
* Logstash and Filebeat

## About project

* Elastic CMD
elasticsearch.bat

* Default URL
http://localhost:9200

* Kibana CMD
kibana.bat

* Default URL
http://localhost:5601

* Logstash CMD
logstash -f logstash.conf

* Filebeat CMD
filebeat.exe -c filebeat.yml

* logstash.conf
* filebeat.yml

## ELK Stack
Once app is running, you can access the logs by running the following in postman/browser:
GET: http://localhost:8080/api/hello
GET: http://localhost:8080/api/Food-Details
GET: http://localhost:8080/api/weather/ohio



## JSON object
Provided example.json and is located in C: drive

## References
https://www.javainuse.com/spring/springboot-microservice-elk