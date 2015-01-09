package com.alaride.platformer.controller;

import com.alaride.platformer.model.Player;

public class PlayerController {

    public static Player player;

    public static void intitializeController(){
        player = new Player(70, 100);
    }

    public static void update(float deltaTime){
        player.update(deltaTime);
    }
}
