package com.example.hlb_hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SurveyCrm extends AppCompatActivity implements View.OnClickListener{

    //Common for all screens
    private ImageButton homeNavi;
    private ImageButton missionNavi;
    private ImageButton rankNavi;
    private ImageButton quizNavi;
    private ImageButton crmNavi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_crm);
        //Common for all screens
        homeNavi = findViewById(R.id.navi_home);
        missionNavi = findViewById(R.id.navi_mission);
        rankNavi = findViewById(R.id.navi_rank);
        quizNavi = findViewById(R.id.navi_quiz);
        crmNavi = findViewById(R.id.navi_crm);

        homeNavi.setOnClickListener(this);
        missionNavi.setOnClickListener(this);
        rankNavi.setOnClickListener(this);
        quizNavi.setOnClickListener(this);
        crmNavi.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navi_home:
                Intent intent_home = new Intent(SurveyCrm.this, MainActivity.class);

                // start the activity connect to the specified class
                startActivity(intent_home);
                break;

            case R.id.navi_mission:
                Intent intent_mission = new Intent(SurveyCrm.this, Mission.class);
                finish();
                // start the activity connect to the specified class
                startActivity(intent_mission);
                break;

            case R.id.navi_rank:
                Intent intent_rank = new Intent(SurveyCrm.this, Rank.class);

                // start the activity connect to the specified class
                startActivity(intent_rank);
                break;

            case R.id.navi_quiz:
                Intent intent_quiz = new Intent(SurveyCrm.this, Quiz.class);

                // start the activity connect to the specified class
                startActivity(intent_quiz);
                break;

            case R.id.navi_crm:
                Intent intent_crm = new Intent(SurveyCrm.this, SurveyCrm.class);

                // start the activity connect to the specified class
                startActivity(intent_crm);
                break;
        }
    }
}