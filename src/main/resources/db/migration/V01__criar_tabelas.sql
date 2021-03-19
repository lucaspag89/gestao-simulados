CREATE TABLE alternativa (
    id BIGINT(10) NOT NULL AUTO_INCREMENT,
    opcao VARCHAR(200) NOT NULL,
    gabaritoid BIGINT(10)   ,
    questaoid BIGINT(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE aluno (
    id BIGINT(10) NOT NULL AUTO_INCREMENT,
    matricula BIGINT(10) NOT NULL,
    nome VARCHAR(20) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    escola VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE gabarito (
    id BIGINT(10) NOT NULL AUTO_INCREMENT,
    provaid BIGINT(10) NOT NULL,
    PRIMARY KEY (id),
);

CREATE TABLE prova (
    id BIGINT(10) NOT NULL AUTO_INCREMENT,
    simuladoid BIGINT(10) NOT NULL,
    PRIMARY KEY (id),
);

CREATE TABLE questao (
    id BIGINT(10) NOT NULL AUTO_INCREMENT,
    enunciado VARCHAR(200) NOT NULL,
    nivel VARCHAR(10) NOT NULL,
    provaid BIGINT(10) NOT NULL,
    PRIMARY KEY (id),
);

CREATE TABLE respostaaluno (
    id BIGINT(10) NOT NULL AUTO_INCREMENT,
    alunoid BIGINT(10) NOT NULL,
    simuladoid BIGINT(10) NOT NULL,
    provaid BIGINT(10) NOT NULL,
    questaoid BIGINT(10) NOT NULL,
    alternativaid BIGINT(10) NOT NULL,
    PRIMARY KEY (id),
);

CREATE TABLE simulado (
    id BIGINT(10) AUTO_INCREMENT,
    PRIMARY KEY (id)
);


