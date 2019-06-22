package dao;

import java.io.IOException;
import model.Versao;

public class VersaoDao extends Dao<Versao> {
    
    public VersaoDao() throws IOException {
        super("./versao.dat");
    }
    
}