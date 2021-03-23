import java.io.File;
import java.util.*;

public class Lector {

    HashMap<String,String> var = new HashMap<String,String>();


    public String[] tokenizar(String linea){
        return linea.split("[\\s,]*(~@|[\\[\\]{}()'`~^@]|\"(?:\\\\.|[^\\\\\"])*\"?|;.*|[^\\s\\[\\]{}('\"`,;)]*)");
    }

    public String LISP(String path){
        String resultado = "";
        try {
            Scanner input = new Scanner(new File(path));
            int cont = 0;
            while (input.hasNextLine()) {
                Read(input.nextLine());
            }
        }catch (Exception ignored){

        }

        return resultado;
    }

    public void Read(String LispExpresion){

        LispExpresion = LispExpresion.trim();
        LispExpresion = LispExpresion.replaceAll("\\s{2,}", " ");
        List<String> exp = new ArrayList<String>();

        for(int i = 0; i<LispExpresion.length();i++){
            exp.add(LispExpresion.charAt(i)+"");
        }
        //System.out.println("Expresion: " + LispExpresion);
        //la expresion es valida.

        System.out.println("Exp: " + exp + "\n");

        boolean salir = false;
        boolean llave = false;
        String expresion = "";
        String palabra = "";


        while(!salir) {
            for (int c = 0; c < LispExpresion.length(); c++) {
                if(!llave){
                    if (LispExpresion.charAt(c) != ' ')
                        palabra += LispExpresion.charAt(c) + "";
                    else
                        llave = true;

                }else
                    expresion += LispExpresion.charAt(c)+"";


                if ((c == LispExpresion.length()-1)){
                    var.put(palabra,expresion);
                    salir = true;
                }

            }
        }
        System.out.println(var);

    }
}

