package dao;

import java.io.IOException;
import model.PessoaJuridica;

public class PessoaJuridicaDao extends Dao<PessoaJuridica> {
    
    public PessoaJuridicaDao() throws IOException {
        super("./pessoajuridica.dat");
    }
    
}
