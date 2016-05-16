package com.example.matias.c2m8calitbird;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Name:        GridAdapter
 * Description: Adapter to populate the GridView of the activity_main.xml
 * Created by matias on 5.5.2016.
 */
public class GridAdapter extends BaseAdapter {
    private ArrayList<Bitmap> arrayList;
    private Context context;

    /**
     * Name:        GridAdapter
     * Description: Constructor for GridAdapter that instantiates the private members.
     * @param arrayList containing Bitmap images corresponding to the Actors.
     * @param context   of the activity to enable populating the GridView instance
     *                  in activity_main.xml
     */
    public GridAdapter(ArrayList<Bitmap> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    /**
     * Name:                getView
     * Description:         Uses LayoutInflater to populate the layout of context with the
     *                      corresponding Bitmap from the ArrayList.
     * @param position      int representing the position in GridView
     * @param convertView   Unused parameter
     * @param parent        ViewGroup used to inflate the layout
     * @return              View to populate the specific Grid block
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout coordinate;

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        coordinate = (LinearLayout) inflater.inflate(R.layout.coordinate, parent, false);

        ImageView image = (ImageView) coordinate.getChildAt(0);
        image.setImageBitmap(this.arrayList.get(position));

        return coordinate;
    }

    /**
     * Name:        getCount
     * Description: Returns the count of items in the ArrayList
     * @return      int representing the size of ArrayList
     */
    public int getCount() {
        return this.arrayList.size();
    }

    /**
     * Unused method inherited from extending BaseAdapter.
     * Normally this would get the data item associated with the specified position in the data set.
     *
     * @param position  Unused parameter.
     *                  Position of the item whose data we want within the adapter's data set.
     * @return          Always null. The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return null;
    }

    /**
     * Unused method inherited from extending BaseAdapter.
     * Normally this would get the row id associated with the specified position in the list.
     *
     * @param position  Unused parameter.
     *                  The position of the item within the adapter's data set whose row id we want.
     * @return          Always zero. The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }
}
