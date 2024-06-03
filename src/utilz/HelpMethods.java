package utilz;

import main.GameWindow;

import java.awt.geom.Rectangle2D;

public class HelpMethods {
    public static boolean canMoveHere(float x, float y, float width, float height, int [][] levelData){
        if(!isSolid(x,y,levelData))
            if(!isSolid(x+width,y+height,levelData))
                if(!isSolid(x+width,y,levelData))
                    if(!isSolid(x,y+height,levelData))
                        return true;
        return false;
    }

    private static boolean isSolid(float x, float y, int [][] levelData){
        if(x < 0 || x >= GameWindow.GAME_WIDTH)
            return true;
        if(y<0 || y >= GameWindow.GAME_HEIGTH)
            return true;

        float xIndex = x / GameWindow.TILES_SIZE;
        float yIndex = y / GameWindow.TILES_SIZE;

        int value = levelData[(int)yIndex][(int)xIndex];

        if(value >= 48 || value < 0 || value != 11)
            return true;
        return false;
    }

    public static float getEntityXposNextToWall(Rectangle2D.Float hitbox, float xSpeed){

        int currentTile = (int) (hitbox.x / GameWindow.TILES_SIZE);
        int tileXpos = 0;
        int xOffset = 0;

        if(xSpeed > 0){
            tileXpos = currentTile * GameWindow.TILES_SIZE;
            xOffset = (int) (GameWindow.TILES_SIZE - hitbox.width);
            return tileXpos + xOffset -1;
        }else{
            return currentTile * GameWindow.TILES_SIZE;
        }
    }

    public static float getEntityYPosUnderRoofOrFloor(Rectangle2D.Float hitbox, float airSpeed){
        int currentTile = (int) (hitbox.y / GameWindow.TILES_SIZE);
        int tileYpos = 0;
        int yOffset = 0;

        if(airSpeed > 0){
            /*
                Falling and touching floor
             */
            tileYpos = currentTile * GameWindow.TILES_SIZE;
            yOffset = (int) (GameWindow.TILES_SIZE - hitbox.height);
            return tileYpos + yOffset -1;
        }
        else{
            return currentTile * GameWindow.TILES_SIZE;
        }
    }

    public static boolean isEntityOnFloor(Rectangle2D.Float hitbox, int[][] levelDatas){
        if(!isSolid(hitbox.x,hitbox.y + hitbox.height + 1,levelDatas))
            if(!isSolid(hitbox.x + hitbox.width,hitbox.y+ hitbox.height + 1,levelDatas))
                return false;
        return true;
    }
}
