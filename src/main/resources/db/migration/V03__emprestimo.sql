CREATE TABLE emprestimo {
    id BIGINT(10) PRIMARY KEY,
    pessoa_id UUID NOT NULL ,
    livro_id BIGINT(10) NOT NULL,
    dataEmprestimo DATE,
    dataDevolucao DATE NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    FOREIGN KEY (livro_id) REFERENCES livro(id)
} ENGINE=InnDB DEFAULT CHARSET=utf8;
