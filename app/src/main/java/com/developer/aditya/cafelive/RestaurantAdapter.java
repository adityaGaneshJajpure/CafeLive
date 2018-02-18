package com.developer.aditya.cafelive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.aditya.cafelive.pojo.NearbyRestaurant;

import java.util.List;

/**
 * Created by root on 27/4/17.
 */

public class RestaurantAdapter extends BaseAdapter{
    private static LayoutInflater inflater = null;
    Context context;
    List<NearbyRestaurant> response;
    public RestaurantAdapter(Context context,List<NearbyRestaurant> response) {
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context=context;
        this.response=response;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View onCell;
        onCell = inflater.inflate(R.layout.prototype_cell,null);
        TextView name = (TextView)onCell.findViewById(R.id.restaurant_name);
        ImageView imgage = (ImageView)onCell.findViewById(R.id.restaurant_image);
        name.setText(response.get(position).getRestaurant().getName());
        return onCell;
    }

    @Override
    public int getCount() {
        return response.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
