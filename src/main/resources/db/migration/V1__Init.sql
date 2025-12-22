CREATE TYPE degree_type as ENUM ('ASSISTANT', 'ASSOCIATE_PROFESSOR', 'PROFESSOR');
CREATE TABLE IF NOT EXISTS lectors (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    degree degree_type NOT NULL,
    salary NUMERIC(8,2)
);
CREATE TABLE IF NOT EXISTS departments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) UNIQUE NOT NULL,
    head_of_department_name VARCHAR (256)
);
CREATE TABLE IF NOT EXISTS department_assignments(
    dep_id INT REFERENCES departments(id) ON DELETE CASCADE,
    lec_id INT REFERENCES lectors(id) ON DELETE CASCADE,
    PRIMARY KEY (dep_id,lec_id)
);
CREATE INDEX idx_name_search ON lectors (first_name, last_name);
CREATE INDEX idx_department_name ON departments (name);
