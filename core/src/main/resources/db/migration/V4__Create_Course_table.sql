create table Course (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    courseName VARCHAR(40) NOT NULL,
    description VARCHAR(200));

INSERT INTO Course (courseName,description) VALUES ("private","You need to specify a coach!");
INSERT INTO Course (courseName,description) VALUES ("swimming","This is an interesting sport!");
INSERT INTO Course (courseName,description) VALUES ("football","This is an interesting sport!");
INSERT INTO Course (courseName,description) VALUES ("running","This is an interesting sport!");
INSERT INTO Course (courseName,description) VALUES ("basketball","This is an interesting sport!");