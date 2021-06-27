
package juego.triqui.semillero;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;


public class Jugadores extends JFrame implements ActionListener{
    public Jugadores(){
        componentes();
    }
    
    Conexion conectar = new Conexion();
    Connection cn = conectar.con();
    
    JLabel Jugador1, Jugador2, entrar, salir,o, titulo;
    
    JTextField P1, P2;
    
    JButton start, sali;
    
    URL ruta1,ruta2;
    
    ImageIcon ingre,sal;
        
    String valor1, valor2;
    
    private void componentes(){
        this.setSize(350,200);
        this.setLocationRelativeTo(this);
        this.getContentPane().setBackground(new Color(0,0,0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        
        titulo = new JLabel("TRIKI");
        titulo.setBounds(150, 0, 100, 20);
        titulo.setFont(new Font("Comic Sans MS",Font.BOLD , 26));
        titulo.setForeground(Color.ORANGE);
        this.add(titulo);
        
        Jugador1 = new JLabel("Jugador 1");
        Jugador1.setBounds(30, 30, 100, 20);
        Jugador1.setFont(new Font("Comic Sans MS",Font.BOLD , 16));
        Jugador1.setForeground(Color.ORANGE);
        this.add(Jugador1);
        
        Jugador2 = new JLabel("Jugador 2");
        Jugador2.setBounds(30, 60, 100, 20);
        Jugador2.setFont(new Font("Comic Sans MS",Font.BOLD , 16));
        Jugador2.setForeground(Color.ORANGE);
        this.add(Jugador2);
        
        P1 = new JTextField();
        P1.setBounds(125, 30, 200, 20);
        P1.setToolTipText("Alias");
        this.add(P1);
        
        P2 = new JTextField();
        P2.setBounds(125, 60, 200, 20);
        P2.setToolTipText("Alias");
        this.add(P2);
        
        start = new JButton();
        start.setBounds(135, 90, 50, 50);
        start.addActionListener(this);
        start.setToolTipText("Jugar");
        start.setBackground(Color.ORANGE);
        entrar = new JLabel();
        ruta1 = this.getClass().getResource("/Imagenes/entrar.png");
        ingre = new ImageIcon(ruta1);
        start.setIcon(new ImageIcon(ingre.getImage().getScaledInstance(start.getWidth(), start.getHeight(), Image.SCALE_SMOOTH)));
        this.add(start);
    
        sali = new JButton();
        sali.setBounds(190, 90, 50, 50);
        sali.addActionListener(this);
        sali.setToolTipText("Salir");
        sali.setBackground(Color.ORANGE);
        o = new JLabel();
        ruta2 = this.getClass().getResource("/Imagenes/salir.png");
        sal = new ImageIcon(ruta2);
        sali.setIcon(new ImageIcon(sal.getImage().getScaledInstance(sali.getWidth(), sali.getHeight(), Image.SCALE_SMOOTH)));
        this.add(sali);
        
        valor1= P1.getText();
        valor2 = P2.getText();
        
        
        /*Datos_Nombre_Jugador dimelo = new Datos_Nombre_Jugador();
        dimelo.setPlayer1(P1.getText());
        dimelo.setPlayer2(P2.getText());*/
    }
    
    
    
    
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==start) {
            valor1= P1.getText();
            valor2 = P2.getText();
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios(nombre) VALUES (?)");
                ps.setString(1, P1.getText());
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(Jugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios(nombre) VALUES (?)");
                ps.setString(1, P2.getText());
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(Jugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            Interfaz iniciarInterfaz = new Interfaz();
            iniciarInterfaz.setVisible(true);
           
            
            this.setVisible(false);
        }
    
    }
}
