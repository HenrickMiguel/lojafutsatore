/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.ConnectionFactory;
import modelos.Cliente;
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

    public void adiciona(Cliente cliente) {
        String sql = "INSERT INTO tbl_cliente (nome,cpf,contato,cidade,bairro,rua,numero) VALUES(?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getContato());
                stmt.setString(4, cliente.getCidade());
                stmt.setString(5, cliente.getBairro());
				stmt.setString(6, cliente.getRua());
				stmt.setInt(7, cliente.getNumero());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
    
}
