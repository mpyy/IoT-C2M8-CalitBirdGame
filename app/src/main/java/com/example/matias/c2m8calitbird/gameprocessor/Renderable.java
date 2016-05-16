package com.example.matias.c2m8calitbird.gameprocessor;

/**
 * Name: Renderable
 * Description: Interface for the game to render its contents.
 * Created by matias on 24.4.2016.
 */
public interface Renderable {
    void begin();
    void clear(final int score);
    void render(char[][] data, final int score);
}
