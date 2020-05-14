package data;

import data.Acompañamiento.estadoAcom;
import static data.Acompañamiento.estadoAcom.en_curso;
import static data.Acompañamiento.estadoAcom.terminado;
import data.Acompañamiento.tipoAcom;
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
    File facom = new File("src"+File.separator+"ficheros"+File.separator+"acompañamientos.txt");
    
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
    
    /**
     * Lee el fichero de acompañamientos y lo pasa a la lista de acompañamientos
     */
    private void deFicheroAListaAcom(File f) throws IOException {
        FicUtls fic = new FicUtls();
        String todo = fic.leer(f);
        String[] linea = todo.split("\n");
        for (int i = 0; i < linea.length; i++) {
           String[] str = linea[i].split(">");
           if ( str[0].equals( this.getIdCuenta()+"" ) ) { //el this.getIdCuenta()+"" pasa de int a String para que se puedan comparar
               str[1] = str[1].substring( 0 , str[1].indexOf("*") );
               String[] partes = str[1].split(",");
               int id = Integer.parseInt(partes[0]);
               estadoAcom esta = toEstadoAcom(partes[1]);
               tipoAcom tip = toTipoAcom(partes[2]);
               acompañamientos.add( new Acompañamiento( id , esta , tip ) );
           }
        }
    }
    
    /**
     * Pasa una string a estado de acompañameinto, en caso de que no sea un estado de acompañameinto, devolvera null
     */
    private estadoAcom toEstadoAcom(String parte) {
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
    
    /**
     * Pasa a tipo de acompañamiento
     */
    private tipoAcom toTipoAcom(String parte) {
        parte = parte.toLowerCase();
        switch(parte){
            case "paseo":
                return data.Acompañamiento.tipoAcom.paseo;
            case "visitas_medicas":
                return data.Acompañamiento.tipoAcom.visitas_medicas;
            case "visitas_culturales":
                return data.Acompañamiento.tipoAcom.visitas_culturales;
            case "otros":
                return data.Acompañamiento.tipoAcom.otros;
            default: System.out.println("Esto no es un tipo de acompañamiento");
        }
        return null;
    }
    
    /**
     * Añade un acompañamiento a un voluntario, pero solo a la lista, no al fichero
     * @param id Identificador del estado
     * @param estado Estado del acompañamiento
     * @param tip Tipo de acompañamiento
     */
    public void addAcom( int id , estadoAcom estado , tipoAcom tip){
        this.acompañamientos.add( new Acompañamiento( id , estado , tip ) );
    }
    
    /**
     * Añade un acompañamiento a un voluntario, pero solo a la lista, no al fichero
     * @param id Identificador del estado
     * @param estado Estado del acompañamiento
     * @param tip Tipo de acompañamiento
     * @param facom Fichero en el que etan los acompañamientos
     * @throws java.io.IOException
     */    
    public void addAcom( int id , estadoAcom estado ,tipoAcom tip, File facom) throws IOException{
        acompañamientos.add( new Acompañamiento( id , estado , tip) );
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
