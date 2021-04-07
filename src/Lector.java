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

    public ArrayList<Object> LISP(String path){
        String resultado = "";
        try {
            Scanner input = new Scanner(new File(path));
            int cont = 0;
            while (input.hasNextLine()) {
                resultado += input.nextLine();
            }
        }catch (Exception ignored){

        }

        resultado = resultado.replaceAll("\\(","\\ ( ");
        resultado = resultado.replaceAll("\\)","\\ ) ");

        return Read(resultado);
    }

    public ArrayList<Object> createList(List<String> charac){

        int parentesis = 0;
        ArrayList<Object> expresionTemp = new ArrayList<Object>();
        ArrayList<Object> lista = new ArrayList<Object>();

        String temporal = "";
        try{
            for(String temp: charac){

                //agregar todo lo anterior.
                switch (temp){
                    case "(" -> {
                        if(temporal.contains(" ")){
                            ArrayList<String> separar = new ArrayList<String>(Arrays.asList(temporal.split(" ")));
                            lista.addAll(separar);
                        }else{
                            lista.add(temporal);
                        }
                        temporal = "";
                        parentesis++;
                    }
                    case ")" ->{
                        expresionTemp = createList(Arrays.asList(temporal.split("")));
                        if(!expresionTemp.isEmpty()){
                            lista.add(expresionTemp);
                            parentesis--;
                            temporal = "";
                        }

                    }
                    default -> temporal += temp;
                }



            }
            if(!temporal.equals("")){
                lista.add(temporal);
            }
        }catch(Exception ignored){

        }

        ArrayList<Object> expresion = new ArrayList<>();
        for (Object s : lista) {
            if (s.equals("") || s.equals(" ")) {

            }else{
                expresion.add(s);
            }


        }


        expresion.removeAll(Collections.singleton(" "));
        expresion.removeAll(Collections.singleton("  "));
        expresion.removeAll(Collections.singleton("   "));
        expresion.removeAll(Collections.singleton("    "));
        expresion.removeAll(Collections.singleton("     "));

        return expresion;
    }

    public ArrayList<Object> Read(String LispExpresion){
        LispExpresion = LispExpresion.replaceAll("\\s{2,}", " ");


        String[] sep = LispExpresion.split("");
        List<String> charac = Arrays.asList(sep);

        ArrayList<Object> expresion = createList(charac);
        for(Object z : expresion){
            if(z instanceof List){
                String contenido = (String) ((List<?>) z).get(0);
                List<String> cont = new ArrayList<String>(Arrays.asList(contenido.split(" ")));

                if(!cont.isEmpty()){
                    cont.remove(0);
                }

                for(int i = 0; i<cont.size(); i++){

                    if (i == 0) {
                        ((List<Object>) z).set(i, (Object) cont.get(i));
                    } else {
                        ((List<Object>) z).add((Object) cont.get(i));
                    }
                }
            }
        }


        if(parentesis != 0){
            System.out.println("Hace falta un parentesis para completar la expresion.");
            return null;
        }else{
            return expresion;
        }

    }
}
