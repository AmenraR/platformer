package com.alaride.platformer.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Level {
    public TiledMap map;

    public Level(String mapPath){
        map = new TmxMapLoader().load(mapPath);      //takes path to map

    }

}
