package data;

import gui.VenOpcUsr;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import utilsFicheros.FicUtls;

public class App {
    /**
     * @author Millan
     * @throws java.io.IOException Cuando ocurre un error de entrada-salida
     */
    public App() throws IOException {
        
        File fasoc = new File("src"+File.separator+"ficheros"+File.separator+"asociaciones.txt");
        ArrayList<Asociacion> asociaciones = new ArrayList<>();
        deFicheroAListaAsoc(fasoc, asociaciones);

        VenOpcUsr v = new VenOpcUsr(asociaciones);
        v.setVisible(true);
        
        
    }
    
    /**
     * @param fasoc Fichero de asociaciones
     * @param asociaciones Lista de asociaciones a la que quieres pasar lo que hay en el fichero
     * @throws IOException
     */
    private void deFicheroAListaAsoc(File fasoc, ArrayList<Asociacion> asociaciones) throws IOException {
        FicUtls fic = new FicUtls();
        String str = fic.leer(fasoc).substring(0, fic.leer(fasoc).indexOf("*"));
        String[] strpar = str.split(",");
        asociaciones.add(new Asociacion(strpar[0], strpar[1]));
    }
    
}
