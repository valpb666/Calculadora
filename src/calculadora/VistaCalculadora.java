/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;
import java.awt.BorderLayout;
import java.awt.GridLayout; 
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent; 
import javax.swing.event.DocumentListener;

/**
 *
 * @author urielchavezsanchez
 */
public class VistaCalculadora extends JFrame {
// atrib
private JPanel panelBase, panelTexto;
private JButton boton0;
private JButton boton1, boton2, boton3, boton4;
private JButton boton5, boton6, boton7, boton8;
private JButton boton9, boton10, boton11, boton12;
private JButton boton13, boton14, boton15, boton16;
private JButton boton17, boton18, boton19, boton20, boton21;
private JTextField cuadroTexto;
private Border bordeBase, bordeTexto;
/*
Si es true entonces hay error 
Si es false no encontro error
*/
protected static boolean Error= false;

// constructor de la GUI
 public VistaCalculadora(){
    this.setTitle("Calculadora"); 
    this.setSize(300, 350);
    this.setLocationRelativeTo(null);
    this.setResizable(false); 
    this.personalizacion();
    this.funcionalidad();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    }
   //Personalizacion
 private void personalizacion() {
     //Panel
    panelBase = new JPanel();
    panelTexto = new JPanel(); 
    panelBase.setLayout(new GridLayout(6, 5));
    panelTexto.setLayout(new GridLayout(1,1));
    //borde
    bordeBase = BorderFactory.createEmptyBorder(10, 10, 10, 10); 
    bordeTexto = BorderFactory.createEmptyBorder(10, 10, 0, 10); 
    panelBase.setBorder(bordeBase); 
    panelTexto.setBorder(bordeTexto);
    //boton
    boton0 = new JButton(); boton0.setText("Negativo"); panelBase.add(boton0);
    boton1 = new JButton(); boton1.setText("C"); panelBase.add(boton1);
    boton2 = new JButton(); boton2.setText("⌫"); panelBase.add(boton2);
    boton3 = new JButton(); boton3.setText("^"); panelBase.add(boton3);
    boton5 = new JButton(); boton5.setText("7"); panelBase.add(boton5);
    boton6 = new JButton(); boton6.setText("8"); panelBase.add(boton6);
    boton7 = new JButton(); boton7.setText("9"); panelBase.add(boton7);
    boton4 = new JButton(); boton4.setText("*"); panelBase.add(boton4);
    boton9 = new JButton(); boton9.setText("4"); panelBase.add(boton9);
    boton10 = new JButton(); boton10.setText("5"); panelBase.add(boton10);
    boton11 = new JButton(); boton11.setText("6"); panelBase.add(boton11);
    boton8 = new JButton(); boton8.setText("/"); panelBase.add(boton8);
    boton13 = new JButton(); boton13.setText("1"); panelBase.add(boton13);
    boton14 = new JButton(); boton14.setText("2"); panelBase.add(boton14);
    boton15 = new JButton(); boton15.setText("3"); panelBase.add(boton15);
    boton12 = new JButton(); boton12.setText("-"); panelBase.add(boton12);
    boton17 = new JButton(); boton17.setText("0"); panelBase.add(boton17);
    boton18 = new JButton(); boton18.setText("("); panelBase.add(boton18);
    boton19 = new JButton(); boton19.setText(")"); panelBase.add(boton19);
    boton16 = new JButton(); boton16.setText("+"); panelBase.add(boton16);
    boton20 = new JButton(); boton20.setText("="); panelBase.add(boton20);
    boton21 = new JButton(); boton21.setText(""); panelBase.add(boton21);
    cuadroTexto = new JTextField(); 
    cuadroTexto.setText(""); 
    panelTexto.add(cuadroTexto); 
    cuadroTexto.setEditable(false);
   
    getContentPane().setLayout(new BorderLayout()); 
    getContentPane().add(panelTexto, BorderLayout.NORTH); 
    getContentPane().add(panelBase, BorderLayout.CENTER);
    }
  private void funcionalidad() {
       boton0.addActionListener((ActionEvent e) -> {
        String texto = cuadroTexto.getText();
        int pos = texto.length() - 1; // Comienza desde el último carácter
    
    if (texto.isEmpty()) { // Verifica si el cuadro de texto no está vacío
        return;
    }
     if (texto.charAt(0) == '(' && texto.charAt(texto.length() - 1) == ')') {
        // Agrega el "?" antes del paréntesis de apertura "("
        cuadroTexto.setText("?" + texto);
        Error = false;
        return;
    }
    // Recorre el texto desde la derecha hasta encontrar un signo
    while (pos >= 0) {
        char caracterActual = texto.charAt(pos);
        
        // If: encuentra +, *, / o ^ y agrega "?" después del signo
        if (caracterActual == '+' || caracterActual == '*' || caracterActual == '/' || caracterActual == '^') {
            cuadroTexto.setText(texto.substring(0, pos + 1) + "?" + texto.substring(pos + 1));
            Error = false;
            return;
        }
        
        // Else: encuentra - y reemplázalo por "?"
        if (caracterActual == '-') {
            cuadroTexto.setText(texto.substring(0, pos) + "?" + texto.substring(pos + 1));
            Error = false;
            return;
        }
        
        pos--;
    }
    
    // Si no se encuentra ningún signo, no se hace nada adicional
});
       boton1.addActionListener((ActionEvent e) -> {
           cuadroTexto.setText("");
           Error = false; // Restablece el false para que no haya error 
           boton20.setEnabled(true);// Habilita el boton de calcular 
        });
       boton2.addActionListener((ActionEvent e) -> { //se elimina el ultimo caracter 
           String p=cuadroTexto.getText().substring(0, cuadroTexto.getText().length()-1); 
           cuadroTexto.setText(p);
           Error= false; // Restablece
        });
       boton3.addActionListener((ActionEvent e) -> {
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"^");
           Error = false; // Restablece 
        });
       boton4.addActionListener((ActionEvent e) -> {
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"*");
           Error = false; // Restablece 
        });
       boton5.addActionListener((ActionEvent e) -> {
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"7");
           Error = false; // Restablece 
        });
       boton6.addActionListener((ActionEvent e) -> {
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"8");
           Error = false; // Restablece 
        });
       boton7.addActionListener((ActionEvent e) ->  { 
           String p=cuadroTexto.getText(); 
           cuadroTexto.setText(p+"9");
           Error = false; // restablece
       });
       boton8.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"/");
           Error= false; // Restablece
       });
       boton9.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"4"); 
           Error = false; // Restablece
       });
       boton10.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"5"); 
           Error= false; // Restablece
       });
       boton11.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText(); 
           cuadroTexto.setText(p+"6"); 
           Error = false; // Restablece
       });
       boton12.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText(); 
           cuadroTexto.setText(p+"-"); 
           Error = false; // Restablece
       });
       boton13.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText(); 
           cuadroTexto.setText(p+"1");
           Error = false; // Restablece
       });

       boton14.addActionListener((ActionEvent e) -> {
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"2");
           Error = false; // // Restablece la variable de control de error
       });
       boton15.addActionListener((ActionEvent e) -> {
            String p=cuadroTexto.getText();
            cuadroTexto.setText(p+"3");
            Error = false;
       });
       boton16.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"+");
           Error = false; // Restablece
       });
       boton17.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"0"); 
           Error = false; // Restablece
       });
       boton18.addActionListener((ActionEvent e) -> {
           String p=cuadroTexto.getText(); 
           cuadroTexto.setText(p+"("); 
           Error = false; // Restablece
       });
       boton19.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+")"); 
           Error = false; // Restablece
       });
       boton21.addActionListener((ActionEvent e) -> { 
           String p=cuadroTexto.getText();
           cuadroTexto.setText(p+"."); 
           Error = false; // Restablece
        });
       boton20.addActionListener((ActionEvent e) -> {
    String c = cuadroTexto.getText();
    try {
        // Convierte la expresión infija a postfijo
        PilaADT<String> pilaPostfija = InfijoAPostfijo.conviertePostfijo(c); //clase que utilice junto con metodo solo para probar el codigo, manda solo syntax error

        if (!Error) { // Verifica si no hay error de sintaxis
            try {
                // Evalúa la expresión postfija
                double resultado = evaluarExp(pilaPostfija);

                // Muestra el resultado en el cuadro de texto
                cuadroTexto.setText(Double.toString(resultado));
            } catch (Exception ex) {
                Error = true; // Si ocurre un error durante la evaluación
                cuadroTexto.setText("Syntax Error"); // Muestra un mensaje de error
            }
        } else {
            cuadroTexto.setText("Syntax Error"); // Si hubo un error de sintaxis antes, muestra un mensaje de error
        }
    } catch (Exception ex) {
        cuadroTexto.setText("Syntax Error");
    }
});
	
       cuadroTexto.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        revisaError();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        revisaError();
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
         // se necesita la implementacion de este codigo 
    }
    
    private void revisaError() {
        String texto = cuadroTexto.getText(); 
        if (texto.contains("Syntax Error")) {
            System.out.println("Syntax Error.");
            boton20.setEnabled(false); //quita la funcionalidad si existe un error al boton "="
            }
        } 
    });

 }  

    private double evaluarExp(PilaADT<String> pilaPostfija) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 }
 
