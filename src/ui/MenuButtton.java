package ui;

import gamestates.GameStates;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.Buttons.*;

public class MenuButtton implements Button {
    private int x, y, rowIndex, index;
    private int xOffsetCenter = BT_WIDTH / 2;
    private GameStates gameStates;
    private BufferedImage[] images;
    private boolean mouseIsPressed, mouseOver;

    public Rectangle getBounds() {
        return bounds;
    }

    private Rectangle bounds;

    public MenuButtton(int x, int y, int rowIndex, GameStates gameStates) {
        this.x = x;
        this.y = y;
        this.rowIndex = rowIndex;
        this.gameStates = gameStates;
        loadImages();
        initBounds();
    }

    private void initBounds() {
        this.bounds = new Rectangle(x - xOffsetCenter, y, BT_WIDTH, BT_HEIGHT);
    }

    private void loadImages() {
        images = new BufferedImage[3];
        BufferedImage tmp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);
        for (int i = 0; i < images.length; i++) {
            images[i] = tmp.getSubimage(i * BT_WIDTH_DEFAULT, rowIndex * BT_HEIGHT_DEFAULT, BT_WIDTH_DEFAULT, BT_HEIGHT_DEFAULT);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(images[index], x - xOffsetCenter, y, BT_WIDTH, BT_HEIGHT, null);
    }

    public void update(){
        index = 0;
        if(mouseOver)
            index = 1;
        if(mouseIsPressed)
            index = 2;
    }

    public boolean isMouseIsPressed() {
        return mouseIsPressed;
    }

    public void setMouseIsPressed(boolean mouseIsPressed) {
        this.mouseIsPressed = mouseIsPressed;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public void applyGameState(){
        GameStates.gameState = gameStates;
    }

    public void resetMouseState(){
        mouseOver = false;
        mouseIsPressed = false;
    }
}
