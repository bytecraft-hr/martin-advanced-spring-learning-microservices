-- Kreiranje tablice za osobe
CREATE TABLE person (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);


INSERT INTO person (first_name, last_name, email) VALUES ('Martin', 'Cikor', 'martin.cikor@bytecraft.eu');
INSERT INTO person (first_name, last_name, email) VALUES ('Angela', 'Radic', 'angela.radic@bytecraft.eu');
INSERT INTO person (first_name, last_name, email) VALUES ('Ivan', 'Horvat', 'ivan.horvat@example.com');
INSERT INTO person (first_name, last_name, email) VALUES ('Petra', 'Maric', 'petra.maric@example.com');
INSERT INTO person (first_name, last_name, email) VALUES ('Marko', 'Novak', 'marko.novak@example.com');
INSERT INTO person (first_name, last_name, email) VALUES ('Lucija', 'Kos', 'lucija.kos@example.com');
INSERT INTO person (first_name, last_name, email) VALUES ('Ante', 'Zovko', 'ante.zovko@example.com');
INSERT INTO person (first_name, last_name, email) VALUES ('Dora', 'Matic', 'dora.matic@example.com');
