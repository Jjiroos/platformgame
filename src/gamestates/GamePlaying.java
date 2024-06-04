package gamestates;

import entities.Player;
import levels.LevelManager;
import main.Game;
import main.GameWindow;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GamePlaying extends State implements StateMethods {

    private Player player;
    private LevelManager levelManager;

    public GamePlaying(Game game) {
        super(game);
        initEntities();
    }

    private void initEntities() {
        levelManager = new LevelManager(this.game);
        player = new Player(200F,200F,(int)(64* GameWindow.SCALE),(int)(40*GameWindow.SCALE));
        player.loadLevelData(levelManager.getCurrentLevel().getLevelDatas());
    }

    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBoolean();
    }

    /**
     *
     */
    @Override
    public void update() {
        levelManager.update();
        player.update();
    }

    /**
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        levelManager.draw(g);
        player.render(g);
    }

    /**
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            player.setAttacking(true);
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
        switch(e.getKeyCode()){
            case KeyEvent.VK_Q:
                player.setLeft(true);
                break;
            case KeyEvent.VK_D:
                player.setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(true);
                break;
            case KeyEvent.VK_ENTER:
                GameStates.gameState = GameStates.MENU;
                break;
        }
    }

    /**
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_Q:
                player.setLeft(false);
                break;
            case KeyEvent.VK_D:
                player.setRight(false);
                break;
            case KeyEvent.VK_SPACE:
                player.setJump(false);
                break;
        }
    }
}
