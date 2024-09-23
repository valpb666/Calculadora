/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

/**
 *
 * @author valen
 */
public class Calculadora {
    public boolean verificarExp (String expresion) {
        boolean resp = false; 
        boolean parentesis = false;
        boolean operadores = false;
        
        parentesis = validaParentesis(expresion);
        operadores = validaOperadores(expresion);
        
        if(parentesis && operadores)
            resp = true;
        
        return resp;
    } 
    
    private boolean validaParentesis (String expresion) {
        boolean balanceado;
        int i = 0;
        balanceado = true;
        PilaADT<Character> pilaAux = new PilaA<>();
        char c;
                
        while (i < expresion.length() && balanceado) {
            c = expresion.charAt(i);
            
            if (c == '(' )
                pilaAux.push(c);
            else if ( c == ')' )
                if (pilaAux.isEmpty() || i == 0 || expresion.charAt(i - 1) == '(') 
                    balanceado = false;  // No hay '(' que le corresponde
                else
                    pilaAux.pop(); //Sacamos su '(' correspondiente
            
            i++;
        }
        
       return balanceado && pilaAux.isEmpty();
    }
    
    private boolean validaOperadores (String expresion) {
        boolean esValido = true;
        int i = 0;
    
        while (i < expresion.length() && esValido) {
            char c = expresion.charAt(i);
        
            switch (c) {
                case '.':  // Punto decimal
                    if (!puntoValido(expresion, i)) 
                        esValido = false;
                
                    break;
                
                case '+':
                case '-':
                    if(!sumaRestaValido(expresion, i))
                        esValido = false;
                    break;
                    
                case '*':
                case '/':
                case '#':  // Potencia
                    if (!operadorValido(expresion, i, c == '/'))   // Si es '/' se valida también la división entre 0
                        esValido = false;
                    break;
                
                default:
                    break;
            }
        
            i++;
        }
    return esValido;
}

// Verifica que el punto decimal esté rodeado por dígitos
    private boolean puntoValido(String expresion, int pos) {
        boolean digitoIzquierda, digitoDerecha;
    
        digitoIzquierda = pos > 0 && Character.isDigit(expresion.charAt(pos - 1)); 
        digitoDerecha = pos < expresion.length() - 1 && Character.isDigit(expresion.charAt(pos + 1));
    
        return digitoIzquierda && digitoDerecha;
    }
    
    // Verifica que multiplicacion, division y potencia sean validos
    private boolean operadorValido(String expresion, int pos, boolean esDivision) {
        // Verificar que haya un dígito o paréntesis a la izquierda y derecha del operador
        boolean validoIzq, validoDer;
     
        
        validoIzq = pos > 0 && (Character.isDigit(expresion.charAt(pos - 1)) || expresion.charAt(pos - 1) == ')');
       
        validoDer = pos < expresion.length() - 1 && (Character.isDigit(expresion.charAt(pos + 1)) || expresion.charAt(pos + 1) == '(' );
        
        // Si es una división, además de lo anterior, verificar si divide entre 0
        if (esDivision)   
            if (pos < expresion.length() - 1 && expresion.charAt(pos + 1) == '0') 
                // Verificar si después del 0 hay un punto decimal o más dígitos
                validoDer = pos + 2 < expresion.length() && (expresion.charAt(pos + 2) == '.' || Character.isDigit(expresion.charAt(pos + 2))); // División entre 0
                           
        return validoIzq && validoDer;
    }
    
    //Verifica que suma y resta sean validos
    private boolean sumaRestaValido (String expresion, int pos) {
        boolean validoIzq, validoDer;
        validoIzq = pos > 0 && (Character.isDigit(expresion.charAt(pos - 1)) || expresion.charAt(pos - 1) == ')');
        validoDer  = pos < expresion.length() - 1 && (Character.isDigit(expresion.charAt(pos + 1)) || expresion.charAt(pos + 1) == '(' || expresion.charAt(pos + 1) == '?');
        
        return validoDer && validoIzq;
    }
    
    /*
    // Verifica que multiplicacion, division y potencia sean validos
    private boolean operadorValido1(String expresion, int pos, boolean esDivision) {
        // Verificar que haya un dígito o paréntesis a la izquierda y derecha del operador
        boolean validoIzq, validoDer;
     
        validoIzq = pos > 0 && (Character.isDigit(expresion.charAt(pos - 1)) || expresion.charAt(pos - 1) == ')');
       
        validoDer = pos < expresion.length() - 1 && (Character.isDigit(expresion.charAt(pos + 1)) || expresion.charAt(pos + 1) == '(' );
    
        // Si es una división, además de lo anterior, verificar si divide entre 0
        if (esDivision)  
            if (pos < expresion.length() - 1 && expresion.charAt(pos + 1) == '0'){
                // Verificar si después del 0 hay un punto decimal o más dígito
                if(pos + 2 < expresion.length()){
                    validoDer=(expresion.charAt(pos + 2) == '.' && pos+2<expresion.length()-1 && Character.isDigit(expresion.charAt(pos + 3))&& expresion.charAt(pos + 3)!='0') || Character.isDigit(expresion.charAt(pos + 2));
                    if(!validoDer && pos+2<expresion.length()-1 && Character.isDigit(expresion.charAt(pos + 3))){
                        int i=pos+3;
                        char elemento=expresion.charAt(i);
                        while(elemento=='0' && i<expresion.length()){
                            if(Character.isDigit(elemento))
                                validoDer=true;
                            i++;
                            if(i<expresion.length())
                                elemento=expresion.charAt(i);
                        }
                    }
                }
            }
                           
        return validoIzq && validoDer;
    }
    
    */
    /**
     * Método auxiliar para asignar el valor de los operadores y obtener una
     * jerarquía
     * <pre>
     * Utiliza un switch para identificar el tipo de operador
     * Cada caso asigna un valor distinto de acuerdo a la jerarquía de las operaciones
     * <pre>
     * @param operador String
     * @return int valor asignado al operador
     */
    
    private int jerarquia(String operador) {
        int jerarquia = 0;
        switch (operador) {
            case "*": //Tanto la multiplicacion como la división son de la misma jerarquía 
                jerarquia = 3;
                break;
            case "/":
                jerarquia = 3;
                break;
            case "+": //La suma y la resta son de la misma jerarquía
                jerarquia = 2;
                break;
            case "-":
                jerarquia = 2;
                break;
            case "^": //La potencia tiene la máxima jerarquía después del paréntesis
                jerarquia = 4;
                break;
            case "(": //Menor jerarquía para que lo saque al momento de encontrar su contraparte
                jerarquia = 1;
                break;
            default:
                jerarquia = 0;
                break;
        }
        return jerarquia;
    }
    
    private double evaluarExp(PilaADT<String> postfijo){ //Estamos asumiendo que la pila esta volteada, es decir si tenemos a*b asumimos que el postfijo esta así: * b a
        PilaADT<Double> pila = new PilaA<>();
        
        while(!postfijo.isEmpty()){
            String elemento = postfijo.pop();
            
            try {
                double numero=Double.parseDouble(elemento);
                pila.push(numero);
            } catch(NumberFormatException e){
                //checar negativos
                switch(elemento){
                    case "+" -> {
                        double digito1,digito2;
                        digito1=pila.pop();
                        digito2=pila.pop();
                        pila.push(digito1+digito2);
                        break;
                    }
                    case "-" -> {
                        double digito1 = pila.pop();
                        double digito2 = pila.pop();
                        pila.push(digito2-digito1);
                        break;
                    }
                    case "*" -> {
                        double digito1 = pila.pop();
                        double digito2 = pila.pop();
                        pila.push(digito1*digito2);
                        break;
                    }
                    case "/" -> {
                        double digito1 = pila.pop();
                        double digito2 = pila.pop();
                        pila.push(digito2/digito1);
                        break;
                    }
                    case "^" -> {
                        double digito1 = pila.pop();
                        double digito2 = pila.pop();
                        pila.push(Math.pow(digito2, digito1));
                        break;
                    }
                    default -> {
                        break;
                    }
                }
            }
        }
        
        return pila.peek();
    }
    
}
