package com.alaride.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class InputController {
    private static Spritesheet spritesheet;
    private static InputControl left;

    public static void initializeController(){
        spritesheet = new Spritesheet("img/touch-controls.png", 80, 80);
        left = new InputControl(new Vector2(0,0), spritesheet.spriteFrames[0], "left");     //initializing the controller with the task

    }

    public static void draw(Batch spriteBatch){
        spriteBatch.begin();
        left.draw(spriteBatch);     //creating the sprite onscreen
        spriteBatch.end();
    }
}
