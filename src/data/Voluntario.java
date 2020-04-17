package data;

import data.Acompañamiento.EstadoAcom;
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
    
    public Voluntario( int idCuenta,
                       String nomCuenta,
                       String contraseña,
                       String nombre,
                       String ape1,
                       String ape2,
                       Asociacion asociacion,
                       Discapacidad prefAcomp,
                       Estado estado )
    {
        super(idCuenta, nomCuenta, contraseña, nombre, ape1, ape2, asociacion);
        this.estado = estado;
        this.prefAcomp  = prefAcomp;
    }
    
    public void addAcom( int id , EstadoAcom estado){
        this.acompañamientos.add( new Acompañamiento( id , estado ) );
        FicUtls fic = new FicUtls();
    }
    
    public void addAcom( int id , EstadoAcom estado , File facom) throws IOException{
        this.acompañamientos.add( new Acompañamiento( id , estado ) );
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
