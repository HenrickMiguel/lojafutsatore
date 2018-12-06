/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Henrick
 */
public class tbl_venda {
   
   private Long id; 
   private Date data_venda; 
   private Integer quanti_tem;
   private BigDecimal valor_total;
   private tbl_cliente cli_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public Integer getQuanti_tem() {
        return quanti_tem;
    }

    public void setQuanti_tem(Integer quanti_tem) {
        this.quanti_tem = quanti_tem;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public tbl_cliente getCli_id() {
        return cli_id;
    }

    public void setCli_id(tbl_cliente cli_id) {
        this.cli_id = cli_id;
    }

    
}
