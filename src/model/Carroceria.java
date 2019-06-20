package model;

public enum Carroceria {
    
    SEDAN(0), 
    HATCH(1), 
    MINIVAN(2), 
    CONVERSIVEL(3),
    PERUA(4),
    CUPE(5),
    PICAPE(6),
    CROSSOVER(7),
    SUV(8),
    VAN(9),
    SPORT(10),
    TRUCK(11);
    
    private final int valor;
    
    Carroceria(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return this.valor;
    }
    
}

