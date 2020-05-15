package utilsFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class FicUtls {

    public FicUtls() {
    }
    
    /**
     * Muestra un fichero
     * @param ruta Ruta del fichero a mostrar
     * @throws IOException Cuando tiene problemas con el fichero
     */
    public void ejecutar(String ruta) throws IOException{
        new ProcessBuilder().command("cmd.exe","/c",ruta).start();
    }
    
    /**
     * Añade un texto al final de un fichero
     * @param texto Texto a añadir
     * @param f Fichero en el que se añade
     * @throws java.io.IOException Cuando tiene problemas con el fichero
     */
    public void añadir(String texto, File f) throws IOException {
        if (f.exists()) {
            String s = leer(f);
            FileWriter fw = new FileWriter(f);
            String todo = s + texto;
            fw.write(todo);
            fw.close();            
        }else{
            System.out.println("ERROR. El archivo no existe");
        }
    }
    
    /**
     * Devuelve el fichero en forma de String
     * @param f Fichero a leer
     * @return El fichero en forma de String
     * @throws java.io.IOException Cuando tiene problemas con el fichero
     */
    public String leer(File f) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        
        if (f.exists()) {
            String cad = "" , str = cad;
            while((cad = br.readLine()) != null){
                str = str + cad + "\n";
            }
            return str;       
        }else{
            System.out.println("ERROR. El archivo no existe");
            return null;
        }
        
    }

    /**
     * Elimina todas las lineas que coincidan con la linea a buscar en un fichero
     * @param text Texto a eliminar
     * @param f Fichero en el que buscar la palabra a eliminar
     * @throws java.io.IOException Cuando tiene problemas con el fichero
     */
    public void eliminar(String text, File f) throws IOException {
        String str = "";
        
        if ( f.exists() ) {
            String[] arr = leer(f).split("\n");
            
            for (String arr1 : arr) {
                if (arr1.equalsIgnoreCase(text)) {
                    vaciar(f);
                } else {
                    str = str + arr1 + "\n";
                }
            }
            
            añadir(str,f);
            
        }else{
            JOptionPane.showMessageDialog(null, "Error. No existe el fichero "+f.getName());
        }
    }

    /**
     * Busca si una linea coincide con el texto a buscar
     * @param text Linea del fichero a buscarLinea
     * @param f Fichero del que se quiere buscar
     * @return Linea de la coincidencia (-1 si no coincide)
     * @throws java.io.IOException Cuando tiene problemas con el fichero
     */
    public int buscarLinea(String text, File f) throws IOException {
        String s = leer(f);
        String[] arr = s.split("\n");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(text)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Busca la primera coincidencia (usa un indexOf)
     * @param text Texto a buscar
     * @param f Fichero del que se quiere buscar
     * @return Posicion en la que se encuentra la primera coincidencia por delante
     * @throws java.io.IOException Cuando tiene problemas con el fichero
     * @see #leer(java.io.File)
     */
    public int buscar(String text, File f) throws IOException {
        String s = leer(f);
        return s.indexOf(text);
    }
    
    /**
     * Busca en un fichero las lineas que contienen una palabra que coincide con la palabra a buscar
     * @param text Texto a buscar
     * @param f Fichero del que se quiere buscar
     * @return Linea que contiene la coincidencia
     * @throws java.io.IOException Cuando tiene problemas con el fichero
     */
    public String buscarEnLinea(String text , File f) throws IOException{
        String[] str = this.leer(f).split("\n");
        for (int i = 0; i < str.length; i++) {
            if ( str[i].contains(text) ) {
                return str[i];
            }
        }
        return null;
    }
    
    /**
     * Busca la ultima coincidencia (usa un lastIndexOf)
     * @param text Texto a buscar
     * @param f Fichero del que se quiere buscar
     * @return Posicion en la que se encuentra la primera coincidencia por detras
     * @throws java.io.IOException Cuando tiene problemas con el fichero
     * @see #leer(java.io.File)
     */
    public int buscarAtrás(String text, File f) throws IOException {
        String s = leer(f);
        return s.lastIndexOf(text);
    }

    /**
     * Vacía un fichero
     * @param f Fichero a vaciar
     * @throws java.io.IOException Cuando tiene problemas con el fichero
     */
    public void vaciar(File f) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("");
        bw.close();
    }
}
