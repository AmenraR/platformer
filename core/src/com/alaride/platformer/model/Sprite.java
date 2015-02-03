package com.alaride.platformer.model;

import com.alaride.platformer.controller.LevelController;
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
    public String direction;
    protected HashMap<String, Animation> animations;

    public float width;
    public float height;

    public Sprite(Vector2 position, int width, int height, String sheetPath){
        this.position = position;    //creates an origin for the player's position
        animations = new HashMap<String, Animation>();

        this.width =width* (LevelController.UNIT_SCALE);
        this.height = height * (LevelController.UNIT_SCALE);

        spriteSheet = new Spritesheet(sheetPath, width, height);     //makes a new object for the character
        direction = "right";
        stateTime = 0f;
        currentAnimation = "walk";
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x , position.y , width, height); //created animation and put it in the table

    }

    public void update(float deltaTime){
        stateTime += deltaTime;     //sets the game time

    }
}
