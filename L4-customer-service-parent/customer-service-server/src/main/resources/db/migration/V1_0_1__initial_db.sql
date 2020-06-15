CREATE TABLE IF NOT EXISTS `CUSTOMER` (
	`id` BIGINT NOT NULL PRIMARY KEY,
	`first_name` varchar(255) not null,
	`last_name` varchar(255) not null,
	`email` varchar(50) not null,
	`phone` varchar(20) not null,
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

create sequence hibernate_sequence start with 100001 increment by 1