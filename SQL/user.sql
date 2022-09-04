
create database user;
use user;

create table usuario(
id int primary key auto_increment,
nome varchar(50),
telefone int,
email varchar(50),
destino varchar(40),
dias int,
valor double,
dataCadastro date
);

select * from usuario;