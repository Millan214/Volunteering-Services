package data;

public class Acompañamiento {

    private int id;
    private estadoAcom estadoAcom;
    private tipoAcom tipo;
    private int clasificacion = -1;
    
    public enum tipoAcom{ paseo , visitas_medicas , visitas_culturales , otros };
    public enum estadoAcom{ en_curso , terminado };

    public Acompañamiento(int id, estadoAcom estadoAcom , tipoAcom tipoAcom) {
        this.id = id;
        this.estadoAcom = estadoAcom;
        this.tipo=tipoAcom;
    }
    
    @Override
    public String toString() {
        return "Acompañamiento { id="+this.id+", estadoAcom="+this.estadoAcom+", tipoAcom="+this.tipo+" }";
    }
    
    /**
     * Pasa el acompañamiento a una string con un formato para guardarla en un fichero
     * @param idCuen Id de cuenta del Voluntario
     * @param separador Símbolo que hace de separador en el fichero
     * @param fin Símbolo que hace de final de linea en el fichero
     * @return Cadena a escribir en el fichero
     */
    public String toStringFichero(int idCuen , String separador , String fin){
        if (clasificacion == -1) {
            return idCuen + ">" + id + separador + estadoAcom + separador + tipo + fin ;
        }
        return idCuen + ">" + id + separador + estadoAcom + separador + tipo + separador + clasificacion + fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public estadoAcom getEstadoAcom() {
        return estadoAcom;
    }

    public void setEstadoAcom(estadoAcom estadoAcom) {
        this.estadoAcom = estadoAcom;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        for (int i = 0; i < 5; i++) {
            if (clasificacion >= 0 && clasificacion <= 5) {
                this.clasificacion = clasificacion;
                break;
            }
            System.out.println(i+". La clasificacion ha de estar entre 0 y 5");
        }
        System.out.println("Has agotado los 5 intentos");
    }
    
}
