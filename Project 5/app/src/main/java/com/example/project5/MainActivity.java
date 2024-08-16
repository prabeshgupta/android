package com.example.project5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText name, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        name = findViewById(R.id.name);
        number = findViewById(R.id.mobileNumber);

        try {
            AppDB appDB = new AppDB(this);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String userName = name.getText().toString();
                    String userNumber = number.getText().toString();

                    appDB.addContact(userName, userNumber);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}