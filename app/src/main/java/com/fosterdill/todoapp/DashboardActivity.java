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
    private static final int NEW_TODO_CODE = 1;

    ArrayList<TodoList> list;
    DaoSession daoSession;
    ArrayAdapter<TodoList> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        App app = (App) getApplication();
        daoSession = app.getDaoSession();
        final TodoListDao tdlDao = daoSession.getTodoListDao();
        ListView listView = (ListView) findViewById(R.id.listView);
        final Intent todoListItemDetail = new Intent(this, TodoListItemDetail.class);
        list = (ArrayList<TodoList>) tdlDao.loadAll();
        adapter = new ArrayAdapter<>(this, R.layout.todo_list_item_layout, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TodoList modelToAdd = list.get(position);
                todoListItemDetail.putExtra("name", modelToAdd.getName());
                todoListItemDetail.putExtra("description", modelToAdd.getDescription());
                startActivity(todoListItemDetail);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TodoList modelToDelete = list.get(position);
                list.remove(position);
                tdlDao.delete(modelToDelete);
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    public void handleNewTodoClick(View v) {
        Intent newTodoIntent = new Intent(this, NewTodoListActivity.class);
        startActivityForResult(newTodoIntent, NEW_TODO_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_TODO_CODE) {
            if (resultCode == RESULT_OK) {
                long newId = data.getLongExtra("todoListId", 0);
                TodoList addedTodoList = daoSession.getTodoListDao().load(newId);
                list.add(addedTodoList);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
