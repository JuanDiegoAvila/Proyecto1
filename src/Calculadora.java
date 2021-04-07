import java.util.Arrays;
import java.util.List;

/**
 * @author Esteban Aldana Guerra 20591
 * @author Juan Diego Avila Sagastume
 * @author Jun Woo Lee Hong 
 */
public class Calculadora {

    private boolean isOperator(String x)
    {
        return switch (x) {
            case "+", "-", "/", "*" -> true;
            default -> false;
        };
    }

    // Convert prefix to Postfix expression
    public String preToPost(String expresion)
    {

        Stack<String> stack = new StackVector<String>();
        List<String> lista = Arrays.asList(expresion.split(","));

        // De derecha a izquierda
        for (int i = lista.size() - 1; i >= 0; i--)
        {

            if (isOperator(lista.get(i)))
            {

                String op1 = stack.Pop();
                String op2 = stack.Pop();

                String temp = op1+" "+op2+" "+lista.get(i);
                stack.Push(temp);
            }
            // if symbol is an operand
            else {
                // push the operand to the stack
                stack.Push(lista.get(i) + " ");
            }
        }
        // stack contains only the Postfix expression
        return stack.toString();

    }

    public String Calculo(StringBuilder datos) {
        //Se crea Stack
        String expresion = preToPost(datos.toString());
        Stack<Double> stack = new StackVector<Double>();
        List<String> lista = Arrays.asList(expresion.split("  "));
        Double x = 0.0, y = 0.0;
        //for para realizar las operaciones
        for(String c: lista) {
            try{
                Double numero = Double.parseDouble(c);
                stack.Push(numero);
            }catch(Exception e){
                y = stack.Pop();
                x = stack.Pop();
                switch (c) {
                    case "+" -> stack.Push(x + y);
                    case "-" -> stack.Push(x - y);
                    case "*" -> stack.Push(x * y);
                    case "/" -> stack.Push(x / y);
                }
            }
        }
        return String.valueOf(stack.Pop());
    }




}
