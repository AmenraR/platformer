package com.alaride.platformer;

import com.alaride.platformer.view.GameScreen;
import com.badlogic.gdx.Game;

public class Platformer extends Game {
    @Override
    public void create() {
        //sets the GameScreen area
        setScreen(new GameScreen());
    }
}
