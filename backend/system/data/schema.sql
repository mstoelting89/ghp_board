DROP TABLE IF EXISTS `news`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `news` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `news_author` varchar(255) NOT NULL,
    `news_date` datetime NOT NULL,
    `news_image` varchar(255) DEFAULT NULL,
    `news_text` varchar(255) NOT NULL,
    `news_title` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `email` varchar(255) DEFAULT NULL,
    `enabled` bit(1) DEFAULT NULL,
    `locked` bit(1) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `user_role` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

