# RabbitMQ demo project

1. To run all services it's just enough to execute bash script:
    ```./runApps```
    
It will:
    - build jar files for producer and consumer project
    - build docker images 
    - execute docker compose for rabbitMQ and producer app
    - execute REST curl requests 
        - it will create 4 queues in rabbitMQ
        - populate queues with messages
    - execute docker compose for consumer apps
    	- it will create 3 consumer apps that will pull messages from queues
	
