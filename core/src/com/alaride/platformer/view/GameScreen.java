package com.alaride.platformer.view;

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
        camera= new OrthographicCamera(14f, 14f);       //defines the size of camera in units
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
