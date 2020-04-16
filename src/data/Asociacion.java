package data;

import data.Usuario.Discapacidad;
import static data.Usuario.Discapacidad.fisica;
import static data.Usuario.Discapacidad.intelecutal;
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
import utilsFicheros.FicUtls;

public class Asociacion {

    private String nom;
    private String cif;
    private File fvol = new File("src\\bd\\voluntarios.txt");
    private File fusr = new File("src\\bd\\usuarios.txt");
    
    ArrayList<Voluntario> voluntarios = new ArrayList <>();
    ArrayList<Usuario> usuarios = new ArrayList <>();
    
    public Asociacion( String nom, String cif ) throws IOException{
        this.nom = nom;
        this.cif = cif;
        deFicheroAListaVol(fvol);
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
            if( str[6].equals(this.cif) ){
                voluntarios.add( new Voluntario( idCue , str[1] , str[2] , str[3] , str[4] , str[5] , this , disc , est ) );
            }
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
                       Estado estado )
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
        fic.añadir(voluntarios.get( voluntarios.size()-1 ).toStringFichero(",","*"), f);
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
        usuarios.add( new Usuario ( idCuenta , nomCuenta , contraseña ,
                nombre , ape1 , ape2, edad , asociacion , tipoDiscap , direccion , telMov , telFij ) );
        FicUtls fic = new FicUtls();
        fic.añadir( usuarios.get( usuarios.size()-1 ).toStringFichero(",", "*") , f);
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
        switch(string){
            case "fisica":
                return fisica;
            case "sensorial":
                return sensorial;
            case "intelectual":
                return intelecutal;
            case "multiple":
                return multiple;
            case "otras":
                return otras;
            default: System.out.println("Discapacidad no válida");
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
