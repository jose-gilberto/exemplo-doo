package service;

import dao.PessoaJuridicaDao;
import java.io.IOException;
import java.util.List;
import model.PessoaJuridica;

public class PessoaJuridicaService {
    
    private final PessoaJuridicaDao dao;
    
    public PessoaJuridicaService() throws IOException {
        dao = new PessoaJuridicaDao();
    }
    
    public boolean create(PessoaJuridica obj) {
        return this.dao.create(obj);
    }
    
    public List<PessoaJuridica> retrieve() {
        return this.dao.retrieve();
    }
    
    public PessoaJuridica retrieve(int id) {
        return this.dao.retrieve(id);
    }
    
    public boolean update(int id, PessoaJuridica obj) {
        return this.dao.update(id, obj);
    }
    
    public boolean delete(int id) {
        return this.dao.delete(id);
    }
    
}
