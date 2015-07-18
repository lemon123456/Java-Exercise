create table Courses (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    courseName VARCHAR(40) NOT NULL,
    coachId INT NOT NULL,
    foreign key(coachId) references Employee(id) on delete cascade on update cascade
);

INSERT INTO Courses (courseName,coachId) VALUES ("swimming",3);
INSERT INTO Courses (courseName,coachId) VALUES ("private",3);
INSERT INTO Courses (courseName,coachId) VALUES ("running",4);
iNSERT INTO Courses (courseName,coachId) VALUES ("private",5)