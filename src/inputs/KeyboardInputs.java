package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constants.Direction.*;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case KeyEvent.VK_Z :
                gamePanel.setDirection(UP);
                break;
            case KeyEvent.VK_Q :
                gamePanel.setDirection(LEFT);
                break;
            case KeyEvent.VK_S :
                gamePanel.setDirection(DOWN);
                break;
            case KeyEvent.VK_D :
                gamePanel.setDirection(RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                break;
        }

    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_Z:
            case KeyEvent.VK_Q:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                gamePanel.setMoving(false);
        }
    }
}
