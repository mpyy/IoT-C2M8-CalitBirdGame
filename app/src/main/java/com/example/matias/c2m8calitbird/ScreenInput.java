package com.example.matias.c2m8calitbird;

import com.example.matias.c2m8calitbird.gameprocessor.Inputtable;

/**
 * Name:        ScreenInput
 * Description: Defines a concrete class of the Inputtable interface.
 *              ScreenInput facilitates the communication between the inputs of the layouts and
 *              the game.
 *              Note: the actual onClick method is defined in Main instead of this class due to
 *              restrictions in the Activity class.
 * Created by matias on 5.5.2016.
 */
public class ScreenInput implements Inputtable {
    private boolean input;
    private boolean running;

    /**
     * Name:        setInputState
     * Description: Setter method for the private instance input
     * @param       state is a boolean indicating whether or not the game is receiving input.
     */
    @Override
    public void setInputState(boolean state) {
        this.input = state;
    }

    /**
     * Name:        getInputState
     * Description: Getter method for the private instance input
     * @return      Private instance input indicating the input state
     */
    @Override
    public boolean getInputState() {
        return input;
    }

    /**
     * Name:        setRunningState
     * Description: Setter method for the private instance running
     * @param       running is a boolean indicating whether or not the game is running.
     */
    @Override
    public void setRunningState(boolean running) {
        this.running = running;
    }

    /**
     * Name:        getRunningState
     * Description: Getter method for the private instance running
     * @return      Private instance running indicating the running state of the input
     */
    @Override
    public boolean getRunningState() {
        return running;
    }
}
