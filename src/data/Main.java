package data;

import static data.Acompañamiento.EstadoAcom.en_curso;
import static data.Acompañamiento.EstadoAcom.terminado;
import data.Usuario.Discapacidad;
import static data.Usuario.Discapacidad.fisica;
import static data.Usuario.Discapacidad.intelectual;
import static data.Usuario.Discapacidad.otras;
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
        p.command("cmd.exe","/c","src\\bd\\usuarios.txt");
        
        FicUtls fic = new FicUtls();
        
        File facom = new File("src\\bd\\acompañamientos.txt");
        File fasoc = new File("src\\bd\\asociaciones.txt");
        File fvol = new File("src\\bd\\voluntarios.txt");
        File fusr = new File("src\\bd\\usuarios.txt");
        
        fic.vaciar(facom);
        
        ArrayList<Asociacion> asociaciones = new ArrayList <>();
        deFicheroAListaAsoc(fasoc,asociaciones);
        
        asociaciones.get(0).voluntarios.get(0).addAcom(112, terminado , facom);
        asociaciones.get(0).voluntarios.get(1).addAcom(113, en_curso , facom);
        
        asociaciones.get(0).showUsuarios();
        asociaciones.get(0).showVolunt();
        
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