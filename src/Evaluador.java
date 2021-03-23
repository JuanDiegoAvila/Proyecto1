import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Evaluador<E> {
    public String funcion = "";
    private HashMap<String, Object> var = new HashMap<>();
    private List<E> instrucciones;
/**
 * Función Para evaluar Quote dentro de Lisp
 * @param instrucciones Lista con las instrucciones de la funcion del método
 */
public void Quote(List<E> instrucciones){
    	String texto="";
    	for(int i=1;i<instrucciones.size();i++) {
    		
    		texto+=instrucciones.get(i)+" ";
    		System.out.println(texto);
    	}
    }
}


