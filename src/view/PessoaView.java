/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Pichau
 */
public class PessoaView extends javax.swing.JDialog {

    /**
     * Creates new form PessoaView
     */
    public PessoaView(java.awt.Frame parent, boolean modal) {
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

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jRadioPessoaJuridica = new javax.swing.JRadioButton();
        jRadioPessoaFisica = new javax.swing.JRadioButton();
        jInputId = new javax.swing.JTextField();
        jLabelId = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jInputNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jInputEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jInputTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jInputCEP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jInputRua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jInputNum = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jInputCidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jInputEstado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jInputPais = new javax.swing.JTextField();
        jLabelDoc = new javax.swing.JLabel();
        jInputDoc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jInputFiltro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jBtnAplicar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jBtnEditar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnSair = new javax.swing.JButton();
        jBtnLimpar = new javax.swing.JButton();
        jBtnCadastrar = new javax.swing.JButton();
        jBtnAtualizar = new javax.swing.JButton();
        jRadioPessoaJuridicaBusca = new javax.swing.JRadioButton();
        jRadioPessoaFisicaBusca = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciamento de Proprietários");
        jLabel1.setAlignmentY(0.0F);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Cadastro");

        buttonGroup2.add(jRadioPessoaJuridica);
        jRadioPessoaJuridica.setText("Pessoa Jurídica");

        buttonGroup2.add(jRadioPessoaFisica);
        jRadioPessoaFisica.setText("Pessoa Física");

        jInputId.setEnabled(false);

        jLabelId.setText("Id:");

        jLabelNome.setText("Nome:");

        jLabel3.setText("Email:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("CEP:");

        jLabel6.setText("Rua:");

        jLabel7.setText("Nº:");

        jLabel8.setText("Cidade:");

        jLabel9.setText("Estado:");

        jInputEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre", "Alagoas", "Amapa", "Amazonas", "Bahia", "Ceara", "Distrito Federal", "Espirito Santo", "Goias", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Para", "Paraiba", "Parana", "Pernambuco", "Piaui", "Rio Grande do Norte", "Rio Grande do Sul", "Rio de Janeiro", "Rondonia", "Roraima", "Santa Catarina", "Sao Paulo", "Sergipe", "Tocatins" }));

        jLabel10.setText("País:");

        jLabelDoc.setText("CNPJ/CPF:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Busca");

        jLabel12.setText("Filtro:");

        jBtnAplicar.setText("Aplicar");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Email", "Telefone", "CEP", "Documento", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);

        jBtnEditar.setText("Editar");

        jBtnExcluir.setText("Excluir");

        jBtnSair.setText("Sair");

        jBtnLimpar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtnLimpar.setText("Limpar");

        jBtnCadastrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtnCadastrar.setText("Cadastrar");

        jBtnAtualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtnAtualizar.setText("Atualizar");
        jBtnAtualizar.setEnabled(false);

        buttonGroup3.add(jRadioPessoaJuridicaBusca);
        jRadioPessoaJuridicaBusca.setText("Pessoa Jurídica");

        buttonGroup3.add(jRadioPessoaFisicaBusca);
        jRadioPessoaFisicaBusca.setText("Pessoa Física");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioPessoaFisicaBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioPessoaJuridicaBusca))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jInputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jInputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jInputCEP))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jRadioPessoaFisica)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioPessoaJuridica))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelId)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jInputId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jInputNome))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jInputEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jInputPais))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jInputRua, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jInputNum, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jInputCidade)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelDoc)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jInputDoc))))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(565, 565, 565)
                                    .addComponent(jBtnEditar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtnExcluir)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtnSair))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(jBtnAtualizar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jBtnCadastrar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jBtnLimpar))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jInputFiltro)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtnAplicar))))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioPessoaFisica)
                    .addComponent(jRadioPessoaJuridica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jInputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome)
                    .addComponent(jInputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jInputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jInputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jInputCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jInputRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jInputNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jInputCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jInputEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jInputPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDoc)
                    .addComponent(jInputDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnLimpar)
                            .addComponent(jBtnCadastrar)
                            .addComponent(jBtnAtualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jInputFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAplicar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioPessoaFisicaBusca)
                    .addComponent(jRadioPessoaJuridicaBusca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSair)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnEditar))
                .addGap(22, 22, 22))
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
            java.util.logging.Logger.getLogger(PessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PessoaView dialog = new PessoaView(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jBtnAplicar;
    private javax.swing.JButton jBtnAtualizar;
    private javax.swing.JButton jBtnCadastrar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnLimpar;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JTextField jInputCEP;
    private javax.swing.JTextField jInputCidade;
    private javax.swing.JTextField jInputDoc;
    private javax.swing.JTextField jInputEmail;
    private javax.swing.JComboBox<String> jInputEstado;
    private javax.swing.JTextField jInputFiltro;
    private javax.swing.JTextField jInputId;
    private javax.swing.JTextField jInputNome;
    private javax.swing.JTextField jInputNum;
    private javax.swing.JTextField jInputPais;
    private javax.swing.JTextField jInputRua;
    private javax.swing.JTextField jInputTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDoc;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JRadioButton jRadioPessoaFisica;
    private javax.swing.JRadioButton jRadioPessoaFisicaBusca;
    private javax.swing.JRadioButton jRadioPessoaJuridica;
    private javax.swing.JRadioButton jRadioPessoaJuridicaBusca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables

    public JButton getjBtnAplicar() {
        return jBtnAplicar;
    }

    public void setjBtnAplicar(JButton jBtnAplicar) {
        this.jBtnAplicar = jBtnAplicar;
    }

    public JButton getjBtnEditar() {
        return jBtnEditar;
    }

    public void setjBtnEditar(JButton jBtnEditar) {
        this.jBtnEditar = jBtnEditar;
    }

    public JButton getjBtnExcluir() {
        return jBtnExcluir;
    }

    public void setjBtnExcluir(JButton jBtnExcluir) {
        this.jBtnExcluir = jBtnExcluir;
    }

    public JButton getjBtnSair() {
        return jBtnSair;
    }

    public void setjBtnSair(JButton jBtnSair) {
        this.jBtnSair = jBtnSair;
    }

    public JTextField getjInputCEP() {
        return jInputCEP;
    }

    public void setjInputCEP(JTextField jInputCEP) {
        this.jInputCEP = jInputCEP;
    }

    public JTextField getjInputCidade() {
        return jInputCidade;
    }

    public void setjInputCidade(JTextField jInputCidade) {
        this.jInputCidade = jInputCidade;
    }

    public JTextField getjInputDoc() {
        return jInputDoc;
    }

    public void setjInputDoc(JTextField jInputDoc) {
        this.jInputDoc = jInputDoc;
    }

    public JTextField getjInputEmail() {
        return jInputEmail;
    }

    public void setjInputEmail(JTextField jInputEmail) {
        this.jInputEmail = jInputEmail;
    }

    public JComboBox<String> getjInputEstado() {
        return jInputEstado;
    }

    public void setjInputEstado(JComboBox<String> jInputEstado) {
        this.jInputEstado = jInputEstado;
    }

    public JTextField getjInputFiltro() {
        return jInputFiltro;
    }

    public void setjInputFiltro(JTextField jInputFiltro) {
        this.jInputFiltro = jInputFiltro;
    }

    public JTextField getjInputId() {
        return jInputId;
    }

    public void setjInputId(JTextField jInputId) {
        this.jInputId = jInputId;
    }

    public JTextField getjInputNome() {
        return jInputNome;
    }

    public void setjInputNome(JTextField jInputNome) {
        this.jInputNome = jInputNome;
    }

    public JTextField getjInputNum() {
        return jInputNum;
    }

    public void setjInputNum(JTextField jInputNum) {
        this.jInputNum = jInputNum;
    }

    public JTextField getjInputPais() {
        return jInputPais;
    }

    public void setjInputPais(JTextField jInputPais) {
        this.jInputPais = jInputPais;
    }

    public JTextField getjInputRua() {
        return jInputRua;
    }

    public void setjInputRua(JTextField jInputRua) {
        this.jInputRua = jInputRua;
    }

    public JTextField getjInputTelefone() {
        return jInputTelefone;
    }

    public void setjInputTelefone(JTextField jInputTelefone) {
        this.jInputTelefone = jInputTelefone;
    }

    public JLabel getjLabelDoc() {
        return jLabelDoc;
    }

    public void setjLabelDoc(JLabel jLabelDoc) {
        this.jLabelDoc = jLabelDoc;
    }

    public JRadioButton getjRadioPessoaFisica() {
        return jRadioPessoaFisica;
    }

    public void setjRadioPessoaFisica(JRadioButton jRadioPessoaFisica) {
        this.jRadioPessoaFisica = jRadioPessoaFisica;
    }

    public JRadioButton getjRadioPessoaJuridica() {
        return jRadioPessoaJuridica;
    }

    public void setjRadioPessoaJuridica(JRadioButton jRadioPessoaJuridica) {
        this.jRadioPessoaJuridica = jRadioPessoaJuridica;
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public JButton getjBtnAtualizar() {
        return jBtnAtualizar;
    }

    public void setjBtnAtualizar(JButton jBtnAtualizar) {
        this.jBtnAtualizar = jBtnAtualizar;
    }

    public JButton getjBtnCadastrar() {
        return jBtnCadastrar;
    }

    public void setjBtnCadastrar(JButton jBtnCadastrar) {
        this.jBtnCadastrar = jBtnCadastrar;
    }

    public JButton getjBtnLimpar() {
        return jBtnLimpar;
    }

    public void setjBtnLimpar(JButton jBtnLimpar) {
        this.jBtnLimpar = jBtnLimpar;
    }

}