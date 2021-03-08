public class Calculadora {
    public String Calculo(String expresion){

        int resultado = 0;

        //separa el String recibido para poder utilizar las dos variables y el operador.
        String[] op = expresion.split(",");
        int var1 = Integer.parseInt(op[0]);
        int var2 = Integer.parseInt(op[2]);

        //en la posicion 1 se encuentre el operador por lo que se define la operacion segun su valor.
        switch(op[1]){
            case "+":
                resultado = var1 + var2;
                break;

            case "-":
                resultado = var1 - var2;
                break;

            case "*":
                resultado = var1 * var2;
                break;

            case "/":
                resultado = var1 / var2;
                break;
        }
        return ""+resultado;
    }
}
