package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.PlayerConstants.*;

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
    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update(){
        updatePlayerPosition();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g){
        g.drawImage(animations[playerAction][animationIndex], (int)xPosition, (int)yPosition,128,80,null);
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

        if(left && !right) {
            xPosition-= playerSpeed;
            moving = true;
        }
        else if(!left && right){
            xPosition+= playerSpeed;
            moving = true;
        }
        if(up && !down){
            yPosition-=playerSpeed;
            moving = true;
        }
        if(!up && down){
            yPosition+=playerSpeed;
            moving =true;
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
