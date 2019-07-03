package dao;

import java.io.IOException;
import model.Movimentacao;

public class MovimentacaoDao extends Dao<Movimentacao> {
    
    public MovimentacaoDao() throws IOException {
        super("./movimentacao.dat");
    }
    
}
