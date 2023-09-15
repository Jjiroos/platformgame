package main;

import entities.Player;
import levels.LevelManager;

import java.awt.*;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameLoopThread;
    private Player player;
    private LevelManager levelManager;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    public Game(){
        initEntities();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        levelManager = new LevelManager(this);
        startGameLoop();
    }

    private void initEntities() {
        player = new Player(200,200);
    }

    private void startGameLoop(){
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    public void update(){
        player.update();
        levelManager.update();
    }

    public void render(Graphics g){
        player.render(g);
        levelManager.draw(g);
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
                System.out.println("FPS : "+frames + "UPS : "+updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBoolean();
    }
}
