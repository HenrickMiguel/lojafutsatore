/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.math.BigDecimal;

/**
 *
 * @author Henrick
 */
public class tbl_items_venda {
   
   private Long id; 
   private tbl_produto produto; 
   private Integer quantidade;
   private BigDecimal valor;
   private tbl_venda venda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public tbl_produto getProduto() {
        return produto;
    }

    public void setProduto(tbl_produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public tbl_venda getVenda() {
        return venda;
    }

    public void setVenda(tbl_venda venda) {
        this.venda = venda;
    }

   
}
