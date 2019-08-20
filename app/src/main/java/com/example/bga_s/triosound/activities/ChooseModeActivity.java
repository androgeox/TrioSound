package com.example.bga_s.triosound.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bga_s.triosound.App;
import com.example.bga_s.triosound.MainActivity;
import com.example.bga_s.triosound.R;
import com.example.bga_s.triosound.database.TrioDB;

public class ChooseModeActivity extends AppCompatActivity implements View.OnClickListener{

    Button trioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

        trioButton = findViewById(R.id.trioBut);
        trioButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//        App.getAppInstance().feelDB(this);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        App.getAppInstance().trioDB.feelDB(this);
    }
}
