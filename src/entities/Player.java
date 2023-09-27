package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.PlayerConstants.*;
import static utilz.HelpMethods.*;

public class Player extends Entity{
    private final static int HERO_ANIMATION_Y = 9, HERO_ANIMATION_X = 6;
    private BufferedImage[][] animations;
    private int animationTick, animationIndex, animationSpeed = 15;
    private int playerAction = IDLE;
    private int playerSpeed = 2;
    private boolean left;
    private boolean up;
    private boolean right;
    private boolean down;
    private boolean moving;
    private boolean attacking;
    private int[][] levelData;
    public Player(float x, float y,int width, int heigth) {
        super(x, y,width,heigth);
        loadAnimations();
    }

    public void update(){
        updatePlayerPosition();
        updateHitbox();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g){
        g.drawImage(animations[playerAction][animationIndex], (int)xPosition, (int)yPosition,128,80,null);
        drawHitbox(g);
    }
    private void setAnimation() {
        int startAnimation = playerAction;
        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
        if(attacking)
            playerAction = ATTACK_1;
        if(startAnimation != playerAction)
            resetAnimationTick();
    }

    private void resetAnimationTick() {
        animationTick = 0;
        animationIndex = 0;
    }

    private void updateAnimationTick(){
        animationTick++;
        if(animationTick >= animationSpeed){
            animationTick = 0;
            animationIndex++;
            if(animationIndex >= GetSpriteAmount(playerAction)){
                animationIndex=0;
                attacking = false;
            }
        }
    }
    private void updatePlayerPosition() {
        moving = false;
        if(!left && !right && !up && !down)
            return;

        float xSpeed = 0, ySpeed = 0;

        if(left && !right)
            xSpeed= -playerSpeed;
        else if(!left && right)
            xSpeed= playerSpeed;

        if(up && !down)
            ySpeed = -playerSpeed;
        else if(!up && down)
            ySpeed =playerSpeed;

        if(CanMoveHere(xPosition+xSpeed, yPosition+ySpeed, width, height, levelData)){
            this.xPosition += xSpeed;
            this.yPosition += ySpeed;
            moving = true;
        }

    }

    private void loadAnimations(){
        BufferedImage heroImg = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
        animations = new BufferedImage[HERO_ANIMATION_Y][HERO_ANIMATION_X];
        for(int i =0; i<animations.length; i++){
            for(int j=0; j<animations[i].length; j++){
                animations[i][j] = heroImg.getSubimage(j*64,i*40,64,40);
            }
        }
    }
    public void loadLevelData(int [][] levelData){
        this.levelData = levelData;
    }
    public void resetDirBoolean(){
        up = false;
        left = false;
        right = false;
        down = false;
    }
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
}
