# Rentalo Tool 

## Directories structure
  - There are 3 java backend services directories: tools ,orders, api-gateway
  - The Rentalo-tool-app is the android project

## Pre-requirements:
#### Backend:
 - Docker installed
 - Maven installed
 - linux terminal emulator so that backend can be started with a bash script: <b>build.sh</b>
#### Frontend:
 - Android studio
 - Android emulator like Pixel 3 with API version 30 

## Startup:
#### Version 1 Backend startup
    Go to tools and execute the bash script with the following command if you're from a terminal:
    ./bash.sh 
#### Version 2 Backend startup
     Go into every service: tools, orders, api-gateway and execute mvn clean install command, build the docker images with
       docker build -t tools-app:1.0.0 .
       docker build -t orders-app:1.0.0 .
       docker build -t api-gateway:1.0.0 .
     and execute docker-compose command from tools/environment directory.
#### Frontend
    Run the emulator, open Rentalo Tool android project and deploy the application into the emulator. 

## Tools Service
The main purpose of the service is to manage tools and category operations. 

## Orders Service
The main purpose of the service is to manage orders operations.

## Api Gateway
The main purpose of the service is to route the incoming traffic to orders and tools services.

## Deployment
### Docker
1. Build current springboot app image:
```
docker build -t tools-app:1.0.0 .
```
2.Start the container with docker compose:

```
cd environment
docker-compose up
docker run -d -p 8080:8080 -t tools-app:1.0.0
```

Postgres and pgAdmin 4
https://github.com/khezen/compose-postgres

The created database name is : postgres

#High level TODO:

##  Add jenkins environment on localhost docker always started. 
##  Add sonarqube/checkmarx on localhost 
##  Add sonar stages for format code, build, tests, sonar run, checkmarx, docker build image 
##  Add elastic stack/ log aggregator, splunk/kibana dashboard 

#Low level TODO:
### Add contract based generation not generate the contract via ApiResponses.
### Contract module
### Fix swagger-ui on deployment docker compose 