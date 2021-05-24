Create dataBase mvcalunojdbc; 
use mvcalunojdbc;

CREATE TABLE IF NOT EXISTS Aluno(
codigo int auto_increment NOT NULL primary key,
nome character(90) NOT NULL,
matricula int NOT NULL,
cpf character(11) NOT NULL,
dataNascimento character(12) NOT NULL,
email character(100) NOT NULL, 
UNIQUE(matricula));

SELECT * FROM Aluno;