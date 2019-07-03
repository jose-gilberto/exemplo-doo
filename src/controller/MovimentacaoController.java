package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Movimentacao;
import service.MovimentacaoService;
import view.MovimentacaoView;

public class MovimentacaoController {
    
    private MovimentacaoView view;
    private MovimentacaoService service;
    
    public MovimentacaoController(MovimentacaoView view) throws IOException {
        this.view = view;
        this.view.setLocationRelativeTo(null);
        this.service = new MovimentacaoService();
        
        preencherTabela();
        
        this.view.getjBtnSair().addActionListener(new ActionSair());
    }
    
    public void limparTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        tabela.setRowCount(0);
    }
    
    public void preencherTabela() {
        limparTabela();
        // Preenchendo tabela com as marcas do arquivo de serialização
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        ArrayList<Movimentacao> lista = (ArrayList<Movimentacao>) this.service.retrieve();
        
        if (lista == null)
            return;
        
        lista.forEach((mov) -> {
            tabela.addRow(new Object[] { 
                mov.getId(),
                mov.getVeiculo().getPlaca(),
                mov.getVeiculo().getProprietario().getDocumento(),
                mov.getEntrada(),
                mov.getSaida()
            });
        });
    }
    
    public void aplicarFiltro() {
        TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<>(
            (DefaultTableModel) this.view.getjTable().getModel()
        );
        
        filtro.setRowFilter(RowFilter.regexFilter(this.view.getjInputFiltro().getText()));
                
        this.view.getjTable().setRowSorter(filtro);
    }
    
    public void sairView() {
        this.view.dispose();
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
    
}
