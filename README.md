The example project for StringBoot service

<div align="center">
    <img src="./assets/images/spring_boot_icon.png"/>
</div>

## Getting Started

## Project structure
```
.
├── spring-boot-cassandra
│   ├── Dockerfile
│   ...
├── docker-compose.yaml
|
└── README.md
```

## Prerequisites
- Make sure that you have Docker and Docker Compose installed
  - Windows or macOS:
    [Install Docker Desktop](https://www.docker.com/get-started)
  - Linux: [Install Docker](https://www.docker.com/get-started) and then
    [Docker Compose](https://github.com/docker/compose)

## Start infrastructure

```shell script
$ docker-compose -f ./docker-compose-infrastructure.yml -p spring-boot-cassandra-infrastructure up -d
```

- Tạo keyspace, table và insert data

```cql
CREATE KEYSPACE spring_boot_cassandra_example WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '3'}  AND durable_writes = true;
USE spring_boot_cassandra_example;
CREATE TABLE user (
    user_id bigint,
    user_name text,
    PRIMARY KEY (user_id)
);
INSERT INTO user (user_id,user_name) VALUES (1, 'Nguyen Van A');
```

## Start services
### Start services in local

- Build project
```shell script
$ ./mvnw clean package
$ cd spring-boot-cassandra
$ ../mvnw spring-boot:run
...
```

### Start services in docker 

```shell script
$ docker-compose -f ./docker-compose-service.yml -p spring-boot-service up -d
```

## Run testing

```shell script
curl http://localhost:8081/greet?user_id=1
```

## Stop project

- Kill project if start in local mode
- Stop infrastructure & services in docker

```shell script
$ docker-compose -f ./docker-compose-infrastructure.yml -p spring-boot-infrastructure down
$ docker-compose -f ./docker-compose-service.yml -p spring-boot-service down
```

## Contribute

## Reference

- https://www.bezkoder.com/spring-boot-cassandra-crud/
- https://www.baeldung.com/spring-data-cassandra-tutorial
- https://medium.com/@aamine/spring-data-for-cassandra-a-complete-example-3c6f7f39fef9
- http://www.inanzzz.com/index.php/post/ecgh/docker-compose-for-single-and-multi-node-cassandra-example?ref=morioh.com&utm_source=morioh.com