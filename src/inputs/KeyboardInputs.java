package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                System.out.println("Z is pressed : movin up");
                gamePanel.changeyShift(-10);
                break;
            case KeyEvent.VK_Q :
                System.out.println("Q is pressed: movin left");
                gamePanel.changexShift(-10);
                break;
            case KeyEvent.VK_S :
                System.out.println("S is pressed: movin down");
                gamePanel.changeyShift(10);
                break;
            case KeyEvent.VK_D :
                System.out.println("D is pressed: movin right");
                gamePanel.changexShift(10);
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("SPACE pressed => Character jumpin");
                break;
            default:
                System.out.println("random key pressed");
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

    }
}
