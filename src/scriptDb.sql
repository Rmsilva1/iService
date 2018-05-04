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
	
CREATE TABLE Servicos_Finalizados (
	ID_Servico_Finalizado INTEGER NOT NULL CONSTRAINT SERVICO_FINALIZADO_PK PRIMARY KEY,
	ID_Servico INTEGER NOT NULL,
	ID_Categoria INTEGER NOT NULL,
	ID_NOTA INTEGER NOT NULL,
	DataFinalizacao TIMESTAMP,
	ID_USUARIO_CONTRATANTE INTEGER NOT NULL,
	ID_TECNICO_FORNECEDOR INTEGER NOT NULL,
    CONSTRAINT FK_Servico_Finalizado FOREIGN KEY(ID_Servico) REFERENCES SERVICOS(ID_Servico),
	CONSTRAINT FK_NOTA FOREIGN KEY(ID_NOTA) REFERENCES AVALIACOES(ID_AVALIACAO),
    CONSTRAINT FK_Categoria_Finalizada FOREIGN KEY(ID_Categoria) REFERENCES Categorias_Servicos(ID_CATEGORIA));

--Tabela de pedidos ativos que ira referenciar o tecnico contratado atraves do servico contratado.	
CREATE TABLE Pedidos (
	ID_Pedido INTEGER NOT NULL CONSTRAINT PEDIDO_PK PRIMARY KEY,
	ID_USUARIO_SOLICITANTE INTEGER NOT NULL,
	ID_Servico INTEGER NOT NULL,
	ID_Nota INTEGER NOT NULL,
	Data_Solicitacao timestamp,
	Data_Finalizacao timestamp,
    CONSTRAINT FK_PEDIDO_SERVICO FOREIGN KEY(ID_Servico) REFERENCES SERVICOS(ID_Servico),
	CONSTRAINT FK_USUARIO_SOLICITANTE FOREIGN KEY(ID_USUARIO_SOLICITANTE) REFERENCES USUARIOS(ID_USUARIO));


CREATE SEQUENCE USUARIO_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SERVICO_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE CATEGORIAS_SEQ
START WITH 1
INCREMENT BY 1;
       

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
	
COMMIT;

------------------------------------PROCEDURES------------------------------------
CREATE OR REPLACE PROCEDURE GET_TOTAL_USUARIOS
IS
  var_totalUsuarios NUMBER(20);
BEGIN

SELECT count(ID_USUARIO)
INTO var_totalUsuarios

FROM iservice.USUARIOS;
  DBMS_OUTPUT.PUT_LINE('A quantidade total de usuarios é de ' ||var_totalUsuarios|| ' Usuarios.');
END GET_TOTAL_USUARIOS;
/

CREATE OR REPLACE PROCEDURE GET_SERVICO_MAIS_CARO
IS
  var_nomeServico varchar(255);
  var_precoServico NUMBER(8,2);
BEGIN

SELECT Descricao, max(Preco)
INTO var_nomeServico, var_precoServico

FROM iservice.SERVICOS;
  DBMS_OUTPUT.PUT_LINE('O servico mais caro é o ' ||var_nomeServico|| ' Com o valor de ' || 'R$ ' || var_precoServico || '.');
END GET_SERVICO_MAIS_CARO;
/

CREATE OR REPLACE PROCEDURE GET_ESTADO_COM_MAIOR_NUMERO_TECNICOS
IS
  var_estado VARCHAR(32);
  count_tecnicos INTEGER;
BEGIN

SELECT count(codigo_estado)
INTO var_estado

FROM projeto_iservice.estado;

  DBMS_OUTPUT.PUT_LINE('O Estado com maior numero de tecnicos é o ' ||var_estado|| ' com' || count_tecnicos || ' tecnicos.');

END GET_ESTADO_COM_MAIOR_NUMERO_TECNICOS;
/

CREATE OR REPLACE PROCEDURE GET_CATEGORIA_COM_MAIOR_NUMERO_SERVICOS
IS
  var_countServicos NUMBER(20);
  var_categoria  NUMBER(20);
BEGIN

SELECT count(codigo_estado)
INTO var_totalEst

FROM projeto_iservice.estado;

  DBMS_OUTPUT.PUT_LINE('A categoria com maior numero de servicos é a ' ||var_categoria|| ' com ' || var_servicos || '.');

END GET_CATEGORIA_COM_MAIOR_NUMERO_SERVICOS;
/

CREATE OR REPLACE PROCEDURE ATUALIZA_TABELA_SERVICOS_FINALIZADOS
IS
	var_dataFimServico timestamp;
BEGIN

SELECT Data_Finalizacao
	INTO var_dataFimServico
FROM iservice.Pedidos;
	IF var_dataFimServico != null
		THEN
			insert into Servicos_Finalizados = var_dataFimServico;

  DBMS_OUTPUT.PUT_LINE('Servico atualizado na base de dados com a data' ||var_dataFimServico|| ' .');
END Get_QuantidadeDeEstados;
/
------------------------------------END PROCEDURES------------------------------------
drop table servicos;   
drop table categoria;    
drop table usuarios;