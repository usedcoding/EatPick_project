DROP
DATABASE IF EXISTS proj1;
CREATE
DATABASE proj1;

USE
proj1;

SHOW
tables;

SELECT *
FROM `member`;
SELECT *
FROM article;

DESC `member`;
DESC article;

DROP TABLE `member`;
DROP TABLE article;

CREATE TABLE `member`
(
    id         int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nickname   char(100) NOT NULL UNIQUE,
    `password` char(100) NOT NULL,
    regDate    datetime  NOT NULL
);

CREATE TABLE article
(
    id        int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category  char(100) NOT NULL,
    foodName  char(100) NOT NULL,
    brandName char(100) NOT NULL,
    price     int       NOT NULL,
    weight    int       NOT NULL,
    `scope`   int       NOT NULL,
    review    text      NOT NULL,
    writer    char(100) NOT NULL,
    regDate   datetime  NOT NULL
);

INSERT INTO `member`
SET nickname = "",
`password` = "",
regDate = now();

INSERT INTO `article`
SET category = "",
foodName = "",
brandName = "",
price = ,
weight = ,
`scope` = ,
review = "",
writer = "",
regDate = now();
