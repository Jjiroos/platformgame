package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {

    protected float xPosition, yPosition;
    protected int width, height;
    protected Rectangle2D.Float hitbox;

    public Entity(float x, float y, int width, int height){
        xPosition = x;
        yPosition = y;
        this.width = width;
        this.height= height;
    }

    protected void initHitbox(float xPosition, float yPosition, float width, float height) {
        hitbox = new Rectangle2D.Float(xPosition, yPosition, width, height);
    }

    protected void drawHitbox(Graphics g){
        //This method only usefull for debugging the hitbox
        g.setColor(Color.RED);
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }
//    protected void updateHitbox(){
//        hitbox.x = (int) xPosition;
//        hitbox.y = (int) yPosition;
//    }

    public Rectangle2D.Float getHitbox(){
        return this.hitbox;
    }

}
