package ui;

import gamestate.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by Serhii on 12/1/2015.
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {

    // dimentions
    public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    public static final int SCALE = 2;

    //game thread
    private Thread thread;
    private boolean running;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    //image
    private BufferedImage image;
    private Graphics2D g;
    //game state manager
    GameStateManager gsm;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    long start;
    long elapsed;
    long wait;

    public void run() {
        init();
        while (running) {
            start = System.nanoTime();
            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;
            wait=(wait>0)  ? targetTime - elapsed / 1000000 :5;


            try {
                Thread.sleep(wait);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private void update() {
        gsm.update();
    }

    private void draw() {
        gsm.draw(g);
    }

    private void drawToScreen() {
        Graphics2D g2 = (Graphics2D) getGraphics();
        g2.drawImage(image, 0, 0,WIDTH*SCALE,HEIGHT*SCALE, null);
        g2.dispose();
    }

    private void init() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        running = true;
        gsm = new GameStateManager();
    }

    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e) {
    }
}
