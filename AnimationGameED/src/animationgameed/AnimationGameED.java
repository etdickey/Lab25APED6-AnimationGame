/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationgameed;

/**
 *
 * @author 0001046365
 */
import static java.lang.System.*;
public class AnimationGameED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            new GameRunner();
        }
        catch(Exception e){
            err.println(e + " main");
        }
    }
    
}
