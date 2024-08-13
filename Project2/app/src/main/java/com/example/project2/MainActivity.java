package com.example.project2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Button button;
    EditText email;
    EditText password;
    EditText confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Spinner Work
        spinner = findViewById(R.id.city);
        spinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.city,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);

        // Button Work
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the text from EditText fields inside onClick
                String emailAdd = email.getText().toString();
                String pass = password.getText().toString();
                String confirm_pass = confirm_password.getText().toString();

                if(TextUtils.isEmpty(emailAdd)){
                    Toast.makeText(getApplicationContext(), "Email cannot be empty.", Toast.LENGTH_SHORT).show();
                }

                // Check if the passwords match and are not empty
                if (TextUtils.isEmpty(pass) || TextUtils.isEmpty(confirm_pass)) {
                    Toast.makeText(getApplicationContext(), "Passwords cannot be empty.", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(confirm_pass)) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match.", Toast.LENGTH_SHORT).show();
                } else if (pass.length() <= 6) {
                    Toast.makeText(getApplicationContext(), "Password must be longer than 6 characters.", Toast.LENGTH_LONG).show();
                } else {
                    Log.d("ok", "Password is good");
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Handle spinner item selection if needed
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Handle no selection if needed
    }
}
