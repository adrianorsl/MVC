package com.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Json implements Persistencia{

	public boolean gravar(List<Aluno> lista) throws Exception {

		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer = new FileWriter("arquivos/Alunos.json");
	    writer.write(gson.toJson(lista));
	    writer.close();
		return true;
	    
	}



	public List<Aluno> ler(List<Aluno> lista) {
		FileReader reader = null;

		try {
			List<Aluno> alunos = new ArrayList<>();
			

			File arquivo = new File("arquivos/Alunos.json");

			if (arquivo.exists()) {
				try {
					reader = new FileReader(arquivo);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Gson gson = new Gson();
				
				alunos = gson.fromJson(reader, new TypeToken<List<Aluno>>() {
				}.getType());
			}

			
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reader = null;
			}
		}
		return lista;
		
	}



	@Override
	public boolean alterar(List<Aluno> lista) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
