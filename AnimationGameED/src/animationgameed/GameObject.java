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
    public void setX(int x){location[0]=x;}
    public void setY(int y){location[1]=y;}
    public void setSize(int sizeX, int sizeY){
        size[0]=sizeX;
        size[1]=sizeY;
    }
    public java.awt.Shape getShape(){return new java.awt.Rectangle(location[0],location[1],size[0],size[1]);}
    public int getX(){return location[0];}
    public int getY(){return location[1];}
    public int[] getSize(){return size;}
    public int[] getLocation(){return location;}
//    public int getSpeed(){return speed;}
//    public void setSpeed(int s){speed=s;}
}