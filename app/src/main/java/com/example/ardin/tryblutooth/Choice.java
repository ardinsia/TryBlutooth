package com.example.ardin.tryblutooth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Choice extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        findViewById(R.id.justtry).setOnClickListener(this);
        findViewById(R.id.ecgreader).setOnClickListener(this);
        findViewById(R.id.ecgviewer).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.justtry:
                startActivity(new Intent(this,RealTomkins.class));
                break;

            case R.id.ecgreader:
                startActivity(new Intent(this,LogIn.class));
                break;

            case R.id.ecgviewer:
                startActivity(new Intent(this,LogIn.class));
                break;


        }
    }
}
