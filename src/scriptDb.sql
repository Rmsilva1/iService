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
    cpf VARCHAR(13) NOT NULL,
    Email VARCHAR(64) NOT NULL,
    Senha VARCHAR(128) NOT NULL,
    Nome VARCHAR(128) NOT NULL,
    Telefone VARCHAR(16) NOT NULL,
    Estado VARCHAR(32) NOT NULL,
    Cidade VARCHAR(32) NOT NULL,
    cep NUMBER(8) NOT NULL,
    bairro VARCHAR(64),
    rua VARCHAR(64) ,
    complemento VARCHAR(64));

) TABLESPACE iService;

--TODO
--CREATE TABLE Servicos (
--id_servico INTEGER NOT NULL CONSTRAINT SERVICO_PK PRIMARY KEY,
--nome VARCHAR(2048) NOT NULL,
--data TIMESTAMP NOT NULL,
--preco NUMERIC(7,2),
--id_especialidade INTEGER NOT NULL,
--id_subespecialidade INTEGER NOT NULL,
--id_usuario INTEGER NOT NULL,
--id_tecnico INTEGER NOT NULL,
--CONSTRAINT COD_ESP_SERVICO_FK FOREIGN KEY(id_especialidade) REFERENCES ESPECIALIDADE (id_especialidade),
--CONSTRAINT COD_SUB_ESP_SERVICO_FK FOREIGN KEY(id_subespecialidade) REFERENCES SUB_ESPECIALIDADE (id_subespecialidade),
--CONSTRAINT ID_USU_SERVICO_FK FOREIGN KEY(id_usuario) REFERENCES USUARIO (id_usuario),
--CONSTRAINT ID_TEC_SERVICO_FK FOREIGN KEY(id_tecnico) REFERENCES USUARIO (id_usuario)
--) TABLESPACE iService;


CREATE SEQUENCE USUARIO_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SERVICO_SEQ
START WITH 1
INCREMENT BY 1;
