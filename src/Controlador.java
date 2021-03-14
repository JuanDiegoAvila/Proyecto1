import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controlador {

    HashMap<String,String> LISP = new HashMap<String,String>();

    public Controlador(){

    }
    //lee y analiza codigo.
    public void Expresion(String LispExpresion){
        List<String> exp = new ArrayList<String>();

        for(int i = 0; i<LispExpresion.length();i++){
            exp.add(LispExpresion.charAt(i)+"");
        }

        System.out.println(LispExpresion);

        if((exp.get(0)).equals("(") && (exp.get(exp.size()-1)).equals(")")){
            //la expresion es valida.
            exp.remove(0);

            boolean salir = false;
            boolean inicial = false;

            String expresion = "";
            String palabra = "";


            while(!salir) {
                for (int c = 0; c < LispExpresion.length(); c++) {
                    if(!inicial){
                        if (LispExpresion.charAt(c) != ' ')
                            palabra += LispExpresion.charAt(c) + "";
                        else
                            inicial = true;

                    }else
                        expresion += LispExpresion.charAt(c)+"";


                    if ((LispExpresion.charAt(c) == ')') && (c == LispExpresion.length() - 1)){
                        LISP.put(palabra,expresion);
                        salir = true;
                    }

                }
            }

            for(HashMap.Entry<String, String> entry : LISP.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                System.out.println("Key:"+ key +"\nValue: "+value );

                // do what you have to do here
                // In your case, another loop.
            }
        }else{
            //la expresion no es valida.
            System.out.println("La expresion debe estar encerrada en parentesis! ");
        }
    }
}
