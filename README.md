# RabbitMQ demo project

1. To run all services it's just enough to execute bash script:

    ```./runApps```
    
It will:

* build jar files for producer and consumer projects
* build docker images 
* execute docker compose for running rabbitMQ and producer app
* execute REST curl requests 
	* as a result 4 queues in rabbitMQ will be created
	* all queues will be populated with messages
* execute docker compose for running consumer apps
	* as a result 3 different consumer apps will be created that will pull messages from queues
	
