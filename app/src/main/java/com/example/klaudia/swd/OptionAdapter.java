package com.example.klaudia.swd;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KarolinaR on 2016-05-31.
 */
public class OptionAdapter extends ArrayAdapter<Option> {

    private final Context context;
    private final List<Option> options;

    public OptionAdapter(Context context, List<Option> options) {
        super(context, -1, options);
        this.context = context;
        this.options = options;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        TextView klimat = (TextView) rowView.findViewById(R.id.klimat);
        TextView aktywnosc = (TextView) rowView.findViewById(R.id.aktywnosc);
        TextView lokalizacja = (TextView) rowView.findViewById(R.id.lokalizacja);
        if(options.get(position).getKlimat() != null) {
            klimat.setText(options.get(position).getKlimat().getName());

        }else{klimat.setText("");}
        StringBuilder sb = new StringBuilder();
        for(Aktywnosc akt : options.get(position).getAktywnoscList()){
            sb.append(akt.getName());
        }
        aktywnosc.setText(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        for(Lokalizacja lok : options.get(position).getLokalizacjaList()){
            sb2.append(lok.getName());
        }
        lokalizacja.setText(sb2.toString());
        return rowView;
    }
}
