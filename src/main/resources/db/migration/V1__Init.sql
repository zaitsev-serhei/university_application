CREATE USER univ_db_admin WITH PASSWORD 'admin';
CREATE DATABASE university_db OWNER univ_db_admin;
REVOKE ALL ON DATABASE university_db FROM PUBLIC;
