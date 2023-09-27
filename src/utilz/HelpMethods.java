package utilz;

import main.GameWindow;

public class HelpMethods {
    public static boolean CanMoveHere(float x, float y, int width, int height, int [][] levelData){

        if(!IsSolid(x,y,levelData))
            if(!IsSolid(x+width,y+height,levelData))
                if(!IsSolid(x+width,y,levelData))
                    if(!IsSolid(x,y+height,levelData))
                        return true;
        return false;

    }

    private static boolean IsSolid(float x, float y, int [][] levelData){
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

}
