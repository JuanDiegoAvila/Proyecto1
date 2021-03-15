

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int op = 0;
        boolean salir = true;
        Scanner sc = new Scanner(System.in);

        
            while (salir) {
                try {
                System.out.println("------------LISP------------");
                System.out.println("1. Ejecutar comando Lisp");
                System.out.println("2. Salir");
                System.out.print("Seleccione la opcion a realizar -> ");
                op = sc.nextInt();

                if (op == 1) {
                        System.out.print("Ingrese la direccion del archivo a evaluar: \n");
                        String path = sc.nextLine();
                        Lector lector = new Lector();
                        String expresion = lector.LISP(path);

                    } else if (op == 2) {
                        salir = false;
                        System.exit(0);
                    } else {
                        System.out.println("Ingrese un numero dentro del rango especificado\n");
                       
                    }
                }
                catch (Exception e) {
                    System.out.println("Solo se pueden ingresar numeros\n");
                    break;
                }
        }
    }

}


