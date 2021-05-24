package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	
	
	final static String NOME_DO_BANCO = "mvcalunojdbc";
    public static Connection conectar() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + NOME_DO_BANCO;
            return DriverManager.getConnection(url,"root","Az151088");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
