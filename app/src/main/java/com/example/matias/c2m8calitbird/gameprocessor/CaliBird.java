package com.example.matias.c2m8calitbird.gameprocessor;

/**
 * Name:        CaliBird
 * Description: Defines a concrete Actor class that represents the CaliBird
 * Created by matias on 24.4.2016.
 */
public class CaliBird extends Actor {

    /**
     * Name:        CaliBird
     * Description: Constructor with specified X and Y coordinates for the Actor
     * @param x     Horizontal coordinate
     * @param y     Vertical coordinate
     */
    public CaliBird(int x, int y) {
        super(x, y);
    }

    /**
     * Name:            CaliBird
     * Description:     Constructor with specified Location object for the Actor
     * @param location  Location object
     */
    public CaliBird(Location location) {
        super(location);
    }

    /**
     * Name:        move
     * Description: Empty method because the actual move is implemented
     *              elsewhere
     * @return      Boolean dummy value (always true)
     */
    @Override
    public boolean move() {
        return true;
    }
}
