-- CREATE TABLE
DROP TABLE IF EXISTS heroes;
CREATE TABLE heroes (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    power NUMERIC(5,2)
);