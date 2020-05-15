package data;

import data.Usuario.Discapacidad;
import static data.Usuario.Discapacidad.*;
import data.Voluntario.Estado;
import static data.Voluntario.Estado.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utilsFicheros.FicUtls;

public class Asociacion {

    private String nom;
    private String cif;
    private File fvol = new File("src"+File.separator+"ficheros"+File.separator+"voluntarios.txt");
    private File fusr = new File("src"+File.separator+"ficheros"+File.separator+"usuarios.txt");
    
    ArrayList<Voluntario> voluntarios = new ArrayList <>();
    ArrayList<Usuario> usuarios = new ArrayList <>();
    
    public Asociacion( String nom, String cif ) throws IOException{
        this.nom = nom;
        this.cif = cif;
        deFicheroAListaVol(fvol);
        deFicheroAListaUsr(fusr);
    }
    
    /**
     * Lee el fichero de voluntarios y pasa su contenido a la lista de voluntarios
     * @param f Fichero de voluntarios
     * @throws java.io.IOException Cuando tiene problemas con el fichero de Voluntarios
     */
    public void deFicheroAListaVol(File f) throws IOException{
        FicUtls fic = new FicUtls();
        String todo = fic.leer(f);
        String[] linea = todo.split("\n");
        for (int i = 0; i < linea.length; i++) {
            String[] str = linea[i].substring( 0 , linea[i].indexOf("*") ).split(",");
            int idCue = Integer.parseInt(str[0]);
            Discapacidad disc = toDiscapacidad(str[7]);
            Estado est = toEstado(str[8]);
            voluntarios.add( new Voluntario( idCue , str[1] , str[2] , str[3] , str[4] , str[5] , this , disc , est ) );
        }
    }
    
    /**
     * Lee el fichero de usuarios y pasa su contenido a la lista de usuarios
     * @param f Fichero de ususarios
     * @throws java.io.IOException Cuando tiene problemas con el fichero de usuarios
     */
    public void deFicheroAListaUsr(File f) throws IOException {
        FicUtls fic = new FicUtls();
        String todo = fic.leer(f);
        String[] linea = todo.split("\n");
        for (int i = 0; i < linea.length; i++){
            String[] str = linea[i].substring( 0 , linea[i].indexOf("*") ).split(",");
            int idCue = Integer.parseInt(str[0]);
            int edad = Integer.parseInt(str[6]);
            Discapacidad disc = toDiscapacidad(str[8]);
            int telMov = Integer.parseInt(str[10]);
            int telFij = Integer.parseInt(str[11]);
            usuarios.add( new Usuario( idCue , str[1] , str[2] , str[3] , str[4] , str[5] ,
                                       edad , this , disc , str[10] , telMov , telFij ) );
        }
    }
    
    public void mostrarUsr(){
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }
    }
    
    /**
     * Muestra los voluntarios por consola
     */
    public void mostrarVol(){
        for (int i = 0; i < voluntarios.size(); i++) {
            System.out.println(voluntarios.get(i));
        }
    }
    
    /**
     * Muestra cada voluntario y sus acompañamientos
     */
    public void mostrarVolAcom(){
        for (int i = 0; i < voluntarios.size(); i++) {
            System.out.println(voluntarios.get(i));
            for (int j = 0; j < voluntarios.get(i).acompañamientos.size(); j++) {
               System.out.println("   "+voluntarios.get(i).acompañamientos.get(j).toString()); 
            }
        }
    }
    
    /**
     * Añade un volutario a la lista de volutarios de la asociacion
     * @param idCuenta Numero con el que se identifica la cuenta
     * @param nomCuenta Nombre la cuenta
     * @param contraseña Contraseña 
     * @param nombre Nombre del voluntario
     * @param ape1 Primer apellido
     * @param ape2 Segundo apellido
     * @param asociacion Asociación a la que pertenece
     * @param prefAcomp Preferencia de acomañameiento del voluntario
     * @param estado Estado del voluntario (disponible , ocupado)
     * @see #voluntarios
     */
    public void addVol( int idCuenta,
                       String nomCuenta,
                       String contraseña,
                       String nombre,
                       String ape1,
                       String ape2,
                       Asociacion asociacion,
                       Discapacidad prefAcomp,
                       Estado estado ) throws IOException
    {
        voluntarios.add( new Voluntario ( idCuenta , nomCuenta , contraseña , nombre , ape1 , ape2 , asociacion , prefAcomp , estado ) );
    }
    
    /**
     * Añade un volutario al fichero de volutarios de la asociacion
     * @param idCuenta Numero con el que se identifica la cuenta
     * @param nomCuenta Nombre la cuenta
     * @param contraseña Contraseña 
     * @param nombre Nombre del voluntario
     * @param ape1 Primer apellido
     * @param ape2 Segundo apellido
     * @param asociacion Asociación a la que pertenece
     * @param prefAcomp Preferencia de acomañameiento del voluntario
     * @param estado Estado del voluntario (disponible , ocupado)
     * @param f Fichero en el que se guardan los voluntarios
     * @throws java.io.IOException Cuando tiene problemas con el fichero de voluntarios
     * @see #voluntarios
     */    
    public void addVol( int idCuenta,
                       String nomCuenta,
                       String contraseña,
                       String nombre,
                       String ape1,
                       String ape2,
                       Asociacion asociacion,
                       Discapacidad prefAcomp,
                       Estado estado,
                       File f) throws IOException
    {
        voluntarios.add( new Voluntario ( idCuenta , nomCuenta , contraseña , nombre , ape1 , ape2 , asociacion , prefAcomp , estado ) );
        FicUtls fic = new FicUtls();
        char com = (char)34;// " -> comillas dobles
        String todo = idCuenta + "," +
                      com + nomCuenta + com + "," +
                      com + contraseña + com + "," +
                      com + nombre + com + "," +
                      com + ape1 + com + "," +
                      com + ape2 + com + "," +
                      asociacion.getCif() + "," +
                      prefAcomp + "," +
                      estado + "*";
        fic.añadir( todo , f);
    }
    
    /**
     * Añade un usuario a la lista de usuarios de la organización
     * @param idCuenta Numero con el que se idetifica la cuenta del usuario
     * @param nomCuenta Nombre de la cuena del usuario
     * @param contraseña Contraseña del usuario
     * @param nombre Nombre del usuario
     * @param ape1 Primer apellido del usuario
     * @param ape2 Segundo apellido del usuario
     * @param edad Edad del usuario
     * @param asociacion Asociación de la que quiere recibir el servicio el usuario
     * @param tipoDiscap Tipo de discapacidad del usuario
     * @param direccion Dirección postal de la vivienda del usuario
     * @param telMov Telefono movil del usuario
     * @param telFij Telefono fijo del usuario
     */
    public void addUsr( int idCuenta,
                   String nomCuenta,
                   String contraseña,
                   String nombre,
                   String ape1,
                   String ape2,
                   int edad,
                   Asociacion asociacion,
                   Discapacidad tipoDiscap,
                   String direccion,
                   int telMov,
                   int telFij)
    {
        usuarios.add( new Usuario ( idCuenta , nomCuenta , contraseña ,
                nombre , ape1 , ape2, edad , asociacion , tipoDiscap , direccion , telMov , telFij ) );
    }
    
    /**
     * Añade un usuario a la lista de usuarios de la organización
     * @param idCuenta Numero con el que se idetifica la cuenta del usuario
     * @param nomCuenta Nombre de la cuena del usuario
     * @param contraseña Contraseña del usuario
     * @param nombre Nombre del usuario
     * @param ape1 Primer apellido del usuario
     * @param ape2 Segundo apellido del usuario
     * @param edad Edad del usuario
     * @param asociacion Asociación de la que quiere recibir el servicio el usuario
     * @param tipoDiscap Tipo de discapacidad del usuario
     * @param direccion Dirección postal de la vivienda del usuario
     * @param telMov Telefono movil del usuario
     * @param telFij Telefono fijo del usuario
     * @param f Fichero en el que están los usuarios de la asociacion
     * @throws java.io.IOException Cuando tiene problemas con el fichero de usuarios
     */
    public void addUsr( int idCuenta,
                   String nomCuenta,
                   String contraseña,
                   String nombre,
                   String ape1,
                   String ape2,
                   int edad,
                   Asociacion asociacion,
                   Discapacidad tipoDiscap,
                   String direccion,
                   int telMov,
                   int telFij,
                   File f) throws IOException
    {
        usuarios.add( new Usuario ( idCuenta , nomCuenta , contraseña , nombre , ape1 , ape2, edad , asociacion , tipoDiscap , direccion , telMov , telFij ) );
        FicUtls fic = new FicUtls();
        char com = (char)34;// " -> comillas dobles
        String todo = idCuenta + "," +
                      com + nomCuenta + com + "," +
                      com + contraseña + com + "," +
                      com + nombre + com + "," +
                      com + ape1 + com + "," +
                      com + ape2 + com + "," +
                      edad + "," +
                      asociacion.getCif() + "," +
                      tipoDiscap + "," +
                      com + direccion + com + "," +
                      telMov + "," +
                      telFij + "*";
        fic.añadir( todo , f);
    }
        
    /**
     * Busca el nombre de la cuenta, y si existe, te devuelve el voluntario al que pertenece ese nombre
     * @param str Nombre de la cuenta a buscar
     * @return Voluntario al que pertenece el nombre de cuenta introducido
     */
    public Voluntario buscarNomCuenVolunt(String str){
        char com = (char)34;// " -> comillas dobles
        str = com+str+com;
        for (int i = 0; i < voluntarios.size(); i++) {
            if (voluntarios.get(i).getNomCuenta().equals(str)) {
                return voluntarios.get(i);
            }
        }
        JOptionPane.showMessageDialog(null,"Nombre no encontrado: " + str);
        return null;
    }
    
    /**
     * Comrueba la contraseña del Voluntario
     * @param v Voluntario del que queremos comprobar la contraseña
     * @param pass Contraseña a comprobar
     * @return Verdadero si coincide, Falso si no
     */
    public boolean checkPassVol(Voluntario v , String pass){
        char com = (char)34;// " -> comillas dobles
        pass = com+pass+com;
        if ( v == null || pass == null) {
            JOptionPane.showMessageDialog(null, "Rellena todos los campos");
            return false;
        }
        if (v.getContraseña().equals(pass)) {
            return true;
        }
        return false;
    }
    
    public Usuario buscarNomCuenUser(String nom) {
        char com = (char)34;// " -> comillas dobles
        nom = com+nom+com;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNomCuenta().equals(nom)) {
                return usuarios.get(i);
            }
        }
        JOptionPane.showMessageDialog(null,"Nombre no encontrado: " + nom);
        return null;
    }

    public boolean checkPassUer(Usuario usr, String pass) {
        char com = (char)34;// " -> comillas dobles
        pass = com+pass+com;
        if ( usr == null || pass == null) {
            JOptionPane.showMessageDialog(null, "Rellena todos los campos");
            return false;
        }
        if (usr.getContraseña().equals(pass)) {
            return true;
        }
        return false;
    }
    
    /**
     * Muestra por consola los voluntarios
     */
    public void showVolunt (){
        for (Voluntario voluntario : voluntarios) {
            System.out.println( voluntario );
        }
    }
    
    /**
     * Muestra por consola los Voluntarios y sus acompañamientos
     */
    public void showAcomVolunt (){
        for (int i = 0; i < voluntarios.size(); i++) {
            System.out.println( voluntarios.get(i).getNombre() );
            for (int j = 0; j < voluntarios.get(i).acompañamientos.size(); j++) {
                System.out.println("  - "+voluntarios.get(i).getAcom(j));
            }
        }
    }
    
    /**
     * Muestra los usuarios por consola
     */
    public void showUsuarios (){
        for (Usuario usuario : usuarios) {
            System.out.println( usuario );
        }
    }

    @Override
    public String toString() {
        return "Asociacion{" + "nom=" + nom + ", cif=" + cif + '}';
    }
    
    /**
     * Pasa la asociacion el formato en el que guardamos las clases
     * @param separador Caracter separador que se quiere usar
     * @param fin Caracter que se usa para indicar el fin de una linea
     * @return Cadena formateada para introducir en fichero
     */
    public String toStringFichero(String separador , String fin){
        char com = (char)34;
        return com + this.nom + com + separador + com + this.cif + com + fin;
    }

    public String getNom() {
        return nom;
    }

    public String getCif() {
        return cif;
    }

    /**
     * Pasa una string a enumerado de discapadicad
     * @param string Texto a comparar
     * @return la discapacidad
     */
    public Discapacidad toDiscapacidad(String string) {
        string = string.toLowerCase();
        switch(string){
            case "fisica":
                return fisica;
            case "sensorial":
                return sensorial;
            case "intelectual":
                return intelectual;
            case "multiple":
                return multiple;
            case "otras":
                return otras;
            default: System.out.println("Discapacidad no válida (" + string + ")");
        }
        return null;
    }

    /**
     * Pasa a estado una cadena introducida, en caso de que esta no coincida con ninguno de los estados, devoverá null
     */
    private Estado toEstado(String string) {
        string = string.trim().toLowerCase();
        switch(string){
            case "disponible":
                return disponible;
            case "ocupado":
                return ocupado;
            default: System.out.println("Estado no válido");;
        }
        return null;
    } 
    
}
