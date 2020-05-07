package data;

import data.Usuario.Discapacidad;
import static data.Usuario.Discapacidad.fisica;
import static data.Usuario.Discapacidad.intelectual;
import static data.Usuario.Discapacidad.multiple;
import static data.Usuario.Discapacidad.otras;
import static data.Usuario.Discapacidad.sensorial;
import data.Voluntario.Estado;
import static data.Voluntario.Estado.disponible;
import static data.Voluntario.Estado.ocupado;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    public void showVolunt (){
        for (Voluntario voluntario : voluntarios) {
            System.out.println( voluntario );
        }
    }
    
    public void showAcomVolunt (){
        for (int i = 0; i < voluntarios.size(); i++) {
            System.out.println( voluntarios.get(i).getNombre() );
            for (int j = 0; j < voluntarios.get(i).acompañamientos.size(); j++) {
                System.out.println("  - "+voluntarios.get(i).getAcom(j));
            }
        }
    }
    
    public void showUsuarios (){
        for (Usuario usuario : usuarios) {
            System.out.println( usuario );
        }
    }

    @Override
    public String toString() {
        return "Asociacion{" + "nom=" + nom + ", cif=" + cif + '}';
    }
    
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

    private Discapacidad toDiscapacidad(String string) {
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
