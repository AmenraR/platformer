package com.alaride.platformer.controller;

import com.badlogic.gdx.math.Vector2;
import com.alaride.platformer.model.Player;

public class PlayerController {
    //create new variables to display map
    public static Player player;
    public static String movementAction;
    public static String specialAction;

    public static boolean grounded;

    private enum State{
        Idle, Walk, Run, Swim, Duck, Stand, Jump, Climb, Hurt
    }
    private static State playerState;
    private static final float VELOCITY= 1f;
    private static final float VELOCITY2= -1f;
    private static final float MAX_VELOCITY= 5f;
    private static final float JUMP_VELOCITY= 1f;

    public static void initializeController(){
        //render the player
        player= new Player(new Vector2(0,2), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";
        playerState= State.Idle;
    }

    public static void update(float deltaTime){
        handleInput();

        //update character position constantly

        player.update(deltaTime);
    }

    private static void handleInput(){
        //handle keyboard input
        Vector2 velocity= player.physicsBody.getLinearVelocity();
        Vector2 position= player.physicsBody.getPosition();

        if(Math.abs(velocity.x)> MAX_VELOCITY){
            velocity.x= Math.signum(velocity.x)* MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(movementAction.equalsIgnoreCase("right")){

            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
            player.direction= "right";
        }

        if(movementAction.equalsIgnoreCase("left")){

            player.physicsBody.applyLinearImpulse(VELOCITY2, 0f, position.x, position.y, true);
            player.direction= "left";
        }

        if(specialAction.equalsIgnoreCase("jump")){

            player.physicsBody.applyLinearImpulse(0f, JUMP_VELOCITY, position.x, position.y, true);
        }

        if(Math.abs(velocity.x)>0){
            playerState= State.Walk;
        }

        else{
            playerState=State.Idle;
        }
        setCurrentAnimation();

    }

    private static void setCurrentAnimation(){
        if (player.direction.equals("right")){
            setRightAnimation();
        }
        else if (player.direction.equals("left")){
            setLeftAnimation();
        }
    }

    private static void setRightAnimation(){
        if (playerState== State.Walk){
            player.currentAnimation= "walk";
        }
        else if (playerState== State.Idle){
            player.currentAnimation= "stand";
        }
    }

    private static void setLeftAnimation(){
        if (playerState== State.Walk){
            player.currentAnimation= "walkFlip";
        }
        else if (playerState== State.Idle){
            player.currentAnimation= "stand";
        }
    }
    private static void setJumpAnimation(){
        if (playerState == State.Jump){
            player.currentAnimation= "jump";
        }


    }


}