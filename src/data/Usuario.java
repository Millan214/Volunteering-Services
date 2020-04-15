package data;
public class Usuario extends Cuenta{

    private int edad;
    private Discapacidad tipoDiscap;
    private String Direccion;
    private int telMov;
    private int telFij;

    public enum Discapacidad{ fisica , sensorial , intelecutal , diabetes , multiple , otras };
    
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
                             ", asociacion=" + this.getNomAsociacion() +
                             ", tipoDiscap=" + this.getTipoDiscap() +
                             ", direccion=" + this.getDireccion() +
                             ", telMov=" + this.getTelMov() +
                             ", telFij=" + this.getTelFij() + '}';
    }
    
    public String toStringFichero(String separador , String fin){
        return super.getIdCuenta() + separador +
               super.getNomCuenta() + separador +
               super.getContraseña() + separador +
               super.getNombre() + separador +
               super.getApe1() + separador +
               super.getApe2() + separador +
               this.getNomAsociacion() + separador +
               this.getTipoDiscap() + separador +
               this.getDireccion() + separador +
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