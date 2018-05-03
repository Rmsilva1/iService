CONNECT system/system

CREATE TABLESPACE
iService
DATAFILE 'iService.dbf' SIZE 40M ONLINE;

CREATE USER iService IDENTIFIED BY iService
DEFAULT TABLESPACE iService
TEMPORARY TABLESPACE TEMP;

GRANT DBA TO iService;

DISCONNECT;

CONNECT iService/iService

CREATE TABLE Usuarios (
    id_usuario INTEGER NOT NULL CONSTRAINT USUARIO_PK PRIMARY KEY,
    permissionLevel INTEGER NOT NULL,
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
    Descricao VARCHAR(64)
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

------------------------------------PROCEDURES------------------------------------
--CREATE OR REPLACE PROCEDURE GET_TOTAL_USUARIOS
--IS
--  var_totalUsuarios NUMBER(20);
--BEGIN

--SELECT count(ID_USUARIO)
--INTO var_totalUsuarios

--FROM iservice.USUARIOS;
--  DBMS_OUTPUT.PUT_LINE('A quantidade total de usuarios é de ' ||var_totalUsuarios|| ' Usuarios.');
--END GET_TOTAL_USUARIOS;
--/

--CREATE OR REPLACE PROCEDURE GET_SERVICO_MAIS_CARO
--IS
--  var_nomeServico varchar(255);
--  var_precoServico NUMBER(8,2)
  
--BEGIN

--SELECT Descricao, max(Preco)
--INTO var_nomeServico, var_precoServico

--FROM iservice.SERVICOS;

--  DBMS_OUTPUT.PUT_LINE('O servico mais caro é o ' ||var_nomeServico|| ' Com o valor de ' || 'R$ ' ||var_precoServico '.');

--END GET_SERVICO_MAIS_CARO;
--/

--CREATE OR REPLACE PROCEDURE GET_ESTADO_COM_MAIOR_NUMERO_TECNICOS
--IS
--  var_estado VARCHAR(32);
--  count_tecnicos NUMBER;
--BEGIN

--SELECT count(codigo_estado)
--INTO var_estado

--FROM projeto_iservice.estado;

--  DBMS_OUTPUT.PUT_LINE('O Estado com maior numero de tecnicos é o ' ||var_estado|| ' com' || count_tecnicos || ' tecnicos.');

--END GET_ESTADO_COM_MAIOR_NUMERO_TECNICOS;
--/

--CREATE OR REPLACE PROCEDURE GET_CATEGORIA_COM_MAIOR_NUMERO_SERVICOS
--IS
--  var_countServicos NUMBER(20);
--  var_categoria  NUMBER(20);
--BEGIN

--SELECT count(codigo_estado)
--INTO var_totalEst

--FROM projeto_iservice.estado;

--  DBMS_OUTPUT.PUT_LINE('A categoria com maior numero de servicos é a ' ||var_categoria|| ' com ' || var_servicos || '.');

--END GET_CATEGORIA_COM_MAIOR_NUMERO_SERVICOS;
--/

--CREATE OR REPLACE PROCEDURE GET_QUANTIDADEDEESTADOS
--IS
--  var_totalEst NUMBER(20);
--BEGIN

--SELECT count(codigo_estado)
--INTO var_totalEst

--FROM projeto_iservice.estado;

--  DBMS_OUTPUT.PUT_LINE('A quantidade total de estados é de ' ||var_totalEst|| ' Estados.');

--END Get_QuantidadeDeEstados;
--/
------------------------------------PROCEDURES------------------------------------
drop table servicos;   
drop table categoria;    
drop table usuarios;
    
CREATE SEQUENCE USUARIO_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SERVICO_SEQ
START WITH 1
INCREMENT BY 1;
