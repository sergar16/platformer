package gamestate.levels;

import gamestate.GameState;
import gamestate.GameStateManager;
import tilemap.Background;
import tilemap.TileMap;
import ui.Game;
import ui.GamePanel;

import java.awt.*;

/**
 * Created by Serhii on 12/2/2015.
 */
public class Level1 extends Level {
    private TileMap tileMap;
    private Background bg;
    public Level1(GameStateManager gsm) {
        this.gsm = gsm;
        init();
    }

    @Override
    public void init() {
        tileMap=new TileMap(30);
        tileMap.loadTiles("/tilesets/tileset.jpg");
        tileMap.loadMap("/maps/map.map");
        tileMap.setPosition(0,0);

        bg=new Background("/backgrounds/menubg.png", 1);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
       //clear screen
       bg.draw(g);
        tileMap.draw(g);
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
