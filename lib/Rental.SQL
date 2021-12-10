DROP DATABASE IF EXISTS RENTAL;
CREATE DATABASE RENTAL; 
USE RENTAL;


DROP TABLE IF EXISTS LANDLORD;
CREATE TABLE LANDLORD (
	Username		varchar(50),
	Password		varchar(50),
	Email			varchar(50),
	LLID 			char(5) not null,
	primary key (LLID)
);

INSERT INTO LANDLORD (Username,Password,Email,LLID)
VALUES
('James','qwerty','placeholder1@gmail.com','L0001'),
('Jeremy','hello','placeholder2@gmail.com','L0002');

DROP TABLE IF EXISTS MANAGER;
CREATE TABLE MANAGER (
	Username		varchar(50),
	Password		varchar(50),
	ManID			char(5) not null,
	primary key (ManID)
);

INSERT INTO MANAGER (Username,Password,ManID)
VALUES
('manager1','password1','M0001'),
('manager1','password1','M0002');

DROP TABLE IF EXISTS REGISTEREDRENTER;
CREATE TABLE REGISTEREDRENTER (
	Username		varchar(50),
	Password		varchar(50),
	Email			varchar(50),
	RRID			char(5) not null,
	primary key (RRID)
);

INSERT INTO REGISTEREDRENTER (Username,Password,Email,Subscribed,RRID)
VALUES
('renter1','pass1','email1@gmail.com',0,'R0001'),
('renter2','pass2','email2@gmail.com',1,'R0002');

DROP TABLE IF EXISTS PROPERTY;
CREATE TABLE PROPERTY (
	Status			varchar(10),
	HouseType		varchar(10),
	Address			varchar(50),
	BedroomNumber	integer,
	BathroomNumber	integer,
	Furnished		integer,
	Quadrant		char(2),
	RentCost		integer,
	Fee				integer,
	FeePaid			integer,
	FeePeriod		integer,
	PID 			char(5) not null,
	LLID			char(5),
	primary key (PID),
	foreign key (LLID) references LANDLORD(LLID) ON UPDATE CASCADE
);

INSERT INTO PROPERTY (Status,HouseType,Address,BedroomNumber,BathroomNumber,Furnished,Quadrant,RentCost,Fee,FeePaid,FeePeriod,PID,LLID)
VALUES
('Suspended','Detached','1231 address st',3,2,0,'NE',1000,50,0,3,'P0001','L0001'),
('Active','Bungalow','1231 address rd',4,3,1,'SE',1500,100,1,6,'P0002','L0002');

DROP TABLE IF EXISTS SUBSCRIPTION;
CREATE TABLE SUBSCRIPTION (
	HouseType		varchar(10),
	BedroomNumber	integer,
	BathroomNumber	integer,
	Furnished		integer,
	Quadrant		char(2),
	Budget			integer,
	SID 			char(5) not null,
	RRID			char(5),
	primary key (SID),
	foreign key (RRID) references REGISTEREDRENTER(RRID) ON UPDATE CASCADE
);

INSERT INTO SUBSCRIPTION (HouseType,BedroomNumber,BathroomNumber,Furnished,Quadrant,Budget,SID,RRID)
VALUES
('Bungalow',3,3,1,'SW',1250,'S0001','R0001'),
('Detached',4,3,0,'SE',1750,'S0002','R0002');
