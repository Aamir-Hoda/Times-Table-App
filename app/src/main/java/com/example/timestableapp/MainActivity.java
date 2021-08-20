package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> multiplesArrayList = new ArrayList<Integer>(asList(0,0,0,0,0,0,0,0,0,0));
    ArrayAdapter<Integer> objAdapater;

    public void numberMultiples(int number)
    {
        multiplesArrayList.clear();
        for(int i=1; i<=10; i++)
        {
            multiplesArrayList.add(number*i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView timesListView = (ListView) findViewById(R.id.timesTableListView);
        final SeekBar timesSeekBar = (SeekBar) findViewById(R.id.numSeekBar);   //Max of seekBar is set to 20, in design view.

        objAdapater = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, multiplesArrayList);
        timesListView.setAdapter(objAdapater);

        timesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                numberMultiples(i);
                objAdapater.notifyDataSetChanged();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}