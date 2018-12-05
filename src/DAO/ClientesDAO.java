/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConnectionFactory;
import Modelos.tbl_cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Henrick
 */
public class ClientesDAO {
 
    private final Connection connection;
    
    String nome;
    String cpf;
    String contato;
    String cidade;
    String Bairro;
    String rua;
    String numero;
    
    public ClientesDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(tbl_cliente tbl_cliente) {
        String sql = "INSERT INTO tbl_cliente (Nome,Cpf,Contato,Cidade,Bairro,Rua,Numero) VALUES(?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, tbl_cliente.getNome());
                stmt.setString(2, tbl_cliente.getCpf());
                stmt.setString(3, tbl_cliente.getContato());
                stmt.setString(4, tbl_cliente.getCidade());
                stmt.setString(5, tbl_cliente.getBairro());
                stmt.setString(6, tbl_cliente.getRua());
                stmt.setString(7, tbl_cliente.getNumero());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
    
}
