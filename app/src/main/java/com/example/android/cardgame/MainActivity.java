package com.example.android.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //setting up variables
    public Button loginButton;
    public Button registerButton;
    public EditText email;
    public EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //locating variable contents
        loginButton = findViewById(R.id.button);
        registerButton = findViewById(R.id.button2);
        email = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        //listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ensuring input is not blank and showing moving to game if so

                if (email.getText().length()<1 && password.getText().length()<1) {


                    Toast toast2 = Toast.makeText(MainActivity.this, "Credentials Incorrect", Toast.LENGTH_LONG);
                    toast2.show();
                }

                else{

                    startActivity(new Intent(MainActivity.this, card1.class));

                }

            }
        });

                                 }


           //move into game if login credentials are correct
         public void switchScreenLoginButton(View view) {

        startActivity(new Intent(MainActivity.this, card1.class));
    }

    //switch to register screen if registration button is selected
    public void switchScreenRegisterButton(View view) {

        startActivity(new Intent(MainActivity.this, registration.class));
    }
}

