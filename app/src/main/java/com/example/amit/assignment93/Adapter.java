package com.example.amit.assignment93;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import static com.example.amit.assignment93.R.id.text2;

/**
 * Created by Amit on 6/15/2017.
 */

public class Adapter extends BaseAdapter {
String[]name={};
    String[]number={};
    Context context;
    LayoutInflater inflater;

    public Adapter(Context context, String[] name, String[] number) {
        this.context=context;
        this.name=name;
        this.number=number;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        Holder holder=new Holder();
        if(convertview==null){
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview=inflater.inflate(R.layout.row,null);
        }
        holder.text1=(TextView)convertview.findViewById(R.id.Name);
        holder.text2=(TextView)convertview.findViewById(R.id.Number);
        holder.text1.setText(name[position]);
        holder.text2.setText(number[position]);
        return convertview;
    }
    public class Holder{
        TextView text1;
        TextView text2;
    }
}


