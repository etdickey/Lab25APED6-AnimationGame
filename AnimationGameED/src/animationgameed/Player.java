/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animationgameed;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author 100032528
 */
public class Player extends GameObject{
    private Image[] images = null;
    private int imageNum = 0;
    
    public Player(Image[] images, int xLoc, int yLoc){
        //add code here
        setSize(images[0].getWidth(null),images[0].getHeight(null));
    }
    public void Draw(Graphics g){
        //draw the player at a constant size
        
        //after that frame has been on the screen for a given number of draw 
        //calls, change the player image
    }
    public boolean collision(GameObject g){
        //return true if the player intersects the gameObject; else return false
        return false;
    }
    public void move(int amount){
        //move the charicter amount in the y direction 
        //if that dosn't take them off the edge of the screen
    }
}
