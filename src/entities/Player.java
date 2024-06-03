package entities;

import main.Game;
import main.GameWindow;
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
    private float playerSpeed = 2.0f;
    private boolean left, up, right, down, moving, attacking;
    private int[][] levelData;
    private float xDrawOffset = 21 * GameWindow.SCALE;
    private float yDrawOffset = 4 * GameWindow.SCALE;
    private int hitboxWidth = 20;
    private int hitboxHeight = 27;
    private boolean isDebug = false;
    /*
        Jumping and gravity settings for the player
     */
    private boolean jump, inAir;
    private float airSpeed = 0.f;
    private float gravity = 0.04f * GameWindow.SCALE;
    private float jumpSpeed = -2.25f * GameWindow.SCALE;
    private float fallSpeedAfterCollision = 0.5f * GameWindow.SCALE;


    public Player(float x, float y,int width, int heigth) {
        super(x, y,width,heigth);
        loadAnimations();
        initHitbox(x,y, hitboxWidth*GameWindow.SCALE, hitboxHeight*GameWindow.SCALE);
    }

    public void update(){
        updatePlayerPosition();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g){
        g.drawImage(animations[playerAction][animationIndex], (int) (hitbox.x - xDrawOffset), (int)(hitbox.y - yDrawOffset),width,height,null);
        if(isDebug)
            drawHitbox(g);
    }
    private void setAnimation() {
        int startAnimation = playerAction;
        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
        if(inAir) {
            if (airSpeed < 0)
                playerAction = JUMPING;
            else
                playerAction = FALLING;
        }
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
        if (jump)
            jump();

        if(!left && !right && !inAir)
            return;

        float xSpeed = 0;

        if(left)
            xSpeed -= playerSpeed;
        if(right)
            xSpeed += playerSpeed;

        if(!inAir)
            if(!isEntityOnFloor(hitbox, levelData))
                inAir = true;

        if(inAir){
            if(canMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, levelData)){
                hitbox.y += airSpeed;
                airSpeed += gravity;
                updateXpos(xSpeed);
            } else {
                hitbox.y = getEntityYPosUnderRoofOrFloor(hitbox, airSpeed);
                if(airSpeed > 0)
                    resetInAir();
                else
                    airSpeed = fallSpeedAfterCollision;
                updateXpos(xSpeed);
            }
        }else{
            updateXpos(xSpeed);
        }
        moving = true;
    }

    private void jump() {
        if (inAir)
            return;
        inAir = true;
        airSpeed = jumpSpeed;
    }

    private void resetInAir() {
        inAir = false;
        airSpeed = 0;
    }

    private void updateXpos(float xSpeed) {
        if(canMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, levelData)){
            hitbox.x += xSpeed;
        }
        else{
            hitbox.x = getEntityXposNextToWall(hitbox, xSpeed);
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
        if(!isEntityOnFloor(hitbox, levelData))
            inAir = true;
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

    public void setJump(boolean jump){
        this.jump = jump;
    }
}
