package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Askname extends AppCompatActivity {
    public static EditText firstName,lastName;//public static variables to access these variables at in other activities. this makes our job easy but don't know is this secure?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_askname);
        //setupUI(findViewById(R.id.parent));

        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        Button toDOB = findViewById(R.id.Next);

        toDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//when next button is clicked it puts all the details entered into fields into public static valiables
                                        //which can be acessed by another activity outside this also we don't finish this activity as we will nedd this data while registering
                // by this u can use this in another activity and get it by getIntent().getExtras.getString("fullName");
                // for multiple values u can use hashmap
                // and pass it same as intent.putExtra("map",map)
                // and getit by Intent intent = getIntent();
                //    HashMap<String, String> data = (HashMap<String, String>)intent.getSerializableExtra("hash");
                //starting this new intent

                if (firstName.getText().toString().isEmpty()) {
                    firstName.setError("First name required");

                }
                else {
                    firstName.setError(null);
                    lastName.setError(null);
                    Intent intent = new Intent(Askname.this,AskDOB.class);//creating a new intent pointing to AskEmail
                    String fullName = firstName.getText().toString()+" "+lastName.getText().toString();
                    intent.putExtra("fullName",fullName);
                    startActivity(intent);
                }


            }
        });

    }
}
