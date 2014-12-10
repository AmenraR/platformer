package com.alaride.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Spritesheet {

    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;
    public Animation animation;

    public Spritesheet(String pathToFile, int width, int height) {

        spriteSheet = new Texture(Gdx.files.internal(pathToFile));       //looks into the assets folder and searches for aliens and saves it in the spritesheet variable

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);      //

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

    public Animation createAnimation(){
        TextureRegion[] animationFrames = new TextureRegion[2];     //a spot saved for the two walking animations (45 and 46) in textureRegion
        animationFrames[0] = spriteFrames[45];      //a saved frame for the first step of the walking animation
        animationFrames[1] = spriteFrames[46];      //a saved frame for the second step of the walking animation
        animation = new Animation(0.5f, animationFrames);       //the animation flip rate, and where the frames are selected from

        return animation;
    }
}
