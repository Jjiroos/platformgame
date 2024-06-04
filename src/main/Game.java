package main;

import gamestates.GameMenu;
import gamestates.GamePlaying;
import gamestates.GameStates;

import java.awt.*;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameLoopThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

//    public enum GameStates {
//        PLAYING, MENU;
//
//        public static GameStates gameState = MENU;
//    }

    private GamePlaying gamePlaying;
    private GameMenu gameMenu;

    public Game(){
        initEntities();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initEntities() {
        gamePlaying = new GamePlaying(this);
        gameMenu = new GameMenu(this);
    }

    private void startGameLoop(){
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    public void update(){

        switch(GameStates.gameState){
            case GameStates.MENU:
                gameMenu.update();
                break;
            case GameStates.PLAYING:
                gamePlaying.update();
                break;
        }
    }

    public void render(Graphics g){

        switch(GameStates.gameState){
            case GameStates.MENU:
                gameMenu.draw(g);
                break;
            case GameStates.PLAYING:
                gamePlaying.draw(g);
                break;
        }
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();
        long lastCheck = System.currentTimeMillis();

        int updates = 0;
        int frames = 0;

        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentSystemTime = System.nanoTime();

            deltaU += (currentSystemTime - previousTime) / timePerUpdate;
            deltaF += (currentSystemTime - previousTime) / timePerFrame;
            previousTime = currentSystemTime;

            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }
            if(deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS : "+frames + " | UPS : "+updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public void windowFocusLost() {
        if(GameStates.gameState == GameStates.PLAYING)
            gamePlaying.getPlayer().resetDirBoolean();
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public GamePlaying getGamePlaying() {
        return gamePlaying;
    }
}
