package data;

import gui.VenLoginVol;
import gui.VenModificarVol;
import gui.VenPpalAdmin;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import utilsFicheros.FicUtls;

public class Main {
    /**
     * @author Millan & Abel
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        File fasoc = new File("src"+File.separator+"ficheros"+File.separator+"asociaciones.txt");
        File fvol = new File("src"+File.separator+"ficheros"+File.separator+"voluntarios.txt");;
        ArrayList<Asociacion> asociaciones = new ArrayList<>();
        deFicheroAListaAsoc(fasoc, asociaciones);

        //pepito 12314
        VenLoginVol vol = new VenLoginVol(asociaciones);
        vol.setVisible(true);
        
        
        
//        VenModificarVol vmv = new VenModificarVol(asociaciones.get(0).voluntarios.get(0) , fvol);
        //vmv.setVisible(true);
//        fic.ejecutar("src"+File.separator+"ficheros"+File.separator+"voluntarios.txt");
        
    }//psvm
    
    /**
     * @param fasoc Fichero de asociaciones
     * @param asociaciones Lista de asociaciones a la que quieres pasar lo que hay en el fichero
     * @throws IOException
     */
    private static void deFicheroAListaAsoc(File fasoc, ArrayList<Asociacion> asociaciones) throws IOException {
        FicUtls fic = new FicUtls();
        String str = fic.leer(fasoc).substring(0, fic.leer(fasoc).indexOf("*"));
        String[] strpar = str.split(",");
        asociaciones.add(new Asociacion(strpar[0], strpar[1]));
    }
    
}
