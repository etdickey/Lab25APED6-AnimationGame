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
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import static java.lang.System.*;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
/**
 *
 * @author Ethan Dickey
 */
public class GameRunner extends JPanel implements KeyListener{

    private static JFrame frame = new JFrame();
    private static Timer timer;
    private final int timerSpeed = 20;
    public final boolean[] keys = new boolean[2];
    Player p = null;
    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    
    /**
     * sets up and starts a game
     * Reads in the images and assigns them to variables.
     */
    public GameRunner(){
        Image[] playerImages = new Image[3];
        Image obstacle = null;
        
        try{
            ////rock
            //desktop
            File url = new File("H:\\CompSci\\Programs\\StarfighterAPED6"
                    + "\\src\\Lab25APED6-AnimationGame\\AnimationGameED"
                    + "\\src\\animationgameed\\rock.png");
            //laptop
//            File url = new File("C:\\Users\\Administrator\\Desktop\\School"
//                    + "\\CompSci\\Repo\\src\\Lab25APED6-AnimationGame"
//                    + "\\AnimationGameED\\src\\animationgameed\\rock.png");
            obstacle = ImageIO.read(url);
            ////player images
            for(int ab=0;ab<3;ab++){
                //desktop
                url = new File("H:\\CompSci\\Programs\\StarfighterAPED6"
                    + "\\src\\Lab25APED6-AnimationGame\\AnimationGameED"
                    + "\\src\\animationgameed\\Player"+ab+".png");
                //laptop
//                url = new File("C:\\Users\\Administrator\\Desktop\\School"
//                        + "\\CompSci\\Repo\\src\\Lab25APED6-AnimationGame"
//                        + "\\AnimationGameED\\src\\animationgameed\\Player"+ab+".png");
                playerImages[ab] = ImageIO.read(url);
            }
            Thread.sleep(10);
        }
        catch(Exception e){
            err.println(e+" trying to import.");
        }
        p = new Player(playerImages,50,200);
        frame.add(this);
        frame.addKeyListener(this);
        
        frame.setVisible(true); 
        
        frame.setSize(800, 600);
        frame.setResizable(false);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width/2)-200, (screenSize.height/2)-150);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.repaint();
        timer = new Timer(timerSpeed, timerListener);
        timer.start();
        
        
        for(int i=0;i<5;i++){
            obstacles.add(new Obstacle(obstacle));
        }
    }
    ActionListener timerListener = (ActionEvent e) -> {
        moveObjects();
        repaint();
    };
    @Override
    public void paintComponent(Graphics g){
        g.setColor(new Color(255, 170, 5));
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
            p.move(-10);
        }
        else if(keys[1])
            p.move(10);
        obstacles.forEach((ab)->{
            ab.move(20);
        });
        
        for(int ab=0;ab<obstacles.size();ab++){
            if(obstacles.get(ab).getShape().intersects((Rectangle2D)(p.getShape()))){
                System.exit(0);
            }
        }
        
        //End the game if there is a collision
    }
}