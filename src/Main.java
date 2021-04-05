
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
        boolean salir = true;
        Scanner sc = new Scanner(System.in);

        Lector lector = new Lector();
        Evaluador eval = new Evaluador();
        EvalFuncion<Object> evaluar = new EvalFuncion<Object>();


            while (salir) {

                try {
                    System.out.println("------------LISP------------");
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

                        ArrayList<Object> functionExpresion = lector.Read(userFunction);
                        String temporal = functionExpresion.get(0).toString();
                        String[] sep = temporal.split(" ");
                        List<String> userFunctionList = Arrays.asList(sep);

                        HashMap tempHashMap = evaluar.getMap();


                        if(tempHashMap.containsKey(userFunctionList.get(0))){


                            ArrayList values = evaluar.getValue(userFunctionList.get(0));
                            //ArrayList one = (ArrayList) temp.get(0);
                            //ArrayList two = (ArrayList) one.get(0);
                            String tempString = values.get(0).toString();



                            Object param = userFunctionList.get(1);


                            for(int i = 0; i<values.size(); i++){
                                Object a = values.get(i);
                                if(a instanceof ArrayList){
                                    for(int k = 0; k< ((ArrayList<?>) a).size(); k++){
                                        if(((ArrayList<?>) a).get(k).equals("x")){
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


