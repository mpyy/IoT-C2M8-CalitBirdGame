package com.example.matias.c2m8calitbird;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // TODO: 24.4.2016 Write onCreate
    }

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

    @Override
    protected void onResume() {
        // TODO: 24.4.2016 Write onResume code
    }

    @Override
    protected void onPause() {
        // TODO: 24.4.2016 Write onPause code
    }

    public void beginNewGame() {
        // TODO: 24.4.2016 Write beginNewGame
    }

    public void endGame() {
        // TODO: 24.4.2016 Write endGame 
    }
    
    public void setInput(View view) {
        // TODO: 24.4.2016 Write setInput
    }
}
