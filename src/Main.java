

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.classes.Aluno;
import com.classes.AlunoBO;
import com.classes.AlunoDAO;
import com.classes.ListAluno;
import com.classes.Persistencia;

import Enum.Tipos;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		final Tipos tipo = Tipos.BD;
		Persistencia p = tipo.getPersistencia();
		ListAluno lista = new ListAluno();
		
		Aluno aluno = new Aluno("Adriano", 35201, "01010101011", "15/10/1988", "adrianorslsc@hotmail.com");
		lista.inserir(aluno);
		
		aluno = new Aluno("Jamile", 35214, "02020202021", "28/02/1998", "Jamile@homail.com");
		lista.inserir(aluno);
		
		aluno = new Aluno("Cristiano", 35255, "02030303030", "09/07/1985", "cristiano@homail.com");
		lista.inserir(aluno);
		
		p.gravar(lista.getLista());
		
		
		List<Aluno> list = p.ler(lista.getLista());

	    for (Iterator iter = list.iterator(); iter.hasNext();) {
			Aluno element = (Aluno) iter.next();
			System.out.println(element.toString() + "\n---");	
		}
		
	    
	    
		aluno = new Aluno("Aristiano", 35255, "02030303030", "09/07/1985", "cristiano@homail.com");
		lista.inserir(aluno);
		p.alterar(lista.getLista());
		
		

		
		List<Aluno> list2 = p.ler(lista.getLista());

	    for (Iterator iter = list2.iterator(); iter.hasNext();) {
			Aluno element = (Aluno) iter.next();
			System.out.println(element.toString() + "\n---");	
		}
	
		
		
		
		
		
		
	
	}
}
