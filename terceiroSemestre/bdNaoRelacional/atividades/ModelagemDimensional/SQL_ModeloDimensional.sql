CREATE TABLE "FATO:CONSULTA"(
    "id_consulta" INTEGER NOT NULL,
    "id_medico" INTEGER NOT NULL,
    "id_paciente" INTEGER NOT NULL,
    "id_unidade" INTEGER NOT NULL,
    "id_convenio" INTEGER NOT NULL,
    "id_tempo" INTEGER NOT NULL,
    "diagnostico" VARCHAR(255) NOT NULL,
    "valorConsulta" DECIMAL(8, 2) NOT NULL,
    "valorConvenio" DECIMAL(8, 2) NOT NULL
);

ALTER TABLE
    "FATO:CONSULTA"
ADD PRIMARY KEY("id_consulta");


CREATE TABLE "DIM:PACIENTE"(
    "id_paciente" INTEGER NOT NULL,
    "nomePaciente" VARCHAR(255) NOT NULL,
    "sexo" VARCHAR(255) NOT NULL,
    "cidade" VARCHAR(255) NOT NULL,
    "estado" VARCHAR(255) NOT NULL,
    "dataNascimento" DATE NOT NULL
);

ALTER TABLE
    "DIM:PACIENTE"
ADD PRIMARY KEY("id_paciente");


CREATE TABLE "DIM:CONVENIO"(
    "id_convenio" INTEGER NOT NULL,
    "nomeConvenio" VARCHAR(255) NOT NULL,
    "tipoPlano" VARCHAR(255) NOT NULL
);

ALTER TABLE
    "DIM:CONVENIO"
ADD PRIMARY KEY("id_convenio");


CREATE TABLE "DIM:MEDICO"(
    "id_medico" INTEGER NOT NULL,
    "nomeMedico" VARCHAR(255) NOT NULL,
    "especialidade" VARCHAR(255) NOT NULL,
    "crm" INTEGER NOT NULL
);

ALTER TABLE
    "DIM:MEDICO"
ADD PRIMARY KEY("id_medico");


CREATE TABLE "DIM:UNIDADE"(
    "id_unidade" INTEGER NOT NULL,
    "nomeUnidade" VARCHAR(255) NOT NULL,
    "cidade" VARCHAR(255) NOT NULL,
    "estado" VARCHAR(255) NOT NULL
);

ALTER TABLE
    "DIM:UNIDADE"
ADD PRIMARY KEY("id_unidade");


CREATE TABLE "DIM:TEMPO"(
    "id_tempo" INTEGER NOT NULL,
    "dataConsulta" DATE NOT NULL,
    "horaConsulta" TIME(0) WITHOUT TIME ZONE NOT NULL
);

ALTER TABLE
    "DIM:TEMPO"
ADD PRIMARY KEY("id_tempo");


ALTER TABLE
    "FATO:CONSULTA"
ADD CONSTRAINT "fato:consulta_id_convenio_foreign"
FOREIGN KEY("id_convenio")
REFERENCES "DIM:CONVENIO"("id_convenio");


ALTER TABLE
    "FATO:CONSULTA"
ADD CONSTRAINT "fato:consulta_id_medico_foreign"
FOREIGN KEY("id_medico")
REFERENCES "DIM:MEDICO"("id_medico");


ALTER TABLE
    "FATO:CONSULTA"
ADD CONSTRAINT "fato:consulta_id_tempo_foreign"
FOREIGN KEY("id_tempo")
REFERENCES "DIM:TEMPO"("id_tempo");


ALTER TABLE
    "FATO:CONSULTA"
ADD CONSTRAINT "fato:consulta_id_paciente_foreign"
FOREIGN KEY("id_paciente")
REFERENCES "DIM:PACIENTE"("id_paciente");


ALTER TABLE
    "FATO:CONSULTA"
ADD CONSTRAINT "fato:consulta_id_unidade_foreign"
FOREIGN KEY("id_unidade")
REFERENCES "DIM:UNIDADE"("id_unidade");
