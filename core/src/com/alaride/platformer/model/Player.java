package com.alaride.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Texture spritesheet;

    public Player() {
        position = new Vector2(0,0);    //creates an origin for the player's position
        spritesheet = new Texture(Gdx.files.internal("img/aliens(1).png"));       //looks into the assets folder and searches for aliens and saves it in the spritesheet variable
    }
}
