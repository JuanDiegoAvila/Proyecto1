
public class Main {
    public static void main(String[]args){


        //Creamos el lector de texto
        Lector lector = new Lector();
        String expresion = lector.Archivo("datos.txt");

        Controlador control = new Controlador();
        control.Expresion(expresion);
    }
}
