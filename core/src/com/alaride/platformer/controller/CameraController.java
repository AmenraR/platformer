package com.alaride.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;
    public static OrthographicCamera inputCamera;

    public static float widthScale;
    public static float heightScale;

    public static void initializeController(){
        float width = Gdx.graphics.getWidth();      //looks through the graphics library and pulls the window width and saves it into a variable
        float height = Gdx.graphics.getHeight();        //grabs the window height from the graphics library and saves it into a variable

        camera= new OrthographicCamera(14f, 14f*(height/width));       //defines the size of camera in units
        inputCamera = new OrthographicCamera(14f,14f*(height/width));
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f,0);
        inputCamera.update();
    }

    public static void update(){
        camera.position.set(PlayerController.player.position.x, PlayerController.player.position.y, 0);     //gives the camera a place to follow ( player
        camera.update();        //updates position of camera


    }

    public static void resize(int width, int height){
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        camera.update();        //updates position of camera

        inputCamera.viewportWidth = 14f;
        inputCamera.viewportHeight = 14f * height / width;
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f,0);
        inputCamera.update();
    }
}
//vid 52 5:15