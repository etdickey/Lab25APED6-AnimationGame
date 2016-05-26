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
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
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
            //desktop
//            File url = new File("H:\\CompSci\\Programs\\StarfighterAPED6\\"
//                    + "src\\StarFighterReal\\ship.png");
            //laptop
            File url = new File("C:\\Users\\Administrator\\Desktop\\School"
                    + "\\CompSci\\Repo\\src\\Lab25APED6-AnimationGame"
                    + "\\AnimationGameED\\src\\animationgameed");
            playerImages[0] = ImageIO.read(url);
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
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.repaint();
        timer = new Timer(timerSpeed, timerListener);
        timer.start();
        
        p = new Player(playerImages,50,200);
        //add a player and obstacles to the game
        
    }
    ActionListener timerListener = (ActionEvent e) -> {
        moveObjects();
        repaint();
    };
    @Override
    public void paintComponent(Graphics g){
        g.setColor(new Color(0, 170, 0));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        p.Draw(g);
        obstacles.forEach((ab) -> {
            ab.Draw(g);
        });
    }
    @Override
    public void keyTyped(KeyEvent ke){}
    @Override
    public void keyPressed(KeyEvent ke){
        if (ke.getKeyCode() == KeyEvent.VK_UP){
            keys[0] = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN){
            keys[1] = true;
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_UP){
            keys[0] = false;
        }
        if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            keys[1] = false;
        }
        repaint();
    }
    private void moveObjects(){
        //move the player based on the arrow keys
        if(keys[0]){
            p.move(-1);
        }
        
        //move the obsticles to the left
        
        
        //check for a collision between the player and each obstacle by calling
        //the collision method in the player class. 
        //End the game if there is a collision
    }
}