import java.util.List;

public class EvalFuncion<E> {
    
    public void fEvaluar(List<E> instruccion){
        

        if(instruccion.contains("quote")) {
            new Evaluador<E>().quote(instruccion);
        }else if(instruccion.contains("setq")) {
            new Evaluador<E>().setq(instruccion);
        }
}
}
