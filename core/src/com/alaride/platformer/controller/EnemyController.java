package com.alaride.platformer.controller;

import com.alaride.platformer.model.Enemy;
import com.badlogic.gdx.math.Vector2;

public class EnemyController {

        public static Enemy enemy;

        public static void initializeController(){
            enemy = new Enemy(new Vector2(2,9), 51, 58, "img/enemy-barnacle.png");

        }

        public static void update(float deltaTime){

            enemy.update(deltaTime);

        }

    }

