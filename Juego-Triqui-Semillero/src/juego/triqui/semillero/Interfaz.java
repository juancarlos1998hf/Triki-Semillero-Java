package juego.triqui.semillero;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import java.applet.AudioClip;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.LayoutManager;
import java.net.URL;
import java.util.Locale;
import javax.swing.JLabel;

public class Interfaz extends JFrame implements ActionListener {
    public Interfaz(){
        componentes();
    }
    
    Jugadores ju = new Jugadores();
    
    int posx = 0, posy = 0;
    int c  = 0;
    int turno = 1,i=0;
    int cg=0;
    
    String rc = " ",x=" ";
    String caracteres[][] = {{"0","0","0"},{"0","0","0"},{"0","0","0"}};

    JLabel titulo;
    
    JPanel Marco_juego = new JPanel();
    
    JButton[][] MatrizBotones = new JButton[3][3];
    JButton nuevo_juego;
    
    AudioClip  sonidoe,sonidog;
    
    URL ruta1;
    ImageIcon resetear;
    private void componentes(){
        
        this.setSize(600, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(this);
        this.getContentPane().setBackground(new Color(0,0,0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFont(new Font("Bodoni MT", Font.BOLD, 30));
        //no deja que se maximice la ventana
        this.setResizable(false);
        //dispose cierra el proceso de JFrame
        this.dispose();
        //icono al JFrame
        this.
        //Panel Triki
        Marco_juego.setBounds(50,50, 400, 400);
        Marco_juego.setLayout(new GridLayout(3,3));
        this.add(Marco_juego);
        //sonido
        sonidoe = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/empate.wav"));
        sonidog = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/ganador.wav"));
        
        titulo = new JLabel("TRIKI");
        titulo.setFont(new Font("Comic Sans MS",Font.BOLD , 25));
        titulo.setBounds(150, 0, 150, 25);
        titulo.setForeground(Color.ORANGE);
        this.add(titulo);
        
        Datos_Nombre_Jugador digame =  new Datos_Nombre_Jugador();
        digame.getPlayer1();
        digame.getPlayer2();
        
        System.out.println(digame.getPlayer1());
        System.out.println(digame.getPlayer2());
        //Matriz Botones
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c = c+1;
                rc = String.valueOf(c);
                MatrizBotones[i][j] = new JButton(rc);
                MatrizBotones[i][j].setBounds(posx, posy, 80, 80);
                MatrizBotones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                            for (int k = 0; k < 3; k++) {
                                    for (int l = 0; l < 3; l++) {
                                        if(ae.getSource()==MatrizBotones[k][l]) {
                                            if (turno == 1) {
                                                MatrizBotones[k][l].setText("O");
                                                caracteres[k][l] = MatrizBotones[k][l].getText();
                                                MatrizBotones[k][l].setEnabled(false);
                                                System.out.println("Turno "+turno);
                                                turno = 2;
                                                System.out.println("Turno "+turno);
                                            }else if (turno == 2) {
                                                MatrizBotones[k][l].setText("X");
                                                caracteres[k][l] = MatrizBotones[k][l].getText();
                                                MatrizBotones[k][l].setEnabled(false);
                                                turno = 3;
                                                System.out.println("Turno "+turno);
                                            }else if (turno == 3) {
                                                MatrizBotones[k][l].setText("O");
                                                caracteres[k][l] = MatrizBotones[k][l].getText();
                                                MatrizBotones[k][l].setEnabled(false);
                                                turno = 4;
                                                System.out.println("Turno "+turno);
                                            }else if (turno == 4) {
                                                MatrizBotones[k][l].setText("X");
                                                caracteres[k][l] = MatrizBotones[k][l].getText();
                                                MatrizBotones[k][l].setEnabled(false);
                                                turno = 5;
                                                System.out.println("Turno: "+turno);
                                            }else if (turno == 5) {
                                                MatrizBotones[k][l].setText("O");
                                                caracteres[k][l] = MatrizBotones[k][l].getText();
                                                MatrizBotones[k][l].setEnabled(false);
                                                    if (caracteres[0][0].equals("O") && caracteres[0][1].equals("O") && caracteres[0][2].equals("O")){
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 1;
                                                    }else if (caracteres[1][0].equals("O") && caracteres[1][1].equals("O") && caracteres[1][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 1;
                                                    }else if (caracteres[2][0].equals("O") && caracteres[2][1].equals("O") && caracteres[2][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 1;
                                                    }else if (caracteres[0][0].equals("O") && caracteres[1][0].equals("O") && caracteres[2][0].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 1;
                                                    }else if (caracteres[0][1].equals("O") && caracteres[1][1].equals("O") && caracteres[2][1].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 1;
                                                    }else if (caracteres[0][2].equals("O") && caracteres[1][2].equals("O") && caracteres[2][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 1;
                                                    }else if (caracteres[0][0].equals("O") && caracteres[1][1].equals("O") && caracteres[2][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 1;
                                                    }else if (caracteres[2][0].equals("O") && caracteres[1][1].equals("O") && caracteres[0][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 1;
                                                    }
                                                    if (cg==1) {
                                                        sonidog.play();
                                                        for (int m = 0; m < 3; m++) {
                                                            for (int n = 0; n < 3; n++) {
                                                                 MatrizBotones[m][n].setEnabled(false);
                                                            }
                                                        }
                                                    }
                                                x = "Ganador O";
                                                turno = 6;
                                                System.out.println(turno);
                                            }else if (turno == 6) {
                                                
                                                MatrizBotones[k][l].setText("X");
                                                caracteres[k][l] = MatrizBotones[k][l].getText();
                                                MatrizBotones[k][l].setEnabled(false);
                                                    
                                                    if (caracteres[0][0].equals("X") && caracteres[0][1].equals("X") && caracteres[0][2].equals("X")){
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 2;
                                                    }else if (caracteres[1][0].equals("X") && caracteres[1][1].equals("X") && caracteres[1][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 2;
                                                    }else if (caracteres[2][0].equals("X") && caracteres[2][1].equals("X") && caracteres[2][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 2;
                                                    }else if (caracteres[0][0].equals("X") && caracteres[1][0].equals("X") && caracteres[2][0].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 2;
                                                    }else if (caracteres[0][1].equals("X") && caracteres[1][1].equals("X") && caracteres[2][1].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 2;
                                                    }else if (caracteres[0][2].equals("X") && caracteres[1][2].equals("X") && caracteres[2][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 2;
                                                    }else if (caracteres[0][0].equals("X") && caracteres[1][1].equals("X") && caracteres[2][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 2;
                                                    }else if (caracteres[2][0].equals("X") && caracteres[1][1].equals("X") && caracteres[0][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 2;
                                                    }
                                                    if (cg == 2) {
                                                        sonidog.play();
                                                        for (int m = 0; m < 3; m++) {
                                                            for (int n = 0; n < 3; n++) {
                                                                 MatrizBotones[m][n].setEnabled(false);
                                                            }
                                                            
                                                        }
                                                    }
                                                    
                                                x = "Ganador X";    
                                                turno = 7;
                                                
                                            }else if (turno == 7) {
                                                
                                                MatrizBotones[k][l].setText("O");
                                                caracteres[k][l] = MatrizBotones[k][l].getText();
                                                MatrizBotones[k][l].setEnabled(false);
                                                turno = 8;
                                                
                                                if (caracteres[0][0].equals("O") && caracteres[0][1].equals("O") && caracteres[0][2].equals("O")){
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 3;
                                                    }else if (caracteres[1][0].equals("O") && caracteres[1][1].equals("O") && caracteres[1][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 3;
                                                    }else if (caracteres[2][0].equals("O") && caracteres[2][1].equals("O") && caracteres[2][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 3;
                                                    }else if (caracteres[0][0].equals("O") && caracteres[1][0].equals("O") && caracteres[2][0].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 3;
                                                    }else if (caracteres[0][1].equals("O") && caracteres[1][1].equals("O") && caracteres[2][1].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 3;
                                                    }else if (caracteres[0][2].equals("O") && caracteres[1][2].equals("O") && caracteres[2][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 3;
                                                    }else if (caracteres[0][0].equals("O") && caracteres[1][1].equals("O") && caracteres[2][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 3;
                                                    }else if (caracteres[2][0].equals("O") && caracteres[1][1].equals("O") && caracteres[0][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 3;
                                                    }
                                                    if (cg == 3) {
                                                        sonidog.play();
                                                        for (int m = 0; m < 3; m++) {
                                                            for (int n = 0; n < 3; n++) {
                                                                 MatrizBotones[m][n].setEnabled(false);
                                                            }
                                                        }
                                                    }
                                                
                                                x = "Ganador O";
                                            }else if (turno == 8) {
                                                
                                                MatrizBotones[k][l].setText("X");
                                                caracteres[k][l] = MatrizBotones[k][l].getText();
                                                MatrizBotones[k][l].setEnabled(false);
                                                turno = 9;
                                                
                                                    if (caracteres[0][0].equals("X") && caracteres[0][1].equals("X") && caracteres[0][2].equals("X")){
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 4;
                                                    }else if (caracteres[1][0].equals("X") && caracteres[1][1].equals("X") && caracteres[1][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 4;
                                                    }else if (caracteres[2][0].equals("X") && caracteres[2][1].equals("X") && caracteres[2][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 4;
                                                    }else if (caracteres[0][0].equals("X") && caracteres[1][0].equals("X") && caracteres[2][0].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 4;
                                                    }else if (caracteres[0][1].equals("X") && caracteres[1][1].equals("X") && caracteres[2][1].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 4;
                                                    }else if (caracteres[0][2].equals("X") && caracteres[1][2].equals("X") && caracteres[2][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 4;
                                                    }else if (caracteres[0][0].equals("X") && caracteres[1][1].equals("X") && caracteres[2][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 4;
                                                    }else if (caracteres[2][0].equals("X") && caracteres[1][1].equals("X") && caracteres[0][2].equals("X")) {
                                                        JOptionPane.showMessageDialog(null, "Gano X");
                                                        cg = 4;
                                                    }
                                                    if (cg == 4) {
                                                        sonidog.play();
                                                        for (int m = 0; m < 3; m++) {
                                                            for (int n = 0; n < 3; n++) {
                                                                 MatrizBotones[m][n].setEnabled(false);
                                                            }
                                                        }
                                                    }
                                                x = "Ganador X";
                                                System.out.println("Turno: "+turno);
                                            }else if (turno == 9) {
                                              
                                                MatrizBotones[k][l].setText("O");
                                                caracteres[k][l] = MatrizBotones[k][l].getText();
                                                MatrizBotones[k][l].setEnabled(false);
                                                x = "Ganador O";
                                                
                                                if (caracteres[0][0].equals("O") && caracteres[0][1].equals("O") && caracteres[0][2].equals("O")){
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 5;
                                                    }else if (caracteres[1][0].equals("O") && caracteres[1][1].equals("O") && caracteres[1][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 5;
                                                    }else if (caracteres[2][0].equals("O") && caracteres[2][1].equals("O") && caracteres[2][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 5;
                                                    }else if (caracteres[0][0].equals("O") && caracteres[1][0].equals("O") && caracteres[2][0].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 5;
                                                    }else if (caracteres[0][1].equals("O") && caracteres[1][1].equals("O") && caracteres[2][1].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 5;
                                                    }else if (caracteres[0][2].equals("O") && caracteres[1][2].equals("O") && caracteres[2][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 5;
                                                    }else if (caracteres[0][0].equals("O") && caracteres[1][1].equals("O") && caracteres[2][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 5;
                                                    }else if (caracteres[2][0].equals("O") && caracteres[1][1].equals("O") && caracteres[0][2].equals("O")) {
                                                        JOptionPane.showMessageDialog(null, "Gano O");
                                                        cg = 5;
                                                    }else {
                                                        JOptionPane.showMessageDialog(null, "¡Empate!");
                                                        sonidoe.play();
                                                    }
                                                    if (cg == 5) {
                                                        sonidog.play();
                                                        for (int m = 0; m < 3; m++) {
                                                            for (int n = 0; n < 3; n++) {
                                                                 MatrizBotones[m][n].setEnabled(false);
                                                            }
                                                        }
                                                    }
                                            }
                                        }  
                                    }
                                }
                            }
                });
                Marco_juego.add(MatrizBotones[i][j]);
                posx = posx + 80;
                
            }
                posx = 0;
                posy = posy + 80;
        }
        nuevo_juego = new JButton();
        nuevo_juego.setBounds(460, 60, 50, 50);
        ruta1 = this.getClass().getResource("/Imagenes/reset.png");
        resetear = new ImageIcon(ruta1);
        nuevo_juego.setToolTipText("¿Nuevo Juego?");
        nuevo_juego.setIcon(new ImageIcon(resetear.getImage().getScaledInstance(nuevo_juego.getWidth(), nuevo_juego.getHeight(), Image.SCALE_SMOOTH)));
        nuevo_juego.setCursor(new Cursor(HAND_CURSOR));
        nuevo_juego.addActionListener(this);
        this.add(nuevo_juego);
}
    @Override
    public void actionPerformed(ActionEvent ae) {
        int i = 0;
        if (ae.getSource()==nuevo_juego) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    i++;
                    String inicializar = String.valueOf(i);
                    MatrizBotones[j][k].setEnabled(true);
                    MatrizBotones[j][k].setText(inicializar);
                    caracteres[j][k] = "0";
                    turno = 1;
                    cg = 0;
                }
            }
        }
    }
}
