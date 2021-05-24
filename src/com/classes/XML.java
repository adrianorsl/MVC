package com.classes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class XML implements Persistencia{
	
	final static String NOMEDOARQUIVO = "alunos";
	final static String LOCALHOST = "arquivos/";

	public boolean gravar(List<Aluno> lista) throws IOException {
		
		Element config = new Element("Alunos");
		
		Document documento = new Document(config);
		
		for (int x = 0; x < lista.size(); x++){
			Element alunos = new Element("aluno");
			
			alunos.setAttribute("matricula", String.valueOf(lista.get(x).getMatricula()));
			
			Element cpf = new Element("cpf");
			cpf.setText(lista.get(x).getCpf());
			
			Element dataNascimento = new Element("DataNascimento");
			dataNascimento.setText(lista.get(x).getDataNascimento());
			
			Element email = new Element("email");
			email.setText(lista.get(x).getEmail());
			
			Element nome = new Element("nome");
			nome.setText(lista.get(x).getNome());
			
			
			alunos.addContent(cpf);
			alunos.addContent(dataNascimento);
			alunos.addContent(email);
			alunos.addContent(nome);
			config.addContent(alunos);			
		}
		
		
		XMLOutputter xout = new XMLOutputter();
		
		try {
			System.out.println(NOMEDOARQUIVO );
			BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCALHOST +  NOMEDOARQUIVO + ".xml"),"UTF-8"));
			xout.output(documento, arquivo);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	

	public List<Aluno> ler(List<Aluno> lista) {
		List<Aluno> listaAlu = new ArrayList<Aluno>();
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();	
		try { 
			doc = builder.build(LOCALHOST + NOMEDOARQUIVO + ".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}            
		Element config = doc.getRootElement();
		List lista1 = config.getChildren("aluno");
		
		for (Iterator iter = lista1.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Aluno alu = new Aluno("");
			alu.setMatricula(Integer.parseInt(element.getAttributeValue("matricula")));
			alu.setNome(element.getChildText("nome"));
			alu.setEmail(element.getChildText("email"));
			alu.setCpf(element.getChildText("cpf"));
			alu.setDataNascimento(element.getChildText("DataNascimento"));
			listaAlu.add(alu);
		}
		return listaAlu;
	}



	@Override
	public boolean alterar(List<Aluno> lista) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}	
}
	

