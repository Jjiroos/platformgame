package levels;

import main.Game;
import main.GameWindow;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.LoadSave.LEVEL_ATLAS;

public class LevelManager {
    private Game game;
    private BufferedImage[] levelSprite;
    private Level levelOne;
    public LevelManager(Game game) {
        this.game = game;
//        levelSprite = LoadSave.getSpriteAtlas(LEVEL_ATLAS);
        importOutsideSprites();
        levelOne = new Level(LoadSave.GetLevelData());
    }

    private void importOutsideSprites() {
        BufferedImage image = LoadSave.GetSpriteAtlas(LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];
        for(int i =0; i<4; i++){
            for(int j =0; j<12; j++){
                int index = i*12 + j;
                levelSprite[index] = image.getSubimage(j*32,i*32,32,32);
            }
        }
    }

    public void draw(Graphics g){
        for(int i = 0; i< GameWindow.TILES_IN_HEIGTH; i++){
            for(int j =0; j<GameWindow.TILES_IN_WIDTH; j++){
                int index = levelOne.getSpritesIndex(j,i);
                g.drawImage(levelSprite[index], j*GameWindow.TILES_SIZE,i*GameWindow.TILES_SIZE,GameWindow.TILES_SIZE,GameWindow.TILES_SIZE,null);
            }
        }
    }

    public void update(){

    }

    public Level getCurrentLevel(){
        return levelOne;
    }
}
