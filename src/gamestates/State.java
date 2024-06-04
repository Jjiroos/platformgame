package gamestates;

import main.Game;
import ui.MenuButtton;

import java.awt.event.MouseEvent;

public abstract class State {

    protected Game game;

    public State(Game game){
        this.game = game;
    }

    public boolean isIn(MouseEvent e, MenuButtton mb) {
        return mb.getBounds().contains(e.getX(), e.getY());
    }

    private Game getGame(){
        return this.game;
    }
}
