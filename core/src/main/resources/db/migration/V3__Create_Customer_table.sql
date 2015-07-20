create table Customer (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customerName VARCHAR(40) NOT NULL,
    coachId INT NOT NULL,
    foreign key(coachId) references Employee(id) on delete cascade on update cascade
);

INSERT INTO Customer(customerName,coachId) VALUES ("李煜",3);
INSERT INTO Customer(customerName,coachId) VALUES ("朱江",4);
INSERT INTO Customer(customerName,coachId) VALUES ("李静",5);
INSERT INTO Customer(customerName,coachId) VALUES ("杨洋",5);