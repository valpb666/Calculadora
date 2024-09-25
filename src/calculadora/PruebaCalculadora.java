package calculadora;

/*
 * @author DAVID ESTRADA // 2123453
 */

public class PruebaCalculadora {
    public static void main(String[] args) {
        // TODO code application logic here
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCalculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCalculadora().setVisible(true);
            }
        });
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
/*
        ConvertidorAPosFijo convertidor = new ConvertidorAPosFijo();
        
        String infijo1 = "3*4+2"; // Cadena infix a convertir a postfix
        String postfijo1 = convertidor.convierteAPostFijo(infijo1);
        System.out.println("Infijo: " + infijo1);
        System.out.println("Postfijo: " + postfijo1);
        
        String infijo2 = "(%3+4)^2-1"; // Cadena infix a convertir a postfix
        String postfijo2 = convertidor.convierteAPostFijo(infijo2);
        System.out.println("Infijo: " + infijo2);
        System.out.println("Postfijo: " + postfijo2);
*/
    }    
}
