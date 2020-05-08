drop table if exists aluno;

create table aluno(
 id_aluno bigint auto_increment,
 nome varchar(100) not null,
 email varchar(100) not null,
 idade int not null,
 primary key(id_aluno));