package com.classes;

import java.util.List;


public class AlunoBO implements Persistencia{

	@Override
	public boolean gravar(List<Aluno> lista) throws Exception {
		for (int x = 0; x < lista.size(); x++) {
			if (existe(lista.get(x)) != true) {
				AlunoDAO alunosDAO = new AlunoDAO();
				alunosDAO.inserir(lista.get(x));
			}	
		}
		return false;
	}
	@Override
	public boolean alterar(List<Aluno> lista){
		for (int i = 0; i < lista.size(); i++) {
			AlunoDAO alunosDAO = new AlunoDAO();
	        return alunosDAO.alterar(lista.get(i));
	    }
		return false;
	}
	    public static boolean excluir(Aluno aluno){
	    	AlunoDAO alunosDAO = new AlunoDAO();
	        return alunosDAO.excluir(aluno);
	    }
	    public static Aluno procurarPorCpf(Aluno aluno){
	        AlunoDAO alunosDAO = new AlunoDAO();
	        return alunosDAO.procurarPorCpf(aluno);
	    }
	    public static Aluno procurarPorMatricula(Aluno aluno){
	    	 AlunoDAO alunosDAO = new AlunoDAO();
	        return alunosDAO.procurarPorMatricula(aluno);
	    }
	    public boolean existe( Aluno aluno){
	    	AlunoDAO alunosDAO = new AlunoDAO();
	        return alunosDAO.existe(aluno);
	    }
	    public static List<Aluno> pesquisarTodos(Aluno aluno){
	        AlunoDAO alunosDAO = new AlunoDAO();
	        return alunosDAO.pesquisarTodos(aluno);
	    }
		
		
		@Override
		public List<Aluno> ler(List<Aluno> lista) throws Exception {
			for (int x = 0; x < lista.size(); x++) {
				AlunoDAO alunosDAO = new AlunoDAO();
		        return alunosDAO.pesquisarTodos(lista.get(x));
			}
			return null;
		}
		
}
