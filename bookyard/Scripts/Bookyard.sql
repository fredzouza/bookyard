create table pessoa(
	id int auto_increment primary key,
	nome varchar(20) not null,
	sobrenome varchar(50) not null,
	cpf bigint not null unique key,
	rg bigint unique key,
	data_nascimento date,
	sexo char not null
);

create table uf(
	id int auto_increment primary key,
	descricao varchar(50) not null
);

create table municipio(
	id int auto_increment primary key,
	descricao varchar(50) not null,
	codigo_ibge int
);

create table endereco(
	id int auto_increment primary key,
	logradouro varchar(80) not null,
	numero varchar(10),
	complemento varchar(150),
	id_pessoa int,
	id_uf int,
	id_municipio int,
	foreign key (id_pessoa) references pessoa(id),
	foreign key (id_uf) references uf(id),
	foreign key (id_municipio) references municipio(id)
);

create table tipo_telefone(
	id int auto_increment primary key,
	tipo varchar(30) not null
);

insert into tipo_telefone (tipo) values ('celular');
insert into tipo_telefone (tipo) values ('celular2');
insert into tipo_telefone (tipo) values ('casa');
insert into tipo_telefone (tipo) values ('trabalho');
insert into tipo_telefone (tipo) values ('fax');

create table telefone(
	id int auto_increment primary key,
	ddd int,
	numero int,
	id_pessoa int,
	id_tipo_telefone int,
	foreign key (id_pessoa) references pessoa(id),
	foreign key (id_tipo_telefone) references tipo_telefone(id)
);


create table livro(
	id int auto_increment primary key,
	titulo varchar(100) not null,
	sumario varchar(255),
	id_autor int not null,
	editora varchar(100),
	sbn int,
	ano int,
	data_cadastro date not null,
	foreign key (id_autor) references pessoa(id)
);

create table compra(
	id int auto_increment primary key,
	nota_fiscal int not null,
	serie varchar(10),
	data_compra date not null,
	valor decimal
);

create table compra_item(
	id_compra int not null,
	id_livro int not null,
	quantidade int not null,
	valor_unitario decimal not null,
	foreign key (id_compra) references compra(id),
	foreign key (id_livro) references livro(id)
);

create table venda(
	id int auto_increment primary key,
	data_venda date not null,
	valor decimal not null
);

create table venda_item(
	id_venda int not null,
	id_livro int not null,
	quantidade int not null,
	valor_unitario decimal not null,
	foreign key (id_venda) references venda(id),
	foreign key (id_livro) references livro(id)
);

create table estoque(
	id_livro int,
	quantidade int,
	foreign key (id_livro) references livro(id)
);

create table editora(
	id int auto_increment primary key,
	nome varchar(100)
);
