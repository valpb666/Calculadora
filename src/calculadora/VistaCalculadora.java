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

// constructor de la GUI
 public VistaCalculadora(){
    this.setTitle("Calculadora"); 
    this.setSize(300, 350);
    this.setLocationRelativeTo(null);
    this.setResizable(false); 
    this.personalizacion();
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
 
 }
 