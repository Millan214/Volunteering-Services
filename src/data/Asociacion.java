package data;

import data.Usuario.Discapacidad;
import data.Voluntario.Estado;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import utilsFicheros.FicUtls;

public class Asociacion {

    private String nom;
    private String cif;
    
    ArrayList<Voluntario> voluntarios = new ArrayList <>();
    ArrayList<Usuario> usuarios = new ArrayList <>();
    
    public Asociacion( String nom, String cif ){
        this.nom = nom;
        this.cif = cif;
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
        fic.añadir(asociacion.voluntarios.get( voluntarios.size()-1 ).toStringFichero(",","*"), f);
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

    public String getNom() {
        return nom;
    }

    public String getCif() {
        return cif;
    }
        
}
