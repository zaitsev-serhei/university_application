INSERT INTO lectors (first_name, last_name, degree, salary) VALUES
('Alice', 'Smith', 'PROFESSOR', 95000.00),
('Bob', 'Johnson', 'ASSOCIATE_PROFESSOR', 78000.00),
('Charlie', 'Williams', 'ASSISTANT', 55000.00),
('Diana', 'Brown', 'PROFESSOR', 105000.00),
('Edward', 'Jones', 'ASSISTANT', 52000.00),
('Fiona', 'Garcia', 'ASSOCIATE_PROFESSOR', 82000.00),
('George', 'Miller', 'PROFESSOR', 98000.00),
('Hannah', 'Davis', 'ASSISTANT', 58000.00),
('Ian', 'Rodriguez', 'ASSOCIATE_PROFESSOR', 75000.00),
('Julia', 'Martinez', 'PROFESSOR', 110000.00);
INSERT INTO departments (name, head_of_department_name) VALUES
('Computer Science', 'Alice Smith'),
('Mathematics', 'Diana Brown'),
('Physics', 'George Miller'),
('History', 'Julia Martinez'),
('Biology', 'Sarah Wilson');
INSERT INTO department_assignments (dep_id, lec_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(3, 6),
(3, 7),
(4, 8),
(4, 9),
(4, 10);