package data;

public class Acompañamiento {

    private int id;
    private String estadoAcom;
    private int calificacion;

    public Acompañamiento(int id, String estadoAcom) {
        this.id = id;
        this.estadoAcom = estadoAcom;
    }

    @Override
    public String toString() {
        return "Acompa\u00f1amiento{" + "id=" + id + ", estadoAcom=" + estadoAcom + ", calificacion=" + calificacion + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstadoAcom() {
        return estadoAcom;
    }

    public void setEstadoAcom(String estadoAcom) {
        this.estadoAcom = estadoAcom;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
}
