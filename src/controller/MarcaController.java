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
import service.MarcaService;
import view.MarcaView;

public class MarcaController {
    
    private final MarcaView marcaView;
    private final MarcaService service;
    
    public MarcaController(MarcaView marcaView) throws IOException {
        
        this.marcaView = marcaView;
        this.marcaView.setLocationRelativeTo(null);
        
        this.service = new MarcaService();
        preencherTabela();
        
        this.marcaView.getjBtnSair().addActionListener(new ActionSair());
        this.marcaView.getjBtnAplicar().addActionListener(new ActionFiltro());
        this.marcaView.getjBtnLimpar().addActionListener(new ActionLimpar());
        this.marcaView.getjBtnCadastrar().addActionListener(new ActionCadastrar());
        this.marcaView.getjBtnExcluir().addActionListener(new ActionExcluir());
        this.marcaView.getjBtnEditar().addActionListener(new ActionEditar());
        this.marcaView.getjBtnAtualizar().addActionListener(new ActionAtualizar());
        
    }
    
    public void limparTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.marcaView.getjTableMarca().getModel();
        tabela.setRowCount(0);
    }
    
    public void preencherTabela(){
        limparTabela();
        // Preenchendo tabela com as marcas do arquivo de serialização
        DefaultTableModel tabela = (DefaultTableModel) this.marcaView.getjTableMarca().getModel();
        ArrayList<Marca> lista = (ArrayList<Marca>) this.service.retrieve();
        
        if (lista == null)
            return;
        
        lista.forEach((marca) -> {
            tabela.addRow(new Object[] { marca.getId(), marca.getNome() });
        });
    }
    
    public void limparCampos() {
        this.marcaView.getjInputId().setText("");
        this.marcaView.getjInputNome().setText("");
    }
    
    public void sairView() {
        this.marcaView.dispose();
    }
    
    public void cadastrar() {
        Marca novaMarca = new Marca(this.marcaView.getjInputNome().getText());
        this.service.create(novaMarca);
    }
    
    public void aplicarFiltro() { 
        TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<>(
            (DefaultTableModel) this.marcaView.getjTableMarca().getModel()
        );
        
        filtro.setRowFilter(RowFilter.regexFilter(this.marcaView.getjInputFiltro().getText()));
                
        this.marcaView.getjTableMarca().setRowSorter(filtro);
    }
    
    public void excluir() {
        int row = this.marcaView.getjTableMarca().getSelectedRow();
        if (row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar uma marca para excluir.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            int idMarca = (int) this.marcaView.getjTableMarca().getValueAt(row, 0);
            this.service.delete(idMarca);
            preencherTabela();
        }
    }
    
    public void editar() {
        int row = this.marcaView.getjTableMarca().getSelectedRow();
        if ( row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar uma marca para editar.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            this.marcaView.getjBtnCadastrar().setEnabled(false);
            this.marcaView.getjBtnAtualizar().setEnabled(true);
            
            int idMarca = (int) this.marcaView.getjTableMarca().getValueAt(row, 0);
            String nomeMarca = (String) this.marcaView.getjTableMarca().getValueAt(row, 1);
            
            this.marcaView.getjInputId().setText("" + idMarca);
            this.marcaView.getjInputNome().setText(nomeMarca);
        }
    }
    
    public void atualizar() {
        Marca marcaAtualizada = new Marca(
                this.marcaView.getjInputNome().getText()
        );        
        marcaAtualizada.setId(Integer.parseInt(this.marcaView.getjInputId().getText()));
        
        this.service.update(marcaAtualizada.getId(), marcaAtualizada);
        
        this.marcaView.getjBtnCadastrar().setEnabled(true);
        this.marcaView.getjBtnAtualizar().setEnabled(false);
    }
    
    private class ActionLimpar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limparCampos();
        }
    }
    
    private class ActionSair implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sairView();
        }
    }
    
    private class ActionCadastrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cadastrar();
            limparCampos();
            preencherTabela();
        }
    }
    
    private class ActionFiltro implements ActionListener {
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
