package main;

import javax.swing.JFrame;

public class GameWindow {
    JFrame gameScreen;
    public GameWindow(GamePanel gamePanel){
        gameScreen  = new JFrame();
        gameScreen.add(gamePanel);
        gameScreen.pack();
        gameScreen.setVisible(true);
        gameScreen.setResizable(false);
        gameScreen.setLocationRelativeTo(null);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
