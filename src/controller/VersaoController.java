package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import service.VersaoService;
import view.VersaoView;

public class VersaoController {
    
    private final VersaoView view;
    private final VersaoService serviceVersao;
    
    public VersaoController(VersaoView view) throws IOException {
        
        this.view = view;
        this.view.setLocationRelativeTo(null);
        
        this.serviceVersao = new VersaoService();
        
        this.view.getjBtnSair().addActionListener(new ActionSair());
        this.view.getjBtnLimpar().addActionListener(null);
        this.view.getjBtnCadastrar().addActionListener(null);
        this.view.getjBtnExcluir().addActionListener(null);
        this.view.getjBtnEditar().addActionListener(null);
        this.view.getjBtnAtualizar().addActionListener(null);
        this.view.getjBtnAplicar().addActionListener(null);
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
    
}
