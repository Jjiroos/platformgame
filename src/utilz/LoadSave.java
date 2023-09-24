package utilz;

import main.GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {
    public static final String PLAYER_ATLAS = "player_sprites.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "level_one_data.png";
    public static BufferedImage GetSpriteAtlas(String fileName){
        BufferedImage heroImg = null;
        InputStream inputStream = LoadSave.class.getResourceAsStream("/"+fileName);
        try {
            heroImg = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally{
            try{
                inputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return heroImg;
    }

    public static int[][] GetLevelData(){
        int levelDatas[][] = new int[GameWindow.TILES_IN_HEIGTH][GameWindow.TILES_IN_WIDTH];
        BufferedImage levelImage = GetSpriteAtlas(LEVEL_ONE_DATA);

        for(int i=0; i < levelImage.getHeight(); i++){
            for(int j=0; j < levelImage.getWidth(); j++){
                Color color = new Color(levelImage.getRGB(j,i));
                int value = color.getRed();
                if(value >= 48)
                    value = 0;
                levelDatas[i][j] = value;
            }
        }
        return levelDatas;
    }
}
