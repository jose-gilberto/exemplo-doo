package model;

public class Versao extends Model {
    
    private String nome;
    private Carroceria carroceria;
    private Direcao direcao;
    private int numPortas;
    private int numAssentos;

    public Versao() {
    }

    public Versao(String nome, Carroceria carroceria, Direcao direcao, int numPortas, int numAssentos) {
        this.nome = nome;
        this.carroceria = carroceria;
        this.direcao = direcao;
        this.numPortas = numPortas;
        this.numAssentos = numAssentos;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public int getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(int numAssentos) {
        this.numAssentos = numAssentos;
    }
    
}
