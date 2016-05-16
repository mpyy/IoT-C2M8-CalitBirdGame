package com.example.matias.c2m8calitbird.gameprocessor;

/**
 * Name: GameProcessor
 * Description: The class that runs the game on a separate Thread.
 * Created by matias on 24.4.2016.
 */
public class GameProcessor extends Thread {

    public final static int SLEEP_TIME = 500; // in milliseconds
    public final static int INPUT_RATE = 2;
    public final static int RANDOMIZE_RATE = 6;

    private Map map;
    private CaliBird caliBird;
    private Renderable renderer;
    private Inputtable input;
    private int score;

    /**
     * Constructor for GameProcessor. Instantiates private members and calls begin() on renderer
     * @param renderer  is the concrete class of Renderable
     * @param input     is the concrete class of Inputtable
     */
    public GameProcessor(Renderable renderer, Inputtable input) {
        this.renderer = renderer;
        this.input = input;

        caliBird = new CaliBird(3, 3);
        map = new Map(caliBird);
        score = 0;

        renderer.begin();
    }

    /**
     * Runs a continuous loop dependent on the running state of Inputtable. In the while loop, the
     * GameProcessor
     * 1. moves the Actors
     * 2. checks for collisions
     * 3. updates the score
     * 4. repeats the process
     * Once the running state of Inputtable is false (i.e. the game isn't running), we
     * make a call to Renderable to clear the screen.
     */
    public void run() {
        long time;
        int index = 0;

        while (input.getRunningState()) {
            time = System.currentTimeMillis();

            // Determine if CaliBird moves up or down
            if (input.getInputState()) {
                if (!caliBird.incrementY()) { caliBird.decrementY(); }
                input.setInputState(false);
            } else if (!caliBird.decrementY()) {
                map.removeCaliBird();
                input.setRunningState(false);
                break;
            }

            // Move the pipes at the INPUT_RATE
            if (index % INPUT_RATE == 0) {
                map.move();
            }

            // Randomize the pipes at RANDOMIZE_RATE
            if (index % RANDOMIZE_RATE == 0) {
                map.randomize();
            }

            // Get Map data
            char[][] data = map.updateMap();

            // Check for collisions
            if (map.collisions()) {
                input.setRunningState(false);
                break;
            }

            // Update score
            if (map.checkCaliBirdScore() && index % INPUT_RATE == 0) {
                score++;
            }

            // Display the image
            renderer.render(data, score);

            // Make Thread sleep to simulate the frame rate
            long difference = System.currentTimeMillis() - time;
            if (difference > SLEEP_TIME) {
                sleepTime(0);
            } else {
                sleepTime(SLEEP_TIME - difference);
            }

            index++;
        }
        renderer.clear(score);
    }

    /**
     * Make the Thread sleep for a certain amount of time
     * @param time in milliseconds
     */
    public void sleepTime(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
