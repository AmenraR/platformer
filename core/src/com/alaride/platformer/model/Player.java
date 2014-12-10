package com.alaride.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;;

public class Player {
    public Vector2 position;
    public Animation animation;
    public Spritesheet spriteSheet;
    private float stateTime;

    public int width;
    public int height;

    public Player() {
        position = new Vector2(0,0);    //creates an origin for the player's position
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);     //makes a new object for the character
        animation = spriteSheet.createAnimation();      //saves the animation

        stateTime = 0f;

    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x , position.y , width * (1/70f), height * (1/70f));

    }

    public void update(float deltaTime){
        stateTime += deltaTime;     //sets the game time
        position.y += deltaTime;    //adds to the variable of
    }
}