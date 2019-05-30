package dao;

import java.io.IOException;
import java.io.Serializable;
import model.Marca;

public class MarcaDao extends Dao<Marca> implements Serializable {
    
    public MarcaDao() throws IOException {
        super("./marca.dat");
    }
    
}
