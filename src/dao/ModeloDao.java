package dao;

import java.io.IOException;
import model.Modelo;

public class ModeloDao extends Dao<Modelo> {
    
    public ModeloDao() throws IOException {
        super("./modelo.dat");
    }
    
}
