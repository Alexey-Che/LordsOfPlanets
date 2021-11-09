create table jpa.lord_table
(
    id   serial
        constraint table_name_pk
            primary key,
    name varchar not null,
    age  int     not null
);

create table jpa.planet_table
(
    id      serial
        constraint planet_table_pk
            primary key,
    name    varchar not null,
    lord_id int
        constraint planet_table_lord_table_id_fk
            references jpa.lord_table
);