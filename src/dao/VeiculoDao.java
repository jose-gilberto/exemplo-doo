package dao;

import java.io.IOException;
import model.Veiculo;

public class VeiculoDao extends Dao<Veiculo> {
    
    public VeiculoDao() throws IOException {
        super("./veiculo.dat");
    }
    
}
