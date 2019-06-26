package model;

import java.io.Serializable;

public class PessoaFisica extends Model implements Pessoa, Serializable {
    
    private String nome;
    private String email;
    private Endereco endereco;
    private String telefone;
    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String email, Endereco endereco, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() {
        return this.cpf;
    }
    
}
