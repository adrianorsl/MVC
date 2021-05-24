package com.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Enum.Tipos;

public class AlunoDAO  {
	
	final Tipos tipo = Tipos.BD;
	final String NOMEDATABELA = "Aluno";
	public void gravar(Aluno aluno) {
		inserir(aluno);
	}
	
	
    public boolean inserir(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA + " (nome, matricula, cpf, dataNascimento, email) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getMatricula());
            ps.setString(3, aluno.getCpf());
            ps.setString(4, aluno.getDataNascimento());
            ps.setString(5, aluno.getEmail());
            ps.executeUpdate();
            ps.close();
            conn.close();
            
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterar(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET nome = ?  WHERE cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluir(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }
    public Aluno procurarPorCpf(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Aluno obj = new Aluno(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public Aluno procurarPorMatricula(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE matricula = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aluno.getMatricula());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Aluno obj = new Aluno(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public boolean existe(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE cpf = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public List<Aluno> pesquisarTodos(Aluno aluno) { 
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
    public List<Aluno> montarLista(ResultSet rs) {
        List<Aluno> listObj = new ArrayList<Aluno>();
        try {
            while (rs.next()) {
                Aluno obj = new Aluno(rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }


	
}
