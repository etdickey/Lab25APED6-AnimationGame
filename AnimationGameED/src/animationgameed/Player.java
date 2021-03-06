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
    private Image[] images = new Image[3];
    private int imageNum = 0;
    private int num=0;
    public Player(Image[] image, int xLoc, int yLoc){
        images = image;
        setSize(50,50);
        setLocation(50,50);
    }
    public void Draw(Graphics g){
        //draw the player at a constant size
        if(num<=20)
            g.drawImage(images[0], getX(), getY(), getWidth(), getHeight(), null);
        else if(num<=40)
            g.drawImage(images[1], getX(), getY(), getWidth(), getHeight(), null);
        else if(num<=60)
            g.drawImage(images[2], getX(), getY(), getWidth(), getHeight(), null);
        else
            num = 0;
        num++;
    }
    public boolean collision(GameObject g){
        //return true if the player intersects the gameObject; else return false
        return false;
    }
    public void move(int dir){
        setY(getY()+dir);
    }
}
