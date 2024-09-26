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
/**
 * Verifica la validez de una expresión basada en dos criterios:
 * 1. La expresión tiene paréntesis correctamente balanceados.
 * 2. La expresión contiene operadores válidos.
 * 
 * Este método llama a dos métodos auxiliares:
 * {@link #validaParentesis(String)} - verifica si los paréntesis en la expresión están balanceados.
 * {@link #validaOperadores(String)} - verifica si los operadores en la expresión son válidos.
 * 
 * @param expresion La representación en cadena de la expresión a verificar.
 * @return {@code true} si la expresión tiene paréntesis balanceados y operadores válidos,
 *         de lo contrario, {@code false}.
 */
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
/**
 * Verifica si los paréntesis en una expresión están correctamente balanceados.
 * 
 * Este método utiliza una pila auxiliar para asegurarse de que cada paréntesis 
 * de apertura '(' tenga un paréntesis de cierre ')' correspondiente en el orden correcto.
 * 
 * Reglas:
 * - Cada paréntesis de apertura debe tener un cierre correspondiente.
 * - No puede haber un paréntesis de cierre sin un paréntesis de apertura anterior.
 * - Los paréntesis no pueden estar desequilibrados (más de un tipo sin su contraparte).
 * 
 * @param expresion La expresión a analizar, representada como una cadena de caracteres.
 * @return {@code true} si los paréntesis están correctamente balanceados, 
 *         {@code false} en caso contrario.
 */
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

/**
 * Verifica si los operadores en una expresión son válidos.
 * 
 * Este método evalúa los operadores aritméticos y otros símbolos en la expresión para asegurar que:
 * - Los operadores aritméticos (+, -, *, /, ^) estén correctamente ubicados y utilizados.
 * - El punto decimal (.) esté colocado de manera válida en los números.
 * - El signo de número negativo (?) esté correctamente posicionado.
 * - En el caso de la división (/), verifica que no se intente dividir entre 0.
 * 
 * Este método utiliza tres funciones auxiliares:
 * {@link #puntoValido(String, int)} - verifica si el punto decimal está correctamente posicionado.
 * {@link #operadorValido(String, int, boolean)} - verifica si un operador aritmético está bien colocado.
 * {@link #negativoValido(String, int)} - verifica si el signo para un número negativo está bien utilizado.
 * 
 * @param expresion La expresión a analizar, representada como una cadena de caracteres.
 * @return {@code true} si los operadores son válidos, {@code false} en caso contrario.
 */
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

/**
 * Verifica si el punto decimal ('.') está correctamente colocado dentro de la expresión.
 * 
 * El punto decimal es válido si está rodeado por dígitos numéricos a ambos lados:
 * - Debe haber un dígito antes del punto.
 * - Debe haber un dígito después del punto.
 * 
 * @param expresion La expresión que contiene el punto decimal, representada como una cadena de caracteres.
 * @param pos La posición del punto en la cadena de la expresión.
 * @return {@code true} si el punto está correctamente ubicado entre dígitos, 
 *         {@code false} si no hay un dígito a la izquierda o a la derecha del punto.
 */
    private static boolean puntoValido(String expresion, int pos) {
        boolean digitoIzquierda, digitoDerecha;

        digitoIzquierda = pos > 0 && Character.isDigit(expresion.charAt(pos - 1));
        digitoDerecha = pos < expresion.length() - 1 && Character.isDigit(expresion.charAt(pos + 1));

        return digitoIzquierda && digitoDerecha;
    }

/**
 * Verifica si un operador aritmético está correctamente ubicado dentro de la expresión.
 * 
 * Para que un operador sea válido:
 * - Debe haber un dígito o un paréntesis de cierre ')' a la izquierda del operador.
 * - Debe haber un dígito, un paréntesis de apertura '(', o un signo para número negativo '?' a la derecha del operador.
 * 
 * Si el operador es una división ('/'), además se verifica que no divida entre 0:
 * - Acepta divisiones con números cercanos a 0, como 5/0.00029.
 * - No permite divisiones que resulten en un divisor igual a 0.
 * 
 * @param expresion La expresión que contiene el operador, representada como una cadena de caracteres.
 * @param pos La posición del operador en la cadena de la expresión.
 * @param esDivision Indica si el operador es una división ('/'). Si es {@code true}, 
 *        se realizará una verificación adicional para evitar divisiones entre 0.
 * @return {@code true} si el operador está correctamente ubicado, 
 *         {@code false} si no cumple con las reglas de validez.
 */
    private static boolean operadorValido(String expresion, int pos, boolean esDivision) {
        // Verificar que haya un dígito o paréntesis a la izquierda y derecha del operador
        boolean validoIzq, validoDer;

        validoIzq = pos > 0 && (Character.isDigit(expresion.charAt(pos - 1)) || expresion.charAt(pos - 1) == ')');
        validoDer = pos < expresion.length() - 1 && (Character.isDigit(expresion.charAt(pos + 1)) || expresion.charAt(pos + 1) == '(' || expresion.charAt(pos + 1) == '?');

        // Si es una división, además de lo anterior, verificar si divide entre 0. Tener en cuenta casos donde directamente este dividendo con 0, pero aceptar casos como 5/0.00029
        if (esDivision && pos < expresion.length() - 1) {
            int j = pos + 1;
            
            while (j < expresion.length() && (Character.isDigit(expresion.charAt(j)) || expresion.charAt(j) == '.' || expresion.charAt(j) == '?'))
                j++;

            if (expresion.charAt(j-1) == '0')
                validoDer = false;
        }
        
        return validoIzq && validoDer;
    }
/**
 * Verifica si el signo de número negativo ('?') está correctamente ubicado dentro de la expresión.
 * 
 * Un signo de número negativo es válido si:
 * - Está al inicio de la expresión o precedido por un operador aritmético (+, -, *, /, ^).
 * - Está seguido por un dígito o por un punto decimal (.) que tenga un dígito inmediatamente después.
 * 
 * Este método se utiliza para garantizar que el signo de número negativo esté correctamente posicionado
 * y no se encuentre en lugares inválidos dentro de la expresión.
 * 
 * @param expresion La expresión que contiene el signo negativo, representada como una cadena de caracteres.
 * @param pos La posición del signo negativo en la cadena de la expresión.
 * @return {@code true} si el signo negativo está correctamente ubicado, 
 *         {@code false} si no cumple con las reglas de validez.
 */
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
                            // Si intentamos dividir por cero, en lugar de lanzar una excepción,
                            // devolvemos Double.NaN (Not-a-Number) para indicar un error en la operación.
                            return Double.NaN;
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
