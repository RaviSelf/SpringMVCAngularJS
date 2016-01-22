CREATE DATABASE IF NOT EXISTS dev;
GRANT ALL PRIVILEGES ON dev.* TO pc@localhost IDENTIFIED BY 'pc';

USE dev;

CREATE TABLE IF NOT EXISTS address(
  id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  address_one VARCHAR(30) NOT NULL,
  address_two VARCHAR(30),
  city VARCHAR(30) NOT NULL,
  state VARCHAR(30) NOT NULL,
  pincode VARCHAR(30) NOT NULL,
  street VARCHAR(30),
  transaction_date DATE NOT NULL
)ENGINE = innoDB;

CREATE TABLE IF NOT EXISTS member(
  id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  role VARCHAR(30) NOT NULL,
  phone_number VARCHAR(30) NOT NULL ,
  gender VARCHAR(30) NOT NULL,
  email VARCHAR(30) NOT NULL,
  image_path BLOB,
  transaction_date DATE NOT NULL,
  address_id INT(11) UNSIGNED NOT NULL DEFAULT 1,
  FOREIGN KEY (address_id) REFERENCES address(id)
)ENGINE =innoDB;

-- Dumping structure for table spring_security.users
CREATE TABLE IF NOT EXISTS users (
  username varchar(45) NOT NULL,
  password varchar(450) NOT NULL,
  enabled tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (username),
  INDEX (username)
) ENGINE=InnoDB;

-- Dumping structure for table spring_security.user_roles
CREATE TABLE IF NOT EXISTS user_roles (
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  username VARCHAR(45) NOT NULL,
  role VARCHAR(45) NOT NULL,
  transaction_date DATE NOT NULL,
  created_by VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uni_username_role (role, username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*CREATE TABLE IF NOT EXISTS member(
  id INT(11) UNSIGNED NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  role VARCHAR(30),
  gender VARCHAR(30),
  image_path BLOB,
  transaction_date DATE,
  address_id INT(11) UNSIGNED NULL,
  CONSTRAINT PK_member PRIMARY KEY (id),
  CONSTRAINT FK_Member_Address FOREIGN KEY (address_id) REFERENCES Address(id),
  INDEX(last_name)
)ENGINE =innoDB;

CREATE TABLE IF NOT EXISTS address(
  id INT(11) UNSIGNED NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
  address_one VARCHAR(30),
  address_two VARCHAR(30),
  city VARCHAR(30),
  state VARCHAR(30),
  phone_number VARCHAR(30),
  pincode VARCHAR(30),
  street VARCHAR(30),
  transaction_date DATE,
  CONSTRAINT PK_member PRIMARY KEY (id),
  INDEX(address_one)
)ENGINE = innoDB;*/
