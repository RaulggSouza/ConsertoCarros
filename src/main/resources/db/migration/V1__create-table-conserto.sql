create table consertos(
    id bigint not null auto_increment,
    data_entrada varchar(12) not null,
    data_saida varchar(12),
    nome varchar(30) not null,
    anos_de_experiencia int not null,
    marca varchar(20) not null,
    modelo varchar(20) not null,
    ano int not null,
    primary key (id)
);