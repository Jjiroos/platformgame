package main;

import entities.Player;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static main.GameWindow.GAME_HEIGTH;
import static main.GameWindow.GAME_WIDTH;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game){
        this.game = game;
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        setPanelSize();
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGTH);
        setPreferredSize(size);
        System.out.println("size : "+ GAME_WIDTH + " : " + GAME_HEIGTH);
    }

    public void updateGame(){

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame(){
        return game;
    }
}
