
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
/**
 * @author Esteban Aldana Guerra 20591
 * @author Juan Diego Avila Sagastume
 * @author Jun Woo Lee Hong
 */
public class Main {
    public static void main(String[] args) {
        int op = 0;
        //boolean que identifica si selecciona salir o no
        boolean salir = true;
        Scanner sc = new Scanner(System.in);

        //Se llama a la clase Lector
        Lector lector = new Lector();
        EvalFuncion<Object> evaluar = new EvalFuncion<Object>();


            while (salir) {
                //try para ver si el usuario ingresa un dato incorrecto
                try {
                    System.out.println("\n------------LISP------------");
                    System.out.println("1. Ejecutar comando Lisp");
                    System.out.println("2. Ingresar Funcion");
                    System.out.println("3. Salir");
                    System.out.print("Seleccione la opcion a realizar -> ");

                    op = sc.nextInt();
                    sc.nextLine();

                    if (op == 1) {
                        String path = "";
                        System.out.print("Ingrese la direccion del archivo a evaluar: ");
                        path = sc.nextLine();

                        ArrayList<Object> expresion = lector.LISP(path);
                        evaluar.fEvaluar(expresion);

                    } else if (op == 2) {
                        System.out.println("Ingrese su funcion");
                        String userFunction = sc.nextLine(); //La funcion se debe ingresar sin parentesis

                        //Toma lo que el usuario ingreso y lo convierte en un ArrayList
                        ArrayList<Object> functionExpresion = lector.Read(userFunction);
                        String temporal = functionExpresion.get(0).toString();
                        String[] sep = temporal.split(" ");
                        List<String> userFunctionList = Arrays.asList(sep);


                        HashMap tempHashMap = evaluar.getMap();
                        if(tempHashMap.containsKey(userFunctionList.get(0))){ //If para ver si lo que el usuario ingreso esta en el hashmap

                            //Separa el nombre de la funcion y el parametro que el usuario encontro
                            ArrayList values = evaluar.getValue(userFunctionList.get(0));
                            Object param = userFunctionList.get(1);


                            for(int i = 0; i<values.size(); i++){ //for loop que repite por cuantas instrucciones hay
                                Object a = values.get(i); //Pone cada instruccion en el valor por cada vez q se repite
                                if(a instanceof ArrayList){
                                    //if la instruccion en este paso es un ArrayList
                                    for(int k = 0; k< ((ArrayList<?>) a).size(); k++){
                                        //for loop para revisar cada indice de la instrucciones si son un arraylist
                                        if(((ArrayList<?>) a).get(k).equals("x")){
                                            //reemplaza todas las x por lo que el usuario ingreso
                                            ((ArrayList<Object>) a).set(k, param);
                                            values.set(i,a);
                                        }

                                    }

                                }

                            }

                            System.out.println(values);
                            evaluar.fEvaluar(values);






                        }

                    } else if(op == 3){
                        salir = false;
                        System.exit(0);




                    } else {
                        System.out.println("Ingrese un numero dentro del rango especificado\n");

                    }
                }
                catch (Exception e) {
                    //System.out.println("Solo se pueden ingresar numeros\n");
                    System.out.println(e.getMessage());
                    sc.next();
                }
        }
    }

}


