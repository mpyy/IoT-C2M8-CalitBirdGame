package com.example.matias.c2m8calitbird.gameprocessor;

/**
 * Name: Inputtable
 * Description: Interface for the methods needed for the game to take inputs.
 * Created by matias on 24.4.2016.
 */
public interface Inputtable {

    void setInputState(boolean state);
    boolean getInputState();
    void setRunningState(boolean running);
    boolean getRunningState();

}
