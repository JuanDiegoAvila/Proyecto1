import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluador<E> {
    public String funcion = "";
    private HashMap<String, Object> var = new HashMap<>();
    private List<E> instrucciones;

	public List<E> list(List<E> valores){
        return valores;
    }

    public boolean equals(E obj1, E obj2){
        return obj1.equals(obj2);
    }
	
	/**
	 * 
	 * @param obj1 primer objeto a comparar 
	 * @param obj2 segundo objeto a comparar
	 * @return el valor que sea mayor entre los dos objetos
	 */
	 public boolean Mayor(E obj1, E obj2){
        return (Double.parseDouble(obj1.toString()) > Double.parseDouble(obj2.toString()));
    }
	/**
	 * 
	 * @param obj1 primer objeto a comparar
	 * @param obj2 segundo objeto a comparar
	 * @return el valor del objeto que sea menor entre los dos
	 */
    public boolean Menor(E obj1, E obj2){
        return (Double.parseDouble(obj1.toString()) < Double.parseDouble(obj2.toString()));
    }
/**
 * MetodoPara evaluar Quote dentro de Lisp
 * @param instrucciones Lista con las instrucciones de la funcion del método
 */
	public void quote(List<E> instrucciones){
    	String texto="";
    	for(int i=1;i<instrucciones.size();i++) {
    		
    		texto+=instrucciones.get(i)+" ";
    		System.out.println(texto);
    	}
    }
    /**
     * Metodo para poder evaluar la funcion de setq dentro de LISP
     * @param instrucciones Lista con las instrucciones de la funcion del método
     */
    public void setq(List<E> instrucciones) {
    	Map<String, String> map = new HashMap<String, String>();
    	//Si son varios datos
    	if(instrucciones.get(2).toString().charAt(0)=='['){
    		
    		String[] var = instrucciones.get(2).toString().split(",");
    		String contenido="";
    		for(int i=1;i<var.length;i++) {
    			//System.out.println(var[i]);
    			contenido+=var[i];
    		}
    		map.put(instrucciones.get(1).toString(), contenido);
    		System.out.println("La variable es: "+instrucciones.get(1).toString());
    		System.out.println("valor "+"["+map.get(instrucciones.get(1).toString()));
    		
    	//Si solo es un dato
    	}else {
    		
    		map.put(instrucciones.get(1).toString(), instrucciones.get(2).toString());
    		
    		System.out.println("La variable es: "+instrucciones.get(1).toString());
    		System.out.println("valor "+map.get(instrucciones.get(1).toString()));
    	}
    	
    }

    public void cond(List<E> instrucciones){

	}

	public void defun(List<E> instrucciones){
    	
	}
}


