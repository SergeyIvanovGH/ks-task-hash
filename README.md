### Выполнить сборку пакета jar-файл
mvn clean package

### Собрать контейнеры и запустить приложение с БД (postgres)
cd docker
docker-compose up --build

### Используется базовая аутентификация
login = 'user'
password = 'password'


### REST-services. endpoints:

- получение hash-значения по номеру телефона
http://localhost:8081/data/hash?phone=0671234567
в данном случае если в БД нет такого номера, то значение телефона и расчитанный hash добавляется в БД.

- получение номера телефона по hash-значению
http://localhost:8081/data/phone?hash=419d80f88d2e1032a994290bc5b12fb746b41919
в данном случае если в БД нет номера телефона с таким hash-значением, возвращается HTTP 500 и сообщение Phone by hash not found in database 

- также можно вызвать методы используя Swagger2
http://localhost:8081/swagger-ui.html


### Изменение настроек (алгоритма) шифрования
в файл docker/web/assembly/config/hash.properties необходимо внести изменение 

### JMeter проект размещен в каталоге
jmeter/ks-task-hash.jmx

### После остановки контейнеров или если необходимо пересобрать контейнеры, рекомендуется выполнить команду
docker container prune
