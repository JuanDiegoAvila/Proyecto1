import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * @author Esteban Aldana Guerra 20591
 * @author Juan Diego Avila Sagastume
 * @author Jun Woo Lee Hong 
 */
public class EvalFuncion<E> {

    HashMap<Object, ArrayList> newfunct = new HashMap<>();
    ArrayList<Object> inst = new ArrayList<Object>();

    public String Calcular(ArrayList<E> datos){
        Calculadora calc = new Calculadora();
        StringBuilder exp = new StringBuilder();
        for (Object temporal : datos) {
            if (temporal instanceof List) {

                exp.append(Calcular((ArrayList<E>) temporal));
            } else {
                exp.append((String) temporal+",");
            }
        }
        return calc.Calculo(exp);
    }

    public void fEvaluar(ArrayList<E> ins){
        List<E> list;
        /**
         * Se recorre la instruccion para ser evaluada
         */
        for(Object i : ins){

            if(i instanceof List){
                ArrayList<E> instruccion = (ArrayList<E>) i;
                /**
                 * si encuentra signos manda a calcular la expresion
                 */
                if (instruccion.contains("-") || instruccion.contains("/") || instruccion.contains("*") || instruccion.contains("+")){

                    System.out.println("Resultado = "+ Calcular(ins));
                    /**
                     * si encuentra la palabra list, crea una lista con los valores proporcionados
                     */
                } else if (instruccion.contains("list")){

                    list = new Evaluador<E>().list(instruccion.subList(1, instruccion.size()));
                    System.out.println("Lista Creada: " +list);
                    /**
                     * si encuentra equal, compara los valores para ver si son iguales o no
                     */
                } else if (instruccion.contains("equal")){
                    //es igual
                    if( (new Evaluador<E>()).equals(instruccion.get(1), instruccion.get(2))){
                        System.out.println("true");
                    }
                    //no es igual
                    else{
                        System.out.print("false\n");
                        System.out.println("Es falso por lo que no se ejecuta");
                        break;
                    }
                }
                /**
                 * si encutra el signo mayor que, compara para ver si es mayor un valor al otro
                 */
                else if (instruccion.contains(">")){
                    //Si es mayor
                    if( (new Evaluador<E>()).Mayor(instruccion.get(1), instruccion.get(2))){
                        System.out.print("true");
                    }
                    //No es mayor
                    else{
                        System.out.print("false\n");
                        System.out.println("Es falso por lo que no se ejecuta");
                        break;
                    }

                    /**
                     * Si encuentra el signo menor que, Compara para ver si es menor o no
                     */
                } else if (instruccion.contains("<")){
                    //Si es menor
                    if( (new Evaluador<E>()).Menor(instruccion.get(1), instruccion.get(2))){
                        System.out.print("true");
                    }
                    //no es menor
                    else{
                        System.out.print("false\n");
                        System.out.println("Es falso por lo que no se ejecuta");
                        break;
                    }
                    /**
                     * si encuentra cond, manda a ejecutar la funcion del evaluador 
                     */
                }else if (instruccion.contains("cond")){
                    new Evaluador<E>().cond(instruccion);
                }
                /**
                 * si encuentra quote regresa la expresion que le acompaña
                 */
                else if(instruccion.contains("quote") || instruccion.contains("'")) {
                    new Evaluador<E>().quote(instruccion);
                    /**
                     * Si encuentra setq regresa la variable y el valor de la eexpresion 
                     */
                }else if(instruccion.contains("setq")) {
                    new Evaluador<E>().setq(instruccion);

                }else if(ins.contains("defun")) {
                    /**
                     * Corre un loop de la cantidad de arrays de instruccion que tiene el defun.
                     */
                    for(int j = 3; j < ins.size(); j++){
                        inst.add(ins.get(j)); //Agrega los arrays de instrucciones a un neuvo array
                    }

                    newfunct.put(ins.get(1), inst); //Agrega a un hashmap, el key siendo el nombre de la funcion y value el array nuevo con las instrucciones

                    System.out.println("Se ha grabado la funcion: " + ins.get(1));
                    break;

                }else if(instruccion.contains("ATOM") || instruccion.contains("atom")){
                    String atom = new Evaluador<E>().atom(instruccion) ? "True": "False";
                    System.out.println(atom);
                }
            }
        }
    }
    
    public ArrayList getValue(Object function){
        /**
         * Getter que regresa el value del key aportado del hashmap
         */
        ArrayList<ArrayList> tempList = newfunct.get(function);
        return tempList;
    }

    public HashMap getMap(){
        /**
         * getter que regresa el hashmap
         */
        return newfunct;
    }
}
