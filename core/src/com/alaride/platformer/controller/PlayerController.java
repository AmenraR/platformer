package com.alaride.platformer.controller;

import com.alaride.platformer.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class PlayerController {

    public static Player player;
    public static String movementAction;
    public static String specialAction;

    private static final float VELOCITY = 1f;
    private static final float MAX_Velocity = 15f;

    public static void intitializeController(){
        player = new Player(new Vector2(2,6), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";
    }

    public static void update(float deltaTime){
        handleInput();
        player.update(deltaTime);

    }

    private static void handleInput(){
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        Vector2 position = player.physicsBody.getPosition();

        if(Math.abs(velocity.x) > MAX_Velocity) {
            velocity.x = Math.signum(velocity.x) * MAX_Velocity;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(movementAction.equalsIgnoreCase("right")){

        }


        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);

        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0f, position.x, position.y, true);

        }
    }
}

