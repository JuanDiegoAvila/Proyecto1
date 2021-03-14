import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Evaluador<E> {

    public String funcion = "";
    private HashMap<String, E> var = new HashMap<>();
    private List<E> instrucciones;

    /**
     * @param funcion El parametro funcion explica cual el el nombre de la funcion
     * @param var Hashmap que contiene las variables de la funcion
     * @param instruccion Contiene las instrucciones de la funcion
     **/
    public Evaluador (String funcion, E var, E instruccion){

    }
    /**
     * El motodde evaluador ejecuta la funcion correspondiente
     * @param val Lista con las variables necesarias de la funcion
     * @return Devuelve la instruccion con las variables como constantes
     */
    public List<E> ejecutarInstrucciones(List<E> val){

        return null;
    }

    public String getfuncion(){
        return this.funcion;
    }
}


