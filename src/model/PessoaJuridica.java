package model;

public class PessoaJuridica extends Pessoa {
    
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, String razaoSocial, String nome, String email, Endereco endereco, Telefone telefone) {
        super(nome, email, endereco, telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
}
