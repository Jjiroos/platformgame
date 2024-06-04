package inputs;

import gamestates.GameStates;
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
        switch(GameStates.gameState){
            case MENU:
                gamePanel.getGame().getGameMenu().keyPressed(e);
                break;
            case PLAYING:
                gamePanel.getGame().getGamePlaying().keyPressed(e);
                break;
            default:
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
        switch(GameStates.gameState){
            case MENU:
                gamePanel.getGame().getGameMenu().keyReleased(e);
                break;
            case PLAYING:
                gamePanel.getGame().getGamePlaying().keyReleased(e);
                break;
            default:
                break;
        }
    }
}
