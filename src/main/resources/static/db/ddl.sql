CREATE TABLE `users` (
  `users_id`     BIGINT                          NOT NULL AUTO_INCREMENT,
  `first_name`   VARCHAR(255)                    NOT NULL,
  `last_name`    VARCHAR(255)                    NOT NULL,
  `password`     VARCHAR(255)                    NOT NULL,
  `born_date`    DATE DEFAULT current_date()     NOT NULL,
  `live_country` VARCHAR(255)                    NOT NULL,
  PRIMARY KEY (`users_id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE `articles` (
  `articles_id` BIGINT        NOT NULL AUTO_INCREMENT,
  `caption`     VARCHAR(255)  NOT NULL,
  `description` VARCHAR(255)  NOT NULL,
  `heading`     VARCHAR(9000) NOT NULL,
  `author`      VARCHAR(255)  NOT NULL,
  `category`    VARCHAR(255)  NOT NULL,
  PRIMARY KEY (`articles_id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE `categories` (
  `category_id` INT          NOT NULL AUTO_INCREMENT,
  `category`    VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;