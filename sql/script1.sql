create table author (
       id serial primary key,
       first_name text not null,
       last_name text not null,
       middle_name text
);

create table book (
       id serial primary key,
       author_id integer not null references author(id),
       title text not null,
       isbn text not null,
       description text not null
);
