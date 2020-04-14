package data;

import static data.Usuario.Discapacidad.fisica;
import static data.Usuario.Discapacidad.sensorial;
import static data.Voluntario.Estado.disponible;
import static data.Voluntario.Estado.ocupado;
import gui.VenOpcUsr;
import gui.VentanaGeneral;
import java.io.File;
import java.io.IOException;
import utilsFicheros.FicUtls;

public class Main {

    public static void main(String[] args) throws IOException {
        
        Asociacion asoc = new Asociacion("ONCE","D123412T");
        
        ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","src\\bd\\acompañamientos.txt");
        FicUtls fic = new FicUtls();
        File fvol = new File("src\\bd\\voluntarios.txt");
        File facom = new File("src\\bd\\acompañamientos.txt");
        
        fic.vaciar(fvol);
        fic.vaciar(facom);
        
        asoc.addVol(123 , "elepepes" , "12314" , "pepe" , "garcias", "martinez", asoc , fisica , disponible , fvol);
        asoc.addVol(333 , "marialoca" , "234432" , "maria" , "martinez", "lopez", asoc , sensorial , ocupado , fvol);
        asoc.voluntarios.get(0).addAcom(112, "en espera" , facom);
        
        
        
        p.start();
        
    }
    
}