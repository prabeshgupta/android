package com.example.project3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList courseImg = new ArrayList(Arrays.asList(R.drawable.course_html, R.drawable.course_css, R.drawable.course_js, R.drawable.course_php));
    ArrayList courseName = new ArrayList(Arrays.asList("HTML", "CSS", "JS", "PHP"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        //RecyclerView as GridView
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        //recyclerView.setLayoutManager(gridLayoutManager);

        Adapter adapter = new Adapter(MainActivity.this, courseImg, courseName);
        recyclerView.setAdapter(adapter);
    }
}
