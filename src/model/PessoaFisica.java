package model;

public class PessoaFisica extends Pessoa {
    
    private String cpf;
    private String cnh;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf, String cnh, String nome, String email, Endereco endereco, Telefone telefone) {
        super(nome, email, endereco, telefone);
        this.cpf = cpf;
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
}
