create database db_bookstore;
use db_bookstore;


create table tb_category(
	id varchar(40) primary key,
	name varchar(40) not null unique,
	descrition varchar(255)
);


create  table tb_book(
	id varchar(40) primary key,
	name varchar(40) not null unique,
	price decimal(8,2) not null,
	author varchar(40) not null,
	image varchar(255),
	description varchar(255),
	tb_category_id varchar(40),
	constraint category_id_FK foreign key(tb_category_id) references tb_category(id)
);

create table tb_orders(
	id varchar(40) primary key,
	ordertime datetime not null,
	state boolean not null,
	price decimal(8,2) not null,
	tb_user_id varchar(40),
	constraint tb_user_id_Fk foreign key (tb_user_id) references tb_user(id)
	
);


create table tb_orderitem(
	id varchar(40) primary key,
	quantity int not null,
	price decimal(8,2) not null,
	book_id varchar(40),
	constraint book_id_FK foreign key(tb_book_id) references tb_book(id),
	tb_orders_id varchar(40),
	constraint order_id_FK foreign key(tb_orders_id) references tb_orders(id) 
);

create table tb_user(
	id varchar(40) primary key,
	username varchar(40) not null unique,
	password varchar(40) not null,
	phone varchar(20) not null,
	cellphone varchar(20) not null,
	email varchar(40) not null,
	address varchar(255) not null
);

