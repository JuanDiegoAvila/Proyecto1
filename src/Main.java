
public class Main {
    public static void main(String[]args){


        //Creamos el lector de texto
        Lector lector = new Lector();
        String expresion = lector.Archivo("datos.txt");
        Calculadora calc = new Calculadora();

        System.out.println(calc.Calculo(expresion));
    }
}
