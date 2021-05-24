package com.classes;

public class Aluno extends Pessoa {
	private int matricula;
	private String cpf;
	private String dataNascimento;
	private String email;
	
	
	public Aluno(String nome) {
		super(nome);
	}
	
	public Aluno(String nome, int matricula, String cpf, String dataNascimento, String email) {
		super(nome);
		this.matricula = matricula;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}


	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		if(matricula > 0)
			this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if (cpf.length() > 0)
			this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		if (dataNascimento.length() > 0)
			this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (email.length() > 0)	
			this.email = email;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [matricula=");
		builder.append(matricula);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
}
