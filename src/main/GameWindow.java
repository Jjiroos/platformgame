package main;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

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
        gameScreen.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {

            }
        });
    }
}
