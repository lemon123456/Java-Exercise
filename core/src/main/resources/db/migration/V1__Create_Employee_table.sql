create table Employee (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    sex VARCHAR(40) NOT NULL,
    age int NOT NULL,
    email VARCHAR(50) NOT NULL,
    role VARCHAR(40) NOT NULL,
    state VARCHAR(20) NOT NULL
);


INSERT INTO Employee (name,sex,age,email,role,state) VALUES ("李一","male",34,"121@qq.com","OPs","YES");
INSERT INTO Employee (name,sex,age,email,role,state) VALUES ("李二","male",34,"121@qq.com","OPs","YES");
INSERT INTO Employee (name,sex,age,email,role,state) VALUES ("李三","male",34,"121@qq.com","COACH","YES");
INSERT INTO Employee (name,sex,age,email,role,state) VALUES ("李四","male",34,"121@qq.com","COACH","YES");
INSERT INTO Employee (name,sex,age,email,role,state) VALUES ("李舞","male",34,"121@qq.com","COACH","YES");
