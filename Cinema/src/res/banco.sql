drop table if exists cliente;
create table cliente(
    id serial PRIMARY KEY,
    rg varchar(10) NOT NULL,
    nome varchar(40) NOT NULL,
    endereco varchar(40), 
    telefone varchar(20)
);
    
drop table if exists filme;
create table filme(
    id serial PRIMARY KEY,
    nome varchar(40) NOT NULL,
    sinopse varchar(100) NOT NULL,
    genero varchar(40) NOT NULL
);

drop table if exists sala;
create table sala(
    id serial PRIMARY KEY,
    numero int NOT NULL,
    poltronas int NOT NULL
);

drop table if exists sessao;
create table sessao(
    id serial PRIMARY KEY,
    sala int NOT NULL REFERENCES sala(id),
    data date NOT NULL,
    filme int NOT NULL REFERENCES filme(id)
    
);

