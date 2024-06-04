package gamestates;

import main.Game;
import main.GameWindow;
import ui.MenuButtton;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameMenu extends State implements StateMethods{

    private MenuButtton[] menuButttons = new MenuButtton[3];

    public GameMenu(Game game) {
        super(game);
        loadButtonsSprites();
    }

    private void loadButtonsSprites() {
        menuButttons[0] = new MenuButtton(GameWindow.GAME_WIDTH / 2, (int) (150 * GameWindow.SCALE) ,0 , GameStates.PLAYING);
        menuButttons[1] = new MenuButtton(GameWindow.GAME_WIDTH / 2, (int) (220 * GameWindow.SCALE) ,1 , GameStates.OPTIONS);
        menuButttons[2] = new MenuButtton(GameWindow.GAME_WIDTH / 2, (int) (290 * GameWindow.SCALE) ,2 , GameStates.QUIT);
    }

    /**
     *
     */
    @Override
    public void update() {
        for(MenuButtton menuButtton : menuButttons){
            menuButtton.update();
        }
    }

    /**
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        for(MenuButtton menuButtton : menuButttons){
            menuButtton.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        for(MenuButtton menuButtton : menuButttons){
            if(isIn(e,menuButtton)){
                menuButtton.setMouseIsPressed(true);
                break;
            }
        }
    }

    /**
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        for(MenuButtton menuButtton : menuButttons){
            if(!isIn(e,menuButtton)){
                if(menuButtton.isMouseIsPressed())
                    menuButtton.applyGameState();
                break;
            }
        }
        resetButtons();
    }

    private void resetButtons() {
        for(MenuButtton menuButtton : menuButttons){
            menuButtton.resetMouseState();
        }
    }

    /**
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        for(MenuButtton menuButtton : menuButttons){
            menuButtton.setMouseOver(false);
        }

        for(MenuButtton menuButtton : menuButttons){
            if(isIn(e,menuButtton)){
                menuButtton.setMouseOver(true);
                break;
            }
        }
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
