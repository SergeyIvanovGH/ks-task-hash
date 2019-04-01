# ks-task-hash
test task with SHA hash

# Make jar
mvn clean package

# Run containers with app and db (postgres)
cd docker
docker-compose up --build

# Used basic authorization
login = 'user'
password = 'password'


# REST-services. endpoints:

- получение hash-значения по номеру телефона
http://localhost:8081/data/hash?phone=0671234567
в данном случае если в БД нет такого номера, то значение телефона и расчитанный hash добавляется в БД.

- получение номера телефона по hash-значению
http://localhost:8081/data/phone?hash=419d80f88d2e1032a994290bc5b12fb746b41919
в данном случае если в БД нет номера телефона с таким hash-значением, возвращается HTTP 500 и сообщение Phone by hash not found in database 

- также можно вызвать методы используя Swagger2
http://localhost:8081/swagger-ui.html


# Изменение настроек шифрования
в катлоге config/ необходимо внести изменение 


# После остановки контейнеров рекомендуется выполнить команду
docker container prune
