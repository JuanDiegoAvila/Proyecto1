/**
 * clase generica que contiene todas las operaciones necesarias para manejar luego el StackVector.
 * @author Esteban Aldana Guerra 20591
 * @author Juan Diego Avila Sagastume
 * @author Jun Woo Lee Hong 
 * **/
public interface Stack<T> {

    /**
     * Metodo de tipo boolean que regresa true si esta vacio y false si tiene algun valor.
     * **/
    public boolean Empty();

    /**
     * Metodo que regresa el tamaño del Stack Vector.
     * **/
    public int size();

    /**
     * Metodo que elimina el ultimo valor que se encuentra en el Stack y regresa dicho valor.
     * **/
    public T Pop();

    /**
     * Metodo que agrega un elemento en la ultima posicion del Stack.
     * **/
    public void Push(T num);

    /**
     * Metodo que regresa el valor del primer elemento del Stack.
     * **/
    public T Peek();

    public T get(int i);
    public void removeLast();
}