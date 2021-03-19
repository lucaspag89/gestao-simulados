CREATE TABLE valorquestao (
    id BIGINT(10) NOT NULL AUTO_INCREMENT,
    facil BIGINT(10) NOT NULL,
    medio BIGINT(10) NOT NULL,
    dificil BIGINT(10) NOT NULL,
    fator BIGINT(10) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO valorquestao (facil, medio, dificil, fator) VALUES (15, 12, 8, 600);