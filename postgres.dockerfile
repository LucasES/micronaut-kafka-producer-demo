FROM postgres:15.1-alpine

LABEL author="Lucas Araújo"
LABEL description="Postgres Image for demo"
LABEL version="1.0"

COPY *.sql /docker-entrypoint-initdb.d/