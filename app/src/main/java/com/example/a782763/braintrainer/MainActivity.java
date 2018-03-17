package com.example.a782763.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button GoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoButton = findViewById(R.id.goButton);

    }
    public void start(View view){
            openActivity2();
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity3.class);
         startActivity(intent);
    }
}
