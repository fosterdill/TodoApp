package com.fosterdill.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ArrayList<Something> list = new ArrayList<>();

        list.add(new Something());

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<Something> adapter = new ArrayAdapter<>(this, R.layout.todo_list_item_layout, list);
        listView.setAdapter(adapter);
    }
}
