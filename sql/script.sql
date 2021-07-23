create table accounts
(
    id        int,
    surname   text,
    name      text,
    mail      text not null,
    username  text not null
        constraint accounts_pk
            primary key,
    password  TEXT not null,
    birthDate date
);

create index accounts__index_id
    on accounts (id);

create table elements
(
    path        text,
    title       text,
    id          INTEGER
        constraint elements_pk
            primary key autoincrement,
    description json
);

create unique index elements_emplacement_uindex
    on elements (path);


