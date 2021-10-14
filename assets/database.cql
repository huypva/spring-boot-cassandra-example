CREATE KEYSPACE spring_boot_cassandra_example WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '3'}  AND durable_writes = true;
USE spring_boot_cassandra_example;
CREATE TABLE user (
    user_id bigint,
    user_name text,
    PRIMARY KEY (user_id)
);
INSERT INTO user (user_id,user_name) VALUES (1, 'Nguyen Van A');