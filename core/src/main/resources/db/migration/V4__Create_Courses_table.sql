create table Courses (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    courseName VARCHAR(40) NOT NULL,
    coachId INT NOT NULL,
    time VARCHAR(40) NOT NULL,
    foreign key(coachId) references Employee(id)
);

INSERT INTO Courses (courseName,coachId,time) VALUES ("swimming",3,"星期一");
INSERT INTO Courses (courseName,coachId,time) VALUES ("private",3,"星期二");
INSERT INTO Courses (courseName,coachId,time) VALUES ("running",4,"星期三");
iNSERT INTO Courses (courseName,coachId,time) VALUES ("private",5,"星期二")