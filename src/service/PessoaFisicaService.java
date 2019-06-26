package service;

import dao.PessoaFisicaDao;
import java.io.IOException;
import java.util.List;
import model.PessoaFisica;

public class PessoaFisicaService {
    
    private final PessoaFisicaDao dao;
    
    public PessoaFisicaService() throws IOException {
        dao = new PessoaFisicaDao();
    }
    
    public boolean create(PessoaFisica obj) {
        return this.dao.create(obj);
    }
    
    public List<PessoaFisica> retrieve() {
        return this.dao.retrieve();
    }
    
    public PessoaFisica retrieve(int id) {
        return this.dao.retrieve(id);
    }
    
    public boolean update(int id, PessoaFisica obj) {
        return this.dao.update(id, obj);
    }
    
    public boolean delete(int id) {
        return this.dao.delete(id);
    }
    
}
