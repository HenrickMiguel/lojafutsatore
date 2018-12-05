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
import java.sql.SQLException;

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
        String sql = "INSERT INTO tbl_funcionario (Nome,Cpf,Contato,Cidade,Bairro,Rua,Numero) VALUES(?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, tbl_funcionario.getNome());
                stmt.setString(2, tbl_funcionario.getCpf());
                stmt.setString(3, tbl_funcionario.getContato());
                stmt.setString(4, tbl_funcionario.getCidade());
                stmt.setString(5, tbl_funcionario.getBairro());
                stmt.setString(6, tbl_funcionario.getRua());
                stmt.setString(7, tbl_funcionario.getNumero());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
    
}
    
    
    
    
    

