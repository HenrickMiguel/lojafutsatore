/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConnectionFactory;
import Modelos.tbl_funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrick
 */
public class FuncionariosDAO {
    
  private final Connection connection;
    
    String nome;
    String cpf;
    String contato;
    String cidade;
    String Bairro;
    String rua;
    String numero;
    
    public FuncionariosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(tbl_funcionario tbl_funcionario) {
        String sql = "INSERT INTO tbl_funcionario (Nome, Cpf, Senha, Contato, Cidade, Bairro, Rua, Numero) VALUES(?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, tbl_funcionario.getNome());
                stmt.setString(2, tbl_funcionario.getCpf());
                stmt.setString(3, tbl_funcionario.getSenha());
                stmt.setString(4, tbl_funcionario.getContato());
                stmt.setString(5, tbl_funcionario.getCidade());
                stmt.setString(6, tbl_funcionario.getBairro());
                stmt.setString(7, tbl_funcionario.getRua());
                stmt.setString(8, tbl_funcionario.getNumero());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }finally{
            
            try {
                this.connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fechar a conexao: " + ex.getMessage());
            }
        }

    }
    
    public tbl_funcionario consultarPorCPFeSenha(String cpf, String senha){
        
        if(cpf.isEmpty() || senha.isEmpty()){
            return null;
        }
        
        String sql = "SELECT * FROM tbl_funcionario WHERE cpf = ? AND senha = ?";
        ResultSet rs = null;
        tbl_funcionario funcionario = null;
        PreparedStatement stmt = null;
        
         try {
                stmt = connection.prepareStatement(sql);
                stmt.setString(1,cpf);
                stmt.setString(2, senha);
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    funcionario = new tbl_funcionario();
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCpf(rs.getString("cpf"));
                    funcionario.setContato(rs.getString("contato"));

                    return funcionario;
                }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }finally{
            try {

                if(stmt != null){
                    stmt.close();
                }

                if(rs != null){
                    rs.close();
                }

                if(connection != null){
                    connection.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fechar a conexao: " + ex.getMessage());
            }
        }
      return null;
        
    }
    
    
}
    
    
    
    
    

