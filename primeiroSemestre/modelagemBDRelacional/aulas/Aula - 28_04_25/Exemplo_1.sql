CREATE TABLE CLIENTE (
  cd_cpf_cliente NUMERIC(11)   NOT NULL ,
  nm_cliente VARCHAR(45)    ,
  cd_telefone_cliente NUMERIC(13)    ,
  nm_email_cliente VARCHAR(45)      ,
PRIMARY KEY(cd_cpf_cliente));




CREATE TABLE VEICULO (
  cd_placa_veiculo VARCHAR(7)   NOT NULL ,
  CLIENTE_cd_cpf_cliente NUMERIC(11)   NOT NULL ,
  nm_marca_veiculo VARCHAR(50)    ,
  nm_modelo_veiculo VARCHAR(50)    ,
  aa_veiculo NUMERIC(4)      ,
PRIMARY KEY(cd_placa_veiculo),
  FOREIGN KEY(CLIENTE_cd_cpf_cliente)
    REFERENCES CLIENTE(cd_cpf_cliente));


CREATE INDEX IFK_Tem ON VEICULO (CLIENTE_cd_cpf_cliente);


CREATE TABLE LICENCIAMENTO (
  dt_licenciamento DATE   NOT NULL ,
  VEICULO_cd_placa_veiculo VARCHAR(7)   NOT NULL ,
  vl_licenciamento NUMERIC(8,2)      ,
PRIMARY KEY(dt_licenciamento, VEICULO_cd_placa_veiculo),
  FOREIGN KEY(VEICULO_cd_placa_veiculo)
    REFERENCES VEICULO(cd_placa_veiculo));


CREATE INDEX IFK_Faz ON LICENCIAMENTO (VEICULO_cd_placa_veiculo);



