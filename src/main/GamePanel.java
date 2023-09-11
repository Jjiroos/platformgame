package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel{
    private float xShift = 100, yShift = 100;
    private float xDir =0.5f, yDir=0.5f;
    private Color color = new Color(98,45,78);
    private MouseInputs mouseInputs;
    private int frames = 0;
    private long lastCheck = 0;
    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        setPanelSize();
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateGform();
        g.setColor(color);
        g.fillRect((int)xShift,(int)yShift,100,50);

    }
    public void changexShift(int xShift){
        this.xShift += xShift;
    }
    public void changeyShift(int yShift){
        this.yShift += yShift;
    }

    public void changeRectPosition(int x, int y){
        this.xShift = x;
        this.yShift = y;
    }
    public void updateGform(){
        xShift+=xDir;
        if(xShift > 400 || xShift < 0){
            xDir*=-1;
            color = getRandomColor();
        }
        yShift+=yDir;
        if(yShift > 400 || yShift < 0){
            yDir*=-1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);;
        return new Color(r,g,b);
    }
}
