package com.example.matias.c2m8calitbird.gameprocessor;

/**
 * Created by matias on 5.5.2016.
 * Name:        Location
 * Description: This class defines the coordinate system for the CalitBird game.
 */
public class Location {
    private int x;
    private int y;

    /**
     * Name:        Location
     * Description: Constructor for Location class. Instantiates X and Y coordinates.
     * @param x horizontal coordinate
     * @param y vertical coordinate
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Name:        getX
     * Description: Getter for X
     * @return      X coordinate of the current location
     */
    public int getX() {
        return x;
    }

    /**
     * Name:        getY
     * Description: Getter for Y
     * @return      Y coordinate of the current location
     */
    public int getY() {
        return y;
    }

    /**
     * Name:        incrementX
     * Description: Increments/moves the X coordinate by 1
     */
    public void incrementX() {
        this.x++;
    }

    /**
     * Name:        incrementY
     * Description: Increments/moves the Y coordinate by 1
     */
    public void incrementY() {
        this.y--;
        //this.y++;
    }


    /**
     * Name:        decrementX
     * Description: Decrements/moves the X coordinate by 1
     */
    public void decrementX() {
        this.x--;
    }

    /**
     * Name:        decrementX
     * Description: Decrements/moves the Y coordinate by 1
     */
    public void decrementY() {
        this.y++;
        //this.y--;
    }

    /**
     * Name:        setX
     * Description: Sets/moves the X coordinate to the specified parameter
     * @param x     The specified coordinate to change X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Name:        setY
     * Description: Sets/moves the Y coordinate to the specified parameter
     * @param y     The specified coordinate to change Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Name:            intersects
     * Description:     Determines if the current location intersects (has the same X and Y
     *                  coordinates) with the location object passed in as a parameter
     * @param location  The other location object to compare this location to
     * @return          Boolean indicating if the passed in location and the current location have
     *                  the same X and Y coordinates
     */
    public boolean intersects(Location location) {
        return location.getX() == this.getX() && location.getY() == this.getY();
    }

}
