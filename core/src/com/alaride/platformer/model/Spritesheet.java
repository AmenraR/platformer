package com.alaride.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Spritesheet {

    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;

    public Spritesheet(String pathToFile, int width, int height) {

        spriteSheet = new Texture(Gdx.files.internal(pathToFile));       //looks into the assets folder and searches for aliens and saves it in the spritesheet variable

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);      //

        int counter = 0;

        for (int row = 0; row < spriteSheetFrames.length; row++) {
            for (int column = 0; column < spriteSheetFrames[row].length; column++) {
                counter++;
            }
        }

        spriteFrames = new TextureRegion[counter];  //saves the amount of rows in spriteFrames TO store

        counter = 0;

        for (TextureRegion[] row : spriteSheetFrames) {      //looks at spriteSheetFrames and stores it in row
            for (TextureRegion sprite : row) {       //checks every row, and takes out every column, then stores it in sprite
                spriteFrames[counter++] = sprite;       //puts the aliens from sprite into spriteFrames and counts them.

            }

        }


    }

    public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed) {
        int counter = (lastFrame + 1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[counter];     //a spot saved for the two walking animations (45 and 46) in textureRegion

        for(int index = lastFrame; index >= startFrame; index--){
            animationFrames[--counter] = spriteFrames[index];//create the animation frames
        }

        return new Animation(animationSpeed, animationFrames);//create new animation
    }

    public Animation flipAnimation(Animation originalAnimation, boolean flipX, boolean flipY) {
        int frameCount = originalAnimation.getKeyFrames().length;
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];

        for (int index = 0; index <= frameCount - 1; index++) {
            flippedFrames[index] = new TextureRegion(originalAnimation.getKeyFrames()[index]);
            flippedFrames[index].flip(flipX, flipY);
        }
        return new Animation(originalAnimation.getFrameDuration(), flippedFrames);
    }

}
