package gui;

import data.Asociacion;
import data.Usuario;
import static data.Usuario.Discapacidad.intelectual;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utilsFicheros.FicUtls;

public class VenModificarUsr extends JFrame{
    
    private VenPpalUsr vpu;
    private FicUtls fic = new FicUtls();
    private Usuario usr;
    private Usuario dummyusr;
    private File f;
    private String linea;
    private ArrayList<Asociacion> asociaciones;
    
    public VenModificarUsr(Usuario usr, ArrayList<Asociacion> as , File f) throws IOException {
        this.asociaciones = as;
        this.f=f;
        this.dummyusr = new Usuario(44444,"Millan214","noteladigo","Millan","Martinez","Arconada",18,new Asociacion("d","d"),intelectual,"micasas",3123,55555);
        this.usr = usr;
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana Modificar Usuario");
        this.setResizable(false);
        if (usr == null) {
            linea = dummyusr.toString();
        }else{
            linea = fic.buscarEnLinea(usr.getIdCuenta()+"", f);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        campoIdCuenta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        botonCambiar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        campoNomCuenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        campoContraseña = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        campoApe1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        campoApe2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        campoEdad = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        campoDiscapacidad = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        campoDireccion = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        campoTelMov = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        campoTelFij = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(248, 240, 246));
        jPanel2.setForeground(new java.awt.Color(242, 226, 239));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        jLabel5.setText("VENTANA MODIFICAR USUARIO");

        botonSalir.setBackground(new java.awt.Color(240, 230, 216));
        botonSalir.setForeground(new java.awt.Color(0, 0, 0));
        botonSalir.setText("SALIR");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        campoIdCuenta.setBackground(new java.awt.Color(216, 225, 240));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("ID CUENTA:");

        botonCambiar.setBackground(new java.awt.Color(240, 230, 216));
        botonCambiar.setText("CAMBIAR");
        botonCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botonCambiarActionPerformed(evt);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("NOM CUENTA:");

        campoNomCuenta.setBackground(new java.awt.Color(216, 225, 240));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("CONTRASEÑA:");

        campoContraseña.setBackground(new java.awt.Color(216, 225, 240));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("NOMBRE:");

        campoNombre.setBackground(new java.awt.Color(216, 225, 240));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("APE1;");

        campoApe1.setBackground(new java.awt.Color(216, 225, 240));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("APE2;");

        campoApe2.setBackground(new java.awt.Color(216, 225, 240));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("EDAD:");

        campoEdad.setBackground(new java.awt.Color(216, 225, 240));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("DISCAPACIDAD:");

        campoDiscapacidad.setBackground(new java.awt.Color(216, 225, 240));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("DIRECCIÓN:");

        campoDireccion.setBackground(new java.awt.Color(216, 225, 240));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("TELÉFONO MOVIL:");

        campoTelMov.setBackground(new java.awt.Color(216, 225, 240));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("TELÉFONO FIJO:");

        campoTelFij.setBackground(new java.awt.Color(216, 225, 240));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoIdCuenta)
                                    .addComponent(campoNomCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(campoContraseña)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTelFij, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoTelMov, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel15)
                                .addComponent(jLabel14)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoApe1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoApe2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoDiscapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel19)))
                .addGap(0, 71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(campoIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(campoNomCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(campoApe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(campoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(campoApe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(campoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(campoDiscapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(7, 7, 7)
                .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(campoTelMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTelFij, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonSalir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonCambiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.setVisible(false);
        vpu = new VenPpalUsr(usr,asociaciones);
        vpu.setVisible(true);
    }     
    
    private void botonCambiarActionPerformed(java.awt.event.ActionEvent evt) throws IOException {  
        String idCuen = campoIdCuenta.getText();
        String nomCuen = campoNomCuenta.getText();
        String contra = campoContraseña.getText();
        String nombre = campoNombre.getText();
        String ape1 = campoApe1.getText();
        String ape2 = campoApe2.getText();
        String edad = campoEdad.getText();
        String discap = campoDiscapacidad.getText();
        String direccion = campoDireccion.getText();
        String telMov = campoTelMov.getText();
        String telFij = campoTelFij.getText();
        
        if (!idCuen.equals("")) {
            modIdCuen(idCuen);
        }
        if (!nomCuen.equals("")) {
            modNomCuen(nomCuen);
        }
        if (!contra.equals("")) {
            modContra(contra);
        }
        if (!nombre.equals("")) {
            modNombre(nombre);
        }
        if (!ape1.equals("")) {
            modApe1(ape1);
        }
        if (!ape2.equals("")) {
            modApe2(ape2);
        }
        if (!edad.equals("")) {
            modEdad(edad);
        }
        if (!discap.equals("")) {
            modDiscap(discap);
        }
        if (!direccion.equals("")) {
            modDireccion(direccion);
        }      
        if (!telMov.equals("")) {
            modTelMov(telMov);
        }
        if (!telFij.equals("")) {
            modTelFij(telFij);
        }
        
        JOptionPane.showMessageDialog(null, "Modificado correctamente");
        JOptionPane.showMessageDialog(null, "Reinicia la aplicación para aplicar los cambios");
        
    }    
    
    /**
     * Cambia un id de cuenta por otro en el fichero
     * @param idCuen Nuevo Identificador de la cuenta
     * @throws IOException
     */
    private void modIdCuen(String idCuen) throws IOException {
        
        if (checkId(idCuen)) {
            
            String[] str =linea.split(",");
            fic.eliminar(linea, f);
            linea = "";
            for (int i = 0; i < str.length; i++) {
                if (i==0) {
                    linea = linea + idCuen + ",";
                }else{
                    if (i==str.length-1) {
                        linea = linea + str[i];
                    }else{
                        linea = linea + str[i] + ",";
                    }
                }
            }
            fic.añadir(linea, f);        
        }
    }
    
    /**
     * Modifica el nombre de la cuenta de un usuario
     * @param nomCuen Nuevo nombre de la cuenta
     * @throws IOException
     */
    private void modNomCuen(String nomCuen) throws IOException {
        char com = (char)34;// " -> comillas dobles
        nomCuen = com + nomCuen + com;
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==1) {
                linea = linea + nomCuen + ",";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);           
    }
    
    /**
     * Modifica la contraseña de la cuenta de un usuario
     * @param nomCuen Nueva contraseña de la cuenta
     * @throws IOException
     */
    private void modContra(String contra) throws IOException {
        char com = (char)34;// " -> comillas dobles
        contra = com + contra + com;
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==2) {
                linea = linea + contra + ",";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);           
    }
    
     /**
     * Modifica el nombre de la cuenta de un usuario
     * @param nomCuen Nuevo nombre de la cuenta
     * @throws IOException
     */
    private void modNombre(String nombre) throws IOException {
        char com = (char)34;// " -> comillas dobles
        nombre = com + nombre + com;
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==3) {
                linea = linea + nombre + ",";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);           
    }
    
         /**
     * Modifica el nombre de la cuenta de un usuario
     * @param nomCuen Nuevo nombre de la cuenta
     * @throws IOException
     */
    private void modApe1(String ape1) throws IOException {
        char com = (char)34;// " -> comillas dobles
        ape1 = com + ape1 + com;
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==4) {
                linea = linea + ape1 + ",";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);           
    }
    
    private void modApe2(String ape2) throws IOException {
        char com = (char)34;// " -> comillas dobles
        ape2 = com + ape2 + com;
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==5) {
                linea = linea + ape2 + ",";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);   
    }
    
    private void modEdad(String edad) throws IOException {
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==6) {
                linea = linea + edad + ",";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);           
    }         

    private void modDiscap(String discap) throws IOException {
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==8) {
                linea = linea + discap + ",";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);    
    }

    private void modDireccion(String direccion) throws IOException {
        char com = (char)34;// " -> comillas dobles
        direccion = com + direccion + com;
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==9) {
                linea = linea + direccion + ",";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);  
    }

    private void modTelMov(String telMov) throws IOException {
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==10) {
                linea = linea + telMov + ",";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);  
    }

    private void modTelFij(String telFij) throws IOException {
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==11) {
                linea = linea + telFij + "*";
            }else{
                if (i==str.length-1) {
                    linea = linea + str[i];
                }else{
                    linea = linea + str[i] + ",";
                }
            }
        }
        fic.añadir(linea, f);  
    }
    
    private boolean checkId(String idCuen) throws IOException {
        String todo = fic.leer(f);
        String[] linea = todo.split("\n");
        String[] id = new String[linea.length];
        for (int i = 0; i < id.length; i++) {
            id[i] = linea[i].substring(0,linea[i].indexOf(","));
            if ( id[i].equals(idCuen) ) {
                return true;
            }
        }
        return false;
    }
     
    // Variables declaration - do not modify                     
    private javax.swing.JButton botonCambiar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField campoApe1;
    private javax.swing.JTextField campoApe2;
    private javax.swing.JPasswordField campoContraseña;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoDiscapacidad;
    private javax.swing.JTextField campoEdad;
    private javax.swing.JTextField campoIdCuenta;
    private javax.swing.JTextField campoNomCuenta;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelFij;
    private javax.swing.JTextField campoTelMov;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration  

}
