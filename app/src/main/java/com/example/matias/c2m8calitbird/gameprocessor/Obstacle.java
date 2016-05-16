package com.example.matias.c2m8calitbird.gameprocessor;

/**
 * Name:        Obstacle
 * Description: Defines a concrete Actor class that represents an
 *              Obstacle in the game
 * Created by matias on 5.5.2016.
 */
public class Obstacle extends Actor {

    /**
     * Name:        Obstacle
     * Description: Constructor with specified X and Y coordinates for the Actor
     * @param x     Horizontal coordinate
     * @param y     Vertical coordinate
     */
    public Obstacle(int x, int y) {
        super(x, y);
    }

    /**
     * Name:            Obstacle
     * Description:     Constructor with specified Location object for the Actor
     * @param location  Location object
     */
    public Obstacle(Location location) {
        super(location);
    }

    /**
     * Name:        move
     * Description: Shifts obstacle to the left
     * @return      Boolean indicating if the Obstacle was successfully moved
     */
    @Override
    public boolean move() {
        return this.decrementX();
    }
}
