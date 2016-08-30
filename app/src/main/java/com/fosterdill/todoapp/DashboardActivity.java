package com.fosterdill.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ArrayList<Something> list = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<Something> adapter = new ArrayAdapter<>(this, R.layout.todo_list_item_layout, list);
        final Intent todoListItemDetail = new Intent(this, TodoListItemDetail.class);

        list.add(new Something());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(todoListItemDetail);
            }
        });
    }
}
