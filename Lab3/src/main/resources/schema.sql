create table if not exists fighter (
    id identity,
    name varchar2(50) not null,
    damage_per_hit int not null,
    health int not null,
    resistance numeric not null,
    anime_from varchar2(50) not null,
    created_at varchar2(50) not null
);