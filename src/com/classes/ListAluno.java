package com.classes;

import java.util.ArrayList;
import java.util.List;

public class ListAluno {

	List<Aluno> lista = new ArrayList<Aluno>();
	
	public void inserir(Aluno alu){
		lista.add(alu);
	}
	
	public List<Aluno> getLista(){
		return lista;
	}
}
