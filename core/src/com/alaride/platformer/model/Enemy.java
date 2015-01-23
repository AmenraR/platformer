package com.alaride.platformer.model;

import com.alaride.platformer.controller.LevelController;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Enemy extends Sprite{

    public Enemy(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        animations.put("walk", spriteSheet.createAnimation(0, 1, 0.1f));

        BodyDef bodyDefinition = new BodyDef();     //stores the properties of the body
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;     //setting the type of body
        bodyDefinition.position.set(position);      //setting position

        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);      //storing all of the body's information within the player body
        physicsBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();       //created shape as a rectangle.
        rectangleShape.setAsBox(this.width/2f, this.height/2, new Vector2(this.width/2f, this.height/2f), 0f);      //setting the box's height and width

        FixtureDef fixtureDefinition = new FixtureDef();        //defined the shape properties
        fixtureDefinition.shape = rectangleShape;       //storing the shape info as the definition of the shape

        physicsBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();       //deletes the shape



    }

    public void draw(Batch spriteBatch){
        super.draw(spriteBatch);        //calling from super to draw
    }

    public void update(float deltaTime){
        super.update(deltaTime);        //calling from super for deltaTime
    }
}
