package data;

public class Acompañamiento {

    private int id;
    private EstadoAcom estadoAcom;
    private int clasificacion = -1;
    
    public enum EstadoAcom{ en_curso , terminado };

    public Acompañamiento(int id, EstadoAcom estadoAcom) {
        this.id = id;
        this.estadoAcom = estadoAcom;
    }

    @Override
    public String toString() {
        return "Acompa\u00f1amiento{" + "id=" + id + ", estadoAcom=" + estadoAcom + ", calificacion=" + clasificacion + '}';
    }
    
    public String toStringFichero(int idCuen , String separador , String fin){
        if (clasificacion == -1) {
            return idCuen + ">" + id + separador + estadoAcom + fin ;
        }
        return idCuen + ">" + id + separador + estadoAcom + separador + clasificacion + fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstadoAcom getEstadoAcom() {
        return estadoAcom;
    }

    public void setEstadoAcom(EstadoAcom estadoAcom) {
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
