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

SET SERVEROUTPUT ON
BEGIN
     Dbms_Output.Put_Line(Systimestamp);
END;
/

CREATE TABLE Usuarios (
    Id_usuario INTEGER NOT NULL CONSTRAINT USUARIO_PK PRIMARY KEY,
    permissionLevel INTEGER NOT NULL,
    isTecnico INTEGER NOT NULL,
	Nome VARCHAR(128) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    Email VARCHAR(64) NOT NULL,
    Senha VARCHAR(128) NOT NULL,    
    Telefone VARCHAR(16) NOT NULL,
    Estado VARCHAR(32) NOT NULL,
    Cidade VARCHAR(32) NOT NULL,
    cep VARCHAR(32) NOT NULL,
    bairro VARCHAR(64),
    rua VARCHAR(64),
    complemento VARCHAR(64));
	
CREATE TABLE Enderecos_Secundarios (
	ID_Endereco INTEGER NOT NULL CONSTRAINT ENDERECO_PK PRIMARY KEY,
	ID_Usuario INTEGER NOT NULL,
	Estado VARCHAR2(64),
	Cep VARCHAR2(64),
	Cidade VARCHAR2(64),
	Bairro VARCHAR2(64),
	Rua VARCHAR2(64),
	Numero VARCHAR2(64),
	Complemento VARCHAR2(64),
    CONSTRAINT FK_Endereco_Usuario FOREIGN KEY(ID_Usuario) REFERENCES USUARIOS(ID_USUARIO));

CREATE TABLE Categorias_Servicos (
    ID_Categoria INTEGER NOT NULL CONSTRAINT CATEGORIA_PK PRIMARY KEY,
    Descricao VARCHAR(64));

CREATE TABLE Servicos (
    ID_Servico INTEGER NOT NULL CONSTRAINT SERVICO_PK PRIMARY KEY,
    ID_Tecnico INTEGER NOT NULL,
    ID_Categoria INTEGER NOT NULL,
    Descricao VARCHAR2(64),
    Preco NUMBER(8,2),   
    CONSTRAINT FK_Tecnico FOREIGN KEY(ID_Tecnico) REFERENCES Usuarios(id_usuario),
    CONSTRAINT FK_Categoria FOREIGN KEY(ID_Categoria) REFERENCES Categorias_Servicos(ID_CATEGORIA));
	    
CREATE TABLE Pedidos (
	ID_Pedido INTEGER NOT NULL CONSTRAINT PEDIDO_PK PRIMARY KEY,
	ID_Usuario_Solicitante INTEGER NOT NULL,
	ID_Tecnico INTEGER NOT NULL,
	ID_Servico INTEGER NOT NULL,
	Data_Solicitacao timestamp,
	Data_Finalizacao timestamp,
	Nota INTEGER,
    CONSTRAINT FK_PEDIDO_SERVICO FOREIGN KEY(ID_Servico) REFERENCES SERVICOS(ID_Servico),
	CONSTRAINT FK_USUARIO_SOLICITANTE FOREIGN KEY(ID_Usuario_Solicitante) REFERENCES USUARIOS(ID_USUARIO),
	CONSTRAINT FK_PEDIDO_TECNICO FOREIGN KEY(ID_Tecnico) REFERENCES USUARIOS(ID_USUARIO));
	   
CREATE SEQUENCE USUARIOS_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SERVICOS_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE CATEGORIAS_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE PEDIDOS_SEQ
START WITH 1
INCREMENT BY 1;

--DROP SEQUENCE USUARIOS_SEQ
--DROP SEQUENCE SERVICOS_SEQ
--DROP SEQUENCE CATEGORIAS_SEQ
--DROP SEQUENCE PEDIDOS_SEQ
      
-------------------------------MASSAS PARA TESTES-----------------------------------------------------------------
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Chaveiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Desenvolvedor');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Eletricista');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Desentupidor');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Detetizador');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Encanador');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Jardineiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Pedreiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Piscineiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Vidraceiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Terraplanista');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(USUARIOS_SEQ.NEXTVAL,1,1,'00000000000', 'rafael@hotmail.com', '123456', 'Rafael Mateus', '123456789', 'TESTSTATE', 'TESTCITY', 'TESTE', 'TESTE', 'TESTE','TESTE');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(USUARIOS_SEQ.NEXTVAL,1,1,'00000000000', 'joao@hotmail.com', '56465464', 'Joao Pedro', '123456789', 'TESTSTATE', 'TESTCITY', 'TESTE', 'TESTE', 'TESTE','TESTE');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(USUARIOS_SEQ.NEXTVAL,1,1,'00000000000', 'thanos@hotmail.com', '123456', 'Thanos', '123456789', 'Parana', 'Anywhere', 'TESTE', 'TESTE', 'TESTE','TESTE');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(USUARIOS_SEQ.NEXTVAL,1,1,'00000000000', 'Maria@hotmail.com', '123456', 'Maria da Massa', '123456789', 'MASSSTATE', 'TESTCITY', 'TESTE', 'TESTE', 'TESTE','TESTE');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(USUARIOS_SEQ.NEXTVAL,1,1,'00000000000', 'jhonny@hotmail.com', '123456', 'Jhonny test', '123456789', 'TESTSTATE', 'TESTCITY', 'TESTE', 'TESTE', 'TESTE','TESTE');

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 1, 11, 'Terraplanagem de terros grandes 2', 850.00);

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 2, 3, 'Concerto de fiacao eletrica', 250.00);

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 3, 9, 'Manutencao em piscina', 150.00);

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 4, 9, 'Limpeza em piscina', 150.00);

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 5, 9, 'Concerto piscina', 500.00);

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 1, 5, 'Detetizacao Basica', 100.00);

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 2, 7, 'Podagem pequena', 250.00);

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 2, 7, 'Podagem Grande', 350.00);

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 4, 3, 'Reforma estrutura eletrica', 1500.00);

insert into servicos(id_servico, ID_Tecnico, id_categoria, descricao, preco) values
	(SERVICOS_SEQ.NEXTVAL, 5, 11, 'Terraplanagem terros pequenos', 510.00);

insert into pedidos (id_pedido, id_usuario_solicitante, id_tecnico, id_servico, data_solicitacao, data_finalizacao, nota)
    VALUES  (PEDIDOS_SEQ.NEXTVAL,1,2,1, current_timestamp, current_timestamp,null);
        
insert into pedidos (id_pedido, id_usuario_solicitante, id_tecnico, id_servico, data_solicitacao, data_finalizacao, nota)
    VALUES  (PEDIDOS_SEQ.NEXTVAL,1,3,2, current_timestamp, current_timestamp,null);

insert into pedidos (id_pedido, id_usuario_solicitante, id_tecnico, id_servico, data_solicitacao, data_finalizacao, nota)
    VALUES  (PEDIDOS_SEQ.NEXTVAL,1,2,4, current_timestamp, current_timestamp,null);

insert into pedidos (id_pedido, id_usuario_solicitante, id_tecnico, id_servico, data_solicitacao, data_finalizacao, nota)
    VALUES  (PEDIDOS_SEQ.NEXTVAL,1,4,3, current_timestamp, current_timestamp,null);

insert into pedidos (id_pedido, id_usuario_solicitante, id_tecnico, id_servico, data_solicitacao, data_finalizacao, nota)
    VALUES  (PEDIDOS_SEQ.NEXTVAL,1,5,4, current_timestamp, current_timestamp,null);
    
insert into pedidos(id_pedido,id_usuario_solicitante,id_tecnico,id_servico,data_solicitacao,data_finalizacao,nota) 
	VALUES (PEDIDOS_SEQ.NEXTVAL, 1, 2, 1, null, null, null);
       
COMMIT;

------------------------------------PROCEDURES------------------------------------
CREATE OR REPLACE PROCEDURE GET_TOTAL_USUARIOS
IS
  var_totalUsuarios NUMBER(20);
BEGIN

SELECT count(ID_USUARIO)
INTO var_totalUsuarios

FROM USUARIOS;
  DBMS_OUTPUT.PUT_LINE('A quantidade total de usuarios e de ' ||var_totalUsuarios|| ' Usuarios.');
END GET_TOTAL_USUARIOS;
/

--exec get_total_usuarios;

CREATE OR REPLACE PROCEDURE GET_SERVICO_MAIS_CARO
IS
  var_nomeServico varchar(255);
  var_precoServico number(8,2);
BEGIN
    SELECT descricao, preco INTO var_nomeServico, var_precoServico
FROM SERVICOS WHERE preco = (select max(preco) from servicos);
  DBMS_OUTPUT.PUT_LINE('O servico mais caro registrado no sistema e o : '||'"'|| var_nomeServico ||'"'|| ' com o valor de ' || 'R$ ' || var_precoServico || '.');
END GET_SERVICO_MAIS_CARO;
/

--exec GET_SERVICO_MAIS_CARO;

CREATE OR REPLACE PROCEDURE QUANTIDADE_TECNICOS_POR_ESTADO (pEstado nvarchar2)
IS
  count_tecnicos integer;
BEGIN
    SELECT count(id_usuario)
INTO count_tecnicos
FROM USUARIOS where estado = pEstado AND istecnico = 1;
  DBMS_OUTPUT.PUT_LINE('O Estado '|| pEstado|| ' contem ' || count_tecnicos || ' tecnicos.');
END QUANTIDADE_TECNICOS_POR_ESTADO;
/

--exec QUANTIDADE_TECNICOS_POR_ESTADO('Parana');

CREATE OR REPLACE PROCEDURE CAT_MAIOR_NUMERO_SERVICOS
IS
   var_id_categoria integer;
   var_descricao nvarchar2(255);
   var_categoria NUMBER(20);
   var_countServicos NUMBER(20);
BEGIN
    SELECT Z.* INTO var_id_categoria,var_descricao,var_countServicos
		FROM ( SELECT A.*, (SELECT COUNT(*) FROM servicos B WHERE A.ID_CATEGORIA = B.ID_CATEGORIA) AS contagem FROM categorias_servicos A) Z where 
    Z.contagem = (SELECT MAX(k.CONTAGEM) FROM (SELECT A.*, (SELECT COUNT(*) FROM servicos B WHERE A.ID_CATEGORIA = B.ID_CATEGORIA) AS contagem FROM categorias_servicos A) K);
    
  DBMS_OUTPUT.PUT_LINE('A categoria com maior numero de servicos e a de ' ||var_descricao|| ' com ' || var_countServicos || ' servicos cadastrados.');

END CAT_MAIOR_NUMERO_SERVICOS;
/

--exec CAT_MAIOR_NUMERO_SERVICOS;

CREATE OR REPLACE PROCEDURE VERIFICA_SERVICO_FINALIZADO (pID_PEDIDO NUMBER)
IS
    var_ID_PEDIDO NUMBER(38,0);
    var_DATA_FINALIZACAO TIMESTAMP;      
BEGIN
	SELECT ID_PEDIDO, DATA_FINALIZACAO INTO var_ID_PEDIDO, var_DATA_FINALIZACAO FROM PEDIDOS WHERE ID_PEDIDO = pID_PEDIDO;    
     if var_DATA_FINALIZACAO is not null
       then
            DBMS_OUTPUT.PUT_LINE('O pedido ' ||var_ID_PEDIDO|| ' ja foi finalizado.');
            DBMS_OUTPUT.PUT_LINE('Data da finalizacao: ' ||var_DATA_FINALIZACAO|| ' .');     
    else
        DBMS_OUTPUT.PUT_LINE('O pedido ' ||var_ID_PEDIDO|| ' ainda nao foi finalizado.');    
    END IF;              
END VERIFICA_SERVICO_FINALIZADO;
/
--exec verifica_servico_finalizado(5)
--exec verifica_servico_finalizado(6)
------------------------------------END PROCEDURES------------------------------------

------------------------------------SCRIPT ROLLBACK------------------------------------
--drop table pedidos;
--drop table servicos;
--drop table categorias_Servicos;
--drop table enderecos_Secundarios;
--drop table usuarios;
--commit;
--disconnect
--connect system/system
--drop user iService cascade;
--disconnect
------------------------------------SCRIPT ROLLBACK------------------------------------