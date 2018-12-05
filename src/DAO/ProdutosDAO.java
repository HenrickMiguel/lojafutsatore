/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.ConnectionFactory;
import modelos.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Henrick
 */
public class ProdutosDAO {
    
    Long id;
    String Cod;
    String Produto;
    int Quantidade;
    float Precodevenda;
    float Precodecompra;
    String Fornecedor;
    private final Connection connection;
    
    public ProdutosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Produto produto) {
        String sql = "INSERT INTO produto (Cod,Produto,Quantidade,Precodevenda,Precodecompra,Fornecedor) VALUES(?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, produto.getCod());
                stmt.setString(2, produto.getProduto());
                stmt.setInt(3, produto.getQuantidade());
                stmt.setFloat(4, produto.getPrecodevenda());
                stmt.setFloat(5, produto.getPrecodecompra());
                stmt.setString(6, produto.getFornecedor());
                
                stmt.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
    
}
