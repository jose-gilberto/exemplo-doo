package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Cidade;
import model.Endereco;
import service.PessoaFisicaService;
import service.PessoaJuridicaService;
import view.PessoaView;
import model.PessoaJuridica;
import model.PessoaFisica;

public class PessoaController {
    
    private final PessoaView view;
    private final PessoaFisicaService servicePessoaFisica;
    private final PessoaJuridicaService servicePessoaJuridica;

    public PessoaController(PessoaView view) throws IOException {
        this.view = view;
        this.servicePessoaFisica = new PessoaFisicaService();
        this.servicePessoaJuridica = new PessoaJuridicaService();
        
        this.view.setLocationRelativeTo(null);
        
        preencherTabela();
        
        this.view.getjBtnSair().addActionListener(new ActionSair());
        this.view.getjRadioPessoaFisica().addActionListener(new ActionRadioPF());
        this.view.getjRadioPessoaJuridica().addActionListener(new ActionRadioPJ());
        this.view.getjBtnLimpar().addActionListener(new ActionLimparCampos());
        this.view.getjBtnCadastrar().addActionListener(new ActionCadastrar());
    }
    
    public void cadastrar() {
        if (this.view.getjRadioPessoaFisica().isSelected()) {
            PessoaFisica pf = new PessoaFisica(
                    this.view.getjInputNome().getText(),
                    this.view.getjInputEmail().getText(),
                    new Endereco(
                            this.view.getjInputRua().getText(),
                            this.view.getjInputNum().getText(),
                            this.view.getjInputCEP().getText(),
                            new Cidade(
                                    this.view.getjInputCidade().getText(),
                                    this.view.getjInputEstado().getSelectedItem().toString(),
                                    this.view.getjInputPais().getText()
                            )
                    ),
                    this.view.getjInputTelefone().getText(),
                    this.view.getjInputDoc().getText()
            );
            this.servicePessoaFisica.create(pf);
            
        } else {
            PessoaJuridica pj = new PessoaJuridica();
        }
    }
    
    public void preencherTabela() {
        limparTabela();
        
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        ArrayList<PessoaFisica> lista = (ArrayList<PessoaFisica>) this.servicePessoaFisica.retrieve();
        
        if (lista != null)
            lista.forEach((pessoa) -> {
                tabela.addRow(new Object[] { 
                    pessoa.getId(),
                    pessoa.getNome(), 
                    pessoa.getEmail(),
                    pessoa.getTelefone(),
                    pessoa.getEndereco().getCep(),
                    pessoa.getDocumento(),
                    "PESSOA FISICA"
                });
            });
        
    }
    
    public void limparTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        tabela.setRowCount(0);
    }
    
    public void sairView() {
        this.view.dispose();
    }
    
    public void alternarLabelDocumento(boolean b) {
        if (b) {
            this.view.getjLabelDoc().setText("CPF:");
            return;
        }
        
        this.view.getjLabelDoc().setText("CNPJ:");
    }
    
    public void limparCampos() {
        this.view.getjInputId().setText("");
        this.view.getjInputCEP().setText("");
        this.view.getjInputCidade().setText("");
        this.view.getjInputDoc().setText("");
        this.view.getjInputEmail().setText("");
        this.view.getjInputEstado().setSelectedIndex(0);
        this.view.getjInputNome().setText("");
        this.view.getjInputNum().setText("");
        this.view.getjInputPais().setText("");
        this.view.getjInputRua().setText("");
        this.view.getjInputTelefone().setText("");
    }
    
    private class ActionCadastrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cadastrar();
            limparCampos();
            preencherTabela();
        }
    }
    
    private class ActionSair implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sairView();
        }
    }
    
    private class ActionRadioPF implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            alternarLabelDocumento(true);
        }
    }
    
    private class ActionRadioPJ implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            alternarLabelDocumento(false);
        } 
    }
    
    private class ActionLimparCampos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limparCampos();
        }
    }
}
