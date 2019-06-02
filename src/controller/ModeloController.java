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
import model.Marca;
import model.Modelo;
import service.MarcaService;
import service.ModeloService;
import view.ModeloView;

public class ModeloController {
    
    private final ModeloView view;
    private final ModeloService serviceModelo;
    private final MarcaService serviceMarca;
    

    public ModeloController(ModeloView view) throws IOException {
        this.view = view;
        this.view.setLocationRelativeTo(null);
        
        this.serviceModelo = new ModeloService();
        this.serviceMarca = new MarcaService();
        
        preencherMarcas();
        preencherTabela();
        
        this.view.getjBtnSair().addActionListener(new ActionSair());
        this.view.getjBtnLimpar().addActionListener(new ActionLimpar());
        this.view.getjBtnCadastrar().addActionListener(new ActionCadastrar());
        this.view.getjBtnExcluir().addActionListener(new ActionExcluir());
        this.view.getjBtnEditar().addActionListener(new ActionEditar());
        this.view.getjBtnAtualizar().addActionListener(new ActionAtualizar());
        this.view.getjBtnAplicar().addActionListener(new ActionAplicar());
    }
    
    public void preencherMarcas() {
        ArrayList<Marca> listaMarcas = (ArrayList<Marca>) this.serviceMarca.retrieve();
        listaMarcas.forEach((marca) -> {
            this.view.getjInputMarca().addItem(marca.getId() + " - " + marca.getNome());
        });
    }
    
    public void limparTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        tabela.setRowCount(0);
    }
    
    public void preencherTabela() {
        limparTabela();
        
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        ArrayList<Modelo> lista = (ArrayList<Modelo>) this.serviceModelo.retrieve();
        
        if (lista == null)
            return;
        
        lista.forEach((modelo) -> {
            tabela.addRow(new Object[] { modelo.getId(), modelo.getNome(), modelo.getAno(), modelo.getMarca().getNome() });
        });
    }
    
    public void cadastrar() {
        String idMarca = "" + this.view.getjInputMarca().getSelectedItem().toString().charAt(0);
        Modelo novoModelo = new Modelo(
            this.view.getjInputNome().getText(),
            Integer.parseInt(this.view.getjInputAno().getText()),
            this.serviceMarca.retrieve(Integer.parseInt(idMarca))
        );
        this.serviceModelo.create(novoModelo);
    }
    
    public void sairView() {
        this.view.dispose();
    }
    
    public void limparCampos() {
        this.view.getjInputAno().setText("");
        this.view.getjInputNome().setText("");
        this.view.getjInputMarca().setSelectedIndex(0);
        this.view.getjInputId().setText("");
    }
    
    public void editar() {
        int row = this.view.getjTable().getSelectedRow();
        if ( row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar um modelo para editar.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            this.view.getjBtnCadastrar().setEnabled(false);
            this.view.getjBtnAtualizar().setEnabled(true);
            
            int idModelo = (int) this.view.getjTable().getValueAt(row, 0);
            String nomeModelo = (String) this.view.getjTable().getValueAt(row, 1);
            int anoModelo = (int) this.view.getjTable().getValueAt(row, 2);
            String marcaModelo = (String) this.view.getjTable().getValueAt(row, 3);
             
            for (int i = 0; i < this.view.getjInputMarca().getItemCount(); i++) {
                String aux = this.view.getjInputMarca().getItemAt(i);
                aux = aux.substring(4);
                
                if (aux.equals(marcaModelo)) {
                    this.view.getjInputMarca().setSelectedIndex(i);
                    break;
                }
                
            }
            
            this.view.getjInputId().setText("" + idModelo);
            this.view.getjInputNome().setText(nomeModelo);
            this.view.getjInputAno().setText("" + anoModelo);
        }
    }
    
    public void atualizar() {
        String idMarca = "" + this.view.getjInputMarca().getSelectedItem().toString().charAt(0);
        
        Modelo modeloAtualizado = new Modelo(
                this.view.getjInputNome().getText(), 
                Integer.parseInt(this.view.getjInputAno().getText()), 
                this.serviceMarca.retrieve(Integer.parseInt(idMarca))
        );        
        
        modeloAtualizado.setId(Integer.parseInt(this.view.getjInputId().getText()));
        
        this.serviceModelo.update(modeloAtualizado.getId(), modeloAtualizado);
        
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
    
    public void excluir() {
        int row = this.view.getjTable().getSelectedRow();
        if (row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar um modelo para excluir.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            int idModelo = (int) this.view.getjTable().getValueAt(row, 0);
            this.serviceModelo.delete(idModelo);
            preencherTabela();
        }
    }
    
    private class ActionSair implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sairView();
        }
    }
    
    private class ActionAplicar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            aplicarFiltro();
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
    
    private class ActionExcluir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            excluir();
        }
    }
    
}
