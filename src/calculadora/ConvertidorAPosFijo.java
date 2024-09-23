/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadoramatematica;

/**
 *
 * @author Alejandro Castillo
 */
public class ConvertidorAPostFijo {

    public String convierteAPostFijo(String cadenaInFijo){
        PilaADT<Character> operadores = new PilaA<>();
        StringBuilder postfijo = new StringBuilder();
        int i = 0;
        boolean yaHayUnPunto = false;
        int jerarquia = 0;
        
        while (i < cadenaInFijo.length() - 1){
            if(Character.isDigit(cadenaInFijo.charAt(i)) && (Character.isDigit(cadenaInFijo.charAt(i+1)) || ".%".indexOf(cadenaInFijo.charAt(i+1)) != -1)){
                postfijo.append(cadenaInFijo.charAt(i));
            } else if(Character.isDigit(cadenaInFijo.charAt(i)) && "+-*/^()".indexOf(cadenaInFijo.charAt(i+1)) != -1){
                postfijo.append(cadenaInFijo.charAt(i) + "_");
            } else if(cadenaInFijo.charAt(i) == '.' && !yaHayUnPunto){
                postfijo.append(cadenaInFijo.charAt(i));
                yaHayUnPunto = true;
            } else if(cadenaInFijo.charAt(i) == '%'){
                postfijo.append(cadenaInFijo.charAt(i));
            } else if("+-*/^".indexOf(cadenaInFijo.charAt(i)) != -1 && (Character.isDigit(cadenaInFijo.charAt(i-1)) || cadenaInFijo.charAt(i-1) == ')')){
                yaHayUnPunto = false; // Resetea la bandera de punto decimal
                switch(cadenaInFijo.charAt(i)){
                    
                    case '+':
                       if(jerarquia < 1){
                            operadores.push(cadenaInFijo.charAt(i));                  
                       } else {
                          if(!operadores.isEmpty()){
                            while(!operadores.isEmpty() && operadores.peek() != '+' && operadores.peek() != '-' && operadores.peek() != '(')
                                 postfijo.append(operadores.pop());
                             operadores.push(cadenaInFijo.charAt(i));          
                           } else operadores.push(cadenaInFijo.charAt(i));               
                       }
                       jerarquia = 1;
                    break;
                    
                    case '-':
                       if(jerarquia < 1){
                            operadores.push(cadenaInFijo.charAt(i));                  
                       } else {
                          if(!operadores.isEmpty()){
                            while(!operadores.isEmpty() && operadores.peek() != '+' && operadores.peek() != '-' && operadores.peek() != '(')
                                 postfijo.append(operadores.pop());
                             operadores.push(cadenaInFijo.charAt(i));          
                           } else operadores.push(cadenaInFijo.charAt(i));               
                       }
                       jerarquia = 1;
                    break;
                    
                    case '*':
                       if(jerarquia < 2){
                            operadores.push(cadenaInFijo.charAt(i));                 
                       } else {
                           if(!operadores.isEmpty()){
                            while(!operadores.isEmpty() && operadores.peek() != '*' && operadores.peek() != '/' && operadores.peek() != '(')
                                 postfijo.append(operadores.pop());
                             operadores.push(cadenaInFijo.charAt(i));          
                           } else operadores.push(cadenaInFijo.charAt(i));                  
                       }
                       jerarquia = 2;
                    break;
                    
                    case '/':
                       if(jerarquia < 2){
                            operadores.push(cadenaInFijo.charAt(i));                 
                       } else {
                           if(!operadores.isEmpty()){
                            while(!operadores.isEmpty() && operadores.peek() != '*' && operadores.peek() != '/' && operadores.peek() != '(')
                                 postfijo.append(operadores.pop());
                             operadores.push(cadenaInFijo.charAt(i));          
                           } else operadores.push(cadenaInFijo.charAt(i));                  
                       }
                       jerarquia = 2;
                    break;
                    
                    case '^':
                        if(jerarquia < 3){
                            operadores.push(cadenaInFijo.charAt(i));                 
                       } else {
                           if(!operadores.isEmpty()){
                            while(!operadores.isEmpty() && operadores.peek() != '^' && operadores.peek() != '(')
                                 postfijo.append(operadores.pop());
                             operadores.push(cadenaInFijo.charAt(i));          
                           } else operadores.push(cadenaInFijo.charAt(i));                  
                       }
                       jerarquia = 3;

                    break;

                }
                
            } else if("()".indexOf(cadenaInFijo.charAt(i)) != -1){
                    switch(cadenaInFijo.charAt(i)){

                        case '(':
                            operadores.push(cadenaInFijo.charAt(i));
                            jerarquia = 0;
                        break;

                        case ')':
                            while(operadores.peek() != '('){
                                postfijo.append(operadores.pop());
                            }
                            operadores.pop();
                            if(operadores.isEmpty())
                                jerarquia = 0;
                            else if(operadores.peek() == '+' || operadores.peek() == '-')
                                jerarquia = 1;
                            else if(operadores.peek() == '*' || operadores.peek() == '/')
                                jerarquia = 2;
                            else if(operadores.peek() == '^')
                                jerarquia = 3;                        
                            else if(operadores.peek() == '(')
                                jerarquia = 0;
                        break;
                    }
            }
        i++;
        }
        while(!operadores.isEmpty()){
            if(operadores.peek() != '(')
                postfijo.append(operadores.pop());
            else
                operadores.pop();
        }
    return postfijo.toString();
    }
    
    public static void main(String[] args) {
        ConvertidorAPosFijo convertidor = new ConvertidorAPosFijo();
        
        String infijo1 = "3*4+2"; // Cadena infix a convertir a postfix
        String postfijo1 = convertidor.convierteAPostFijo(infijo1);
        System.out.println("Infijo: " + infijo1);
        System.out.println("Postfijo: " + postfijo1);
        
        String infijo2 = "(%3+4)^2-1"; // Cadena infix a convertir a postfix
        String postfijo2 = convertidor.convierteAPostFijo(infijo2);
        System.out.println("Infijo: " + infijo2);
        System.out.println("Postfijo: " + postfijo2);
        
        
    }
}
