package dao;

import java.io.IOException;
import model.PessoaFisica;

public class PessoaFisicaDao extends Dao<PessoaFisica> {
    
    public PessoaFisicaDao() throws IOException {
        super("./pessoafisica.dat");
    }
    
}
