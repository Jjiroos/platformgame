package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    private int xShift = 100, yShift = 100;
    private MouseInputs mouseInputs;

    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(xShift,yShift,100,50);
    }
    public void changexShift(int xShift){
        this.xShift += xShift;
        repaint();
    }
    public void changeyShift(int yShift){
        this.yShift += yShift;
        repaint();
    }

    public void changeRectPosition(int x, int y){
        this.xShift = x;
        this.yShift = y;
        repaint();
    }
}
