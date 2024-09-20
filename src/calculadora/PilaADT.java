/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package calculadora;

/**
 *
 * @author valen
 * @param <T> // Lo pongo para indicar que voy usar ese genérico en la interface
 */
public interface PilaADT <T>{
    public void push(T dato); // necesario o no
    public T pop();
    public boolean isEmpty();
    public T peek();
    public void multiPop(int n);
    
}

