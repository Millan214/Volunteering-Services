package data;

import data.Acompañamiento.EstadoAcom;
import static data.Acompañamiento.EstadoAcom.en_curso;
import static data.Acompañamiento.EstadoAcom.terminado;
import data.Usuario.Discapacidad;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import utilsFicheros.FicUtls;

public class Voluntario extends Cuenta{

    private Discapacidad prefAcomp;
    private Estado estado;
    
    public enum Estado{ disponible , ocupado };
    
    ArrayList<Acompañamiento> acompañamientos = new ArrayList <>();
    File facom = new File("src\\bd\\acompañamientos.txt");
    
    public Voluntario( int idCuenta,
                       String nomCuenta,
                       String contraseña,
                       String nombre,
                       String ape1,
                       String ape2,
                       Asociacion asociacion,
                       Discapacidad prefAcomp,
                       Estado estado ) throws IOException
    {
        super(idCuenta, nomCuenta, contraseña, nombre, ape1, ape2, asociacion);
        this.estado = estado;
        this.prefAcomp  = prefAcomp;
        deFicheroAListaAcom(facom);
    }
    
    private void deFicheroAListaAcom(File f) throws IOException {
        FicUtls fic = new FicUtls();
        String todo = fic.leer(f);
        String[] linea = todo.split("\n");
//        for (int i = 0; i < linea.length; i++) {
           String[] str = linea[0].split(">");//<<<
           if ( str[0].equals( this.getIdCuenta()+"" ) ) { //el this.getIdCuenta()+"" pasa de int a String para que se puedan comparar
               str[1] = str[1].substring( 0 , str[1].indexOf("*") );
               String[] partes = str[1].split(",");
               int id = Integer.parseInt(partes[0]);
               EstadoAcom esta = toEstadoAcom(partes[1]);
               acompañamientos.add( new Acompañamiento( id , esta ) );
           }
//        }
    }
    
    private EstadoAcom toEstadoAcom(String parte) {
        parte = parte.toLowerCase();
        switch(parte){
            case "en_curso":
                return en_curso;
            case "terminado":
                return terminado;
            default: System.out.println("Eso no es un estado del acompañamiento");;
        }
        return null;
    }
    
    public void addAcom( int id , EstadoAcom estado){
        this.acompañamientos.add( new Acompañamiento( id , estado ) );
    }
    
    public void addAcom( int id , EstadoAcom estado , File facom) throws IOException{
        acompañamientos.add( new Acompañamiento( id , estado ) );
        FicUtls fic = new FicUtls();
        fic.añadir(acompañamientos.get( acompañamientos.size()-1 ).toStringFichero( this.getIdCuenta() ,",","*"), facom);
    }
    
    public Acompañamiento getAcom(int i){
        return this.acompañamientos.get(i);
    }

    @Override
    public String toString() {
        return "Voluntario{" + "idCuenta=" + super.getIdCuenta() +
                             ", nomCuenta=" + super.getNomCuenta() +
                             ", contrase\u00f1a=" + super.getContraseña() +
                             ", nombre=" + super.getNombre() +
                             ", ape1=" + super.getApe1() +
                             ", ape2=" + super.getApe2() + 
                             ", asociacion="+this.getCifAsociacion() +
                             ", prefAcomp="+this.getPrefAcomp() +
                             ", estado="+this.getEstado()+'}';
    }
    
    public String getCifAsociacion(){
        return asociacion.getCif();
    }

    public Discapacidad getPrefAcomp() {
        return prefAcomp;
    }

    public Estado getEstado() {
        return estado;
    }

}
