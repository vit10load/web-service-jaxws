package com.br.teste.ws.dao;

import com.br.teste.ws.factory.bd.FactoryConnection;
import datamodel.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vitcl
 */
public class AlunoDao {

    public AlunoDao() {
    }
    
    public void inserir(Aluno aluno) {
        Connection con = FactoryConnection.getConnection();
        try {
           
            PreparedStatement ps = con.prepareStatement("INSERT INTO aluno (nome,telefone) values (?,?)");
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getTelefone());
            ps.execute();
            ps.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("err..."+e.getMessage());
        } finally {
            
        }

    }

    public void remover(Integer index) {
        Connection con = FactoryConnection.getConnection();
        String sql = "DELETE FROM aluno WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(index.intValue()));
            ps.execute();
            con.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("err..." + ex.getMessage());
        }

    }

    public void atualizar(Integer index, Aluno aluno) {
        Connection con = FactoryConnection.getConnection();
        String sql = "UPDATE aluno SET nome = ?, telefone = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getTelefone());
            ps.setString(3, String.valueOf(index.intValue()));
            ps.execute();
            ps.close();
            con.close();
      
        } catch (SQLException ex) {
            System.out.println("err.."+ex.getMessage());
        }
    }

    public String buscarPorIndex(Integer index) {

        Connection con = FactoryConnection.getConnection();
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(index.intValue()));
            ResultSet rs = ps.executeQuery();
         
            while(rs.next()){
                
                return rs.getString("nome")+"   "+rs.getString("telefone");
            }
           
        } catch (SQLException ex) {
            System.out.println("err..." + ex.getMessage());
        }
        
        return null;
    }

    public List<String> getAlunos() {
        List<String> alunos = new ArrayList<>();
        Connection con = FactoryConnection.getConnection();
        String sql = "SELECT * FROM aluno";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                alunos.add(rs.getString("id"));
                alunos.add(rs.getString("nome"));
                alunos.add(rs.getString("telefone"));
            }

            ps.close();
            rs.close();
            con.close();

            return alunos;

        } catch (SQLException ex) {
            System.out.println("err..." + ex.getMessage());
        }

        return null;
    }
}
