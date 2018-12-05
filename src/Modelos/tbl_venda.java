/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;

/**
 *
 * @author Henrick
 */
public class tbl_venda {
    
   Date  data_venda; 
   int quanti_tem;
   float valor_total;
   int cli_id;

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public int getQuanti_tem() {
        return quanti_tem;
    }

    public void setQuanti_tem(int quanti_tem) {
        this.quanti_tem = quanti_tem;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }
  
    
    
   
	
	
	
    
    
}
