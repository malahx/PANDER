#------------------------------------------------------------
#        Script MySQL: PANDER version 2
#------------------------------------------------------------


#------------------------------------------------------------
# DataBase: pander
#------------------------------------------------------------
DROP DATABASE IF EXISTS pander;
CREATE DATABASE IF NOT EXISTS pander;
USE pander;

#------------------------------------------------------------
# Table: kuser
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS kuser(
        id           Bigint Auto_increment PRIMARY KEY NOT NULL,
        email        Varchar(255) NOT NULL,
        password     Varchar(50) NOT NULL,
        role         Varchar(15) NOT NULL,
        disabled     Boolean NULL,
        phone        Varchar(15) NULL,
        address      Varchar(255) NULL,
        postcode     Varchar(6) NULL,
        city         Varchar(50) NULL,
        photo        Varchar(255) NULL,
        description  Text NULL,
        created_at   Datetime NULL,
        updated_at   Datetime NULL,
        UNIQUE(email)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


#------------------------------------------------------------
# Table: company
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS company(
        id_kuser    Bigint PRIMARY KEY NOT NULL,
        name        Varchar(255) NOT NULL,
        siret       Varchar(20) NOT NULL,
        contact     Varchar(255) NULL,
        link        Varchar(255) NULL,
        UNIQUE(siret),
        CONSTRAINT FK_company_id_kuser  FOREIGN KEY (id_kuser) REFERENCES kuser(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


#------------------------------------------------------------
# Table: candidate
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS candidate(
        id_kuser     Bigint PRIMARY KEY NOT NULL,
        firstname    Varchar(255) NOT NULL,
        lastname     Varchar(255) NOT NULL,
        birthdate    Date NULL,
        transport    Varchar(25) NULL,
        link1        Varchar(255) NULL,
        link2        Varchar(255) NULL,
        certificate1 Varchar(255) NULL,
        certificate2 Varchar(255) NULL,
        cv           Varchar(255) NULL,
        CONSTRAINT FK_candidate_id_kuser  FOREIGN KEY (id_kuser) REFERENCES kuser(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#------------------------------------------------------------
# Table: skill
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS skill(
        id   Bigint Auto_increment NOT NULL,
        name Varchar(255) NOT NULL,
        type Varchar(50),
        PRIMARY KEY (id),
        UNIQUE(name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#------------------------------------------------------------
# Table: job
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS job(
        id            Bigint Auto_increment PRIMARY KEY NOT NULL,
        name          Varchar(100) NOT NULL,
        presentation  Text NULL,
        link          Varchar(255) NULL,
        contact       Varchar(255) NULL,
        created_at    Datetime NULL,
        updated_at    Datetime NULL,
        id_company    Bigint NOT NULL,
        CONSTRAINT FK_job_id_company FOREIGN KEY (id_company) REFERENCES company(id_kuser)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#------------------------------------------------------------
# Table: job_skill
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS job_skill(
        id_job      Bigint NOT NULL,
        id_skill    Bigint NOT NULL,
        PRIMARY KEY (id_job, id_skill),
        CONSTRAINT FK_jobskill_id_job FOREIGN KEY (id_job) REFERENCES job(id),
        CONSTRAINT FK_jobskill_id_skill FOREIGN KEY (id_skill) REFERENCES skill(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


#------------------------------------------------------------
# Table: candidate_skill
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS candidate_skill(
        id_skill        Bigint NOT NULL,
        id_candidate    Bigint NOT NULL,
        PRIMARY KEY (id_skill, id_candidate),
        CONSTRAINT FK_candidateskill_id_skill FOREIGN KEY (id_skill) REFERENCES skill(id),
        CONSTRAINT FK_candidateskill_id_candidate FOREIGN KEY (id_candidate) REFERENCES candidate(id_kuser)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#------------------------------------------------------------
# Table: question
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS question(
        id              Bigint Auto_increment PRIMARY KEY NOT NULL,
        title           Varchar(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#------------------------------------------------------------
# Table: answer
#------------------------------------------------------------

CREATE TABLE IF NOT EXISTS answer(
        id              Bigint Auto_increment PRIMARY KEY NOT NULL,
        title           Varchar(255) NOT NULL,
        id_skill        Bigint NOT NULL,
        id_question         Bigint NOT NULL,
        CONSTRAINT FK_answer_id_skill FOREIGN KEY (id_skill) REFERENCES skill(id),
        CONSTRAINT FK_answer_id_skill FOREIGN KEY (id_test) REFERENCES test(id),
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;