package com.example.hlb_hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Pop extends AppCompatActivity implements View.OnClickListener{

    private ImageButton exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit:
                Intent intent_exit = new Intent(Pop.this, MainActivity.class);
                startActivity(intent_exit);
                break;
        }
    }
}