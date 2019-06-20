package model;

public class Pessoa extends Model {
    
    private String nome;
    private String email;
    private Endereco endereco;
    private Telefone telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, Endereco endereco, Telefone telefone) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    
}
