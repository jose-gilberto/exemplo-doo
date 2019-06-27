package service;

import dao.VeiculoDao;
import java.io.IOException;
import java.util.List;
import model.Veiculo;

public class VeiculoService {
    
    private final VeiculoDao dao;
    
    public VeiculoService() throws IOException {
        this.dao = new VeiculoDao();
    }
    
    public boolean create(Veiculo obj) {
        return this.dao.create(obj);
    }
    
    public List<Veiculo> retrieve() {
        return this.dao.retrieve();
    }
    
    public Veiculo retrieve(int id) {
        return this.dao.retrieve(id);
    }
    
    public boolean update(int id, Veiculo obj) {
        return this.dao.update(id, obj);
    }
    
    public boolean delete(int id) {
        return this.dao.delete(id);
    }
}
