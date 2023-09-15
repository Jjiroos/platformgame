package utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {
    public static final String PLAYER_ATLAS = "player_sprites.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";
    public static BufferedImage getSpriteAtlas(String fileName){
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
}
