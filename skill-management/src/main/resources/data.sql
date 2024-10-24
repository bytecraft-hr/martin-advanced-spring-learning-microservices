CREATE TABLE skill (
    skill_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    skill_category VARCHAR(255),
    person_id INT NOT NULL
);



-- Ubacivanje podataka o vještinama u Skill mikroservis
INSERT INTO skill (name, skill_category,person_id) VALUES ('Programming', 'General',1);
INSERT INTO skill (name, skill_category,person_id) VALUES ('Java', 'Backend',2);
INSERT INTO skill (name, skill_category,person_id) VALUES ('Spring', 'Backend',3);
INSERT INTO skill (name, skill_category,person_id) VALUES ('Hibernate', 'Database',1);
INSERT INTO skill (name, skill_category,person_id) VALUES ('Angular', 'Frontend',1);
INSERT INTO skill (name, skill_category,person_id) VALUES ('Python', 'Backend',1);
INSERT INTO skill (name, skill_category,person_id) VALUES ('React', 'Frontend',1);
INSERT INTO skill (name, skill_category,person_id) VALUES ('Kotlin', 'Mobile',1);
INSERT INTO skill (name, skill_category,person_id) VALUES ('Django', 'Backend',1);
