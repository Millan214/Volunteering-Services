package gui;

import data.Asociacion;
import static data.Usuario.Discapacidad.fisica;
import data.Voluntario;
import static data.Voluntario.Estado.disponible;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utilsFicheros.FicUtls;

public class VenModificarVol extends JFrame{
    
    private FicUtls fic = new FicUtls();
    private File f;
    private VenPpalVol vpv;
    private Voluntario vol;
    private String linea;
    private ArrayList<Asociacion> asociaciones;
    private File facom = new File("src"+File.separator+"ficheros"+File.separator+"acompañamientos.txt");    
    //El dummy es para pruebas
    private Voluntario voldummy = new Voluntario(1,"dummy","123","dummy","dummez","payaso",new Asociacion("d","d"),fisica,disponible);
    
    public VenModificarVol(Voluntario vol , ArrayList<Asociacion> as) throws IOException {
        this.asociaciones = as;
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana modificar voluntario");
        this.setResizable(false);
    }
    
    /**
     * Ventana modificar voluntario
     * @author Millan
     * @param vol El voluntario a modificar
     * @param f Fichero de voluntarios
     * @throws java.io.IOException
     * @see #fic.buscarEnLinea(String , File);
     */
    public VenModificarVol(Voluntario vol , File f) throws IOException {
        initComponents();
        this.vol = vol;
        this.f = f;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana modificar voluntario");
        linea = fic.buscarEnLinea(vol.getIdCuenta()+"", f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        campoIdCuenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoNomCuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoPasswd = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoApe1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoApe2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoCifAsoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        desplegableDiscap = new javax.swing.JComboBox<>();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(248, 240, 246));
        jPanel2.setForeground(new java.awt.Color(242, 226, 239));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        jLabel5.setText("MODIFICAR VOLUNTARIO");

        botonSalir.setBackground(new java.awt.Color(240, 230, 216));
        botonSalir.setForeground(new java.awt.Color(0, 0, 0));
        botonSalir.setText("SALIR");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        campoIdCuenta.setBackground(new java.awt.Color(227, 226, 244));
        campoIdCuenta.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ID Cuenta:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("NomCuenta:");

        campoNomCuenta.setBackground(new java.awt.Color(227, 226, 244));
        campoNomCuenta.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Passwd:");

        campoPasswd.setBackground(new java.awt.Color(227, 226, 244));
        campoPasswd.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Nombre:");

        campoNombre.setBackground(new java.awt.Color(227, 226, 244));
        campoNombre.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("1er Ape:");

        campoApe1.setBackground(new java.awt.Color(227, 226, 244));
        campoApe1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("2do Ape:");

        campoApe2.setBackground(new java.awt.Color(227, 226, 244));
        campoApe2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Cif Asoc:");

        campoCifAsoc.setBackground(new java.awt.Color(227, 226, 244));
        campoCifAsoc.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Discapacidad:");

        desplegableDiscap.setBackground(new java.awt.Color(227, 226, 244));
        desplegableDiscap.setForeground(new java.awt.Color(0, 0, 0));
        desplegableDiscap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "fisica", "sensorial", "intelectual", "multiple", "otras" }));

        botonAceptar.setBackground(new java.awt.Color(240, 230, 216));
        botonAceptar.setForeground(new java.awt.Color(0, 0, 0));
        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botonAceptarActionPerformed(evt);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(campoIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(campoPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(campoApe1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoApe2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNomCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(campoCifAsoc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desplegableDiscap, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNomCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoApe1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoApe2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCifAsoc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desplegableDiscap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir)
                    .addComponent(botonAceptar))
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
        vpv = new VenPpalVol(vol,asociaciones);
        vpv.setVisible(true);
    }                                          

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                             
        String idCuen = campoIdCuenta.getText();
        String nomCuen = campoNomCuenta.getText();
        String passwd = campoPasswd.getText();
        String nom = campoNombre.getText();
        String ape1 = campoApe1.getText();
        String ape2 = campoApe2.getText();
        String cifAsoc = campoCifAsoc.getText();
        String discap = desplegableDiscap.getSelectedItem().toString();
        
        if (!idCuen.equals("")) {
            modIdCuen(idCuen);
        }
        if (!nomCuen.equals("")) {
            modNomCuen(nomCuen);
        }
        if (!passwd.equals("")) {
            modPasswd(passwd);
        }
        if (!nom.equals("")) {
            modNom(nom);
        }
        if (!ape1.equals("")) {
            modApe1(ape1);
        }
        if (!ape2.equals("")) {
            modApe2(ape2);
        }
        if (!cifAsoc.equals("")) {
            modCifAsoc(cifAsoc);
        }
        if (!discap.equals("")) {
            modDiscap(discap);
        }
        
        JOptionPane.showMessageDialog(null, "Modificado correctamente");
        
    }
    
    /**
     * @author Millán
     * Modifica un id de cuenta.
     * Elimina la linea que coincide con el id antiguo
     * y añade al final otra linea igual pero con el id actualizado
     * @param idCuen Nuevo id de cuenta del voluntario
     * @see #checkId(java.lang.String) 
     * @throws IOException
     */
    private void modIdCuen(String idCuen) throws IOException {
        if (!checkId(idCuen)) {
            String lineaOld = linea;
            fic.eliminar(lineaOld, f);
            linea = idCuen + linea.substring( linea.indexOf(",") , linea.length() );
            fic.añadir(linea, f); 
            System.out.println("Linea en voluntarios.txt --> "+linea);

            //Modificar también el id del acompañamiento
            String idVol = vol.getIdCuenta()+"";
            String todo = fic.leer(facom);
            String[] linac = todo.split("\n");
            String[] idAcom = new String[linac.length];
            for (int i = 0; i < linac.length; i++) {
                idAcom[i] = linac[i].substring( 0 , linac[i].indexOf(">") );
                System.out.println("idAcom: "+idAcom[i]);
                if (idAcom[i].equals(idVol)) {
                    String lin = idCuen + linac[i].substring( linac[i].indexOf(">") );
                    fic.eliminar(linac[i], facom);
                    fic.añadir(lin, facom);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Esta id ya existe");
        }
    }

    /**
     * @author Millán
     * Modifica el nombre de cuenta
     * Elimina la linea que coincide con el nombre de cuenta antigua
     * y añade al final otra linea igual pero con el nombre actualizado
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
     * @author Millán
     * Modifica la contraseña
     * Elimina la linea que coincide con la contraseña antigua
     * y añade al final otra linea igual pero con la contraseña actualizada
     * @param passwd Nueva contraseña
     * @throws IOException
     */
    private void modPasswd(String passwd) throws IOException {
        char com = (char)34;// " -> comillas dobles
        passwd = com + passwd + com;
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==2) {
                linea = linea + passwd + ",";
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
     * @author Millán
     * Modifica el nombre del Voluntario
     * Elimina la linea que coincide con el nombre antiguo
     * y añade al final otra linea igual pero con el nombre actualizado
     * @param nom Nuevo nombre
     * @throws IOException
     */
    private void modNom(String nom) throws IOException {
        char com = (char)34;// " -> comillas dobles
        nom = com + nom + com;
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==3) {
                linea = linea + nom + ",";
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
     * @author Millán
     * Modifica el primer apellido del Voluntario
     * Elimina la linea que coincide con el primer apellido antiguo
     * y añade al final otra linea igual pero con el primer apellido actualizado
     * @param ape1 Nuevo primer apellido
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

    /**
     * @author Millán
     * Modifica el segundo apellido del Voluntario
     * Elimina la linea que coincide con el segundo apellido antiguo
     * y añade al final otra linea igual pero con el segundo apellido actualizado
     * @param ape2 Nuevo segundo apellido
     * @throws IOException
     */    
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

    /**
     * @author Millán
     * Modifica el cif de la asociación del Voluntario
     * Elimina la linea que coincide con el cif de la asociación antiguo
     * y añade al final otra linea igual pero con el cif de la asociación actualizado
     * @param cifAsoc Nueva asociación
     * @throws IOException
     */    
    private void modCifAsoc(String cifAsoc) throws IOException {
        char com = (char)34;// " -> comillas dobles
        cifAsoc = com + cifAsoc + com;
        String[] str =linea.split(",");
        
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==6) {
                linea = linea + cifAsoc + ",";
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
     * @author Millán
     * Modifica el cif de la preferncia de acompañamiento de discapacidad del Voluntario
     * Elimina la linea que coincide con la preferencia antigua
     * y añade al final otra linea igual pero con la preferencia actualizada
     * @param discap Nueva preferncia de discapacidad
     * @throws IOException
     */     
    private void modDiscap(String discap) throws IOException {
        String[] str =linea.split(",");
        fic.eliminar(linea, f);
        linea = "";
        for (int i = 0; i < str.length; i++) {
            if (i==7) {
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
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField campoApe1;
    private javax.swing.JTextField campoApe2;
    private javax.swing.JTextField campoCifAsoc;
    private javax.swing.JTextField campoIdCuenta;
    private javax.swing.JTextField campoNomCuenta;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JPasswordField campoPasswd;
    private javax.swing.JComboBox<String> desplegableDiscap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration  

    /**
     * Comprueba si un id está repetido
     * @param idCuen El id de cuenta a cambiar
     * @throws IOException
     */
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
    
}
