package gamestate;


import tilemap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Serhii on 12/1/2015.
 */
public class MenuState extends GameState {
    private Background bg;

    private int currentChoice = 0;
    private String[] options = {"Start", "HELP", "QUIT"};

    private static final Color titleColor = Color.RED;
    private static final Color optionsColor = Color.GREEN;
    private static final Color selectedColor = Color.BLACK;
    private static final Font titleFont = new Font("Century Gothic", Font.PLAIN, 28);
    private static final Font font = new Font("Arial", Font.PLAIN, 12);


    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;

        try {
            bg = new Background("/backgrounds/menubg.png", 1);
            bg.setVector(-0.1, 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        bg.update();
    }

    @Override
    public void draw(Graphics2D g2) {
        //draw bg
        bg.draw(g2);
        //draw title
        //TODO Center function
        g2.drawString("MyPlatformer", 80, 70);
        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice) {
                g2.setColor(selectedColor);
            } else {
                g2.setColor(optionsColor);
            }
            g2.drawString(options[i], 145, 140 + i * 15);
        }    }

    @Override
    public void keyPressed(int k) {
        switch (k) {
            case KeyEvent.VK_ENTER:
                select();
                break;
            case KeyEvent.VK_UP: {
                currentChoice--;
                if (currentChoice == -1) {
                    currentChoice = options.length - 1;
                }
                break;
            }
            case KeyEvent.VK_DOWN: {
                currentChoice++;
                if (currentChoice == options.length) {
                    currentChoice = 0;
                }
                break;
            }
            default:
        }
    }

    private void select() {
        switch (currentChoice) {
            case 0: //start;
                gsm.setState(1);
                break;
            case 1: //help;
                break;
            case 2:
                System.exit(0);
        }

    }

    @Override
    public void keyReleased(int k) {

    }



}
