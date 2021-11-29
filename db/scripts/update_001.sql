create table if not exists post (
                                    id serial primary key,
                                    name text,
                                    description text,
                                    created timestamp
);

create table if not exists city (
                                    id serial PRIMARY KEY,
                                    name text
);

create table if not exists candidate (
                                        id serial primary key,
                                        name text,
                                        city_id int references city(id),
                                        created timestamp
    );

create table if not exists users (
                                     id serial primary key,
                                     name text,
                                     email text,
                                     password text
);

INSERT INTO city(name) VALUES ('S-Petersburg');
INSERT INTO city(name) VALUES ('Moscow');
INSERT INTO city(name) VALUES ('Vladivostok');
