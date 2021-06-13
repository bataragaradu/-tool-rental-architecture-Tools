cd environment
docker-compose down
cd ../tools-server
mvn clean install
cd ..
docker build -t tools-app:1.0.0 .
cd ../orders/orders-server
mvn clean install
cd ..
docker build -t orders-app:1.0.0 .
cd ../api-gateway
mvn clean install
docker build -t api-gateway:1.0.0 .
cd ../tools/environment
docker-compose up
