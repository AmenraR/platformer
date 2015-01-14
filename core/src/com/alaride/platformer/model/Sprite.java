package com.alaride.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import java.util.HashMap;

public class Sprite {

    public Body physicsBody;
    public Vector2 position;
    public Spritesheet spriteSheet;
    public String currentAnimation;

    protected float stateTime;
    protected HashMap<String, Animation> animations;

    public float width;
    public float height;

    public Sprite(Vector2 position, int width, int height){
        this.position = position;    //creates an origin for the player's position
        animations = new HashMap<String, Animation>();

        this.width = width * (1/70f);
        this.height = height * (1/70f);

        spriteSheet = new Spritesheet("img/aliens.png", width, height);     //makes a new object for the character
        currentAnimation = "walk";
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x , position.y , width, height); //created animation and put it in the table

    }

    public void update(float deltaTime){
        stateTime += deltaTime;     //sets the game time

    }
}
