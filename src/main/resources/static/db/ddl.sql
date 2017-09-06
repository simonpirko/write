CREATE TABLE `users` (
  `user_id`      INT                             NOT NULL AUTO_INCREMENT,
  `first_name`   VARCHAR(255)                    NOT NULL,
  `last_name`    VARCHAR(255)                    NOT NULL,
  `password`     VARCHAR(255)                    NOT NULL,
  `born_date`    DATE DEFAULT current_date()     NOT NULL,
  `live_country` VARCHAR(255)                    NOT NULL,
  `email`        VARCHAR(255)                    NOT NULL,
  PRIMARY KEY (`user_id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE `articles` (
  `article_id`  INT                         NOT NULL AUTO_INCREMENT,
  `header`      VARCHAR(255)                NOT NULL,
  `description` VARCHAR(255)                NOT NULL,
  `text`        VARCHAR(9000)               NOT NULL,
  `author`      VARCHAR(255)                NOT NULL,
  `category`    VARCHAR(255)                NOT NULL,
  `date`        DATE DEFAULT current_date() NOT NULL,
  PRIMARY KEY (`article_id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE `categories` (
  `category_id` INT          NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255) NOT NULL,
  `url`         VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE `role` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role`    VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`role_id`)
)
ENGINE = InnoDB AUTO_INCREMENT = 2
DEFAULT CHARSET = utf8;

CREATE TABLE `user_role` (
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
)
ENGINE =InnoDB
DEFAULT CHARSET = utf8;
