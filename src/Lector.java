import java.io.File;
import java.util.*;

public class Lector {

    HashMap<String,String> var = new HashMap<String,String>();

    public String LISP(String path){
        String resultado = "";
        try {
            Scanner input = new Scanner(new File(path));
            int cont = 0;
            while (input.hasNextLine()) {
                resultado += input.nextLine();
            }
        }catch (Exception ignored){

        }
        ;
        return Read(resultado);
    }

    public String Read(String LispExpresion){
        LispExpresion = LispExpresion.replaceAll("\\s{2,}", " ");

        List<String> expresionTemp = new ArrayList<String>();
        ArrayList<String> operandos = new ArrayList<String>();
        ArrayList<String> operacion = new ArrayList<String>();

        int parentesis = 0;

        String[] sep = LispExpresion.split("");
        List<String> charac = Arrays.asList(sep);

        StringBuilder temporal = new StringBuilder();
        try{
            for(String temp: charac){
                //agregar todo lo anterior.
                switch (temp) {
                    case "(" -> {
                        expresionTemp.add(temporal.toString());
                        temporal = new StringBuilder();
                        parentesis++;
                    }
                    case ")" -> {
                        expresionTemp.add(temporal.toString());
                        temporal = new StringBuilder();
                        parentesis--;}
                    case " " -> {
                        expresionTemp.add(temporal.toString());
                        temporal = new StringBuilder();
                    }
                    default -> temporal.append(temp);
                }
            }
        }catch(Exception ignored){

        }

        List<String> expresion = new ArrayList<>();
        for (String s : expresionTemp) {
            if (s.equals("") || s.equals(" ")) {
                //No colocar si es espacio.
            }else{
                expresion.add(s);
            }
        }

        if(parentesis != 0){
            return "Hace falta un parentesis para completar la expresion.";
        }else{
            EvalFuncion<String> evaluar = new EvalFuncion<String>();
            evaluar.fEvaluar(expresion);
            return null;
        }

    }
}

