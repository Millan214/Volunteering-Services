package gui;

import data.Asociacion;
import java.util.ArrayList;
import javax.swing.JFrame;

public class VenOpcUsr extends javax.swing.JFrame{
    
    VenLoginAdmin vla;
    VenLoginUsr vlu;
    VenLoginVol vlv;
    ArrayList<Asociacion> asociaciones;
    
    public VenOpcUsr(ArrayList<Asociacion> as) {
        this.asociaciones = as;
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana de selección de usuario");
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botonUsr = new javax.swing.JButton();
        botonVoluntario = new javax.swing.JButton();
        botonAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(248, 240, 246));
        jPanel2.setForeground(new java.awt.Color(242, 226, 239));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setFont(new java.awt.Font("Dubai Light", 1, 36)); // NOI18N
        jLabel5.setText("¿QUIEN ERES?");

        botonUsr.setBackground(new java.awt.Color(227, 226, 244));
        botonUsr.setForeground(new java.awt.Color(0, 0, 0));
        botonUsr.setText("USUARIO");
        botonUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUsrActionPerformed(evt);
            }
        });

        botonVoluntario.setBackground(new java.awt.Color(227, 226, 244));
        botonVoluntario.setForeground(new java.awt.Color(0, 0, 0));
        botonVoluntario.setText("VOLUNTARIO");
        botonVoluntario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVoluntarioActionPerformed(evt);
            }
        });

        botonAdmin.setBackground(new java.awt.Color(227, 226, 244));
        botonAdmin.setForeground(new java.awt.Color(0, 0, 0));
        botonAdmin.setText("ADMINISTRADOR");
        botonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(botonUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(botonVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel5)))
                .addGap(0, 74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 608, Short.MAX_VALUE)
                .addComponent(botonAdmin)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void botonAdminActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        vla = new VenLoginAdmin();
        vla.setVisible(true);
    }                                          

    private void botonVoluntarioActionPerformed(java.awt.event.ActionEvent evt) {      
        this.setVisible(false);
        vlv = new VenLoginVol(asociaciones);
        vlv.setVisible(true);
    }                                               

    private void botonUsrActionPerformed(java.awt.event.ActionEvent evt) {          
        this.setVisible(false);
        vlu = new VenLoginUsr(asociaciones);
        vlu.setVisible(true);
    }                                        
 
    // Variables declaration - do not modify                     
    private javax.swing.JButton botonAdmin;
    private javax.swing.JButton botonUsr;
    private javax.swing.JButton botonVoluntario;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration            
}
