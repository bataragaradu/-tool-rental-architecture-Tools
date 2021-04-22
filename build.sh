cd environment
docker-compose down
cd ..
cd tools-server
mvn clean install
cd ..
docker build -t tools-app:1.0.0 .
cd environment
docker-compose up