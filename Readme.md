# Deployment
## Docker
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