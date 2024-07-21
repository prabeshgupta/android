package com.example.combinedcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private GridView gridView;
    private ListView listView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialize views
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);
        btn = findViewById(R.id.btn);

        // Retrieve the array of countries from resources
        String[] countries = getResources().getStringArray(R.array.countries);

        //Define Adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, countries);

        //Set Adapter
        spinner.setAdapter(arrayAdapter);

        //Set a listener to handle item selection
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Get the selected item (country) from the spinner
                String country = (String) adapterView.getItemAtPosition(position);

                //Set the selected item as title of spinner
                setTitle(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //GridView
        gridView.setNumColumns(2);
        gridView.setAdapter(arrayAdapter);

        //ListView
        listView.setAdapter(arrayAdapter);


        //Switch activity on button click
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creating intent to switch activity
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("name", "Combined Components");

                startActivity(intent);
            }
        });
    }
}