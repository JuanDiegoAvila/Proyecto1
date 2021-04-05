import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Esteban Aldana Guerra 20591
 * @author Juan Diego Avila Sagastume
 * @author Jun Woo Lee Hong 
 */
public class Evaluador<E> {
    public String funcion = "";
    private HashMap<String, Object> var = new HashMap<>();
	List<E> instrucciones;
	
	/**
	 * 
	 * @param valores lista en la cual se van a almacenar los valores que desee el usuario
	 * @return la lista ya con los valores agregados
	 */
	public List<E> list(List<E> valores){
        return valores;
    }
	/**
	 * 
	 * @param obj1 primer objeto a comparar
	 * @param obj2 segundo objeto a comparar
	 * @return si los dos valores son iguales o no
	 */
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
 * Metodo para evaluar Quote dentro de Lisp
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
    		System.out.println("\nVariable"+instrucciones.get(1).toString());
    		System.out.println("valor " +map.get(instrucciones.get(1).toString()));
    		
    	//Si solo es un dato
    	}else {
    		
    		map.put(instrucciones.get(1).toString(), instrucciones.get(2).toString());
    		
    		System.out.println("\nVariable "+instrucciones.get(1).toString());
    		System.out.println("valor "+map.get(instrucciones.get(1).toString()));
    	}
    	
    }
	/**
	 * Metodo Atom 
	 * @param instrucciones usa la lista de instrucciones que son leidas del archivo
	 * @return true o false dependiendo de su contenido
	 */
    public boolean atom(List<E> instrucciones){

		String texto= "";
		for(int i=1;i<instrucciones.size();i++) {

			texto += instrucciones.get(i)+" ";
		}

		try{
			Double.parseDouble(texto);
			return true;
		}catch(NumberFormatException e){

			try{
				Integer.parseInt(texto);
				return true;
			}catch(NumberFormatException i){

				try{
					Float.parseFloat(texto);
					return true;
				}catch(NumberFormatException x){

					try{
						texto.toString();
						return true;
					}catch(Exception y){
						return false;
					}
				}
			}
		}
	}
	/**
	 * 
	 * @param instrucciones utiliza el parametro de las instrucciones extraidas del archivo seleccionado
	 * @return regresa las condiciones que contiene el archivo
	 */
    public E cond(List<E> instrucciones){
			List<E> subList = instrucciones.subList(1, instrucciones.size());
			List<E> subList2 = (List<E>) subList.get(0);
			int i = 0;
			for (Object inst: subList2) {
				List<E> instruccion = (List<E>)inst;
				if (instruccion.contains("equal")){
					if (equals(instruccion.get(1), instruccion.get(2))){
						return instruccion.get(3);
					}
				} else if (instruccion.contains("<")){
					if (Menor(instruccion.get(1), instruccion.get(2))){
						return instruccion.get(3);
					}
				} else if (instruccion.contains(">")){
					if (Mayor(instruccion.get(1), instruccion.get(2))){
						return instruccion.get(3);
					}
				} else if (i == subList2.size()){
					return subList2.get(i);
				}
				i++;
			}
			return null;
		}

    /**
	 * Metodo defun 
	 * @param name
	 * @param Vars
	 * @param instrucciones
	 */
	public void defun(String name, List<E> Vars, List<E> instrucciones){
    	List<String> variables = new ArrayList<>();
    	variables.add(Vars.toString());

    	for(String i: variables){
    		var.put(i,null);
		}
		this.instrucciones = instrucciones;
	}

}


