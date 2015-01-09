package com.alaride.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    public static void initializeController(){
        float width = Gdx.graphics.getWidth();      //looks through the graphics library and pulls the window width and saves it into a variable
        float height = Gdx.graphics.getHeight();        //grabs the window height from the graphics library and saves it into a variable

        camera= new OrthographicCamera(14f, 14f*(height/width));       //defines the size of camera in units
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);       //sets the camera position to the saved camera height and width

    }

    public static void update(){
        camera.update();        //updates position of camera

    }

    public static void resize(int width, int height){
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        camera.update();        //updates position of camera
    }
}
