package service;

import dao.MarcaDao;
import java.io.IOException;
import java.util.List;
import model.Marca;

public class MarcaService {
    
    private final MarcaDao dao;
    
    public MarcaService() throws IOException {
        this.dao = new MarcaDao();
    }
    
    public boolean create(Marca obj) {
        return this.dao.create(obj);
    }
    
    public List<Marca> retrieve() {
        return this.dao.retrieve();
    }
    
    public Marca retrieve(int id) {
        return this.dao.retrieve(id);
    }
    
    public boolean update(int id, Marca obj) {
        return this.dao.update(id, obj);
    }
    
    public boolean delete(int id) {
        return this.dao.delete(id);
    }
    
}
