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

        Evaluador evaluar = new Evaluador();

        LispExpresion = LispExpresion.replaceAll("\\s{2,}", " ");
        System.out.println(LispExpresion);

        ArrayList<String> operandos = new ArrayList<String>();
        ArrayList<String> operacion = new ArrayList<String>();
        ArrayList<String> parAbre = new ArrayList<String>();
        ArrayList<String> parCierra = new ArrayList<String>();


        String[] sep = LispExpresion.split("");


        List<String> charac = Arrays.asList(sep);
        System.out.println(charac.toString());

        System.out.println(operandos.toString());
        System.out.println(parCierra.toString());
        System.out.println(parAbre.toString());

        try{
            for(String temp: charac){
                if(temp.equals("(")){
                    parAbre.add(temp);
                }else if(temp.equals(")")){
                    ;parCierra.add(temp);
                }else{
                    operandos.add(temp);
                }
            }

            System.out.println(operandos.toString());
            System.out.println(parCierra.toString());
            System.out.println(parAbre.toString());
        }catch(Exception ignored){

        }

        if(parCierra.size() != parAbre.size()){
            return "Hace falta un parentesis para completar la expresion.";
        }else{
            return null;
        }

    }
}

