
public class Calculadora {



    private boolean isOperator(char x)
    {
        return switch (x) {
            case '+', '-', '/', '*' -> true;
            default -> false;
        };
    }

    // Convert prefix to Postfix expression
    public String preToPost(String expresion)
    {
        expresion = expresion.replace(" ",",");
        Stack<String> stack = new StackVector<String>();

        int length = expresion.length();

        // De derecha a izquierda
        for (int i = length - 1; i >= 0; i--)
        {

            if (isOperator(expresion.charAt(i)))
            {

                String op1 = (!stack.Pop().equals(","))?stack.Pop() : stack.get((int) stack.size()-2);
                String op2 = (!stack.Pop().equals(","))?stack.Pop() : stack.get((int) stack.size()-2);


                String temp = op1+op2+expresion.charAt(i);
                stack.Push(temp);
            }
            // if symbol is an operand
            else {
                // push the operand to the stack
                if(expresion.charAt(i) == ',')
                    stack.Push(",");
                else
                    stack.Push(expresion.charAt(i) + "");
            }
        }


        // stack contains only the Postfix expression
        return stack.toString();

    }

    public String Calculo(String datos) {
        //Se crea Stack
        String expresion = preToPost(datos);
        Stack<Integer> stack = new StackVector<Integer>();
        int x = 0, y = 0;
        char[] ch = expresion.toCharArray();
        //for para realizar las operaciones
        for(char c: ch) {
            if(c >= '0' && c <= '9') {
                stack.Push((int)(c - '0'));
            } else {
                y = stack.Pop();
                x = stack.Pop();
                switch (c) {
                    case '+' -> stack.Push(x + y);
                    case '-' -> stack.Push(x - y);
                    case '*' -> stack.Push(x * y);
                    case '/' -> stack.Push(x / y);
                }
            }
        }
        return String.valueOf(stack.Pop());
    }




}
