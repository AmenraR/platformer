package com.alaride.platformer.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;

    public Level(String mapPath){
        map = new TmxMapLoader().load(mapPath);      //takes path to map

    }

    public MapLayer getMapLayer(String LayerName){
        return map.getLayers().get(LayerName);       //gives us the information associated with the objects
    }

    public MapObjects getMapObjects(MapLayer mapLayer){
        return mapLayer.getObjects();     //selects all of the objects
    }
}
