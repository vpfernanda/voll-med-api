create table paciente(
    id bigint not null auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    telefone varchar(255) not null,
    logradouro varchar(255) not null,
    bairro varchar(255) not null,
    cep varchar(255) not null,
    cidade varchar(255) not null,
    complemento varchar(255),
    numero varchar(255),
    uf enum ('AC','AL','AM','AP','BA','CE','DF','ES','GO','MA','MG','MS','MT','PA','PB','PE','PI','PR','RJ','RN','RO','RR','RS','SC','SE','SP','TO'),
    primary key (id)
)

engine=InnoDB;