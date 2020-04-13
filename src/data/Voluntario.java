package data;

import java.util.ArrayList;

public class Voluntario extends Cuenta{

    private String prefAcomp;
    private String estado;
    
    ArrayList<Acompañamiento> acompañamientos = new ArrayList <>();
    
    public Voluntario( int idCuenta,
                       String nomCuenta,
                       String contraseña,
                       String nombre,
                       String ape1,
                       String ape2,
                       Asociacion asociacion,
                       String prefAcomp,
                       String estado )
    {
        super(idCuenta, nomCuenta, contraseña, nombre, ape1, ape2, asociacion);
        this.estado = estado;
        this.prefAcomp  = prefAcomp;
    }
    
    public void addAcom( int id , String estado){
        this.acompañamientos.add( new Acompañamiento( id , estado ) );
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
                             ", asociacion="+this.getNomAsociacion() +
                             ", prefAcomp="+this.getPrefAcomp() +
                             ", estado="+this.getEstado()+'}';
    }
    
    public String getNomAsociacion(){
        return asociacion.getNom();
    }

    public String getPrefAcomp() {
        return prefAcomp;
    }

    public String getEstado() {
        return estado;
    }

}
