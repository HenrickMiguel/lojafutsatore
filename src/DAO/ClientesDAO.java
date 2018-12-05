/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConnectionFactory;
import Modelos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Henrick
 */
public class ClientesDAO {
 
    private final Connection connection;
    Long id;
    String Nome;
    String cpf;
    String Contato;
    String Cidade;
    String Endereco;
    
    public ClientesDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Cliente clientes) {
        String sql = "INSERT INTO Clientes (Nome,Cpf,Contato,Cidade,Endereco) VALUES(?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, clientes.getNome());
                stmt.setString(2, clientes.getCpf());
                stmt.setString(3, clientes.getContato());
                stmt.setString(4, clientes.getCidade());
                stmt.setString(5, clientes.getEndereco());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
    
}
