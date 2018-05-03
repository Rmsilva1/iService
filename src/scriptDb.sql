CONNECT system/system

CREATE TABLESPACE
iService
DATAFILE 'iService.dbf' SIZE 40M ONLINE;

CREATE USER iService IDENTIFIED BY iService
DEFAULT TABLESPACE iService
TEMPORARY TABLESPACE TEMP;

GRANT DBA TO iService ;

DISCONNECT;

CONNECT iService/iService

CREATE TABLE Usuarios (
    id_usuario INTEGER NOT NULL CONSTRAINT USUARIO_PK PRIMARY KEY,
    isTecnico INTEGER NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    Email VARCHAR(64) NOT NULL,
    Senha VARCHAR(128) NOT NULL,
    Nome VARCHAR(128) NOT NULL,
    Telefone VARCHAR(16) NOT NULL,
    Estado VARCHAR(32) NOT NULL,
    Cidade VARCHAR(32) NOT NULL,
    cep VARCHAR(32) NOT NULL,
    bairro VARCHAR(64),
    rua VARCHAR(64) ,
    complemento VARCHAR(64));

) TABLESPACE iService;


CREATE TABLE CATEGORIA (
    ID_Categoria INTEGER NOT NULL CONSTRAINT CATEGORIA_PK PRIMARY KEY,
    Descricao NVARCHAR2(255)
    );
    
CREATE TABLE SERVICOS (
    ID_Servico INTEGER NOT NULL CONSTRAINT SERVICO_PK PRIMARY KEY,
    ID_Usuario INTEGER NOT NULL,
    ID_Categoria INTEGER NOT NULL,
    Descricao NVARCHAR2(255),
    Preco NUMBER(8,2),   
    CONSTRAINT FK_Usuario FOREIGN KEY(ID_Usuario) REFERENCES USUARIOS(ID_USUARIO),
    CONSTRAINT FK_Categoria FOREIGN KEY(ID_Categoria) REFERENCES CATEGORIA(ID_CATEGORIA)
    );
    
    
insert into categoria(id_categoria, descricao) values (1, 'Encanador');
insert into categoria(id_categoria, descricao) values (2, 'Eletricista');
insert into categoria(id_categoria, descricao) values (3, 'Piscineiro');
insert into categoria(id_categoria, descricao) values (4, 'Detetizador');

drop table servicos;   
drop table categoria;    
drop table usuarios;
    
CREATE SEQUENCE USUARIO_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SERVICO_SEQ
START WITH 1
INCREMENT BY 1;
