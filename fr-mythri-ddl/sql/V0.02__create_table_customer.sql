CREATE TABLE customer
(
    customer_id integer     NOT NULL
        CONSTRAINT customer_pk
            PRIMARY KEY,
    name        varchar(30) NOT NULL
);
