drop table if exists round;
drop table if exists game;

create table game (
    id serial primary key,
    map text,
    date DATE
);

create table round (
    id serial primary key,
    game integer references game(id),
    game_key integer,
    round integer,
    description text
);