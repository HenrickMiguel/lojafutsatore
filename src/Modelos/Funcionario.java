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
public class Funcionario {
    
    Long id;
    String nome;
    String cpf;
    String Endereco;
    String Contato;
    String Email;
    String Cargonaempresa;
    String Horassemanais;
    String Entradasaida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String Contato) {
        this.Contato = Contato;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCargonaempresa() {
        return Cargonaempresa;
    }

    public void setCargonaempresa(String Cargonaempresa) {
        this.Cargonaempresa = Cargonaempresa;
    }

    public String getHorassemanais() {
        return Horassemanais;
    }

    public void setHorassemanais(String Horassemanais) {
        this.Horassemanais = Horassemanais;
    }

    public String getEntradasaida() {
        return Entradasaida;
    }

    public void setEntradasaida(String Entradasaida) {
        this.Entradasaida = Entradasaida;
    }
    
    
   
}
