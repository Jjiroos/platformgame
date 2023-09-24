package main;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow {
    public final static int TILES_DEFAULT_SIZE =32;
    public final static float SCALE = 2f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGTH = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGTH = TILES_SIZE * TILES_IN_HEIGTH;
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
