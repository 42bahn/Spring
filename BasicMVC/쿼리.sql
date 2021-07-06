CREATE TABLE `board` (
	`board_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`category` VARCHAR(200) NOT NULL DEFAULT '',
 	`title` VARCHAR(200) NOT NULL,
 	`author` VARCHAR(50) NOT NULL,
	`content` VARCHAR(500),
	`insert_date` DATETIME NOT NULL DEFAULT NOW(),
 	PRIMARY KEY (`board_id`)
)
COLLATE='utf8mb4_general_ci'
;
