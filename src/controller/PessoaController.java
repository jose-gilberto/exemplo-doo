package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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
        this.view.getjRadioTodosBusca().setSelected(true);
        
        preencherTabela();
        
        this.view.getjBtnSair().addActionListener(new ActionSair());
        this.view.getjRadioPessoaFisica().addActionListener(new ActionRadioPF());
        this.view.getjRadioPessoaJuridica().addActionListener(new ActionRadioPJ());
        this.view.getjBtnLimpar().addActionListener(new ActionLimparCampos());
        this.view.getjBtnCadastrar().addActionListener(new ActionCadastrar());
        this.view.getjBtnAplicar().addActionListener(new ActionAplicarFiltro());
        this.view.getjBtnExcluir().addActionListener(new ActionExcluir());
        this.view.getjBtnEditar().addActionListener(new ActionEditar());
        this.view.getjBtnAtualizar().addActionListener(new ActionAtualizar());
        this.view.getjRadioPessoaFisicaBusca().addActionListener(new ActionFiltroPf());
        this.view.getjRadioPessoaJuridicaBusca1().addActionListener(new ActionFiltroPj());
        this.view.getjRadioTodosBusca().addActionListener(new ActionFiltroTodos());
        
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
            PessoaJuridica pj = new PessoaJuridica(
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
            this.servicePessoaJuridica.create(pj);
        }
    }
    
    public void preencherTabelaPf() {
        limparTabela();
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        ArrayList<PessoaFisica> listaPf = (ArrayList<PessoaFisica>) this.servicePessoaFisica.retrieve();
        
        if (listaPf != null)
            listaPf.forEach((pessoa) -> {
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
    
    public void preencherTabelaPj() {
        limparTabela();
        
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        ArrayList<PessoaJuridica> listaPj = (ArrayList<PessoaJuridica>) this.servicePessoaJuridica.retrieve();
        
        if (listaPj != null)
            listaPj.forEach((pessoa) -> {
                tabela.addRow(new Object[] { 
                    pessoa.getId(),
                    pessoa.getNome(), 
                    pessoa.getEmail(),
                    pessoa.getTelefone(),
                    pessoa.getEndereco().getCep(),
                    pessoa.getDocumento(),
                    "PESSOA JURIDICA"
                });
            });
    }
    
    public void preencherTabela() {
        limparTabela();
        
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        ArrayList<PessoaFisica> listaPf = (ArrayList<PessoaFisica>) this.servicePessoaFisica.retrieve();
        ArrayList<PessoaJuridica> listaPj = (ArrayList<PessoaJuridica>) this.servicePessoaJuridica.retrieve();
        
        if (listaPf != null)
            listaPf.forEach((pessoa) -> {
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
       
        if (listaPj != null)
            listaPj.forEach((pessoa) -> {
                tabela.addRow(new Object[] { 
                    pessoa.getId(),
                    pessoa.getNome(), 
                    pessoa.getEmail(),
                    pessoa.getTelefone(),
                    pessoa.getEndereco().getCep(),
                    pessoa.getDocumento(),
                    "PESSOA JURIDICA"
                });
            });
    }
    
    public void limparTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        tabela.setRowCount(0);
    }
    
    public void aplicarFiltro() {
        TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<>(
            (DefaultTableModel) this.view.getjTable().getModel()
        );
        
        filtro.setRowFilter(RowFilter.regexFilter(this.view.getjInputFiltro().getText()));
                
        this.view.getjTable().setRowSorter(filtro);
    }
    
    public void editar() {
        int row = this.view.getjTable().getSelectedRow();
        if ( row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar uma pessoa para editar.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            this.view.getjBtnCadastrar().setEnabled(false);
            this.view.getjBtnAtualizar().setEnabled(true);
            
            int id = (int) this.view.getjTable().getValueAt(row, 0);
            String tipo = this.view.getjTable().getValueAt(row, 6).toString();
            
            if (tipo.equals("PESSOA FISICA")) {
                PessoaFisica pf = this.servicePessoaFisica.retrieve(id);
                this.view.getjRadioPessoaFisica().setSelected(true);
                this.view.getjRadioPessoaFisica().setEnabled(false);
                this.view.getjRadioPessoaJuridica().setEnabled(false);
                
                this.view.getjInputCEP().setText(pf.getEndereco().getCep());
                this.view.getjInputCidade().setText(pf.getEndereco().getCidade().getNome());
                this.view.getjInputDoc().setText(pf.getDocumento());
                this.view.getjInputEmail().setText(pf.getEmail());
                this.view.getjInputId().setText(pf.getId() + "");
                this.view.getjInputNome().setText(pf.getNome());
                this.view.getjInputNum().setText(pf.getEndereco().getNumero());
                this.view.getjInputPais().setText(pf.getEndereco().getCidade().getPais());
                this.view.getjInputRua().setText(pf.getEndereco().getRua());
                this.view.getjInputTelefone().setText(pf.getTelefone());
                
                for (int i = 0; i < this.view.getjInputEstado().getItemCount(); i++) {
                    if (this.view.getjInputEstado().getItemAt(i).equals(pf.getEndereco().getCidade().getEstado())) {
                        this.view.getjInputEstado().setSelectedIndex(i);
                        break;
                    }
                }                
            } else {
                PessoaJuridica pj = this.servicePessoaJuridica.retrieve(id);
                this.view.getjRadioPessoaJuridica().setSelected(true);
                this.view.getjRadioPessoaFisica().setEnabled(false);
                this.view.getjRadioPessoaJuridica().setEnabled(false);
                
                this.view.getjInputCEP().setText(pj.getEndereco().getCep());
                this.view.getjInputCidade().setText(pj.getEndereco().getCidade().getNome());
                this.view.getjInputDoc().setText(pj.getDocumento());
                this.view.getjInputEmail().setText(pj.getEmail());
                this.view.getjInputId().setText(pj.getId() + "");
                this.view.getjInputNome().setText(pj.getNome());
                this.view.getjInputNum().setText(pj.getEndereco().getNumero());
                this.view.getjInputPais().setText(pj.getEndereco().getCidade().getPais());
                this.view.getjInputRua().setText(pj.getEndereco().getRua());
                this.view.getjInputTelefone().setText(pj.getTelefone());
                
                for (int i = 0; i < this.view.getjInputEstado().getItemCount(); i++) {
                    if (this.view.getjInputEstado().getItemAt(i).equals(pj.getEndereco().getCidade().getEstado())) {
                        this.view.getjInputEstado().setSelectedIndex(i);
                        break;
                    }
                }  
            }
        }
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
    
    public void excluir() {
        int row = this.view.getjTable().getSelectedRow();
        if (row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar uma pessoa para excluir.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            int id = (int) this.view.getjTable().getValueAt(row, 0);
            String tipo = this.view.getjTable().getValueAt(row, 6).toString();
            if (tipo.equals("PESSOA FISICA")) {
                this.servicePessoaFisica.delete(id);
            } else {
                this.servicePessoaJuridica.delete(id);
            }
            preencherTabela();
        }
    }
    
    public void atualizar() {
        if (this.view.getjRadioPessoaFisica().isSelected()) {
            int id = Integer.parseInt(this.view.getjInputId().getText());
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
            pf.setId(id);
            this.servicePessoaFisica.update(id, pf);
        } else {
            int id = Integer.parseInt(this.view.getjInputId().getText());
            PessoaJuridica pj = new PessoaJuridica(
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
            pj.setId(id);
            this.servicePessoaJuridica.update(id, pj);
        }
        
        this.view.getjRadioPessoaFisica().setEnabled(true);
        this.view.getjRadioPessoaJuridica().setEnabled(true);
        this.view.getjBtnCadastrar().setEnabled(true);
        this.view.getjBtnAtualizar().setEnabled(false);
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
        this.view.getjRadioPessoaFisica().setSelected(false);
        this.view.getjRadioPessoaJuridica().setSelected(false);
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
    
    private class ActionAplicarFiltro implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            aplicarFiltro();
        }
    }
    
    private class ActionEditar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            editar();
        }
    }
    
    private class ActionExcluir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            excluir();
        }
    }
    
    private class ActionAtualizar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            atualizar();
            limparCampos();
            preencherTabela();
        }
    }
   
    private class ActionFiltroPf implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            preencherTabelaPf();
        }
    }
    
    private class ActionFiltroPj implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            preencherTabelaPj();
        }
    }
    
    private class ActionFiltroTodos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            preencherTabela();
        }
    }
}
