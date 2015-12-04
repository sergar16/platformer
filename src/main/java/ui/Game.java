package ui;

import javax.swing.*;

/**
 * Created by Serhii on 12/1/2015.
 */
public class Game {
    public static void main(String[] args){
        JFrame window=new JFrame("myPlatformer");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
