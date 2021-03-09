
public class Calculadora {



    private boolean isOperator(char x)
    {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    // Convert prefix to Postfix expression
    private String preToPost(String expresion)
    {

        Stack<String> s = new StackVector<String>();


        int length = expresion.length();

        // De derecha a izquierda
        for (int i = length - 1; i >= 0; i--)
        {

            if (isOperator(expresion.charAt(i)))
            {

                String op1 = s.Pop();
                String op2 = s.Pop();

                String temp = op1 + op2 + expresion.charAt(i);

                s.Push(temp);
            }
            // if symbol is an operand
            else {
                // push the operand to the stack
                s.Push(expresion.charAt(i) + "");
            }
        }


        // stack contains only the Postfix expression
        return s.Peek();

    }

    public String Calculo(String datos) {
        //Se crea Stack
        String expresion = preToPost(datos);
        Stack<Integer> stack = new StackVector<Integer>();
        int x = 0, y = 0;
        char ch[] = expresion.toCharArray();
        //for para realizar las operaciones
        for(char c: ch) {
            if(c >= '0' && c <= '9') {
                stack.Push((int)(c - '0'));
            } else {
                y = stack.Pop();
                x = stack.Pop();
                switch(c) {
                    case '+':
                        stack.Push(x+y);
                        break;
                    case '-':
                        stack.Push(x-y);
                        break;
                    case '*':
                        stack.Push(x*y);
                        break;
                    case '/':
                        stack.Push(x/y);
                        break;
                }
            }
        }
        return String.valueOf(stack.Pop());
    }




}
