create table User(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    password VARCHAR(50) NOT NULL,
    employeeId INT NOT NULL UNIQUE,
    foreign key(employeeId) references Employee(id) on delete cascade on update cascade
);

INSERT INTO User(name,password,employeeId) VALUES ("admin1","202cb962ac59075b964b07152d234b70",1);
INSERT INTO User(name,password,employeeId) VALUES ("admin2","202cb962ac59075b964b07152d234b70",2);
INSERT INTO User(name,password,employeeId) VALUES ("admin3","202cb962ac59075b964b07152d234b70",3);
INSERT INTO User(name,password,employeeId) VALUES ("admin4","202cb962ac59075b964b07152d234b70",4);
INSERT INTO User(name,password,employeeId) VALUES ("admin5","202cb962ac59075b964b07152d234b70",5);