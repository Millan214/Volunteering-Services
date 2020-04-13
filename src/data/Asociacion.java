package data;

import java.util.ArrayList;

public class Asociacion {

    private String nom;
    private String cif;
    
    ArrayList<Voluntario> voluntarios = new ArrayList <>();
    ArrayList<Usuario> usuarios = new ArrayList <>();
    
    public Asociacion( String nom, String cif ){
        this.nom = nom;
        this.cif = cif;
    }
    
    public void addVol(){
    
    }
    
    public void addUsr(){
    
    }
    
    public void showVolunt (){
        for (Voluntario voluntario : voluntarios) {
            System.out.println( voluntario );
        }
    }
    
    public void showAcomVolunt (){
        for (int i = 0; i < voluntarios.size(); i++) {
            System.out.println( voluntarios.get(i).getNombre() );
            for (int j = 0; j < voluntarios.get(i).acompañamientos.size(); j++) {
               voluntarios.get(i).getAcom(j);     
            }
        }
    }
    
    public void showUsuarios (){
        for (Usuario usuario : usuarios) {
            System.out.println( usuario );
        }
    }

    @Override
    public String toString() {
        return "Asociacion{" + "nom=" + nom + ", cif=" + cif + '}';
    }

    public String getNom() {
        return nom;
    }

    public String getCif() {
        return cif;
    }
        
}
