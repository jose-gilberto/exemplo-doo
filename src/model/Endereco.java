package model;

public class Endereco {
    
    private String rua;
    private String numero;
    private String cep;
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String cep, Cidade cidade) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
