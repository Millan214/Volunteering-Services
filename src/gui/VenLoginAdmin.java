package gui;

import data.Asociacion;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VenLoginAdmin extends JFrame{
    
   private VenPpalAdmin vpa; 
   private Asociacion as;
   private ArrayList<Asociacion> asociaciones;
   private final String PASSWORD = "@dmin";
   
    public VenLoginAdmin(ArrayList<Asociacion> as) {
        this.asociaciones = as;
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana de selección de organización para el Administrador");
        this.setResizable(false);
    }
    
    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {
        String cif = this.campoCif.getText();
        String nombre = this.campoNombre.getText();
        String pass = this.campoPasswd.getText();
        
        if (checkLogin( cif , nombre , pass )) {
           this.setVisible(false);
            vpa = new VenPpalAdmin(this.as,this.asociaciones);
            vpa.setVisible(true); 
        }
        
    }    

    /**
     * Comprueba que la asociación existen y que la contraseña del admin es la correcta
     * @param cif Cif introducido por el usuario
     * @param nombre Nombre introducido por el usuario
     * @param pass Contraseña del admin
     * @return true si la asociación es correcta
     */
    private boolean checkLogin(String cif, String nombre, String pass) {
        char com = (char)34;// " -> comillas dobles
        String[] cifAsoc = new String[asociaciones.size()];
        String[] nomAsoc = new String[asociaciones.size()];
        for (int i = 0; i < asociaciones.size(); i++) {
            cifAsoc[i] = asociaciones.get(i).getCif();
            nomAsoc[i] = asociaciones.get(i).getNom();
            
            //Tengo que ponerle las comillas por como se guarda en el fichero :)
            cif = com+cif+com;
            nombre = com+nombre+com;
            
            if (cifAsoc[i].equals(cif)) {
                if (nomAsoc[i].equals(nombre)) {
                    if (pass.equals(PASSWORD)) {
                        this.as = getAsoc( cif );
                        return true;                        
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Login erroneo");
        return false;
    }
    
    private Asociacion getAsoc(String cif) {
        for (int i = 0; i < asociaciones.size(); i++) {
            if (asociaciones.get(i).getCif().equals(cif)) {
                return asociaciones.get(i);
            }
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoCif = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoPasswd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(248, 240, 246));
        jPanel2.setForeground(new java.awt.Color(242, 226, 239));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        jLabel5.setText("¿QUE ORGANIZACIÓN ADMINISTRAS?");

        botonEnviar.setBackground(new java.awt.Color(240, 230, 216));
        botonEnviar.setForeground(new java.awt.Color(0, 0, 0));
        botonEnviar.setText("ENVIAR");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        jLabel6.setText("CIF:");

        campoCif.setBackground(new java.awt.Color(227, 226, 244));
        campoCif.setForeground(new java.awt.Color(0, 0, 0));
        

        jLabel7.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        jLabel7.setText("NOMBRE:");

        campoNombre.setBackground(new java.awt.Color(227, 226, 244));
        campoNombre.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        jLabel8.setText("PASSWORD:");

        campoPasswd.setBackground(new java.awt.Color(227, 226, 244));
        campoPasswd.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCif, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campoCif, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(campoPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(578, Short.MAX_VALUE))
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
 
    // Variables declaration - do not modify                     
    private javax.swing.JButton botonEnviar;
    private javax.swing.JTextField campoCif;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPasswd;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration      

}
