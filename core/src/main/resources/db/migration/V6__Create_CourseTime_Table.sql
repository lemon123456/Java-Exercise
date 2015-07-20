create table CoursesTime (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  courseId INT NOT NULL,
  timeId INT NOT NULL,
  CONSTRAINT foreign key(courseId) REFERENCES Courses(id) ,
  CONSTRAINT foreign key(timeId) REFERENCES STime(id)
);