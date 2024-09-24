package calculadora;

/*
 * @author DAVID ESTRADA // 2123453
 */

public class PruebaCalculadora {
    public static void main(String[] args) {
        // TODO code application logic here
        VistaCalculadora calc = new VistaCalculadora();
        /* Prueba Detección de errores
        Calculadora calc1 = new Calculadora();
        
        String expresion1 = "5+3.2*(7-4)(";
        String expresion2 = "5/0"; 
        String expresion3 = "(5+3*2)";
        String expresion4 = "5+*3";
        String expresion5 = "0.5+3";
        String expresion6 = "5+3+()";
        String expresion7 = "5.2+3.8";
        String expresion8 = "5*(3+2)/2-1";
        String expresion9 = "5+3*2)";
        String expresion10 = "(5+(3*2))+3)";
        String expresion11 = "5*(+3)"; // Esta mal
        String expresion12 = "5/0.0"; // Esta mal

        System.out.println(expresion1);
        System.out.println(expresion2);
        System.out.println(expresion3);
        System.out.println(expresion4);
        System.out.println(expresion5);
        System.out.println(expresion6);
        System.out.println(expresion7);
        System.out.println(expresion8);
        System.out.println(expresion9);
        System.out.println(expresion10);
        System.out.println(expresion11);
        System.out.println(expresion12);
        

         if (calc1.verificarExp(expresion1)) 
            System.out.println("La expresion " + expresion1 + " es valida");
         else 
            System.out.println("La expresion " + expresion1 + " es invalida");
        if (calc1.verificarExp(expresion2))
            System.out.println("La expresion " + expresion2 + " es valida");
        else
            System.out.println("La expresion " + expresion2 + " es invalida");
        
         if (calc1.verificarExp(expresion3))
            System.out.println("La expresion " + expresion3 + " es valida");
        else
            System.out.println("La expresion " + expresion3 + " es invalida");
         if (calc1.verificarExp(expresion4)) 
            System.out.println("La expresion " + expresion4 + " es valida");
         else 
            System.out.println("La expresion " + expresion4 + " es invalida");
         if (calc1.verificarExp(expresion5)) 
            System.out.println("La expresion " + expresion5 + " es valida");
         else 
            System.out.println("La expresion " + expresion5 + " es invalida");
         if (calc1.verificarExp(expresion6)) 
            System.out.println("La expresion " + expresion6 + " es valida");
         else 
            System.out.println("La expresion " + expresion6 + " es invalida");
         if (calc1.verificarExp(expresion7)) 
            System.out.println("La expresion " + expresion7 + " es valida");
         else 
            System.out.println("La expresion " + expresion7+ " es invalida");
         if (calc1.verificarExp(expresion8)) 
            System.out.println("La expresion " + expresion8 + " es valida");
         else 
            System.out.println("La expresion " + expresion8 + " es invalida");
         if (calc1.verificarExp(expresion9)) 
            System.out.println("La expresion " + expresion9 + " es valida");
         else 
            System.out.println("La expresion " + expresion9 + " es invalida");
         if (calc1.verificarExp(expresion10)) 
            System.out.println("La expresion " + expresion10 + " es valida");
         else 
            System.out.println("La expresion " + expresion10 + " es invalida");
         if (calc1.verificarExp(expresion11)) 
            System.out.println("La expresion " + expresion11 + " es valida");
         else 
            System.out.println("La expresion " + expresion11 + " es invalida");
         if (calc1.verificarExp(expresion12)) 
            System.out.println("La expresion " + expresion12 + " es valida");
         else 
            System.out.println("La expresion " + expresion12 + " es invalida");
        */
        
        /*
        PilaADT<String> pila = new PilaA<>();
        pila.push("-");
        pila.push("2");
        pila.push("^");
        pila.push("2");
        pila.push("/");
        pila.push("5");
        pila.push("2");
        System.out.println(pila);
        System.out.println(pila.peek());
*/
        String expresion13 = "5/1-1"; // Esta mal

        System.out.println(expresion13);

    }    
}
