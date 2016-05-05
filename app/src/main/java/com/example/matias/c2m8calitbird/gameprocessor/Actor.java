package com.example.matias.c2m8calitbird.gameprocessor;

/**
 * Name:        Actor
 * Description: Defines an abstract class for the Actors in the Game.
 * Created by matias on 24.4.2016.
 */
public abstract class Actor {
    protected Location location;
    protected boolean running;

    /**
     * Name:        Actor
     * Description: Constructor for Actor object with specified X and Y coordinates as location
     * @param x     Horizaontal coordinate
     * @param y     Vertical coordinate
     */
    public Actor(int x, int y) {
        this.location = new Location(x, y);
        this.running = true;
    }

    /**
     * Name:            Actor
     * Description:     Constructor for Actor with a Location object passed in as parameter
     * @param location  Location object to denote X and Y coordinates
     */
    public Actor(Location location) {
        this(location.getX(), location.getY());
    }


    /**
     * Name:        getLocation
     * Description: Get the location object of this actor
     * @return      The location object of this actor
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Name:        getX
     * Description: Get the X coordinate of this actor
     * @return      The X coordinate of this actor
     */
    public int getX() {
        return this.location.getX();
    }

    /**
     * Name:        getY
     * Description: Get the Y coordinate of this actor
     * @return      The Y coordinate of this actor
     */
    public int getY() {
        return this.location.getY();
    }


    /**
     * Name:        incrementX
     * Description: Increments/moves the X coordinate by 1
     * @return      Boolean indicating if the X variable is less than the Map width
     */
    public boolean incrementX() {
        location.incrementX();
        return (location.getX() < Map.WIDTH);
    }

    /**
     * Name:        incrementY
     * Description: Increments/moves the Y coordinate by 1
     * @return      Boolean indicating if the X variable is less than the Map height
     */
    public boolean incrementY() {
        location.incrementY();
        return (location.getY() < Map.HEIGHT);
    }


    /**
     * Name:        decrementX
     * Description: Decrements/moves the X coordinate by 1
     * @return      Boolean indicating if the X variable is non-negative
     */
    public boolean decrementX() {
        location.decrementX();
        return (location.getX() >= 0);
    }

    /**
     * Name:        decrementY
     * Description: Decrements/moves the Y coordinate by 1
     * @return      Boolean indicating if the Y variable is non-negative
     */
    public boolean decrementY() {
        location.decrementY();
        return (location.getY() >= 0);
    }

    /**
     * Name:        intersects
     * Description: Determines if the current actor has the same X and Y coordinates as the actor
     *              passed in as parameter
     * @param actor Actor to be checked against
     * @return      Boolean indicating if the actors intersect (have the same X and Y coordinates)
     */
    public boolean intersects(Actor actor) {
        return this.location.intersects(actor.getLocation());
    }

    /**
     * Name:        move
     * Description: Abstract method to allow for subclass definition
     * @return      Boolean dummy value (not used)
     */
    public abstract boolean move();
}
