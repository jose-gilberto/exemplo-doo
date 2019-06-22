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
import model.Carroceria;
import model.Direcao;
import model.Modelo;
import model.Versao;
import service.ModeloService;
import service.VersaoService;
import view.VersaoView;

public class VersaoController {
    
    private final VersaoView view;
    private final VersaoService serviceVersao;
    private final ModeloService serviceModelo;
    
    public VersaoController(VersaoView view) throws IOException {
        
        this.view = view;
        this.view.setLocationRelativeTo(null);
        
        this.serviceVersao = new VersaoService();
        this.serviceModelo = new ModeloService();
        
        preencherModelos();
        preencherTabela();
        
        this.view.getjBtnSair().addActionListener(new ActionSair());
        this.view.getjBtnLimpar().addActionListener(new ActionLimpar());
        this.view.getjBtnCadastrar().addActionListener(new ActionCadastrar());
        this.view.getjBtnExcluir().addActionListener(new ActionExcluir());
        this.view.getjBtnEditar().addActionListener(new ActionEditar());
        this.view.getjBtnAtualizar().addActionListener(new ActionAtualizar());
        this.view.getjBtnAplicar().addActionListener(new ActionAplicar());
    }
    
    public void cadastrar() {
        String idModelo = "" + this.view.getjInputModelo().getSelectedItem().toString().charAt(0);
        Versao versao = new Versao(
                this.view.getjInputNome().getText(),
                Carroceria.values()[this.view.getjInputCarroceria().getSelectedIndex()],
                Direcao.values()[this.view.getjInputDirecao().getSelectedIndex()],
                Integer.parseInt(this.view.getjInputNPortas().getText()),
                Integer.parseInt(this.view.getjInputNAssentos().getText()),
                this.serviceModelo.retrieve(Integer.parseInt(idModelo))
        );
        this.serviceVersao.create(versao);
    }
    
    public void preencherModelos() {
        ArrayList<Modelo> modelos = (ArrayList<Modelo>) this.serviceModelo.retrieve();
        modelos.forEach((modelo) -> {
            this.view.getjInputModelo().addItem(modelo.getId() + " - " + modelo.getNome() + " (" + modelo.getMarca().getNome() + ")");
        });
    }
    
    public void limparTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        tabela.setRowCount(0);
    }
    
    public void preencherTabela() {
        limparTabela();
        
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        ArrayList<Versao> lista = (ArrayList<Versao>) this.serviceVersao.retrieve();
        
        if (lista == null)
            return;
        
        lista.forEach((versao) -> {
            tabela.addRow(new Object[] { 
                versao.getId(), 
                versao.getNome(), 
                versao.getNumPortas(), 
                versao.getNumAssentos(),
                versao.getCarroceria().name(),
                versao.getDirecao().name(),
                versao.getModelo().getNome()
            });
        });
    }
    
    public void sairView() {
        this.view.dispose();
    }
    
    public void limparCampos() {
        this.view.getjInputNome().setText("");
        this.view.getjInputDirecao().setSelectedIndex(0);
        this.view.getjInputCarroceria().setSelectedIndex(0);
        this.view.getjInputNAssentos().setText("");
        this.view.getjInputId().setText("");
        this.view.getjInputNPortas().setText("");
    }
    
    public void excluir() {
        int row = this.view.getjTable().getSelectedRow();
        if (row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar uma versão para excluir.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            int idVersao = (int) this.view.getjTable().getValueAt(row, 0);
            this.serviceVersao.delete(idVersao);
            preencherTabela();
        }
    }
    
    public void editar() {
        int row = this.view.getjTable().getSelectedRow();
        if ( row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar uma versão para editar.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            this.view.getjBtnCadastrar().setEnabled(false);
            this.view.getjBtnAtualizar().setEnabled(true);
            
            int idVersao = (int) this.view.getjTable().getValueAt(row, 0);
            String nomeVersao = (String) this.view.getjTable().getValueAt(row, 1);
            int numPortas = (int) this.view.getjTable().getValueAt(row, 2);
            int numAssentos = (int) this.view.getjTable().getValueAt(row, 3);
            String carroceria = (String) this.view.getjTable().getValueAt(row, 4);
            String direcao = (String) this.view.getjTable().getValueAt(row, 5);
            String modelo = (String) this.view.getjTable().getValueAt(row, 6);
             
            for (int i = 0; i < this.view.getjInputModelo().getItemCount(); i++) {
                String aux = this.view.getjInputModelo().getItemAt(i).substring(4).split(" ")[0];                
                
                if (aux.equals(modelo)) {
                    this.view.getjInputModelo().setSelectedIndex(i);
                    break;
                }
            }
            
            for (int i = 0; i < this.view.getjInputDirecao().getItemCount(); i++) {
                if (this.view.getjInputDirecao().getItemAt(i).equals(direcao)) {
                    this.view.getjInputDirecao().setSelectedIndex(i);
                    break;
                }
            }
            
            for (int i = 0; i < this.view.getjInputCarroceria().getItemCount(); i++) {
                if (this.view.getjInputCarroceria().getItemAt(i).equals(carroceria)) {
                    this.view.getjInputCarroceria().setSelectedIndex(i);
                    break;
                }
            }
            
            this.view.getjInputId().setText(idVersao + "");
            this.view.getjInputNome().setText(nomeVersao);
            this.view.getjInputNPortas().setText(numPortas + "");
            this.view.getjInputNAssentos().setText(numAssentos + "");
        }
    }

    public void atualizar() {
        String idModelo = "" + this.view.getjInputModelo().getSelectedItem().toString().charAt(0);
        
        Versao versaoAtualizada = new Versao(
                this.view.getjInputNome().getText(),
                Carroceria.values()[this.view.getjInputCarroceria().getSelectedIndex()],
                Direcao.values()[this.view.getjInputDirecao().getSelectedIndex()],
                Integer.parseInt(this.view.getjInputNPortas().getText()),
                Integer.parseInt(this.view.getjInputNAssentos().getText()),
                this.serviceModelo.retrieve(Integer.parseInt(idModelo))
        );       
        
        versaoAtualizada.setId(Integer.parseInt(this.view.getjInputId().getText()));
        
        this.serviceVersao.update(versaoAtualizada.getId(), versaoAtualizada);
        
        this.view.getjBtnCadastrar().setEnabled(true);
        this.view.getjBtnAtualizar().setEnabled(false);
    }
    
    public void aplicarFiltro() {
        TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<>(
            (DefaultTableModel) this.view.getjTable().getModel()
        );
        
        filtro.setRowFilter(RowFilter.regexFilter(this.view.getjInputFiltro().getText()));
                
        this.view.getjTable().setRowSorter(filtro);
    }
    
    private class ActionSair implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sairView();
        }
    }
    
    private class ActionLimpar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limparCampos();
        }
    }
    
    private class ActionCadastrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cadastrar();
            preencherTabela();
            limparCampos();
        }
    }
    
    private class ActionAplicar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            aplicarFiltro();
        }
    }
    
    private class ActionExcluir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            excluir();
        }
    }
    
    private class ActionEditar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            editar();
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
    
}
