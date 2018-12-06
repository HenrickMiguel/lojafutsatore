/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConnectionFactory;
import Modelos.tbl_items_venda;
import Modelos.tbl_venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrick
 */
public class ItemsVendaDAO {
    
    private final Connection connection;
    
    public ItemsVendaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(tbl_items_venda item_venda) {
        String sql = "INSERT INTO tbl_items_venda (Prod_id,Quantidade,Valor,Vend_id) VALUES(?,?,?,?)";
        PreparedStatement stmt = null;
        
        try {
            
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item_venda.getProduto().getId().intValue());
            stmt.setInt(2, item_venda.getQuantidade());
            stmt.setBigDecimal(3, item_venda.getValor());
            stmt.setInt(4, item_venda.getVenda().getId().intValue());

            stmt.execute();
            
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }finally{
            
            try {
                
                if(stmt != null){
                    stmt.close();
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
