create database itensPedido;
use itensPedido;

create table pedido(
id int primary key auto_increment,
nome varchar(50),
email varchar(50),
telefone int,
destino varchar(40),
aerea varchar(40),
preco double
);

ALTER TABLE pedido
DROP COLUMN preco;
select * from pedido;