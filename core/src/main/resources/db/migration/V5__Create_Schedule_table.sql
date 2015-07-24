create table Schedule (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    courseId INT,
    coachId INT,
    time VARCHAR(20) NOT NULL,
    customer VARCHAR(40),
    CONSTRAINT foreign key(courseId) references Course(id) on delete set null ,
    CONSTRAINT foreign key(coachId) references Employee(id) on delete set null
);

INSERT INTO Schedule (courseId,coachId,time,customer) VALUES (2,4,"2015-07-23","All");
INSERT INTO Schedule (courseId,coachId,time,customer) VALUES (3,4,"2015-07-29","All");
INSERT INTO Schedule (courseId,coachId,time,customer) VALUES (4,4,"2015-07-31","All");
INSERT INTO Schedule (courseId,coachId,time,customer) VALUES (4,5,"2015-08-01","All");
