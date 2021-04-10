--用户表
CREATE TABLE common.m_user (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45),
    password VARCHAR(45),
    address VARCHAR(45),
    birthday DATE,
    PRIMARY KEY (user_id)
)

--订单表
CREATE TABLE magicspring.m_orders (
    id INT NOT NULL AUTO_INCREMENT,
    number VARCHAR(45),
    note VARCHAR(45),
    user_id INT(45),
    dateTime DATE,
    PRIMARY KEY (id)
)