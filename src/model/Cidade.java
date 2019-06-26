
package model;

import java.io.Serializable;

public class Cidade implements Serializable {
    
    private String nome;
    private String estado;
    private String pais;

    public Cidade() {
    }

    public Cidade(String nome, String estado, String pais) {
        this.nome = nome;
        this.estado = estado;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
