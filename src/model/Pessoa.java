package model;

public interface Pessoa {
    
    public String getNome();

    public void setNome(String nome);

    public String getEmail();

    public void setEmail(String email);

    public Endereco getEndereco();

    public void setEndereco(Endereco endereco);

    public String getTelefone();

    public void setTelefone(String telefone);
    
    public String getDocumento();
    
}
