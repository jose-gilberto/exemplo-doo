package service;

import dao.VersaoDao;
import java.io.IOException;
import java.util.List;
import model.Versao;

public class VersaoService {
    
    private final VersaoDao dao;
    
    public VersaoService() throws IOException {
        dao = new VersaoDao();
    }
    
    public boolean create(Versao obj) {
        return this.dao.create(obj);
    }
    
    public List<Versao> retrieve() {
        return this.dao.retrieve();
    }
    
    public Versao retrieve(int id) {
        return this.dao.retrieve(id);
    }
    
    public boolean update(int id, Versao obj) {
        return this.dao.update(id, obj);
    }
    
    public boolean delete(int id) {
        return this.dao.delete(id);
    }
    
}
