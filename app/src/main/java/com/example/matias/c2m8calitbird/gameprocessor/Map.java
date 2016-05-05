package com.example.matias.c2m8calitbird.gameprocessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Name:        Map
 * Description: Creates the data structure for playing the game.
 *              Instantiates the Map data structure containing the necessary data to render the
 *              screen. GameProcessor calls on the methods of the Map to play the game.
 *
 * Created by matias on 24.4.2016.
 */
public class Map {

    public static final int HEIGHT = 8;
    public static final int WIDTH = 8;

    private static final int MINIMUM_PIPE = 2;
    private static final int NUMBER_OF_HOLES = 1;
    private static final int EMPTY = '0';
    private static final int OBSTACLE ='1';
    private static final int CALIBIRD = '2';

    private List<Actor> actors;
    private char map[][];

    /**
     * Name:            Map
     * Description:     Constructor with the specified CaliBird actor. Instantiates the Actors by
     *                  adding CaliBird into the List of actors, and the char array with dimensions
     *                  Map height and width.
     * @param caliBird  A CaliBird actor to populate the Actors list
     */
    public Map(CaliBird caliBird) {
        this.actors = new ArrayList<>();
        actors.add(caliBird);
        this.map = new char[HEIGHT][WIDTH];
    }

    /**
     * Name:            updateMap
     * Description:     Refreshes the Map's char array to indicate locations of each Actor and
     *                  returns it.
     *                      0 indicates an empty space
     *                      1 indicates an obstacle/actor
     *                      2 indicates the CaliBird
     * @return              char[][] containing the grid/actors/obstacles of the Map.
     */
    public char[][] updateMap() {
        // Populates the Map with empty spaces
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                this.map[i][j] = EMPTY;
            }
        }

        for (Actor iter : actors) {
            this.map[iter.getY()][iter.getX()] = OBSTACLE;
        }

        this.map[getCaliBird().getY()][getCaliBird().getX()] = CALIBIRD;

        return this.map;
    }

    /**
     * Name:        collisions
     * Description: Iterates through the list of Actors and determines if CaliBird has collided
     *              with Obstacles
     * @return      Boolean indicating if CaliBird hit an Obstacle
     */
    public boolean collisions() {
        CaliBird calibird = getCaliBird();

        // TODO: Test whether this needs to be implemented with Iterator and hasNext()
        for (Actor iter : actors) {
            if (calibird.intersects(iter)) {
                removeCaliBird();
                return true;
            }
        }
        return false;
    }

    /**
     * Name:        randomize
     * Description: Randomly place Pipes/Obstacles in the List of Actors.
     */
    public void randomize() {
        int numOfPipes;
        int position;

        // Determines number of pipes needed on top of the minimum four + hole
        numOfPipes = HEIGHT - NUMBER_OF_HOLES - (MINIMUM_PIPE * 2); // 3

        // Generates a Random int from 0 ... numOfPipes to determine the number
        // of pipes to place starting from the bottom
        Random random = new Random();
        position = random.nextInt(numOfPipes) + MINIMUM_PIPE; // 2...5

        // Populates the List of Actors with the Pipes at the bottom
        for (int j = 0; j < position; j++) { // min: 0, max: 1...4
            actors.add(new Obstacle(WIDTH - 1, j));
        }

        // Populates the List of Actors with the Pipes at the top
        for (int k = position + MINIMUM_PIPE; k < HEIGHT; k++) { // min: 4...7, max: 7
            actors.add(new Obstacle(WIDTH - 1, k));
        }
    }


    /**
     * Name:        move
     * Description: Move the actors on the map.
     *              Iterates through the List of Actors and calls on their
     *              respective move method
     */
    public void move() {
        // TODO: Test whether this needs to be implemented with Iterator and hasNext()
        for (Actor iter : actors) {
            iter.move();
        }
    }


    /**
     * Name:        checkCaliBirdScore
     * Description: Performs a check whether or not CaliBird passes a Pipe
     * @return      Boolean indicating whether or not we increment the score
     */
    public boolean checkCaliBirdScore() {
        Actor caliBird = getCaliBird();

        // TODO: Test whether this needs to be implemented with Iterator and hasNext()
        for (Actor obstacle : actors) {
            if (obstacle.getX() == (caliBird.getX() - 1)) {
                // An obstacle has X coordinate one to the left from CaliBird
                return true;
            }
        }

        return false;
    }

    /**
     * Name:        getCaliBird
     * Description: Getter method to return the CaliBird. The CaliBird is always the first object
     *              in the Actors list
     * @return      The CaliBird object in the game
     */
    private CaliBird getCaliBird() { return (CaliBird) actors.get(0); }

    /**
     * Name:        removeCaliBird
     * Description: Removes the CaliBird from the List of Actors in the game
     */
    public void removeCaliBird() { actors.remove(0); }


}