package com.example.hlb_hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Common for all screens
    private ImageButton homeNavi;
    private ImageButton missionNavi;
    private ImageButton rankNavi;
    private ImageButton quizNavi;
    private ImageButton crmNavi;

    //Water Button
    private Button giveWater;

    //Tree Image
    private ImageButton tree;

    //tree growth
    private int growth = 0;

    //Water Left
    private Integer water_counter = 5;
    private TextView waterLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Common for all screens
        homeNavi = findViewById(R.id.navi_home);
        missionNavi = findViewById(R.id.navi_mission);
        rankNavi = findViewById(R.id.navi_rank);
        quizNavi = findViewById(R.id.navi_quiz);
        crmNavi = findViewById(R.id.navi_crm);
        giveWater = findViewById(R.id.give_water);
        tree = findViewById(R.id.tree_image);
        waterLeft = findViewById(R.id.water_left);

        homeNavi.setOnClickListener(this);
        missionNavi.setOnClickListener(this);
        rankNavi.setOnClickListener(this);
        quizNavi.setOnClickListener(this);
        crmNavi.setOnClickListener(this);
        giveWater.setOnClickListener(this);
        tree.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.give_water:
                growTree();
                break;

            case R.id.tree_image:
                Intent intent_popup = new Intent(MainActivity.this, Pop.class);
                startActivity(intent_popup);
                break;

            case R.id.navi_home:
                Intent intent_home = new Intent(MainActivity.this, MainActivity.class);

                // start the activity connect to the specified class
                startActivity(intent_home);
                break;

            case R.id.navi_mission:
                Intent intent_mission = new Intent(MainActivity.this, Mission.class);

                // start the activity connect to the specified class
                startActivity(intent_mission);
                break;

            case R.id.navi_rank:
                Intent intent_rank = new Intent(MainActivity.this, Rank.class);

                // start the activity connect to the specified class
                startActivity(intent_rank);
                break;


            case R.id.navi_quiz:
                Intent intent_quiz = new Intent(MainActivity.this, Quiz.class);

                // start the activity connect to the specified class
                startActivity(intent_quiz);
                break;

            case R.id.navi_crm:
                Intent intent_crm = new Intent(MainActivity.this, SurveyCrm.class);

                // start the activity connect to the specified class
                startActivity(intent_crm);
                break;
        }
    }

    public void growTree(){
        growth ++;
        water_counter --;
        if (water_counter<0){
            water_counter=0;
        }
        waterLeft.setText(water_counter.toString());
        switch(growth){
            case 0:
                tree.setImageResource(R.drawable.tree0);
                break;

            case 1:
                tree.setImageResource(R.drawable.tree1);
                break;

            case 2:
                tree.setImageResource(R.drawable.tree2);
                break;

            case 3:
                tree.setImageResource(R.drawable.tree3);
                break;

            case 4:
                tree.setImageResource(R.drawable.tree4);
                break;

        }
    }
}