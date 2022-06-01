create table news
(
    id          bigint auto_increment
        primary key,
    news_author varchar(255) not null,
    news_date   datetime     not null,
    news_image  varchar(255) null,
    news_text   varchar(255) not null,
    news_title  varchar(255) not null
);

INSERT INTO ghp_board.news (id, news_author, news_date, news_image, news_text, news_title) VALUES (1, 'Michael', '2022-06-01 21:16:20', null, 'Foo Bar', 'Dies ist der erste Titel');
