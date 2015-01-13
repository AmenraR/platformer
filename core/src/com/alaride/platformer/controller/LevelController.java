package com.alaride.platformer.controller;

import com.alaride.platformer.model.Level;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

//static- a single instance of something
//this level controller is the only one used

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    public static World gameWorld;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){

        //loads level map from my assets folder

        level = new Level("map/level_01.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);      //defines the unit per pixel
        gameWorld = new World(new Vector2(0, -9.8f), true);     //setting the games gravity
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch = renderer.getSpriteBatch();        //grants the ability to draw the textures on the screen in one print
    }

    public static void draw(){
        //ready to begin drawing
        spriteBatch.begin();
        PlayerController.player.draw(spriteBatch);             //readies spritebach and ends spritebatch
        spriteBatch.end();

        debugRenderer.render(gameWorld, CameraController.camera.combined);       //used to display the shapes to the exact size.
    }

    public static void update(){
        renderer.setView(CameraController.camera);       //renders map view
        renderer.render();      //renders itself
    }
}
