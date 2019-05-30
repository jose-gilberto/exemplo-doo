package model;

import java.io.Serializable;

public class Marca extends Model implements Serializable {
    
    private String nome;
    
    public Marca() { /*...*/ }

    public Marca(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
            
}
