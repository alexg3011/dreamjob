CREATE TABLE post (
                      id SERIAL PRIMARY KEY,
                      name TEXT
);

CREATE TABLE candidate (
                           id SERIAL PRIMARY KEY,
                           name TEXT
);

delete from post;
delete from candidate;