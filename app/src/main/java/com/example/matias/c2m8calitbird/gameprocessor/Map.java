package com.example.matias.c2m8calitbird.gameprocessor;

import java.util.List;

/**
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

    public Map(CaliBird caliBird) {
        // TODO: 24.4.2016 Write Map constructor
    }
}
