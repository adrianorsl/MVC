package com.classes;

import java.util.List;

public interface Persistencia {

	public boolean gravar(List<Aluno> lista) throws Exception;
	
	public List<Aluno> ler(List<Aluno> lista) throws Exception;
	
	public boolean alterar(List<Aluno> lista) throws Exception;
}
