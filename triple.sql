create schema triple default character set utf8;

create table triple.USER_INFO(
	user_id varchar(100) not null primary key,
    user_point int
);
create table triple.PLACE_INFO(
	place_id varchar(100) not null primary key,
    place_nm varchar(100) not null,
    first_review_id varchar(100)
);
create table triple.POINT_HST(
	user_id varchar(100) not null,
    hst_sq int not null,
    review_id varchar(100) not null,
    place_id varchar(100) not null,
    change_point int,
    review_tm Date,
    change_status varchar(100),
    primary key(user_id,hst_sq)
);
create table triple.REVIEW_MST(
	review_id varchar(100) not null primary key,
    user_id varchar(100) not null,
    place_id varchar(100) not null,
    review_tm Date,
    review_txt varchar(200)
);
create table triple.REVIEW_DTL(
	review_id varchar(100) not null,
	img_id varchar(100) not null,
    img_sq int not null,
    primary key(review_id,img_id)
);

insert into triple.PLACE_INFO
values
('3570df7f-a977-42ef-8b70-1d0c437ba107','서울',''),
('550e8400-e29b-41d4-a716-446655440000','대전',''),
('8b80bc6a-1c5d-4b4b-a11f-f596a30d8a25','대구',''),
('c70240c6-0dcb-4cc5-a439-e88b683d888b','부산',''),
('88dd9544-50b7-4002-b709-f0cf9a50f955','광주',''),
('c64adc93-c9d3-4366-9262-22a5e8883f69','울산','');