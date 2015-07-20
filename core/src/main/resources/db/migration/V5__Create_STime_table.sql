create table STime (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  time VARCHAR(40) NOT NULL
);

INSERT INTO STime (id,time) values (1,"星期一");
INSERT INTO STime (id,time) values (3,"星期三");
INSERT INTO STime (id,time) values (2,"星期二");
INSERT INTO STime (id,time) values (5,"星期五");
INSERT INTO STime (id,time) values (4,"星期四");
INSERT INTO STime (id,time) values (6,"星期六");
INSERT INTO STime (id,time) values (7,"星期日");