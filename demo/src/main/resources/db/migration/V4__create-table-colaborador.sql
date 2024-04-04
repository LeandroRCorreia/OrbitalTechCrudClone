CREATE TABLE colaborador(
    id bigint  not null auto_increment,
    nome varchar(60) not null,
    cpf varchar(15) not null,
    data_nascimento date not null,
    matricula_soma varchar(20) not null,
    cep varchar(15)  not null,
    logradouro varchar(50) not null,
    numero varchar(3) not null,
    complemento varchar(50),
    bairro varchar(50),
    cidade varchar(20),
    estado varchar(20),
    ativo tinyint not null,
    data_cadastro date not null,

    primary key(id)
);
