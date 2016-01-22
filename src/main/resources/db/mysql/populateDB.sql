INSERT IGNORE INTO address (ID, ADDRESS_ONE, ADDRESS_TWO, CITY, PINCODE, STATE, STREET, TRANSACTION_DATE)
       VALUES (1, '#12-254', '', 'Kalwakurthy', 'Telangana', '509324', 'Vidhya Nagar', SYSDATE());
INSERT IGNORE INTO member (ID, FIRST_NAME, LAST_NAME, GENDER, ROLE, IMAGE_PATH, ADDRESS_ID, EMAIL, PHONE_NUMBER, TRANSACTION_DATE )
       VALUES (1, 'Ravi', 'Kumar', 'Male', 'President', 'null', 1, 'damarlaravi@gmail.com', '7799557456', sysdate());

INSERT IGNORE INTO users (USERNAME, PASSWORD, ENABLED) VALUES
       ('ravi', 'ravi@123', 1),
       ('mady', 'mady@123', 1),
       ('sree', 'sree@123', 1);

INSERT IGNORE INTO user_roles (ID, first_name, last_name, ROLE, created_by, username, TRANSACTION_DATE) VALUES
       (2, 'Ravi Kumar', 'Demarla', 'ROLE_ADMIN', 'ravi', 'ravi', sysdate()),
       (1, 'Madhavi', 'Demarla', 'ROLE_USER', 'ravi', 'mady', sysdate()),
       (3, 'Sree', 'Demarla', 'ROLE_USER', 'ravi', 'sree', sysdate());