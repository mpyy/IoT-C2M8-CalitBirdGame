package com.example.matias.c2m8calitbird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.matias.c2m8calitbird.gameprocessor.GameProcessor;
import com.example.matias.c2m8calitbird.gameprocessor.Inputtable;
import com.example.matias.c2m8calitbird.gameprocessor.Renderable;

/**
 * Name: CaliBirdActivity
 * Description: The main activity for the game
 *
 */
public class CaliBirdActivity extends AppCompatActivity {

    GameProcessor gameProcessor;
    private Inputtable inputter;
    private Renderable renderer;

    /**
     * Instantiates the Inputtable and Renderable instances
     *
     * @param savedInstanceState    Reference to bundle object. Activities can be restored
     *                              to a former state using data saved in this bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calit_bird);

        this.renderer = new ScreenRender(this);
        this.inputter = new ScreenInput();
    }


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    /**
     * Calls helper method beginNewGame().
     * We begin the game here because this method is called when the screen is live.
     */
    @Override
    protected void onResume() {
        super.onResume();
        beginNewGame();
    }

    /**
     * Calls helper method endGame().
     * We end the game here because this method is called when the screen is dead.
     */
    @Override
    protected void onPause() {
        super.onPause();
        endGame();
    }

    /**
     * Notifies inputter that the game is now running and instantiates the GameProcessor object
     * to essentially start and play the game
     */
    public void beginNewGame() {
        inputter.setRunningState(true);
        gameProcessor = new GameProcessor(this.renderer, this.inputter);
        gameProcessor.start();
    }

    /**
     * Notifies inputter that the game is over (or the running state is false)
     */
    public void endGame() {
        inputter.setRunningState(false);
    }

    /**
     * Method is called when the user taps on activity_main.xml.
     * This method communicates the user's input into the game.
     *
     * @param view The view associated with the method call
     */
    public void setInput(View view) {
        if (inputter != null) {
            inputter.setInputState(true);
        }
    }
}
