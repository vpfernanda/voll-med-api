create table medico (
                        id bigint not null auto_increment,
                        bairro varchar(255),
                        cep varchar(255),
                        cidade varchar(255),
                        complemento varchar(255),
                        crm varchar(255),
                        email varchar(255),
                        logradouro varchar(255),
                        nome varchar(255),
                        numero varchar(255),
                        telefone varchar(255),
                        especialidade enum ('CARDIOLOGIA','DERMATOLOGIA','GINECOLOGIA','ORTOPEDIA'),
                        uf enum ('AC','AL','AM','AP','BA','CE','DF','ES','GO','MA','MG','MS','MT','PA','PB','PE','PI','PR','RJ','RN','RO','RR','RS','SC','SE','SP','TO'),
                        primary key (id)
) engine=InnoDB;
