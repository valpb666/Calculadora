/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.util.ArrayList;

/**
 *
 * @author valen
 */
public class Calculadora {
    
     public static boolean verificarExp(String expresion) {
        boolean resp = false;
        boolean parentesis = false;
        boolean operadores = false;

        parentesis = validaParentesis(expresion);
        operadores = validaOperadores(expresion);

        if (parentesis && operadores) {
            resp = true;
        }

        return resp;
    }

    private static boolean validaParentesis(String expresion) {
        boolean balanceado;
        int i = 0;
        balanceado = true;
        PilaADT<Character> pilaAux = new PilaA<>();
        char c;

        while (i < expresion.length() && balanceado) {
            c = expresion.charAt(i);

            if (c == '(') {
                pilaAux.push(c);
            } else if (c == ')') {
                if (pilaAux.isEmpty() || i == 0 || expresion.charAt(i - 1) == '(') {
                    balanceado = false;  // No hay '(' que le corresponde
                } else {
                    pilaAux.pop(); //Sacamos su '(' correspondiente
                }
            }
            i++;
        }

        return balanceado && pilaAux.isEmpty();
    }

    private static boolean validaOperadores(String expresion) {
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
                    if (!sumaRestaValido(expresion, i)) 
                        esValido = false;
                    
                    break;

                case '*':
                case '/':
                case '^':  // Potencia
                    if (!operadorValido(expresion, i, c == '/')) // Si es '/' se valida también la división entre 0 
                        esValido = false;
                  
                    break;

                case '?': // Signo para numero negativo 
                    if (!negativoValido(expresion, i)) 
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
    private static boolean puntoValido(String expresion, int pos) {
        boolean digitoIzquierda, digitoDerecha;

        digitoIzquierda = pos > 0 && Character.isDigit(expresion.charAt(pos - 1));
        digitoDerecha = pos < expresion.length() - 1 && Character.isDigit(expresion.charAt(pos + 1));

        return digitoIzquierda && digitoDerecha;
    }

    // Verifica que multiplicacion, division y potencia sean validos
    private static boolean operadorValido(String expresion, int pos, boolean esDivision) {
        // Verificar que haya un dígito o paréntesis a la izquierda y derecha del operador
        boolean validoIzq, validoDer;

        validoIzq = pos > 0 && (Character.isDigit(expresion.charAt(pos - 1)) || expresion.charAt(pos - 1) == ')');
        validoDer = pos < expresion.length() - 1 && (Character.isDigit(expresion.charAt(pos + 1)) || expresion.charAt(pos + 1) == '(' || expresion.charAt(pos + 1) == '?');

        // Si es una división, además de lo anterior, verificar si divide entre 0
        if (esDivision && pos < expresion.length() - 1) {
            int j = pos + 1;
            
            while (j < expresion.length() && (Character.isDigit(expresion.charAt(j)) || expresion.charAt(j) == '.' || expresion.charAt(j) == '?'))
                j++;

            if (expresion.charAt(j-1) == '0')
                validoDer = false;
        }
        
        return validoIzq && validoDer;
    }

    private static boolean negativoValido(String expresion, int pos) {
        boolean validaIzq, validaDer;

        validaIzq = pos == 0
                || expresion.charAt(pos - 1) == '/'
                || expresion.charAt(pos - 1) == '+'
                || expresion.charAt(pos - 1) == '-'
                || expresion.charAt(pos - 1) == '*'
                || expresion.charAt(pos - 1) == '^';

        validaDer = pos < expresion.length() - 1 && (Character.isDigit(expresion.charAt(pos + 1))
                || (expresion.charAt(pos + 1) == '.' && pos + 2 < expresion.length() && Character.isDigit(expresion.charAt(pos + 2))));

        return validaIzq && validaDer;
    }

    // Verifica que suma y resta sean válidos
    private static boolean sumaRestaValido(String expresion, int pos) {
        boolean validoIzq, validoDer;
        validoIzq = pos > 0 && (Character.isDigit(expresion.charAt(pos - 1)) || expresion.charAt(pos - 1) == ')');
        validoDer = pos < expresion.length() - 1 && (Character.isDigit(expresion.charAt(pos + 1))
                || expresion.charAt(pos + 1) == '(' || expresion.charAt(pos + 1) == '?');

        return validoDer && validoIzq;
    }
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
    private static int jerarquia(String operador) {
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

 /**
	     * Método auxiliar para revisar si el String es operador
	     *
	     * @param c String
	     * @return boolean <ul>
	     * <li> true: si es un operador "+","-","*","/","^"
	     * <li> false: si no es un operador
	     * <ul>
	     */

	    private static boolean checarOperador(String c) {
	        boolean resp = false;
	        if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^")) {
	            resp = true;
	        }
	        return resp;
	    }

	    /**
	     * Método auxiliar para revisar si el String es un paréntesis
	     *
	     * @param c String
	     * @return boolean <ul>
	     * <li> true: si el String es "(" o ")"
	     * <li> false: si el String no es "(" o ")"
	     * <ul>
	     */
	    private static boolean parentesis(String c) {
	        boolean resp = false;
	        if (c.equals("(") || c.equals(")")) {
	            resp = true;
	        }
	        return resp;
	    }

    /**
     * Método para convertir una expresión en String de infijo a postfijo
     *
     * @param infijo El ArrayList en el que está guardada la expresión en infijo
     * como escrita por el cliente
     * @return ArrayList de String: expresión convertida a postfijo
     * @see parentesis
     * @see checarOperador
     */

    public static ArrayList<String> conviertePostfijo(ArrayList<String> infijo) {
        PilaA<String> pila = new PilaA(100);  //Pila en donde guarda los operadores
        ArrayList<String> postfijo = new ArrayList(); //ArrayList del resultado
        String c;
        for (int i = 0; i < infijo.size(); i++) {
            c = infijo.get(i);
            if (checarOperador(c)) { //Si el char es un operador revisa la jerarquia de pila.peek() y saca o mete de la pila
                while (!pila.isEmpty() && jerarquia(pila.peek()) >= jerarquia(c)) {
                    postfijo.add(pila.pop());
                }
                pila.push(c);
            }
            if (!checarOperador(c) && !parentesis(c)) //Si no es operador o parentesis, agrega al ArrayList postfijo
            {
                postfijo.add(c);
            } else {
                if (c.equals("(")) //Agrega a la pila directo
                {
                    pila.push(c);
                }
                if (c.equals(")")) {
                    while (!pila.peek().equals("(")) //Saca todo de la pila hasta que no encuentre el parentesis abierto
                    {
                        postfijo.add(pila.pop());
                    }
                    pila.pop();
                }
            }
        } //Una vez que se termino de revisar el ArrayList infijo, vacia la pila de operadores
        while (!pila.isEmpty()) {
            postfijo.add(pila.pop());
        }
        return postfijo;
    }

    /**
     * Método para evaluar una expresión en postfijo
     * <pre>
     * Toma una expresión en postfijo y a través de pilas evalúa las operaciones
     * A través de un switch se identifica al operador y asigna la operación a realizar correspondiente
     * La única operación restringida es la división por cero a través de una bandera
     * <pre>
     * @param postfijo ArrayList de la expresión infija convertida a posfija
     * @return Double: resultado final de la operación ingresada por el usuario
     * @see checarOperador
     */

    public static double evaluaPostfijo(ArrayList<String> postfijo) {

        PilaA<Double> pila = new PilaA(100);
        double n1,n2;
        int i = 0;
        boolean bandera = true;
        String c;
        while (i < postfijo.size() && bandera) {
            c = postfijo.get(i);
            if (!checarOperador(c)) {
                pila.push(Double.parseDouble(c));
            } else {
                n1 = pila.pop();
                n2 = pila.pop();
                switch (c) {
                    case "+":
                        pila.push(n1 + n2);
                        break;
                    case "-":
                        pila.push(n2 - n1);
                        break;
                    case "/":
                        if (n1 == 0) {
                            throw new RuntimeException("SyntaxERROR");
                        } else {
                            pila.push(n2 / n1);
                        }
                        break;
                    case "^":
                        pila.push(Math.pow(n2, n1));
                        break;
                    default:
                        pila.push(n1 * n2);
                        break;
                }
            }
            i++;
        }
        return pila.pop();
    }  
}
