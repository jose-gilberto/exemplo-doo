package model;

public class Veiculo extends Model {
    
    private String placa;
    private float capacidadeCombustivel;
    private String tipoCombustivel;
    private float peso;
    private float tamanho;
    private float altura;
    private boolean semiReboque;
    private float capacidadePeso;
    private Versao versao;
    private Pessoa proprietario;

    public Veiculo() {
    }

    public Veiculo(String placa, float capacidadeCombustivel, String tipoCombustivel, float peso, float tamanho, float altura, boolean semiReboque, float capacidadePeso, Versao versao, Pessoa proprietario) {
        this.placa = placa;
        this.capacidadeCombustivel = capacidadeCombustivel;
        this.tipoCombustivel = tipoCombustivel;
        this.peso = peso;
        this.tamanho = tamanho;
        this.altura = altura;
        this.semiReboque = semiReboque;
        this.capacidadePeso = capacidadePeso;
        this.versao = versao;
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getCapacidadeCombustivel() {
        return capacidadeCombustivel;
    }

    public void setCapacidadeCombustivel(float capacidadeCombustivel) {
        this.capacidadeCombustivel = capacidadeCombustivel;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public boolean isSemiReboque() {
        return semiReboque;
    }

    public void setSemiReboque(boolean semiReboque) {
        this.semiReboque = semiReboque;
    }

    public float getCapacidadePeso() {
        return capacidadePeso;
    }

    public void setCapacidadePeso(float capacidadePeso) {
        this.capacidadePeso = capacidadePeso;
    }

    public Versao getVersao() {
        return versao;
    }

    public void setVersao(Versao versao) {
        this.versao = versao;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }
    
}
