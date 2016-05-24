/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animationlab;

import java.awt.Graphics;

/**
 *
 * @author Justin Hill
 */
public abstract class GameObject {
    
    private int[] location = new int[2];
    private int[] size = new int[2];
    
    public abstract void Draw(Graphics g);
    
    public void setLocation(int locX, int locY)
    {
        //add code here
    }
    
    public void setSize(int sizeX, int sizeY)
    {
        //add code here
    }
    
    public int[] getSize()
    {
        //add code here
    }
    
    public int[] getLocation()
    {
        //add code here
    }
    
    public abstract void move(int amount);
    
}
