package com.alaride.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import javax.xml.soap.Text;

public class Player {
    public Vector2 position;
    public Texture spritesheet;
    public TextureRegion[] spriteFrames;

    public Player() {
        position = new Vector2(0,0);    //creates an origin for the player's position
        spritesheet = new Texture(Gdx.files.internal("img/aliens 1).png"));       //looks into the assets folder and searches for aliens and saves it in the spritesheet variable

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spritesheet, 70, 100);

        int counter = 0;

        for(int row = 0; row < spriteSheetFrames.length; row++){
            for(int column = 0; column < spriteSheetFrames[row].length; column++){
                counter++;
            }
        }

        spriteFrames = new TextureRegion[counter];  //saves the amount of rows in spriteFrames TO store

        counter = 0;

        for (TextureRegion[] row : spriteSheetFrames){      //looks at spriteSheetFrames and stores it in row
            for (TextureRegion sprite : row){       //checks every row, and takes out every column, then stores it in sprite
                spriteFrames[counter++] = sprite;       //puts the aliens from sprite into spriteFrames and counts them.

            }

        }
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(spriteFrames[37], 0 , 0 , 70, 100);

    }

    public void update(float deltaTime){


    }
}
