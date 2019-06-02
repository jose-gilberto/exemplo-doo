package service;

import dao.ModeloDao;
import model.Modelo;
import java.io.IOException;
import java.util.List;

public class ModeloService {
    
    private final ModeloDao dao;
    
    public ModeloService() throws IOException {
        dao = new ModeloDao();
    }
    
    public boolean create(Modelo obj) {
        return this.dao.create(obj);
    }
    
    public List<Modelo> retrieve() {
        return this.dao.retrieve();
    }
    
    public Modelo retrieve(int id) {
        return this.dao.retrieve(id);
    }
    
    public boolean update(int id, Modelo obj) {
        return this.dao.update(id, obj);
    }
    
    public boolean delete(int id) {
        return this.dao.delete(id);
    }
    
}
