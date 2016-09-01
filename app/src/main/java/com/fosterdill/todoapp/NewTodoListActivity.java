package com.fosterdill.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by dylan on 8/31/16.
 */
public class NewTodoListActivity extends AppCompatActivity {
    private DaoSession daoSession;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_todo_list);

        App app = (App) getApplication();
        daoSession = app.getDaoSession();
    }

    public void handleNewTodoSaveClick(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText descEditText = (EditText) findViewById(R.id.desc);
        TodoList newTodoList = new TodoList(null, editText.getText().toString(), descEditText.getText().toString());
        Intent resultIntent = new Intent();



        daoSession.insert(newTodoList);
        resultIntent.putExtra("todoListId", newTodoList.getId().longValue());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
