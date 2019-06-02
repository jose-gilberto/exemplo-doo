package model;

public class Modelo extends Model {
    
    private String nome;
    private int ano;
    private Marca marca;

    public Modelo() {
    }

    public Modelo(String nome, int ano, Marca marca) {
        this.nome = nome;
        this.ano = ano;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
}
