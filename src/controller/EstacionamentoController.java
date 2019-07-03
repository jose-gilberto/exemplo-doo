package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import service.VeiculoService;
import view.EstacionamentoView;
import view.MainView;
import view.PessoaView;
import view.VeiculoView;
import model.Veiculo;
import service.MovimentacaoService;
import model.Movimentacao;

public class EstacionamentoController {
    
    private final VeiculoService serviceVeiculo;
    private final EstacionamentoView view;
    private final MovimentacaoService serviceMovimentacao;
    private ArrayList<Integer> carrosEstacionados;
    
    public EstacionamentoController(EstacionamentoView view) throws IOException {
        
        this.view = view;
        this.view.setLocationRelativeTo(null);
        
        this.carrosEstacionados = new ArrayList<>();
        
        this.serviceVeiculo = new VeiculoService();
        this.serviceMovimentacao = new MovimentacaoService();
        
        preencherArrayCarros();
        preencherTabelaVeiculos();
        preencherTabelaSaida();
        
        this.view.getjBtnCadastrarProprietarios().addActionListener(new ActionCadProprietario());
        this.view.getjBtnCadastrarVeiculos().addActionListener(new ActionCadVeiculo());
        this.view.getjBtnSair().addActionListener(new ActionSair());
        this.view.getjBtnAplicarFiltroEntrada().addActionListener(new ActionAplicarFiltroEntrada());
        this.view.getjBtnAplicarFiltroSaida().addActionListener(new ActionAplicarFiltroSaida());
        this.view.getjBtnLimparEstacionamento().addActionListener(new ActionLimparEstacionamento());
        this.view.getjBtnCadEntrada().addActionListener(new ActionAdicionarEntrada());
        this.view.getjBtnCadSaida().addActionListener(new ActionAdicionarSaida());
    }
    
    private void preencherArrayCarros() {
        ArrayList<Movimentacao> lista = (ArrayList<Movimentacao>) this.serviceMovimentacao.retrieve();
        lista.forEach((movimentacao) -> {
            if (movimentacao.getSaida() == null) {
                this.carrosEstacionados.add(movimentacao.getVeiculo().getId());
            }
        });
    }
    
    public void limparTabelaVeiculos() {
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTableEntrada().getModel();
        tabela.setRowCount(0);
    }
    
    public void limparTabelaSaida() {
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTableSaida().getModel();
        tabela.setRowCount(0); 
    }
    
    public void preencherTabelaSaida() {
        limparTabelaSaida();
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTableSaida().getModel();
        ArrayList<Movimentacao> lista = (ArrayList<Movimentacao>) this.serviceMovimentacao.retrieve();
        
        if (lista != null)
            lista.forEach((Movimentacao mov) -> {
                if (mov.getSaida() == null) {
                    tabela.addRow(new Object[] {
                        mov.getId(),
                        mov.getVeiculo().getPlaca(),
                        mov.getVeiculo().getProprietario().getDocumento(),
                        mov.getEntrada()
                    });
                }
            });
    }
    
    public void preencherTabelaVeiculos() {
        limparTabelaVeiculos();
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTableEntrada().getModel();
        ArrayList<Veiculo> lista = (ArrayList<Veiculo>) this.serviceVeiculo.retrieve();
        
        if (lista != null)
            lista.forEach((Veiculo veiculo) -> {
                if (!this.carrosEstacionados.contains(veiculo.getId())) {
                    tabela.addRow(new Object[] {
                        veiculo.getId(),
                        veiculo.getPlaca(),
                        veiculo.getProprietario().getDocumento(),
                        veiculo.getVersao().getNome()
                    });
                }
            });
    }
    
    public void criarEntrada() {
        int row = this.view.getjTableEntrada().getSelectedRow();
        if (row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar um veiculo para entrar no estacionamento.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            int id = (int) this.view.getjTableEntrada().getValueAt(row, 0);
            Veiculo veiculo = this.serviceVeiculo.retrieve(id);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String strDate = formatter.format(date);
            Movimentacao mov = new Movimentacao(veiculo, strDate, null);
            this.serviceMovimentacao.create(mov);
            this.carrosEstacionados.add(veiculo.getId());
        }        
    }
    
    public void criarSaida() {
        int row = this.view.getjTableSaida().getSelectedRow();
        if (row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar um veiculo para sair do estacionamento.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            int id = (int) this.view.getjTableSaida().getValueAt(row, 0);
            Movimentacao mov = this.serviceMovimentacao.retrieve(id);
            
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String strDate = formatter.format(date);
            
            mov.setSaida(strDate);
            
            for (int i = 0; i < this.carrosEstacionados.size(); i++) {
                if (this.carrosEstacionados.get(i) == mov.getVeiculo().getId()) {
                    this.carrosEstacionados.remove(i);
                }
            }
            
            this.serviceMovimentacao.update(id, mov);
        }    
    }
    
    public void sairView() {
        this.view.dispose();
    }
    
    public void aplicarFiltroSaida() {
        TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<>(
            (DefaultTableModel) this.view.getjTableSaida().getModel()
        );
        
        filtro.setRowFilter(RowFilter.regexFilter(this.view.getjInputFiltroSaida().getText()));
                
        this.view.getjTableSaida().setRowSorter(filtro);
    }
    
    public void aplicarFiltroEntrada() {
        TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<>(
            (DefaultTableModel) this.view.getjTableEntrada().getModel()
        );
        
        filtro.setRowFilter(RowFilter.regexFilter(this.view.getjInputFiltroEntrada().getText()));
                
        this.view.getjTableEntrada().setRowSorter(filtro);
    }
    
    public void zerarEstacionamento() {
        ArrayList<Movimentacao> listaMov = (ArrayList<Movimentacao>) this.serviceMovimentacao.retrieve();
        listaMov.stream().filter((movimentacao) -> (movimentacao.getSaida() == null)).forEachOrdered((movimentacao) -> {
            
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String strDate = formatter.format(date);
            movimentacao.setSaida(strDate);
            
            this.carrosEstacionados = new ArrayList<>();
            this.serviceMovimentacao.update(movimentacao.getId(), movimentacao);
        });
    }
    
    private class ActionCadVeiculo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VeiculoView veiculoView = new VeiculoView(null, true);
            try {
                VeiculoController veiculoController = new VeiculoController(veiculoView);
            } catch (IOException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
            veiculoView.setVisible(true);
        }
    }
    
    private class ActionCadProprietario implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PessoaView pessoaView = new PessoaView(null, true);
            try {
                PessoaController pessoaController = new PessoaController(pessoaView);
            } catch (IOException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
            pessoaView.setVisible(true);
        }
    }
    
    private class ActionSair implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sairView();
        }
    }
    
    private class ActionAplicarFiltroEntrada implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            aplicarFiltroEntrada();
        }
    }
    
    private class ActionAplicarFiltroSaida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            aplicarFiltroSaida();
        }
    }
    
    private class ActionAdicionarEntrada implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            criarEntrada();
            preencherTabelaVeiculos();
            preencherTabelaSaida();
        }
    }
    
    private class ActionLimparEstacionamento implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            zerarEstacionamento();
            preencherTabelaSaida();
            preencherTabelaVeiculos();
        }
    }
    
    private class ActionAdicionarSaida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            criarSaida();
            preencherTabelaVeiculos();
            preencherTabelaSaida();
        }
    }
}
