package utilsFicheros;

import data.Voluntario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FicUtls {

    public FicUtls() {
    }
    
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
            System.out.println("ERROR. El archivo no existe");
        }
    }

    public int buscar(String text, File f) throws IOException {
        String s = leer(f);
        String[] arr = s.split("\n");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(text)) {
                return i;
            }
        }
        return -1;
    }

    public void vaciar(File f) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("");
        bw.close();
    }
    
}
