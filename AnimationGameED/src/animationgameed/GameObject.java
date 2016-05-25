package animationgameed;

import java.awt.Graphics;

/**
 *
 * @author Ethan Dickey
 */
public abstract class GameObject {
    private int[] location = new int[2];
    private int[] size = new int[2];
//    private int speed;
    
    public abstract void move(int dir);
    public abstract void Draw(Graphics g);
    
    public void setLocation(int locX, int locY){
        location[0] = locX;
        location[1] = locY;
    }
    public void setSize(int sizeX, int sizeY){
        size[0]=sizeX;
        size[1]=sizeY;
    }
    public int[] getSize(){return size;}
    public int[] getLocation(){return location;}
//    public int getSpeed(){return speed;}
//    public void setSpeed(int s){speed=s;}
}