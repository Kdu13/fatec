-- Gerado por Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   em:        2025-06-04 22:16:14 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE character (
    id_character       INTEGER NOT NULL,
    nm_character       INTEGER,
    qt_level_character INTEGER,
    nm_race_character  VARCHAR2(50),
    player_id_player   INTEGER NOT NULL,
    class_id_class     INTEGER NOT NULL
);

ALTER TABLE character ADD CONSTRAINT character_pk PRIMARY KEY ( id_character );

CREATE TABLE character_session (
    session_id_session     INTEGER NOT NULL,
    character_id_character INTEGER NOT NULL
);

ALTER TABLE character_session ADD CONSTRAINT character_session_pk PRIMARY KEY ( session_id_session,
                                                                                character_id_character );

CREATE TABLE class (
    id_class INTEGER NOT NULL,
    nm_class VARCHAR2(100),
    ds_class CLOB
);

ALTER TABLE class ADD CONSTRAINT class_pk PRIMARY KEY ( id_class );

CREATE TABLE player (
    id_player       INTEGER NOT NULL,
    nm_player       VARCHAR2(100),
    nm_email_player VARCHAR2(100)
);

ALTER TABLE player ADD CONSTRAINT player_pk PRIMARY KEY ( id_player );

CREATE TABLE "SESSION" (
    id_session INTEGER NOT NULL,
    dt_session DATE,
    ds_session CLOB
);

ALTER TABLE "SESSION" ADD CONSTRAINT session_pk PRIMARY KEY ( id_session );

ALTER TABLE character
    ADD CONSTRAINT character_class_fk FOREIGN KEY ( class_id_class )
        REFERENCES class ( id_class );

ALTER TABLE character
    ADD CONSTRAINT character_player_fk FOREIGN KEY ( player_id_player )
        REFERENCES player ( id_player );

ALTER TABLE character_session
    ADD CONSTRAINT character_session_character_fk FOREIGN KEY ( character_id_character )
        REFERENCES character ( id_character );

ALTER TABLE character_session
    ADD CONSTRAINT character_session_session_fk FOREIGN KEY ( session_id_session )
        REFERENCES "SESSION" ( id_session );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                              9
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
