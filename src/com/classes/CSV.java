package com.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CSV implements Persistencia {
	private final int POS_MATRICULA = 0;
	private final int POS_NOME = 1;
	private final int POS_EMAIL = 2;
	private final int POS_CPF = 3;
	private final int POS_DATA_NASCIMENTO = 4;

	public boolean gravar(List<Aluno> lista)  throws IOException {
		FileWriter writer = null;

		try {
			writer = new FileWriter("arquivos/aluno.csv");

			for (Aluno a : lista) {
				String[] info = new String[5];

				info[POS_MATRICULA] = Integer.toString(a.getMatricula());
				info[POS_NOME] = a.getNome();
				info[POS_EMAIL] = a.getEmail();
				info[POS_CPF] = a.getCpf();
				info[POS_DATA_NASCIMENTO] = a.getDataNascimento();

				writer.write(String.join(";", info) + "\n");
			}
		} finally {
			if (writer != null) {
				writer.close();
				writer = null;
			}
		}
		return true;
	}


	@Override
	public List<Aluno> ler(List<Aluno> lista) throws IOException, ParseException {
		BufferedReader reader = null;

		try {
			List<Aluno> alunos = new ArrayList<>();

			File arquivo = new File("arquivos/aluno.csv");

			if (arquivo.exists()) {
				reader = new BufferedReader(new FileReader(arquivo));

				String linha;

				while ((linha = reader.readLine()) != null) {
					if (linha.isEmpty())
						continue;

					String[] info = linha.split(";");

					String nome = "";
					Aluno a = new Aluno(nome);

					a.setMatricula(Integer.parseInt(info[POS_MATRICULA]));
					a.setNome(info[POS_NOME]);
					a.setEmail(info[POS_EMAIL]);
					a.setCpf(info[POS_CPF]);
					a.setDataNascimento(info[POS_DATA_NASCIMENTO]);

					alunos.add(a);
				}
			}

			return alunos;
		} finally {
			if (reader != null) {
				reader.close();
				reader = null;
			}
		}
	}


	@Override
	public boolean alterar(List<Aluno> lista) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}