/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConnectionFactory;
import Modelos.tbl_cliente;
import Modelos.tbl_funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        }finally{
            
            try {
                this.connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fechar a conexao: " + ex.getMessage());
            }
        }

    }
    
    public List<tbl_cliente> consultar(){
                
        String sql = "SELECT * FROM tbl_cliente";
        ResultSet rs = null;
        List<tbl_cliente> clientes = new ArrayList<>();
        tbl_cliente cliente = null;
        PreparedStatement stmt = null;
        
         try {
                stmt = connection.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                if(rs.first()){
                    
                    while(rs.next()){
                        cliente = new tbl_cliente();
                        cliente.setId(new Long(rs.getInt("id")));
                        cliente.setNome(rs.getString("nome"));
                        cliente.setCpf(rs.getString("cpf"));
                        cliente.setContato(rs.getString("contato"));
                        cliente.setCidade(rs.getString("cidade"));
                        cliente.setBairro(rs.getString("bairro"));
                        cliente.setRua(rs.getString("rua"));
                        cliente.setNumero(String.valueOf(rs.getInt("numero")));

                        clientes.add(cliente);
                    }
                    
                }
                
                return clientes;
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
        
    }
    
    
}
