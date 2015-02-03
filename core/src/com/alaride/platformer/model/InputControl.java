package com.alaride.platformer.model;

import com.alaride.platformer.controller.CameraController;
import com.alaride.platformer.controller.LevelController;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class InputControl {
    public String action;       //carries the action
    public Vector2 position;        //the position

    private TextureRegion textureRegion;
    private float width;
    private float height;


    public InputControl(Vector2 position, TextureRegion textureRegion, String action ){
        //initialize
        this.textureRegion = textureRegion;
        this.position = position;
        this.action = action;

        width = textureRegion.getRegionWidth();
        height = textureRegion.getRegionHeight();

    }
    public void draw(Batch spriteBatch){
        spriteBatch.draw(textureRegion, position.x, position.y, width * LevelController.UNIT_SCALE, height* LevelController.UNIT_SCALE);     //passing in the variables
    }

    public Rectangle getBoundingBox(){
        return new Rectangle(position.x / LevelController.UNIT_SCALE * CameraController.widthScale, position.y / LevelController.UNIT_SCALE * CameraController.heightScale, width * CameraController.widthScale, height* CameraController.heightScale);
    }

}
