package model;

public class Movimentacao extends Model {
    
    private Veiculo veiculo;
    private String entrada;
    private String saida;

    public Movimentacao(Veiculo veiculo, String entrada, String saida) {
        this.veiculo = veiculo;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }
    
}
