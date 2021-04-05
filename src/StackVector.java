import java.util.*;

/**
 * @author Esteban Aldana Guerra 20591
 * @author Juan Diego Avila Sagastume
 * @author Jun Woo Lee Hong 
 * StackVector<T>, clase generica que implementa la clase Stack<T> y que utiliza las operaciones del tipo vector para almacenar los datos.
 * **/
public class StackVector<T> implements Stack<T>{

    public Vector<T> vector;

    public StackVector(){
        vector = new Vector<T>();
    }

    //regresa true si esta vacio y false si esta lleno
    public boolean Empty(){
        return vector.isEmpty();
    }

    //regresa la cantidad de elementos en el vector.
    public int size(){
        return vector.size();
    }

    //regresa el ultimo valor del stack.
    public T Pop(){
        //busca el ultimo elemento del vector.
        T valor = vector.get(vector.indexOf(vector.lastElement()));
        vector.remove(valor);
        return valor;
    }

    //agrega el num al final del stack
    public void Push(T num){
        vector.addElement(num);
    }

    //regresa el valor que esta al inicio del stack.
    public T Peek(){

        return vector.get(vector.indexOf(vector.firstElement()));
    }

    public T get(int pos){ vector.removeElementAt(pos+1) ; return vector.get(pos); }
    public void removeLast(){ vector.removeElementAt(vector.indexOf(vector.lastElement())); }

    @Override
    public String toString(){
        String vec = "";
        for(int i = 0; i<size(); i++)
            vec += this.vector.get(i)+"";
        return vec;
    }


}
