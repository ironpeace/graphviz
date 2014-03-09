# --- !Ups

create table transaction (
	source varchar(255),
	target varchar(255),
	value varchar(255),
);


# --- !Downs

drop table if exists transaction;
