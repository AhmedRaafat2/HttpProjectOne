package com.ahmed.httpprojectone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemsAdaptor extends ArrayAdapter<Items> {
    public ItemsAdaptor(@NonNull Context context, @NonNull List<Items> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row,parent,false);
        TextView  name = convertView.findViewById(R.id.name_text_view);
        TextView likes = convertView.findViewById(R.id.like_text_view);

        Items items = getItem(position);
        name.setText(items.getName());
        likes.append(" " + items.getLike());
        return convertView;
    }
}
