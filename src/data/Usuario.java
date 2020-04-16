package data;

public class Usuario extends Cuenta{

    private int edad;
    private Discapacidad tipoDiscap;
    private String Direccion;
    private int telMov;
    private int telFij;

    public enum Discapacidad{ fisica , sensorial , intelecutal , multiple , otras };
    
    public Usuario(
                   int idCuenta,
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
        super(idCuenta, nomCuenta, contraseña, nombre, ape1, ape2, asociacion);
        this.edad = edad;
        this.tipoDiscap = tipoDiscap;
        this.Direccion = direccion;
        this.telMov = telMov;
        this.telFij = telFij;
    }
    
    @Override
    public String toString() {
        return "Voluntario{" + "idCuenta=" + super.getIdCuenta() +
                             ", nomCuenta=" + super.getNomCuenta() +
                             ", contrase\u00f1a=" + super.getContraseña() +
                             ", nombre=" + super.getNombre() +
                             ", ape1=" + super.getApe1() +
                             ", ape2=" + super.getApe2() + 
                             ", asociacion=" + this.getAsociacion() +
                             ", tipoDiscap=" + this.getTipoDiscap() +
                             ", direccion=" + this.getDireccion() +
                             ", telMov=" + this.getTelMov() +
                             ", telFij=" + this.getTelFij() + '}';
    }
    
    public String toStringFichero(String separador , String fin){
        char com = (char)34;// " -> comillas dobles
        return super.getIdCuenta() + separador +
               + com + super.getNomCuenta() + com + separador +
               + com + super.getContraseña() + com + separador +
               + com + super.getNombre() + com + separador +
               + com + super.getApe1() + com + separador +
               + com + super.getApe2() + com + separador +
               this.getEdad() + separador +
               this.getAsociacion() + separador +
               this.getTipoDiscap() + separador +
               + com + this.getDireccion() + separador +
               this.getTelMov() + separador +
               this.getTelFij() + fin;
    }

    public int getEdad() {
        return edad;
    }

    public Discapacidad getTipoDiscap() {
        return tipoDiscap;
    }

    public String getDireccion() {
        return Direccion;
    }

    public int getTelMov() {
        return telMov;
    }

    public int getTelFij() {
        return telFij;
    }
    
}