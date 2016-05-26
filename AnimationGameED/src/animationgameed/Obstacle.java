/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animationgameed;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Ethan Dickey
 */
public class Obstacle extends GameObject{
    private boolean dead = false;
    private Image image = null;
    
    public Obstacle(Image i){
        setSize(i.getWidth(null),i.getHeight(null));
        setLocation((int)(Math.random()*400+400),(int)(Math.random()*600));
        image = i;
    }
    @Override
    public void Draw(Graphics g){
        if(!dead){
            g.drawImage(image, getX(), getY(), null);
        }
    }
    @Override
    public void move(int dir){
        int[] a = getLocation();
        int[] b = getSize();
        if(a[0]+b[0]-dir<0){
            dead=true;
        }
        else
            setLocation(getX()-dir,getY());
        if(dead){
            int rand = (int)(Math.random()*100+1);
            if(rand%13==0){
                dead=false;
                setLocation(801,(int)(Math.random()*600 -10));
            }
        }
        //if it is alive move the object to the left and declare it dead 
        //if it is off the left side of the screen.
        //If it is dead make a small random chanace to declare if alive and 
        //place it just off the right side of the screen at a random y position
    }
    public boolean isDead(){
        return dead;
    }
}