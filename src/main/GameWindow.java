package main;

import javax.swing.JFrame;

public class GameWindow {
    JFrame gameScreen;
    public GameWindow(GamePanel gamePanel){
        gameScreen  = new JFrame();
        gameScreen.setSize(400, 400);
        gameScreen.setLocationRelativeTo(null);
        gameScreen.add(gamePanel);
        gameScreen.setVisible(true);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
