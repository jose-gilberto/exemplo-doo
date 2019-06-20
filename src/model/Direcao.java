package model;

public enum Direcao {
    
    MECANICA(0),
    HIDRAULICA(1),
    ELETRICA(2);
    
    private final int valor;
    
    Direcao(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return this.valor;
    }
    
}
