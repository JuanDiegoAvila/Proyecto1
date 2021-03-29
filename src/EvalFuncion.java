import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EvalFuncion<E> {

    public void fEvaluar(List<E> instruccion){
        List<E> list;
            
        if (instruccion.contains("-") || instruccion.contains("/") || instruccion.contains("*") || instruccion.contains("+")){
            	
            Calculadora cal = new Calculadora();
            //Realizar lo de Calculadora
            //break;

        } else if (instruccion.contains("list")){
            	
            list = new Evaluador<E>().list(instruccion.subList(1, instruccion.size()));
            System.out.println("Lista Creada: " +list);
            
        } else if (instruccion.contains("equal")){
            
            if( (new Evaluador<E>()).equals(instruccion.get(1), instruccion.get(2))){
                System.out.print("Resultado: , " + instruccion.get(1) + " es igual que " + instruccion.get(2));
            }
            else{
                System.out.print("Resultado: , " + instruccion.get(1) + " No es igual que " + instruccion.get(2));
            }
        }
            else if (instruccion.contains(">")){
            	
                if( (new Evaluador<E>()).Mayor(instruccion.get(1), instruccion.get(2))){
                    System.out.print("Resultado: , " + instruccion.get(1) + " es mayor que " + instruccion.get(2));
                }
                else{
                    System.out.print("Resultado: " + instruccion.get(1) + " No es mayor que " + instruccion.get(2));
                }
                
            } else if (instruccion.contains("<")){
            	
                if( (new Evaluador<E>()).Menor(instruccion.get(1), instruccion.get(2))){
                    System.out.print("Resultado: " + instruccion.get(1) + " es menor que " + instruccion.get(2));
                }
                else{
                    System.out.print("Resultado: " + instruccion.get(1) + " No es menor que " + instruccion.get(2));
                }
        }else if (instruccion.contains("cond")){
            new Evaluador<E>().cond(instruccion);
        }
        else if(instruccion.contains("quote") || instruccion.contains("'")) {
            new Evaluador<E>().quote(instruccion);
        }else if(instruccion.contains("setq")) {
            new Evaluador<E>().setq(instruccion);
        }else if(instruccion.contains("defun")) {
            //enviar el nombre, las variables y las instrucciones.
        }else if(instruccion.contains("ATOM") || instruccion.contains("atom")){
            String atom = new Evaluador<E>().atom(instruccion) ? "True": "False";
            System.out.println(atom);

        }
    }
}


    


