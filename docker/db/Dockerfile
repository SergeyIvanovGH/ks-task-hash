FROM postgres:9
ENV POSTGRES_PASSWORD example
COPY init-user-db.sql /docker-entrypoint-initdb.d/
EXPOSE 5432
