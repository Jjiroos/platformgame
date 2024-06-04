package gamestates;

import main.Game;
import main.GameWindow;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameMenu extends State implements StateMethods{

    public GameMenu(Game game) {
        super(game);
    }

    /**
     *
     */
    @Override
    public void update() {

    }

    /**
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("GAME MENU\n PRESS 'ENTER' TO RESUME", GameWindow.GAME_WIDTH / 2, GameWindow.GAME_HEIGTH / 2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }

    /**
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            GameStates.gameState = GameStates.PLAYING;
    }

    /**
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

}
