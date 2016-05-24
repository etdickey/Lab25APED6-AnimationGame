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
public class Obstacle extends GameObject{
    private boolean dead = true;
    private Image image = null;
    
    public Obstacle(Image i){
        //add code here
        setSize(i.getWidth(null),i.getHeight(null));
    }
    @Override
    public void Draw(Graphics g){
        if(!dead){}
            //add code here
    }
    @Override
    public void move(int amount){
        //if it is alive move the object to the left and declare it dead 
        //if it is off the left side of the screen.
        //If it is dead make a small random chanace to declare if alive and 
        //place it just off the right side of the screen at a random y position
    }
    public boolean isDead(){
        //add code here
        return false;
    }
}