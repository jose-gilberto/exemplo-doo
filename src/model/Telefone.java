package model;

public class Telefone {
    
    private enum Tipo {
        FIXO(0), CELULAR(1);
        private final int valor;
        Tipo(int valor) { this.valor = valor; }
        public int getValor() { return this.valor; }
    }
    
    private String numero;
    private Tipo tipo;

    public Telefone() {
    }

    public Telefone(String numero, Tipo tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
}
