CREATE TABLE `users` (
  `users_id`     INT                             NOT NULL AUTO_INCREMENT,
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
  `article_id`  INT           NOT NULL AUTO_INCREMENT,
  `header`      VARCHAR(255)  NOT NULL,
  `description` VARCHAR(255)  NOT NULL,
  `text`        VARCHAR(9000) NOT NULL,
  `author`      VARCHAR(255),
  `category`    VARCHAR(255),
  `date`        DATE                   DEFAULT current_date(),
  PRIMARY KEY (`article_id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE `categories` (
  `category_id` INT          NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255) NOT NULL,
  `url`         VARCHAR(255),
  PRIMARY KEY (`category_id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;