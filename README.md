# Microservices Exercise

There are several approaches to solve this exercise. Mine is descrived by the following diagram:

![alt text](https://github.com/CiudadAlex/MicroservicesExercise/raw/main/diagram.png)


Almost every node of the diagram is an independent webservice application made with SpringBoot (a Java microservice framework). The communication between nodes will be executed by direct REST API calls. There will be the following types of node:

1.	The front end will be a web application programmed as a Single Page Application in a Javascript Framework in order to put all the HTML generation on the browser side and avoid generate HTML in the server side.
2.	Eureka Server. This node is the server where all the other microservices register so that when a microservice has to find another microservice they just have to ask Eureka to find them. If there are N instances o a type of microservice they all will be registered in Eureka and the client will be able to choose which one to use using load balancing algorithms.
3.	Cloud Config Server. This node will host the configuration of all the other nodes in order to allow an easy configuration of thousands of microservices if needed.
4.	Load Balancing Reverse Proxy. This node allows to distribute the load among all the nodes of the API Gateway
5.	API Gateway (N clone instances). The Gateway of the system.
6.	User Authentication (N clone instances). Authentication server.
7.	Dialog Manager (N clone instances).
8.	NLU (N clone instances). Natural Language Understanding.
9.	Knowledge Server (N clone instances).
10.	Direct Request (N clone instances). Node that answers direct requests.
11.	Task Manager (N clone instances). Node that executes the tasks recognized in the intent of the user.

The N clone instances can vary among different types of microservice. For instance, the more CPU expensive or Hard Disk intensive nodes like NLU or the Knowledge Server could have more clones than other microservices since they are probably the bottleneck of the whole system.

As mentioned before, the microservices will be able to load balance themselves using Spring Cloud  Ribbon. In the documentation of SpringBoot you can read:

“Spring Cloud Ribbon is a library that allows communication between different processes whose main characteristic is to provide different algorithms to perform load balancing from the client side (client-side load balancing). In addition to client-side load balancing, Ribbon provides other useful functions, some of which we will discuss below.
Eureka integration: Ribbon enables load balancing tasks between services deployed in distributed / cloud environments. Specifically, it allows you to obtain information about the services registered in Eureka and perform load balancing between them. It also allows you to define a list of services explicitly, as we will explain later in this article.
Fault Tolerance: One of the great advantages that Ribbon provides is that it allows you to determine which services are active or down in a dynamic way and thus act accordingly to guarantee the service.
Standard and Custom Load Balancing Strategies: Ribbon provides various strategies for load balancing, such as RoundRobinRule, AvailabilityFilteringRule, or WeightedResponseTimeRule. Also, if you need some type of strategy adjusted to particular needs, Ribbon allows you to create the classes that allow you to define it.”

Performance tests will be carried out to measure how many microservices of each type will be built. It will depend on the processing time of each of them. The longer the more instances have to be raised. Each microservice can be deployed on a separate physical machine to avoid resource competition between microservices.
Some of the microservices of the same type do not have to be clones. For example, if the NLU service contains many very heavy language models (for example it loads embeddings) of various languages and they do not fit in RAM all at once, forcing the operating system to continually load data from disk into RAM, it could be interesting to have several types of NLU microservice, one for each language (each one replicated in deploy several times depending on the demand of each of the languages) and deciding which one of them to use based on the language used by the user
Each microservice can be deployed in a Docker container. It must be taken into account that any change that is modified in a database must be modified in that of all its clones, for example, when updating the language models.

