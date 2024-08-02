create database gestao_venda1;

use gestao_venda1;

create table usuario(
id bigint primary key auto_increment,
nome varchar(10) not null,
usuario varchar(50) not null unique,
senha varchar(100) not null,
perfil varchar(10) not null default 'Padrao',
estado boolean not null default true,
data_hora_criacao datetime default current_timestamp,
ultimo_login datetime default'0001-01-01 00:00:00'
);




create table categoria(
id int primary key auto_increment,
nome varchar(50) not null unique,
descricao varchar(200)
);

create table produto(
id bigint primary key auto_increment,
nome varchar(50) not null unique,
descricao varchar(200),
proco decimal(10,2) not null,
quantidade int null,
categoria_id int not null,
usuario_id bigint not null,
data_hora_criacao datetime default current_timestamp,
constraint fk_produto_categoria foreign key(categoria_id) references categoria(id),
constraint fk_produto_usuario foreign key(usuario_id) references usuario(id)
);

create table cliente(
id int primary key auto_increment,
nome varchar(30),
telefone varchar(14),
endereço varchar(150)
);

create table venda(
id int primary key auto_increment,
total_venda decimal(10,2),
valor_pago decimal(10,2) not null,
troco decimal(10,2) not null,
desconto decimal(10,2) not null,
cliente_id int,
usuario_id bigint not null,
data_hora_criacao datetime default current_timestamp,
ultima_atualizacao datetime default current_timestamp
);

create table venda_item(
venda_id int not null,
produto_id bigint not null,
quantidade int not null,
total decimal(10,2) not null,
desconto decimal(10,2) not null,
constraint fk_venda_item_venda foreign key(venda_id) references venda(id),
constraint fk_venda_item_produto foreign key(produto_id) references produto(id)
);