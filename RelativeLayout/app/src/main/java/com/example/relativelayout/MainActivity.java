package com.example.relativelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//public class MainActivity extends AppCompatActivity {
//
//    private EditText userInput;
//    private Button loginBtn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.relative_page);
//
//        userInput = findViewById(R.id.userInput);
//        loginBtn = findViewById(R.id.loginBtn);
//
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String username = userInput.getText().toString();
//
//                //In Android, context is an interface that provides access to application-specific resources and classes, such as activities, layouts, and services. It’s essential for things like creating views, starting activities, and accessing resources. in your code, using this as the context means you're providing the mainactivity itself so that the toast knows where to display the message.
//                Toast.makeText(MainActivity.this, "Hello "+ username, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//}

//1. Implementing View.OnClickListener
//Main activity now can handle click events as it implements view.onclicklistener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userInput;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.relative_page);

        userInput = findViewById(R.id.userInput);
        loginBtn = findViewById(R.id.loginBtn);

        //2. Set the click listener
        //this refers to the current instance of MainActivity. this tell the button to use MainActivity for handling click events.
        loginBtn.setOnClickListener(this);
    }

    //3. When the button is clicked, Android automatically calls the onClick(View view) method defined in MainActivity class.

    //4. Handling Clicks
    //Inside onClick(View view), we define what happens when the button is clicked:
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.loginBtn) {
            String username = userInput.getText().toString();
            Toast.makeText(MainActivity.this, "Hello " + username, Toast.LENGTH_SHORT).show();
        }
    }
}