/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConnectionFactory;
import Modelos.tbl_produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Henrick
 */
public class ProdutosDAO {
    
  private final Connection connection;
    
    String nome;
    float preco;
    int quantidade;
    
    public ProdutosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(tbl_produto tbl_produto) {
        String sql = "INSERT INTO tbl_produto (Nome,Quantidade,Preco) VALUES(?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, tbl_produto.getNome());
                stmt.setInt(3, tbl_produto.getQuantidade());
                stmt.setFloat(2, tbl_produto.getPreco());
                
                
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
}
