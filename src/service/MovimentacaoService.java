package service;

import dao.MovimentacaoDao;
import java.io.IOException;
import java.util.List;
import model.Movimentacao;

public class MovimentacaoService {
    
    private final MovimentacaoDao dao;
    
    public MovimentacaoService() throws IOException {
        this.dao = new MovimentacaoDao();
    }
    
    public boolean create(Movimentacao obj) {
        return this.dao.create(obj);
    }
    
    public List<Movimentacao> retrieve() {
        return this.dao.retrieve();
    }
    
    public Movimentacao retrieve(int id) {
        return this.dao.retrieve(id);
    }
    
    public boolean update(int id, Movimentacao obj) {
        return this.dao.update(id, obj);
    }
    
    public boolean delete(int id) {
        return this.dao.delete(id);
    }
    
}
