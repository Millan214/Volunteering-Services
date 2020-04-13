package data;

import java.util.ArrayList;

public class Cuenta {
    
    //DATOS DE LA CUENTA
    private int idCuenta;
    private String nomCuenta;
    private String contraseña;
    
    //DATOS DEL USUARIO
    private String nombre;
    private String ape1;
    private String ape2;

    //Una cuenta pertenece a una asociacion
    Asociacion asociacion;
    
    public Cuenta( int idCuenta,
                   String nomCuenta,
                   String contraseña,
                   String nombre,
                   String ape1,
                   String ape2,
                   Asociacion asociacion )
    {
        this.idCuenta = idCuenta;
        this.nomCuenta = nomCuenta;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.asociacion = asociacion;
        
        
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", nomCuenta=" + nomCuenta + ", contrase\u00f1a=" + contraseña + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + '}';
    }

    public String getNomAsociacion() {
        return asociacion.getNom();
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public String getNomCuenta() {
        return nomCuenta;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public String getApe2() {
        return ape2;
    }
    
    
    
}
