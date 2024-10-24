CREATE TABLE project (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    person_id INT NULL
);


-- Ubaci primjere projekata
INSERT INTO project (name, description, person_id) VALUES ('ProjectAlpha', 'Development of Alpha product', 1);
INSERT INTO project (name, description, person_id) VALUES ('Project Beta', 'Beta testing phase', 1);
INSERT INTO project (name, description, person_id) VALUES ('Project Gamma', 'Development of Gamma API', 2);
INSERT INTO project (name, description, person_id) VALUES ('ProjectSDK', 'Development of Alpha ', 1);
INSERT INTO project (name, description, person_id) VALUES ('ProjectSDK', 'Development of Alpha ', 2);

