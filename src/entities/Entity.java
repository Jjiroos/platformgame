package entities;

import java.awt.*;

public abstract class Entity {
    protected float xPosition, yPosition;
    protected int width, height;
    protected Rectangle hitbox;
    public Entity(float x, float y, int width, int height){
        xPosition = x;
        yPosition = y;
        this.width = width;
        this.height= height;
        initHitbox();
    }



    private void initHitbox() {
        hitbox = new Rectangle((int)xPosition,(int)yPosition,width,height);
    }
    protected void drawHitbox(Graphics g){
        //This method only usefull for debugging the hitbox
        g.setColor(Color.PINK);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
    protected void updateHitbox(){
        hitbox.x = (int) xPosition;
        hitbox.y = (int) yPosition;
    }

    public Rectangle getHitbox(){
        return this.hitbox;
    }

}
