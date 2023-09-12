package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Direction.*;

public class GamePanel extends JPanel{
    private final static int HERO_ANIMATION_Y = 9, HERO_ANIMATION_X = 6;
    private int xImg = 1, yImg = 1;
    private MouseInputs mouseInputs;
    private BufferedImage heroImg;
    private BufferedImage[][] animations;
    private int animationTick, animationIndex, animationSpeed = 15;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean moving;

    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        importImg();
        loadAnimations();
        setPanelSize();
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations(){
        animations = new BufferedImage[HERO_ANIMATION_Y][HERO_ANIMATION_X];
        for(int i =0; i<animations.length; i++){
            for(int j=0; j<animations[i].length; j++){
                animations[i][j] = heroImg.getSubimage(j*64,i*40,64,40);
            }
        }
    }
    private void setAnimation() {
        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
    }
    private void updateAnimationTick(){
        animationTick++;
        if(animationTick >= animationSpeed){
            animationTick = 0;
            animationIndex++;
            if(animationIndex >= GetSpriteAmount(playerAction)) animationIndex=0;
        }
    }

    private void importImg() {
        InputStream inputStream = getClass().getResourceAsStream("/player_sprites.png");
        try {
            heroImg = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
        setAnimation();
        updatePlayerPosition();
        g.drawImage(animations[playerAction][animationIndex], xImg, yImg,256,160,null);
    }

    private void updatePlayerPosition() {
        if(moving){
            switch (playerDirection){
                case LEFT:
                    xImg-=5;
                    break;
                case UP:
                    yImg-=5;
                    break;
                case RIGHT:
                    xImg+=5;
                    break;
                case DOWN:
                    yImg+=5;
                    break;
            }
        }
    }


    public void setDirection(int direction){
        this.playerDirection = direction;
        moving = true;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }

}
