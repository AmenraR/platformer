package com.alaride.platformer.model;

import com.alaride.platformer.controller.LevelController;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import java.util.HashMap;

public class Player {
    public Vector2 position;
    public Spritesheet spriteSheet;
    public String currentAnimation;

    private float stateTime;
    private HashMap<String, Animation> animations;

    public float width;
    public float height;

    public Player(int width, int height) {
        position = new Vector2( 2,6);    //creates an origin for the player's position
        animations = new HashMap<String, Animation>();
        this.width = width * (1/70f);
        this.height = height * (1/70f);
        spriteSheet = new Spritesheet("img/aliens.png", width, height);     //makes a new object for the character
        animations.put("walk", spriteSheet.createAnimation(9, 10, 0.1f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("crouch", spriteSheet.createAnimation(3, 3, 0.1f));
        animations.put("crouchLeft", spriteSheet.flipAnimation(animations.get("crouch"), true, false));

        currentAnimation = "walk";
        stateTime = 0f;

        BodyDef bodyDefinition = new BodyDef();     //stores the properties of the body
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;     //setting the type of body
        bodyDefinition.position.set(position);      //setting position

        Body playerBody = LevelController.gameWorld.createBody(bodyDefinition);      //storing all of the body's information within the player body
        playerBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();       //created shape as a rectangle.
        rectangleShape.setAsBox(this.width/2f, this.height/2, new Vector2(this.width/2f, this.height/2f), 0f);      //setting the box's height and width

        FixtureDef fixtureDefinition = new FixtureDef();        //defined the shape properties
        fixtureDefinition.shape = rectangleShape;       //storing the shape info as the definition of the shape

        playerBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();       //deletes the shape



    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x , position.y , width, height); //created animation and put it in the table

    }

    public void update(float deltaTime){
        stateTime += deltaTime;     //sets the game time

    }
}