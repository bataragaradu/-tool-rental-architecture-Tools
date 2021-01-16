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
cd environment
docker-compose up

Postgres and pgAdmin 4
https://github.com/khezen/compose-postgres

The created database name is : postgres

#TODO:
### Add contract based generation not generate the contract via ApiResponses.
### Contract module
### 