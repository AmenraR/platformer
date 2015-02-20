package com.alaride.platformer.model;

import com.alaride.platformer.controller.PlayerController;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class CollisionListener implements ContactListener {     //use implements for classes that act as blueprints
    @Override
    public void beginContact(Contact contact) {     //what to do during a contact
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        boolean sensorA = fixtureA.isSensor();
        boolean sensorB = fixtureB.isSensor();

        if(sensorA || sensorB){
            PlayerController.grounded = true;

        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
