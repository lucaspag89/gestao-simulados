ALTER TABLE questao
ADD FOREIGN KEY (provaid) REFERENCES prova(id);

ALTER TABLE alternativa
ADD FOREIGN KEY (gabaritoid) REFERENCES gabarito(id);

ALTER TABLE alternativa
ADD FOREIGN KEY (questaoid) REFERENCES questao(id);

ALTER TABLE gabarito
ADD FOREIGN KEY (provaid) REFERENCES prova(id);

ALTER TABLE prova
ADD FOREIGN KEY (simuladoid) REFERENCES simulado(id);

ALTER TABLE respostaaluno
ADD FOREIGN KEY (alunoid) REFERENCES aluno(id);

ALTER TABLE respostaaluno
ADD FOREIGN KEY (simuladoid) REFERENCES simulado(id);

ALTER TABLE respostaaluno
ADD FOREIGN KEY (provaid) REFERENCES prova(id);

ALTER TABLE respostaaluno
ADD FOREIGN KEY (questaoid) REFERENCES questao(id);

ALTER TABLE respostaaluno
ADD FOREIGN KEY (alternativaid) REFERENCES alternativa(id);