package javaapiejercicios;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.util.Random;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Ari
 */
public class Ventana extends JFrame{
    JPanel panel = new JPanel();
    JLabel tag = new JLabel();
    JLabel tag2 = new JLabel();
    JLabel tag3 = new JLabel();
    JLabel tag4 = new JLabel();
    JLabel end = new JLabel();
    JButton b = new JButton();
    JLabel res = new JLabel();
    Random rn = new Random();
    MediaPlayer btnclick;
    public Ventana() {       
        panel();
        complementos();
    }
       
    //configuracion ventana
    private void panel(){
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);          
        this.getContentPane().setBackground(Color.BLACK);
        //this.isResizable();
        this.setTitle("Generador Aleatorio. Hecho por: Ari Chavez");
        this.setLocationRelativeTo(null);
    }
    
    private void complementos(){
    //numero random    
    Random rn = new Random();
    int random = rn.nextInt(100)+1;
    System.out.println("Numero random: " +random);
    
    //colores panel
    this.getContentPane().add(panel);
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);
    
    //etiqueta de titulo
    tag.setText("Número Aleatorio del 1 al 100. Haz click abajo.");
    panel.add(tag);
    tag.setOpaque(false);
    tag.setFont(new Font("arial",Font.BOLD,14));
    tag.setBounds(250, 10, 500, 50);
    
    //etiqueta de dados
    panel.add(tag2);
    tag2.setFont(new Font("arial",Font.BOLD,28));
    tag2.setBounds(250, 350, 500, 50);
    tag2.setText("JAJAJA TE CHAMAQUIE!!");
    tag2.setVisible(false);
    
    //etiqueta de dale dale dale
    panel.add(tag3);
    tag3.setFont(new Font("arial",Font.BOLD,28));
    tag3.setBounds(250, 350, 500, 50);
    tag3.setVisible(false);
    tag3.setText("DALE DALE DALE NO PIERDAS EL TINO!! jaja");

    //etiqueta de ya pues
    panel.add(tag4);
    tag4.setFont(new Font("arial",Font.BOLD,28));
    tag4.setBounds(200, 550, 500, 50);
    tag4.setText("LOL, ya pues =), el numero es: ");
    tag4.setVisible(false);
    
      //etiqueta end
    ImageIcon fin = new ImageIcon(new ImageIcon("dice.gif").getImage().getScaledInstance(700,400, Image.SCALE_DEFAULT));
    panel.add(end);
    end.setBounds(-50, 0, 800, 800);
    end.setOpaque(false);
    end.setVisible(false);
    end.setIcon(fin);
    
    //etiqueta de ya pues
    panel.add(res);
    res.setFont(new Font("arial",Font.BOLD,100));
    res.setBounds(350, 500, 400, 400);
    res.setText(String.valueOf(random));
    res.setOpaque(false);
    res.setVisible(false);
    res.setForeground(Color.WHITE);
    
    //creacion de imagenes
    ImageIcon pos1 = new ImageIcon("dice2.png");

    //creacion boton
    panel.add(b);
    b.setBounds(290,585,179,145);
    b.setIcon(new ImageIcon(pos1.getImage().getScaledInstance(179, 145, Image.SCALE_SMOOTH)));
    
    //mouse event boton
    b.addMouseListener(new MouseAdapter(){   
         
        @Override
        public void mouseEntered(MouseEvent e)
        {
            b.setLocation(new Random().nextInt(621), new Random().nextInt(621));
            if(e.getModifiers() !=1){
                tag2.setVisible(true);
                //Clip clip = AudioSystem.getClip();
                //btnclick = MediaPlayer.create(this, R.raw.button_click);
                new java.util.Timer().schedule( 
                new java.util.TimerTask() {
                    
                    @Override
                     public void run() {
                               tag2.setVisible(false);
                               tag2.setText("");
                               tag3.setBounds(100,300,900,50);
                               tag3.setVisible(true);   
                            new java.util.Timer().schedule( 
                            new java.util.TimerTask() {
                                
                                @Override
                                public void run() {
                                    tag2.setVisible(false);   
                                    tag3.setVisible(false);
                                    tag3.setText("");
                                    tag4.setVisible(true);
                                    new java.util.Timer().schedule( 
                                    new java.util.TimerTask() {
                                    
                                        @Override
                                            public void run() {
                                                tag2.setVisible(false);   
                                                tag3.setVisible(false);
                                                tag4.setText("");
                                                tag4.setVisible(false);
                                                tag4.setText("");
                                                res.setVisible(true);
                                                panel.setBackground(Color.BLACK);
                                                b.setVisible(false);
                                                end.setVisible(true);
                                            }
                                    }, 4000 
                                    );
                                }
                            }, 5000 
                            );
                    }
                }, 5000 
                );
            }else{
            }
        }
        
        @Override
        public void mouseExited(MouseEvent e){

        }
    });
    }
}
