package gamestate;

import gamestate.levels.Level;
import gamestate.levels.Level1;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Serhii on 12/1/2015.
 */
public class GameStateManager {
    private ArrayList<GameState> gameStates;
    private int currentState;

    public static final int MENUSTATE = 0;
    public static final int LEVEL1 = 1;

    public GameStateManager() {
        gameStates = new ArrayList<GameState>();
        currentState = MENUSTATE;
        gameStates.add(new MenuState(this));
        gameStates.add(new Level1(this));

    }

    public void setState(int state) {
        currentState = state;
        gameStates.get(currentState).init();
    }

    public void update() {
        gameStates.get(currentState).update();
    }

    public void draw(Graphics2D g2) {
        gameStates.get(currentState).draw(g2);
    }

    public void keyPressed(int k) {
        gameStates.get(currentState).keyPressed(k);

    }
    public void keyReleased(int k){
        gameStates.get(currentState).keyReleased(k);
    }

}
