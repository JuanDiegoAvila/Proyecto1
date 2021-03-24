import java.util.List;

public class EvalFuncion<E> {
    List<E> list;
    public void fEvaluar(List<E> instruccion){
        
        if (instruccion.contains("-") || instruccion.contains("/") || instruccion.contains("*") || instruccion.contains("+")){
            	
            Calculadora cal = new Calculadora();
            //Realizar lo de Calculadora
            //break;
        } else if (instruccion.contains("list")){
            	
            list = new Evaluador<E>().list(instruccion.subList(1, instruccion.size()));
            System.out.println("Lista Creada: " +list);
            
        } else if (instruccion.contains("equal")){
            
            if( (new Evaluador<E>()).equals(instruccion.get(1), instruccion.get(2))){
                System.out.print("Resultado: Verdadero, " + instruccion.get(1) + " es igual que " + instruccion.get(2));
            }
            else{
                System.out.print("Resultado: Falso, " + instruccion.get(1) + " No es igual que " + instruccion.get(2));
            }
        }
        else if(instruccion.contains("quote")) {
            new Evaluador<E>().quote(instruccion);
        }else if(instruccion.contains("setq")) {
            new Evaluador<E>().setq(instruccion);
        }
}
}
