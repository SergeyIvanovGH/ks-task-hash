# ks-task-hash
test task with SHA hash

# Run server
docker run --name some-postgres -e POSTGRES_PASSWORD=example -d -p 5432:5432 postgres:9

# Connect to server as postgres user
docker exec -it some-postgres psql --u postgres

CREATE DATABASE kstaskhash;
\q

# or

docker exec -it some-postgres psql --u postgres -c "CREATE DATABASE kstaskhash"


# Stop container
docker container stop some-postgres
docker container prune
