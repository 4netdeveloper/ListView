package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //datos a mostrar
        names = new ArrayList<String>();
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Rubén");
        names.add("Santiago");
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Rubén");
        names.add("Santiago");
        names.add("Alejandro");
        names.add("Fernando");
        names.add("Rubén");
        names.add("Santiago");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Clikeado: " + names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        //enlazamos con nuestro adaptador
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, names);
        listView.setAdapter(myAdapter);

    }
}

