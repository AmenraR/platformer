package com.alaride.platformer.view;

import com.alaride.platformer.controller.CameraController;
import com.alaride.platformer.controller.EnemyController;
import com.alaride.platformer.controller.LevelController;
import com.alaride.platformer.controller.PlayerController;
import com.alaride.platformer.model.InputControl;
import com.alaride.platformer.model.InputController;
import com.alaride.platformer.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen implements Screen{
    //setting variables



    public GameScreen() {
        LevelController.initializeController();
        CameraController.initializeController();
        PlayerController.intitializeController();
        EnemyController.initializeController();
        InputController.initializeController();
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.29f, 1f, 0.39f, 1f);  //Clears the Screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);    //Fills the screen with the color

        //updates all, every moment the platformer is active

        CameraController.update();
        LevelController.update();
        PlayerController.update(delta);
        EnemyController.update(delta);
        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width,height);
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
