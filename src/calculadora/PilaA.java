/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 *
 * @author valen
 * @param <T>
 */
public class PilaA<T> implements PilaADT<T>{
    private T[] datos;
    private int tope;
    private final int MAX=10;
    
    public PilaA(){
        datos = (T[]) new Object[MAX];
        tope = -1; //Posición del último elemento de la pila, en este caso inicializa una pila vacía
    }
    public PilaA (int max){
        datos = (T[]) new Object[max];
        tope = -1;
    }

    @Override
    public void push(T dato) {
        if(tope == datos.length-1) //Verifica si la pila está llena
            expande();
        tope++;
        datos[tope]=dato;
    }
    
    private void expande(){
        T[] expandido = (T[]) new Object [datos.length*2];
        
        for (int i=0; i<=tope; i++)
            expandido[i]=datos[i];
        datos = expandido;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new RuntimeException("La pila está vacía");
        T eliminado = datos [tope];
        datos[tope]= null;
        tope--;
        return eliminado;
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new RuntimeException("La pila está vacía");
        return datos[tope];
    }
    
    @Override
    public String toString(){
       StringBuilder sB= new StringBuilder();
       for(int i=0; i<=tope; i++)
           sB.append(datos[i]).append(" ");
       return sB.toString();
    }

    @Override
    public void multiPop(int n) {
        if (isEmpty())
            throw new RuntimeException("La pila esta vacía");
        if (n<=0)
            throw new RuntimeException("No se pueden eliminar cero elementos o elementos negativos");
        if (n-1>tope)
            throw new RuntimeException("La pila no tiene suficientes elementos para eliminar");
        for(int i=0;i<n;i++){
            datos[tope]=null;
            tope--;
        }
            
    }
    
}