create database if not exists sat_db;
use sat_db;

create table if not exists sat_db.sat_response
(
    id           binary(16)   not null
    primary key,
    nSat         varchar(30)  null,
    envio        datetime     null,
    recebimento  datetime     null,
    cupons       int          null,
    situacaoLote varchar(255) null,
    constraint nSat
    unique (nSat)
    );

create table if not exists sat_db.cfe
(
    id       binary(16)   not null
    primary key,
    nSat     varchar(30)  null,
    chaveCfe varchar(50)  null,
    nCupom   int          null,
    situacao varchar(255) null,
    constraint FK_nSat
    foreign key (nSat) references sat_db.sat_response (nSat)
    );

