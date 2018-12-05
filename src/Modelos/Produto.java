/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Henrick
 */
public class Produto {
    
    Long id;
    String Cod;
    String Produto;
    int Quantidade;
    float Precodevenda;
    float Precodecompra;
    String Fornecedor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String Cod) {
        this.Cod = Cod;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public float getPrecodevenda() {
        return Precodevenda;
    }

    public void setPrecodevenda(float Precodevenda) {
        this.Precodevenda = Precodevenda;
    }

    public float getPrecodecompra() {
        return Precodecompra;
    }

    public void setPrecodecompra(float Precodecompra) {
        this.Precodecompra = Precodecompra;
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    
}
