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
    rua VARCHAR(64),
    complemento VARCHAR(64));

CREATE TABLE Categorias_Servicos (
    ID_Categoria INTEGER NOT NULL CONSTRAINT CATEGORIA_PK PRIMARY KEY,
    Descricao VARCHAR(64));

CREATE TABLE Servicos (
    ID_Servico INTEGER NOT NULL CONSTRAINT SERVICO_PK PRIMARY KEY,
    ID_Usuario INTEGER NOT NULL,
    ID_Categoria INTEGER NOT NULL,
    Descricao VARCHAR2(64),
    Preco NUMBER(8,2),   
    CONSTRAINT FK_Usuario FOREIGN KEY(ID_Usuario) REFERENCES Usuarios(id_usuario),
    CONSTRAINT FK_Categoria FOREIGN KEY(ID_Categoria) REFERENCES Categorias_Servicos(ID_CATEGORIA));
	
CREATE TABLE Endereco2 (
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
	
CREATE TABLE Avaliacoes (
	ID_Avaliacao INTEGER NOT NULL CONSTRAINT AVALIACAO_PK PRIMARY KEY,
	ID_Servico INTEGER NOT NULL,
	Nota INTEGER NOT NULL,
    CONSTRAINT FK_SERVICO FOREIGN KEY(ID_Servico) REFERENCES SERVICOS(ID_Servico));
    
CREATE TABLE Pedidos (
	ID_Pedido INTEGER NOT NULL CONSTRAINT PEDIDO_PK PRIMARY KEY,
	ID_USUARIO_SOLICITANTE INTEGER NOT NULL,
	ID_Servico INTEGER NOT NULL,
	ID_Nota INTEGER NOT NULL,
	Data_Solicitacao timestamp,
	Data_Finalizacao timestamp,
    CONSTRAINT FK_PEDIDO_SERVICO FOREIGN KEY(ID_Servico) REFERENCES SERVICOS(ID_Servico),
	CONSTRAINT FK_USUARIO_SOLICITANTE FOREIGN KEY(ID_USUARIO_SOLICITANTE) REFERENCES USUARIOS(ID_USUARIO));
	
CREATE TABLE Pedidos_Finalizados (
	ID_Pedido_Finalizado INTEGER NOT NULL CONSTRAINT SERVICO_FINALIZADO_PK PRIMARY KEY,
	ID_Servico INTEGER NOT NULL,
    ID_Pedido INTEGER NOT NULL,
	ID_Categoria INTEGER NOT NULL,
	ID_NOTA INTEGER NOT NULL,
	DataFinalizacao TIMESTAMP,
	ID_USUARIO_CONTRATANTE INTEGER NOT NULL,
	ID_TECNICO_FORNECEDOR INTEGER NOT NULL,
    CONSTRAINT FK_Servico_Finalizado FOREIGN KEY(ID_Servico) REFERENCES SERVICOS(ID_Servico),
	CONSTRAINT FK_NOTA FOREIGN KEY(ID_NOTA) REFERENCES AVALIACOES(ID_AVALIACAO),
    CONSTRAINT FK_ID_PEDIDO FOREIGN KEY(ID_Pedido) REFERENCES PEDIDOS(ID_Pedido),
    CONSTRAINT FK_Pedido_Finalizada FOREIGN KEY(ID_Categoria) REFERENCES Categorias_Servicos(ID_CATEGORIA));
   
CREATE SEQUENCE USUARIO_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SERVICO_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE CATEGORIAS_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE PEDIDOS_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SERVICOS_FINALIZADOS_SEQ
START WITH 1
INCREMENT BY 1;
       
-------------------------------MASSAS PARA TESTES-----------------------------------------------------------------
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Chaveiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Detetizador');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Desentupidor');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Eletricista');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Encanador');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Jardineiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Pedreiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Piscineiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Vidraceiro');
INSERT INTO Categorias_Servicos(id_categoria, descricao) VALUES (CATEGORIAS_SEQ.NEXTVAL,'Terraplanista');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(1,1,1,'00000000000', 'rafael@hotmail.com', '123456', 'Rafael Mateus', '123456789', 'Parana', 'Curitiba', 'TESTE', 'TESTE', 'TESTE','TESTE');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(2,1,1,'00000000000', 'joao@hotmail.com', '56465464', 'Joao Pedro', '123456789', 'Parana', 'Guaratuba', 'TESTE', 'TESTE', 'TESTE','TESTE');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(3,1,1,'00000000000', 'thanos@hotmail.com', '123456', 'Thanos', '123456789', 'Parana', 'Matinhos', 'TESTE', 'TESTE', 'TESTE','TESTE');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(4,1,1,'00000000000', 'Maria@hotmail.com', '123456', 'Maria da Massa', '123456789', 'Parana', 'Curitiba', 'TESTE', 'TESTE', 'TESTE','TESTE');

insert into usuarios(ID_USUARIO, PERMISSIONLEVEL, ISTECNICO, CPF, EMAIL, SENHA, NOME, TELEFONE, ESTADO, CIDADE, CEP, BAIRRO, RUA,
COMPLEMENTO) VALUES(5,1,1,'00000000000', 'jhonny@hotmail.com', '123456', 'Jhonny test', '123456789', 'Parana', 'Sao Jose', 'TESTE', 'TESTE', 'TESTE','TESTE');


/
insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(99, 1, 10, 'Terraplanagem de terros grandes 2', 850.00);
COMMIT;
insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(2, 1, 4, 'Concerto de fiacao eletrica', 250.00);

insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(3, 1, 8, 'Manutencao em piscina', 150.00);

insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(4, 1, 8, 'Limpeza em piscina', 150.00);

insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(5, 1, 8, 'Concerto pscina', 500.00);

insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(6, 1, 2, 'Detetizacao Basica', 100.00);

insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(7, 1, 7, 'Podagem pequena', 250.00);

insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(8, 1, 7, 'Podagem Grande', 350.00);

insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(9, 1, 4, 'Reforma estrutura eletrica', 1500.00);

insert into servicos(id_servico, id_usuario, id_categoria, descricao, preco) values
(10, 1, 10, 'Terraplanagem terros pequenos', 510.00);

select * from servicos;

insert into avaliacoes(id_avaliacao,id_servico,nota) values (1,1,5);

insert into pedidos (id_pedido, id_usuario_solicitante, id_servico, id_nota, data_solicitacao, data_finalizacao)
    VALUES  (3,3,3,3, current_timestamp, current_timestamp);

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
BEGINWW
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
    
  DBMS_OUTPUT.PUT_LINE('A categoria com maior numero de servicos e a de' ||var_descricao|| ' com ' || var_countServicos || ' servicos cadastrados.');

END CAT_MAIOR_NUMERO_SERVICOS;
/

EXEC CAT_MAIOR_NUMERO_SERVICOS;

CREATE OR REPLACE PROCEDURE ATUALIZA_SERVICOS_FINALIZADOS
IS
    var_ID_PEDIDO NUMBER(38,0);
	var_ID_USUARIO_SOLICITANTE NUMBER(38,0);
    var_ID_SERVICO NUMBER(38,0);
    var_ID_NOTA NUMBER(38,0);
    var_DATA_SOLICITACAO TIMESTAMP;
    var_DATA_FINALIZACAO TIMESTAMP;      
BEGIN

SELECT * INTO var_ID_PEDIDO, var_ID_USUARIO_SOLICITANTE, var_ID_SERVICO, var_ID_NOTA, 
    var_DATA_SOLICITACAO, var_DATA_FINALIZACAO FROM PEDIDOS WHERE ID_PEDIDO = 1;
	
    IF var_DATA_FINALIZACAO is not null  
        THEN        
        DBMS_OUTPUT.PUT_LINE('Executando insert');
			insert into Pedidos_Finalizados(ID_SERVICO_FINALIZADO, ID_SERVICO, ID_PEDIDO,
                ID_CATEGORIA, ID_NOTA, DATAFINALIZACAO, ID_USUARIO_CONTRATANTE, ID_TECNICO_FORNECEDOR)
            VALUES (SERVICOS_FINALIZADOS_SEQ.NEXTVAL, var_ID_SERVICO, var_ID_PEDIDO, 1, var_ID_NOTA, var_DATA_FINALIZACAO, var_ID_USUARIO_SOLICITANTE, 1);            
    END IF;
    DBMS_OUTPUT.PUT_LINE('Servico :' ||var_ID_PEDIDO|| ' atualizado na base de dados com a data' ||var_DATA_FINALIZACAO|| ' .');
END ATUALIZA_SERVICOS_FINALIZADOS;
/

--exec ATUALIZA_SERVICOS_FINALIZADOS;
------------------------------------END PROCEDURES------------------------------------
