# Spring boot k8s demo application
# Getting Started
Clone o repositório:
<pre><code> https://github.com/eltonmmoreira/spring-boot-k8s-demo.git</code></pre>

# Description
API REST demo que retorna a cotação de ações da B3(Bolsa de valores) http://www.b3.com.br/pt_br/  
As informações são buscadas da api https://mfinance.com.br  
Após a primeira requisição, os dados são mantidos em cache no REDIS por um período de tempo configurável.

Tecnologias:
- Spring Boot,
- JAVA, 
- REST, 
- REDIS,
- Docker,
- k8s

# Building and running the application
## Pre-requisites
<pre><code>JAVA 15
Maven
Docker,
Kubernetes</code></pre>

## Package the Spring Boot jar and create the docker image
Para compilar e empacotar o arquivo jar e criar uma imagem docker local, execute os comandos abaixo:
<pre><code>mvn package
mvn jib:dockerBuild</code></pre>

Para criar a imagem docker foi utilizado o jib-maven-plugin, dessa forma não é necessário o uso de Dockerfile 
nem ter o docker instalado.  
Maiores detalhes: https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin

## App on Kubernetes:
O deploy da aplicação pode ser feito localmente em um cluster kubernetes.  
Para isso podemos utilizar ferramentas como:  
- Minikube, 
- Kind, 
- Microk8s.  

Maiores informações:  
https://kind.sigs.k8s.io/  
https://microk8s.io/  
https://kubernetes.io/pt-br/docs/tutorials/hello-minikube/  

Após fazer o build da aplicação e gerar a imagem docker, criar no kubernetes os recursos do diretório k8s. 
Criar primeiramente namespaces, redis, ingress e app.  
Utilizado nginx como ingress.  

Comandos executados a partir de um diretório anterios aos arquivos yml, ex:  
 - kubectl apply -f namespaces/
 - kubectl apply -f redis/

# Documentation
<pre><code>http://localhost:8080/api-docs
http://localhost:8080/swagger-ui.html

