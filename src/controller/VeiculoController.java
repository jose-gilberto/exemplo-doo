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
import model.Pessoa;
import service.VeiculoService;
import view.VeiculoView;
import model.Veiculo;
import model.Versao;
import service.PessoaFisicaService;
import service.PessoaJuridicaService;
import service.VersaoService;

public class VeiculoController {
    
    VeiculoView view;
    VeiculoService serviceVeiculo;
    VersaoService versaoService;
    PessoaFisicaService pessoaFisicaService;
    PessoaJuridicaService pessoaJuridicaService;

    public VeiculoController(VeiculoView view) throws IOException {
        this.view = view;
        this.view.setLocationRelativeTo(null);
        
        this.serviceVeiculo = new VeiculoService();
        this.pessoaFisicaService = new PessoaFisicaService();
        this.pessoaJuridicaService = new PessoaJuridicaService();
        this.versaoService = new VersaoService();
        
        preencherVersoes();
        preencherProprietarios();
        preencherTabela();
        
        this.view.getjBtnSair().addActionListener(new ActionSair());
        this.view.getjBtnLimpar().addActionListener(new ActionLimparCampos());
        this.view.getjBtnAplicar().addActionListener(new ActionAplicarFiltro());
        this.view.getjBtnCadastrar().addActionListener(new ActionCadastrar());
        this.view.getjBtnExcluir().addActionListener(new ActionExcluir());
        this.view.getjBtnEditar().addActionListener(new ActionEditar());
        this.view.getjBtnAtualizar().addActionListener(new ActionAtualizar());
    }
    
    public void sairView() {
        this.view.dispose();
    }
    
    public void preencherProprietarios() {
        this.pessoaFisicaService.retrieve().forEach((pessoa) -> {
            this.view.getjInputProprietario().addItem(pessoa.getId() + " - " + pessoa.getDocumento() + " - PF");
        });
        
        this.pessoaJuridicaService.retrieve().forEach((pessoa) -> {
            this.view.getjInputProprietario().addItem(pessoa.getId() + " - " + pessoa.getDocumento() + " - PJ");
        });
    }
    
    public void preencherVersoes() {
        this.versaoService.retrieve().forEach((versao) -> {
            this.view.getjInputVersao().addItem(versao.getId() + " - " + versao.getNome());
        });
    }
    
    public void cadastrar() {
        Versao versao = this.versaoService.retrieve(
                Integer.parseInt(this.view.getjInputVersao().getSelectedItem().toString().charAt(0) + "")
        );
        String[] aux = this.view.getjInputProprietario().getSelectedItem().toString().split("-");
        Pessoa pessoa = ((aux[2].equals(" PF")) ? this.pessoaFisicaService.retrieve(
                Integer.parseInt(this.view.getjInputProprietario().getSelectedItem().toString().charAt(0) + "")) : 
            this.pessoaJuridicaService.retrieve(
                Integer.parseInt(this.view.getjInputProprietario().getSelectedItem().toString().charAt(0) + "")));
        
        
        
        Veiculo veiculo = new Veiculo(
            this.view.getjInputPlaca().getText(),
                Float.parseFloat(this.view.getjInputCapacidade().getText()),
            this.view.getjInputTipoCombustivel().getText(),
            Float.parseFloat(this.view.getjInputPeso().getText()),
            Float.parseFloat(this.view.getjInputTamanho().getText()),
            Float.parseFloat(this.view.getjInputAltura().getText()),
            this.view.getjSemiReboque().isSelected(),
            Float.parseFloat(this.view.getjInputCapacidadePeso().getText()),
            versao,
            pessoa
        );
        
        this.serviceVeiculo.create(veiculo);
    }
    
    public void aplicarFiltro() {
        TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<>(
            (DefaultTableModel) this.view.getjTable().getModel()
        );
        
        filtro.setRowFilter(RowFilter.regexFilter(this.view.getjInputFiltro().getText()));
                
        this.view.getjTable().setRowSorter(filtro);
    }
    
    public void limparTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        tabela.setRowCount(0);
    }
    
    public void preencherTabela() {
        limparTabela();
        DefaultTableModel tabela = (DefaultTableModel) this.view.getjTable().getModel();
        ArrayList<Veiculo> lista = (ArrayList<Veiculo>) this.serviceVeiculo.retrieve();
        
        if (lista != null)
            lista.forEach((Veiculo veiculo) -> {
                tabela.addRow(new Object[] {
                    veiculo.getId(),
                    veiculo.getPlaca(),
                    veiculo.getProprietario().getDocumento(),
                    veiculo.getVersao().getNome()
                });
            });
    }
    
    public void limparCampos() {
        this.view.getjInputId().setText("");
        this.view.getjInputCapacidade().setText("");
        this.view.getjInputCapacidadePeso().setText("");
        this.view.getjInputPeso().setText("");
        this.view.getjInputPlaca().setText("");
        this.view.getjInputProprietario().setSelectedIndex(0);
        this.view.getjInputTipoCombustivel().setText("");
        this.view.getjInputAltura().setText("");
        this.view.getjInputVersao().setSelectedIndex(0);
    }
    
    public void excluir() {
        int row = this.view.getjTable().getSelectedRow();
        if (row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar um veículo para excluir.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            int id = (int) this.view.getjTable().getValueAt(row, 0);
            this.serviceVeiculo.delete(id);
            preencherTabela();
        }
    }
    
    public void editar() {
        int row = this.view.getjTable().getSelectedRow();
        if ( row < 0) {
            JFrame frame = new JFrame("Aviso");
            JOptionPane.showMessageDialog( frame,
                "Você precisa selecionar um veículo para editar.",
                "Aviso!",
                JOptionPane.WARNING_MESSAGE );
        } else {
            this.view.getjBtnCadastrar().setEnabled(false);
            this.view.getjBtnAtualizar().setEnabled(true);
            
            int id = (int) this.view.getjTable().getValueAt(row, 0);
            Veiculo veiculoEditar = this.serviceVeiculo.retrieve(id);
            
            this.view.getjInputId().setText("" + veiculoEditar.getId());
            this.view.getjInputCapacidade().setText("" + veiculoEditar.getCapacidadeCombustivel());
            this.view.getjInputCapacidadePeso().setText("" + veiculoEditar.getCapacidadePeso());
            this.view.getjInputAltura().setText("" + veiculoEditar.getAltura());
            this.view.getjInputPeso().setText("" + veiculoEditar.getPeso());
            this.view.getjInputPlaca().setText(veiculoEditar.getPlaca());
            this.view.getjInputTamanho().setText("" + veiculoEditar.getTamanho());
            this.view.getjInputTipoCombustivel().setText(veiculoEditar.getTipoCombustivel());
            
            System.out.println(veiculoEditar.getProprietario().getClass());
            
            for (int i = 0; i < this.view.getjInputProprietario().getItemCount(); i++) {
                String[] aux = this.view.getjInputProprietario().getItemAt(i).split("-");
                aux[0] = aux[0].replace(" ", "");
                aux[2] = aux[2].replace(" ", "");    
                if (Integer.parseInt(aux[0]+"") == veiculoEditar.getProprietario().getId()) {
                    if (veiculoEditar.getProprietario() instanceof model.PessoaFisica && aux[2].equals("PF")) {
                        this.view.getjInputProprietario().setSelectedIndex(i);
                        break;
                    } else if (veiculoEditar.getProprietario() instanceof model.PessoaJuridica && aux[2].equals("PJ")) {
                        this.view.getjInputProprietario().setSelectedIndex(i);
                        break;
                    }
                }
            }
            
            for (int i = 0; i < this.view.getjInputVersao().getItemCount(); i++) {
                String[] aux = this.view.getjInputVersao().getItemAt(i).split("-");
                aux[0] = aux[0].replace(" ", "");
                
                if (Integer.parseInt(aux[0]) == veiculoEditar.getVersao().getId()) {
                    this.view.getjInputVersao().setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    public void atualizar() {
        Versao versao = this.versaoService.retrieve(
                Integer.parseInt(this.view.getjInputVersao().getSelectedItem().toString().charAt(0) + "")
        );
        
        String[] aux = this.view.getjInputProprietario().getSelectedItem().toString().split("-");
        Pessoa pessoa = ((aux[2].equals(" PF")) ? this.pessoaFisicaService.retrieve(
                Integer.parseInt(this.view.getjInputProprietario().getSelectedItem().toString().charAt(0) + "")) : 
            this.pessoaJuridicaService.retrieve(
                Integer.parseInt(this.view.getjInputProprietario().getSelectedItem().toString().charAt(0) + "")));
        
        Veiculo veiculoAtualizado = new Veiculo(
            this.view.getjInputPlaca().getText(),
                Float.parseFloat(this.view.getjInputCapacidade().getText()),
            this.view.getjInputTipoCombustivel().getText(),
            Float.parseFloat(this.view.getjInputPeso().getText()),
            Float.parseFloat(this.view.getjInputTamanho().getText()),
            Float.parseFloat(this.view.getjInputAltura().getText()),
            this.view.getjSemiReboque().isSelected(),
            Float.parseFloat(this.view.getjInputCapacidadePeso().getText()),
            versao,
            pessoa
        );
        
        
        veiculoAtualizado.setId(Integer.parseInt(this.view.getjInputId().getText()));
        
        this.serviceVeiculo.update(veiculoAtualizado.getId(), veiculoAtualizado);
        
        this.view.getjBtnCadastrar().setEnabled(true);
        this.view.getjBtnAtualizar().setEnabled(false);
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
    
    private class ActionAplicarFiltro implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            aplicarFiltro();
        }
    }
    
    private class ActionLimparCampos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limparCampos();
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
