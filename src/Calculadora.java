
public class Calculadora {



    private Boolean isOperator(char c){
        //si el caracter es un digito, es un operando.
        switch(c){
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }

    public double Calculo(String expresion){
        Stack<Double> Stack = new StackVector<Double>();

        int length = expresion.length();

        for(int j = length -1; j >= 0; j--){
            char c = expresion.charAt(i);
            if(isOperand(c))
                //es operando por lo que se hace push de la expresion
                Stack.Push((double)(expresion.charAt(j) - 48));
            else{
                // Se encontro un operando
                // Pop de los primeros dos elentos del stack
                double o1 = Stack.Pop();
                double o2 = Stack.Pop();

                // Use switch case to operate on o1
                // and o2 and perform o1 O o2.
                switch (expresion.charAt(j)) {
                    case '+':
                        Stack.Push(o1 + o2);
                        break;
                    case '-':
                        Stack.Push(o1 - o2);
                        break;
                    case '*':
                        Stack.Push(o1 * o2);
                        break;
                    case '/':
                        Stack.Push(o1 / o2);
                        break;
                }
            }
        }

        return Stack.Peek();

    }




}
