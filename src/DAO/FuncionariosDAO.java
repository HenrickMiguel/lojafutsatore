/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.ConnectionFactory;
import modelos.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Henrick
 */
public class FuncionariosDAO {
    
    Long id;
    String nome;
    String cpf;
    String Endereco;
    String Contato;
    String Email;
    String Cargonaempresa;
    String Horassemanais;
    String Entradasaida;
    private final Connection connection;
    
    public FuncionariosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario (Nome,Cpf,Endereco,Contato,Email,Cargonaempresa,Horassemanais,Entradasaida) VALUES(?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getCpf());
                stmt.setString(3, funcionario.getEndereco());
                stmt.setString(4, funcionario.getContato());
                stmt.setString(5, funcionario.getEmail());
                stmt.setString(6, funcionario.getCargonaempresa());
                stmt.setString(7, funcionario.getHorassemanais());
                stmt.setString(8, funcionario.getEntradasaida());
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
    
}
    
    
    
    
    

