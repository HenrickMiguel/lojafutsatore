/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConnectionFactory;
import Modelos.tbl_venda;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrick
 */
public class VendasDAO {
    
    private final Connection connection;
    
  Date  data_venda; 
   int quanti_tem;
   float valor_total;
   int cli_id;
    
    public VendasDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(tbl_venda tbl_venda) {
        String sql = "INSERT INTO tbl_venda (Data_venda,Quanti_tem,Valor_total,Cli_id) VALUES(?,?,?,?)";
        PreparedStatement stmt = null;
        
        try {
            
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, String.valueOf(tbl_venda.getData_venda()));
            stmt.setInt(2, tbl_venda.getQuanti_tem());
            stmt.setFloat(3, tbl_venda.getValor_total().floatValue());
            stmt.setInt(4, tbl_venda.getCli_id().getId().intValue());

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
