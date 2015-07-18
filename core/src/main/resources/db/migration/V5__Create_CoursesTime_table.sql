create table CoursesTime (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  courseId INT NOT NULL,
  courseTime VARCHAR(40) NOT NULL,
  foreign key(courseId) references Courses(id) on delete cascade on update cascade
);

INSERT INTO CoursesTime (courseId,courseTime) values (1,"星期一");
INSERT INTO CoursesTime (courseId,courseTime) values (1,"星期三");
INSERT INTO CoursesTime (courseId,courseTime) values (2,"星期二");
INSERT INTO CoursesTime (courseId,courseTime) values (3,"星期三");
INSERT INTO CoursesTime (courseId,courseTime) values (4,"星期四");