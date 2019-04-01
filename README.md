# ks-task-hash
test task with SHA hash

# Run server
docker run --rm --name some-postgres -e POSTGRES_PASSWORD=example -d -p 5432:5432 postgres:9

# Connect to server as postgres user
docker exec -it some-postgres psql --u postgres

CREATE DATABASE kstaskhash;
\q

# or

docker exec -it some-postgres psql --u postgres -c "CREATE DATABASE kstaskhash"


# Stop container
docker container stop some-postgres
docker container prune


# Build Spring Boot container
docker build -f Dockerfile -t ks-task-hash .

# Run spring boot container with link to Postgresql container
docker run -p 8081:8081 --link some-postgres:postgres -d ks-task-hash
