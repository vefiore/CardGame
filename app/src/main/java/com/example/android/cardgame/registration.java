package com.example.android.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    //initializing variables
    public EditText f_name;
    public EditText l_name;
    public EditText rEmail;
    public EditText rPassword;
    public EditText rDOB;
    public Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //setting variable contexts
        f_name = findViewById(R.id.editText4);
        l_name = findViewById(R.id.editText5);
        rEmail = findViewById(R.id.editText6);
        rPassword = findViewById(R.id.editText7);
        rDOB = findViewById(R.id.editText8);
        sign_up = findViewById(R.id.button3);


        //button Listener
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ensuring input is not blank prompting Toast to fix if it is

                if (f_name.getText().length()<1 && l_name.getText().length()<1 && rEmail.getText().length()<1 && rPassword.getText().length()<1 && rDOB.getText().length()<1) {

                    Toast toast3 = Toast.makeText(registration.this, "Please Enter Valid Input", Toast.LENGTH_LONG);
                    toast3.show();

                }


                //returning to Main if content is correct
                else {
                    startActivity(new Intent(registration.this, MainActivity.class));

                }

            }
        });
    }
    }