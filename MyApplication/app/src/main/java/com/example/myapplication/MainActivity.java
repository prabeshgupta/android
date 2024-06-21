package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
    }

    public void disableButton(View v){
//        Generic view
//        v.setEnabled(false);
//        Button b = (Button) v;
//        b.setText("Disabled");

//        Specific view
//        View myView = findViewById(R.id.btn_no);
//        TypeCasting
//        Button myButton = (Button) myView;
//        myButton.setText("Nope");

//        Direct casting
//        ((Button) findViewById(R.id.btn_no)).setText("Big No");
//        Log.d("Success", "Button Disabled");
    }

    public void userInput(View v){
//        Take User Input
        EditText txt = findViewById(R.id.nameInputField);
        String userTxt =txt.getText().toString();
        Log.d("userInput", userTxt);

// Show user input
        ((TextView) findViewById(R.id.showOutput)).setText(userTxt);

//        Display alert
        Toast.makeText(this,userTxt,Toast.LENGTH_LONG).show();
    }
}