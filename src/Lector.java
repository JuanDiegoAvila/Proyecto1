import java.io.File;
import java.util.*;
/**
 * @author Esteban Aldana Guerra 20591
 * @author Juan Diego Avila Sagastume
 * @author Jun Woo Lee Hong 
 */
public class Lector {

    HashMap<String,String> var = new HashMap<String,String>();
    int parentesis;

    public ArrayList<Object> LISP(Scanner scan){
        ArrayList<Object> expresionTemp = new ArrayList<Object>();
        ArrayList<Object> lista = new ArrayList<Object>();

        while(scan.hasNext()){
            String actual = scan.next();
            switch(actual){
                case "(" ->{
                    expresionTemp = LISP(scan);
                    lista.add(expresionTemp);
                    parentesis++;
                }case ")" ->{
                    parentesis--;
                    return lista;
                }default -> lista.add(actual);
            }
        }
        return lista;
    }
}
