package animationgameed;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Ethan Dickey
 */
public class GameRunner extends JPanel implements KeyListener {

    private static JFrame frame = new JFrame();
    private static Timer timer;
    private final int timerSpeed = 20;
    public final boolean[] keys = new boolean[2];
    Player p = null;
    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    
    /**
     * sets up and starts a game
     */
    public GameRunner(){
        Image[] playerImages;
        Image obstacle = null;
        try{
            //import the nessisary necessary graphics and add them to playerImages
            //import the graphic for the obstacle (you can use the rock provided)
            Thread.sleep(10);
        }
        catch(Exception e){
            
        }
        
        frame.add(this);
        frame.addKeyListener(this);
        
        frame.setVisible(true); 
        
        frame.setSize(400, 300);
        frame.setResizable(false);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width/2)-200, (screenSize.height/2)-150);
        
        frame.repaint();
        timer = new Timer(timerSpeed, timerListener);
        timer.start();
        
        
        //add a player and obstacles to the game
        
    }
    ActionListener timerListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            moveObjects();
            repaint();
        }
    };
    public void paintComponent(Graphics g){
        g.setColor(new Color(0, 170, 0));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        //draw the player and all the obsicles by calling there draw methods
    }
    @Override
    public void keyTyped(KeyEvent ke){}
    @Override
    public void keyPressed(KeyEvent ke) {
       //you may want to add code here
    }
    @Override
    public void keyReleased(KeyEvent ke) {
        //you may want to add code here
    }
    private void moveObjects(){
        //move the player based on the arrow keys
        
        
        //move the obsticles to the left
        
        
        //check for a collision between the player and each obstacle by calling
        //the collision method in the player class. 
        //End the game if there is a collision
    }
}