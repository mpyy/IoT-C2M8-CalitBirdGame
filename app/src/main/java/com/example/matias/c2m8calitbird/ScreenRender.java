package com.example.matias.c2m8calitbird;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.matias.c2m8calitbird.gameprocessor.Map;
import com.example.matias.c2m8calitbird.gameprocessor.Renderable;

import java.util.ArrayList;

/**
 * Name:        ScreenRender
 * Description:
 * Created by matias on 5.5.2016.
 */
public class ScreenRender implements Renderable {
    private CaliBirdActivity activity;
    private TextView scoreView;
    private GridView grid;
    private Bitmap bird;
    private Bitmap block;
    private Bitmap blank;

    /**
     * Name:        ScreenRender
     * Description: Concrete class of the Renderable interface.
     *              Renderable instantiates the visual layout of the game
     * @param activity is an Activity to handle the UI changes on the game
     */
    public ScreenRender(CaliBirdActivity activity) {
        this.activity = activity;
    }

    /**
     * Name:        begin
     * Description: Instantiates layout components and adds listeners.
     */
    @Override
    public void begin() {
        activity.setContentView(R.layout.activity_calit_bird);
        scoreView = (TextView) activity.findViewById(R.id.score);

        activity.findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.setInput(v);
            }
        });

        grid = (GridView) activity.findViewById(R.id.gridView);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                activity.setInput(view);
            }
        });

        bird = BitmapFactory.decodeResource(activity.getResources(), R.drawable.bird);
        block = BitmapFactory.decodeResource(activity.getResources(), R.drawable.block);
        blank = BitmapFactory.decodeResource(activity.getResources(), R.drawable.blank);

    }

    /**
     * Name:        render
     * Description: Populates an ArrayList with the appropriate Bitmap based on the values in
     *              the two-dimensional data array.
     *              render then passes the ArrayList to GridAdapter to to populate the GridView
     *              instance.
     */
    @Override
    public void render(char[][] data, final int score) {
        ArrayList<Bitmap> arrayList = new ArrayList<>();

        for(int i = 0; i < Map.WIDTH; i++) {
            for(int j = 0; j < Map.HEIGHT; j++) {
                if (data[i][j] == '0') {
                    arrayList.add(blank);
                } else if (data[i][j] == '1') {
                    arrayList.add(block);
                } else {
                    arrayList.add(bird);
                }
            }
        }

        final GridAdapter gridAdapter = new GridAdapter(arrayList, activity);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                scoreView.setText("Score: " + score);
                grid.setAdapter(gridAdapter);

            }
        });
    }
/*    @Override
    public void render(char[][] data, final int score) {
        ArrayList<Bitmap> arrayList = new ArrayList<>();

        for (int i = 0; i < Map.HEIGHT; i++) {
            for (int j = 0; j < Map.WIDTH; j++) {
                switch (data[i][j]) {
                    case Map.EMPTY:arrayList.add(blank); break;
                    case Map.OBSTACLE:arrayList.add(block); break;
                    case Map.CALIBIRD:arrayList.add(bird); break;
                    default: break;
                }
            }
        }

        final GridAdapter gridAdapter = new GridAdapter(arrayList, activity);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                scoreView.setText(activity.getString(com.example.matias.c2m8calitbird.R.string.scoreLabel) + score);
                grid.setAdapter(gridAdapter);
            }
        });
    }*/
    /**
     * Name:        clear
     * Description: Runs a separate UI Thread to handle the 'game over' screen and changes the
     *              Layout over to gameover_main.xml
     * @param score is the user's final score
     */
    @Override
    public void clear(final int score) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.setContentView(R.layout.gameover_main);
                ((TextView) activity.findViewById(R.id.gameover_score))
                        .setText(activity.getString(com.example.matias.c2m8calitbird.R.string.scoreLabel) + score);

                Button restartButton = (Button) activity.findViewById(R.id.restart);
                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.beginNewGame();
                    }
                });
            }
        });
    }
}
