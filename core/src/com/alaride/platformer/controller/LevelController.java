package com.alaride.platformer.controller;

import com.alaride.platformer.model.Bodies;
import com.alaride.platformer.model.InputControl;
import com.alaride.platformer.model.InputController;
import com.alaride.platformer.model.Level;
import com.alaride.platformer.model.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

//static- a single instance of something
//this level controller is the only one used

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    public static World gameWorld;
    private static Array<Body> worldBodies;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){

        //loads level map from my assets folder

        level = new Level("map/level_01.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);      //defines the unit per pixel
        gameWorld = new World(new Vector2(0, -9.8f), true);     //setting the games gravity
        debugRenderer = new Box2DDebugRenderer();
        worldBodies = new Array<Body>();
        spriteBatch = renderer.getSpriteBatch();        //grants the ability to draw the textures on the screen in one print
        createLevelBodies();
    }

    public static void draw(){
        spriteBatch.setProjectionMatrix(CameraController.camera.combined);
        //ready to begin drawing
        spriteBatch.begin();
        PlayerController.player.draw(spriteBatch);             //readies spritebach and ends spritebatch
        EnemyController.enemy.draw(spriteBatch);
        spriteBatch.end();


        spriteBatch.setProjectionMatrix(CameraController.inputCamera.combined);
        InputController.draw(spriteBatch);

        debugRenderer.render(gameWorld, CameraController.camera.combined);       //used to display the shapes to the exact size.
    }

    public static void update(){
        renderer.setView(CameraController.camera);       //renders map view
        renderer.render();      //renders itself
        gameWorld.step(1/60f, 1,1);

        updateWorldBodies();
    }

    private static void updateWorldBodies(){
        worldBodies.clear();
        gameWorld.getBodies(worldBodies);

        for(Body body : worldBodies){
            Sprite spriteBody = (Sprite)body.getUserData();

            if(spriteBody != null) {
                spriteBody.position = body.getPosition();
            }
        }
    }

    private static void createLevelBodies(){
        MapObjects mapObjects = level.getMapObjects(level.getMapLayer("collision"));        //gets the map layer and stores it in mapObjects

        for(MapObject mapObject : mapObjects){
            Bodies. createBody(mapObject);

        }

    }
}
