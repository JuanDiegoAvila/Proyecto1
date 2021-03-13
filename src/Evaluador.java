import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Evaluador {
    public String funcion = "";
    private HashMap<String, Object> var = new HashMap<>();
    private List<Object> instrucciones;

    /**
     *
     * @param funcion El parametro funcion explica cual el el nombre de la funcion
     * @param var Hashmap que contiene las variables de la funcion
     * @param instruccion Contiene las instrucciones de la funcion
     */
    public Evaluador (String funcion, Object var, Object instruccion){
        List<String> val = new ArrayList<>();
        val.add(var.toString());
        @SuppressWarnings("unchecked")
        List<Object> ins = (List<Object>) instruccion;
        this.funcion = funcion;
        for (String item: val){
            this.var.put(item, null);
        } 
        this.instrucciones = ins;
    }
    /**
     * El motodde evaluador ejecuta la funcion correspondiente
     * @param val Lista con las variables necesarias de la funcion
     * @return Devuelve la instruccion con las variables como constantes
     */
    public List<Object> EjecutarInstrucciones (List<Object> val){
        List<Object> temp = this.instrucciones;
        //HashMap temporal para almacenar el valor de cada variable
        HashMap<String, Object> tempVar = this.var;
        
        //verifica si la lista es del tamaño necesario para ejecutar la funcion
        if (val.size() == tempVar.size()){
            
            int i = 0;
            //Toma cada elemento del Hahsmap y le asigna un valor
            for (String key: tempVar.keySet()) {
                tempVar.replace(key, val.get(i));
                i++;
            }

        i = 0;
        while (i < temp.size()){
            //Toma cada elemento de las instrucciones temporales
            if ((temp.get(i) instanceof String)){
                //Toma cada elemento del Hashmap
                for (String key: tempVar.keySet()) {
                     //Si el elemento es igual a algun Key del mapa lo reemplaza por su Valor correspondiente
                    if (temp.get(i).equals(key)){
                        temp.add(i, tempVar.get(key));
                        temp.remove(i + 1);
                    }
                }
            } else if (temp.get(i) instanceof ArrayList){
                @SuppressWarnings("unchecked")
                List<Object> subIns = (List<Object>)temp.get(i);
                int j = 0;
                while (j < subIns.size()){
                    //Toma cada elemento de las instrucciones temporales
                    if ((subIns.get(j) instanceof String)){
                        //Toma cada elemento del Hashmap
                        for (String key: tempVar.keySet()) {
                            //Si el elemento es igual a algun Key del mapa lo reemplaza por su Valor correspondiente
                            if (subIns.get(j).equals(key)){
                                subIns.add(j, tempVar.get(key));
                                subIns.remove(j + 1);
                            }
                        }
                    }
                    j++;
                }
                temp.add(i, subIns);
                temp.remove(i + 1);
            }
            i++;
        }
    
        return temp;
    }

//Si la cantidad de variables es menor no se ejecutara el codigo.
    else {

}

        return temp;
}

public String getfuncion(){
return this.funcion;
}
}


