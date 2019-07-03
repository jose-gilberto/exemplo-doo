/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Pichau
 */
public class EstacionamentoView extends javax.swing.JDialog {

    /**
     * Creates new form EstacionamentoView
     */
    public EstacionamentoView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSaida = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEntrada = new javax.swing.JTable();
        jBtnCadEntrada = new javax.swing.JButton();
        jBtnCadSaida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBtnCadastrarVeiculos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBtnCadastrarProprietarios = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jInputFiltroEntrada = new javax.swing.JTextField();
        jBtnAplicarFiltroEntrada = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jInputFiltroSaida = new javax.swing.JTextField();
        jBtnAplicarFiltroSaida = new javax.swing.JButton();
        jBtnLimparEstacionamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTableSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Placa", "Doc. Proprietario", "Entrada"
            }
        ));
        jScrollPane2.setViewportView(jTableSaida);

        jTableEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Placa", "Doc. Proprietario", "Versão"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableEntrada);
        if (jTableEntrada.getColumnModel().getColumnCount() > 0) {
            jTableEntrada.getColumnModel().getColumn(3).setResizable(false);
        }

        jBtnCadEntrada.setText("Realizar Entrada");

        jBtnCadSaida.setText("Realizar Saída");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciamento do Estacionamento");
        jLabel1.setAlignmentY(0.0F);

        jBtnCadastrarVeiculos.setText("Cadastrar Veículos");

        jLabel2.setText("Veículos no Estacionamento:");

        jLabel3.setText("Veículos cadastrados:");

        jBtnCadastrarProprietarios.setText("Cadastrar Proprietários");

        jBtnSair.setText("Sair");

        jLabel4.setText("Filtro:");

        jBtnAplicarFiltroEntrada.setText("Aplicar");

        jLabel5.setText("Filtro:");

        jBtnAplicarFiltroSaida.setText("Aplicar");

        jBtnLimparEstacionamento.setText("Limpar Estacionamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnLimparEstacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSair))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jInputFiltroEntrada)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jBtnAplicarFiltroEntrada))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBtnCadastrarVeiculos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtnCadastrarProprietarios))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBtnCadEntrada)))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnCadSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(321, 321, 321))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jInputFiltroSaida)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jBtnAplicarFiltroSaida))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCadastrarVeiculos)
                    .addComponent(jBtnCadastrarProprietarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jInputFiltroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnAplicarFiltroEntrada)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jInputFiltroSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnAplicarFiltroSaida))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCadEntrada)
                    .addComponent(jBtnCadSaida))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSair)
                    .addComponent(jBtnLimparEstacionamento))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EstacionamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstacionamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstacionamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstacionamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EstacionamentoView dialog = new EstacionamentoView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAplicarFiltroEntrada;
    private javax.swing.JButton jBtnAplicarFiltroSaida;
    private javax.swing.JButton jBtnCadEntrada;
    private javax.swing.JButton jBtnCadSaida;
    private javax.swing.JButton jBtnCadastrarProprietarios;
    private javax.swing.JButton jBtnCadastrarVeiculos;
    private javax.swing.JButton jBtnLimparEstacionamento;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JTextField jInputFiltroEntrada;
    private javax.swing.JTextField jInputFiltroSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableEntrada;
    private javax.swing.JTable jTableSaida;
    // End of variables declaration//GEN-END:variables

    public JButton getjBtnCadastrarProprietarios() {
        return jBtnCadastrarProprietarios;
    }

    public void setjBtnCadastrarProprietarios(JButton jBtnCadastrarProprietarios) {
        this.jBtnCadastrarProprietarios = jBtnCadastrarProprietarios;
    }

    public JButton getjBtnCadastrarVeiculos() {
        return jBtnCadastrarVeiculos;
    }

    public void setjBtnCadastrarVeiculos(JButton jBtnCadastrarVeiculos) {
        this.jBtnCadastrarVeiculos = jBtnCadastrarVeiculos;
    }

    public JButton getjBtnSair() {
        return jBtnSair;
    }

    public void setjBtnSair(JButton jBtnSair) {
        this.jBtnSair = jBtnSair;
    }

    public JButton getjBtnAplicarFiltroEntrada() {
        return jBtnAplicarFiltroEntrada;
    }

    public void setjBtnAplicarFiltroEntrada(JButton jBtnAplicarFiltroEntrada) {
        this.jBtnAplicarFiltroEntrada = jBtnAplicarFiltroEntrada;
    }

    public JButton getjBtnAplicarFiltroSaida() {
        return jBtnAplicarFiltroSaida;
    }

    public void setjBtnAplicarFiltroSaida(JButton jBtnAplicarFiltroSaida) {
        this.jBtnAplicarFiltroSaida = jBtnAplicarFiltroSaida;
    }

    public JTextField getjInputFiltroEntrada() {
        return jInputFiltroEntrada;
    }

    public void setjInputFiltroEntrada(JTextField jInputFiltroEntrada) {
        this.jInputFiltroEntrada = jInputFiltroEntrada;
    }

    public JTextField getjInputFiltroSaida() {
        return jInputFiltroSaida;
    }

    public void setjInputFiltroSaida(JTextField jInputFiltroSaida) {
        this.jInputFiltroSaida = jInputFiltroSaida;
    }

    public JTable getjTableEntrada() {
        return jTableEntrada;
    }

    public void setjTableEntrada(JTable jTableEntrada) {
        this.jTableEntrada = jTableEntrada;
    }

    public JTable getjTableSaida() {
        return jTableSaida;
    }

    public void setjTableSaida(JTable jTableSaida) {
        this.jTableSaida = jTableSaida;
    }

    public JButton getjBtnCadEntrada() {
        return jBtnCadEntrada;
    }

    public void setjBtnCadEntrada(JButton jBtnCadEntrada) {
        this.jBtnCadEntrada = jBtnCadEntrada;
    }

    public JButton getjBtnCadSaida() {
        return jBtnCadSaida;
    }

    public void setjBtnCadSaida(JButton jBtnCadSaida) {
        this.jBtnCadSaida = jBtnCadSaida;
    }

    public JButton getjBtnLimparEstacionamento() {
        return jBtnLimparEstacionamento;
    }

    public void setjBtnLimparEstacionamento(JButton jBtnLimparEstacionamento) {
        this.jBtnLimparEstacionamento = jBtnLimparEstacionamento;
    }

    

}
