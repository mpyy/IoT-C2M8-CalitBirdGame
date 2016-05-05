package com.example.matias.c2m8calitbird.gameprocessor;

/**
 * Created by matias on 24.4.2016.
 * Name: GameProcessor
 * Description: The class that runs the game on a separate Thread.
 */
public class GameProcessor extends Thread {
    // TODO: 24.4.2016 Write GameProcessor

    public final static int SLEEP_TIME = 500; // in milliseconds
    public final static int INPUT_RATE = 2;
    public final static int RANDOMIZE_RATE = 6;

    private Map map;
    private CaliBird caliBird;
    private Renderable renderer;
    private Inputtable input;
    private int score;

    public void GameProcessor(Renderable renderer, Inputtable input) {
        this.renderer = renderer;
        this.input = input;

        caliBird = new CaliBird(3, 3);
        map = new Map(caliBird);
        score = 0;

        renderer.begin();
    }

    public void run() {
        // TODO: 24.4.2016 Write run
    }

    public void sleepTime(long time) {
        // TODO: 24.4.2016 Write sleepTime
    }
}
