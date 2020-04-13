package data;
public class Main {

    public static void main(String[] args) {
        
        Asociacion a = new Asociacion("ONCE","D123412T");
        System.out.println(a.toString());
        Voluntario vo = new Voluntario( 123 , "elepepes" , "12314" , "pepe" ,
                                    "garcias", "martinez", a , "yayos" , "Disponible");
        
        System.out.println(vo.toString());
        
        vo.addAcom( 1230 , "En curso " );
        vo.addAcom( 1430 , "Finalizado" );
        
        
        System.out.println("Hola!!");
        
    }
    
}