package data;

import static data.Acompañamiento.EstadoAcom.en_curso;
import static data.Acompañamiento.EstadoAcom.terminado;
import data.Usuario.Discapacidad;
import static data.Usuario.Discapacidad.fisica;
import static data.Usuario.Discapacidad.sensorial;
import static data.Voluntario.Estado.disponible;
import static data.Voluntario.Estado.ocupado;
import gui.VenAdminSelecc;
import gui.VenOpcUsr;
import gui.VentanaGeneral;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import utilsFicheros.FicUtls;

public class Main {

    public static void main(String[] args) throws IOException {
        
        ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","src\\bd\\voluntarios.txt");
        
        FicUtls fic = new FicUtls();
        
        File fvol = new File("src\\bd\\voluntarios.txt");
        File facom = new File("src\\bd\\acompañamientos.txt");
        File fusr = new File("src\\bd\\usuarios.txt");
        File fasoc = new File("src\\bd\\asociaciones.txt");
        
        fic.vaciar(facom);
        fic.vaciar(fusr);
        
        ArrayList<Asociacion> asociaciones = new ArrayList <>();
        deFicheroAListaAsoc(fasoc,asociaciones);
        
        for (int i = 0; i < asociaciones.get(0).voluntarios.size(); i++) {
            System.out.println( asociaciones.get(0).voluntarios.get(i) );
        }
        

        asociaciones.get(0).voluntarios.get(0).addAcom(112, terminado , facom);
        asociaciones.get(0).voluntarios.get(1).addAcom(113, en_curso , facom);
        
        asociaciones.get(0).addUsr(99999999, "LeandroGado", "afasd223", "leandro", "Gado", "Mucho", 78 , asociaciones.get(0), fisica, "callese", 12312321, 3333123 , fusr);
        
        
//        VenOpcUsr v = new VenOpcUsr();
//        v.setVisible(true);
//        
//        VenAdminSelecc vas = new VenAdminSelecc();
//        vas.setVisible(true);
        
//        VentanaGeneral vg = new VentanaGeneral();
//        vg.setVisible(true);
        
        p.start();
        
    }

    private static void deFicheroAListaAsoc(File fasoc, ArrayList<Asociacion> asociaciones) throws IOException {
        FicUtls fic = new FicUtls();
        
        String str = fic.leer(fasoc).substring( 0 , fic.leer(fasoc).indexOf("*") );
        String[] strpar = str.split(",");
        asociaciones.add( new Asociacion( strpar[0] , strpar[1] ) );
    }
    
}