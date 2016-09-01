package com.fosterdill.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TodoListItemDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list_item_detail);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("description");

        TextView nameView = (TextView) findViewById(R.id.textView);
        TextView descView = (TextView) findViewById(R.id.textView2);

        nameView.setText(name);
        descView.setText(desc);
    }
}
