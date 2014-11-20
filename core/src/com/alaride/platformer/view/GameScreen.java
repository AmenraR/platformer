package com.alaride.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen{
    //setting variables
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        //loads level map from my assets folder
        map = new TmxMapLoader().load("map/level_01.tmx");      //takes path to map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);      //defines the unit per pixel

        float width = Gdx.graphics.getWidth();      //looks through the graphics library and pulls the window width and saves it into a variable
        float height = Gdx.graphics.getHeight();        //grabs the window height from the graphics library and saves it into a variable

        camera= new OrthographicCamera(14f, 14f*(height/width));       //defines the size of camera in units
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);       //sets the camera position to the saved camera height and width
    }

    @Override
    public void render(float delta) {
        //updates all, every moment the platformer is active
        camera.update();        //updates position of camera
        renderer.setView(camera);       //renders map view
        renderer.render();      //renders itself

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
