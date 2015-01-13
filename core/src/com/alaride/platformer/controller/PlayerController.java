package com.alaride.platformer.controller;

import com.alaride.platformer.model.Player;
import com.badlogic.gdx.math.Vector2;

public class PlayerController {

    public static Player player;

    public static void intitializeController(){
        player = new Player(new Vector2(2,6), 70, 100);
    }

    public static void update(float deltaTime){
        player.update(deltaTime);
    }
}
