package com.example.hlb_hackathon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    //Common for all screens
    private ImageButton homeNavi;
    private ImageButton missionNavi;
    private ImageButton rankNavi;
    private ImageButton quizNavi;
    private ImageButton crmNavi;



    // setting up things
    private RadioButton falseButton;
    private RadioButton trueButton;
    private Button nextButton;
    private Button prevButton;
    private Button tryAgain;
    private Button mainMenu;
    private RadioGroup answerRadio;
    private ImageView Image;
    private TextView questionTextView;

    //number of questions
    private final int noOfQuestion = 6;

    //number of correct ans
    private int correct = 0;

    // to keep current Question track
    private int currentQuestionIndex = 0;

    //Array to keep list of correct/wrong answers
    private int[] answerArray = new int[noOfQuestion];

    //Create Question objects
    private Question[] questionBank = new Question[]{
            // array of objects of class Question
            // providing questions from string
            // resource and the correct ans
            new Question(R.string.a, false),
            new Question(R.string.b, true),
            new Question(R.string.c, true),
            new Question(R.string.d, false),
            new Question(R.string.e, true),
            new Question(R.string.f, true),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
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


        // setting up the buttons
        // associated with id
        falseButton = findViewById(R.id.option_false);
        trueButton = findViewById(R.id.option_true);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        tryAgain = findViewById(R.id.tryAgain);
        mainMenu = findViewById(R.id.mainMenu);
        answerRadio = findViewById(R.id.answerRadio);
        Image = findViewById(R.id.myimage);
        questionTextView = findViewById(R.id.questionText);


        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        tryAgain.setOnClickListener(this);
        mainMenu.setOnClickListener(this);

        tryAgain.setVisibility(View.GONE);
        mainMenu.setVisibility(View.GONE);
    }



    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.next_button:
                //Check for answer when click next
                if (trueButton.isChecked()) {
                    checkAnswer(true);
                } else if (falseButton.isChecked()) {
                    checkAnswer(false);
                }

                // go to next Question
                // limiting Question bank range
                if (currentQuestionIndex <= noOfQuestion) {
                    currentQuestionIndex
                            = currentQuestionIndex + 1;
                    // making buttons
                    // invisible
                    if (currentQuestionIndex == noOfQuestion) {
                        questionTextView.setText(getString(
                                R.string.correct, correct));
                        nextButton.setVisibility(
                                View.GONE);
                        prevButton.setVisibility(
                                View.GONE);
                        trueButton.setVisibility(
                                View.GONE);
                        falseButton.setVisibility(
                                View.GONE);
                        Image.setVisibility(View.GONE);
                        tryAgain.setVisibility(View.VISIBLE);
                        calcScore();
                        questionTextView.setText("You answered " + correct + " out of 6! \n Here's " + correct + " water droplets for you!");
                    } else {
                        updateQuestion();
                    }
                }

                break;

            case R.id.prev_button:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex
                            = (currentQuestionIndex - 1)
                            % questionBank.length;
                    updateQuestion();
                }
                break;

            case R.id.tryAgain:
                Intent intent_current = getIntent();
                finish();
                startActivity(intent_current);
                break;
            case R.id.navi_home:
                Intent intent_home = new Intent(Quiz.this, MainActivity.class);

                // start the activity connect to the specified class
                startActivity(intent_home);
                break;

            case R.id.navi_mission:
                Intent intent_mission = new Intent(Quiz.this, Mission.class);
                finish();
                // start the activity connect to the specified class
                startActivity(intent_mission);
                break;

            case R.id.navi_rank:
                Intent intent_rank = new Intent(Quiz.this, Rank.class);

                // start the activity connect to the specified class
                startActivity(intent_rank);
                break;

            case R.id.navi_quiz:
                Intent intent_quiz = new Intent(Quiz.this, Quiz.class);

                // start the activity connect to the specified class
                startActivity(intent_quiz);
                break;

            case R.id.navi_crm:
                Intent intent_crm = new Intent(Quiz.this, SurveyCrm.class);

                // start the activity connect to the specified class
                startActivity(intent_crm);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion() {
        answerRadio.clearCheck();
        Log.d("Current",
                "onClick: " + currentQuestionIndex);

        questionTextView.setText(
                questionBank[currentQuestionIndex]
                        .getAnswerResId());
        // setting the textview with new Question
        switch (currentQuestionIndex) {
            case 0:
                // setting up image for each
                // Question
                Image.setImageResource(R.drawable.a);
                break;
            case 1:
                Image.setImageResource(R.drawable.b);
                break;
            case 2:
                Image.setImageResource(R.drawable.c);
                break;
            case 3:
                Image.setImageResource(R.drawable.d);
                break;
            case 4:
                Image.setImageResource(R.drawable.e);
                break;
            case 5:
                Image.setImageResource(R.drawable.f);
                break;
        }
    }

    private void checkAnswer(boolean userChooseCorrect) {
        boolean answerIsTrue
                = questionBank[currentQuestionIndex]
                .isAnswerTrue();
        // getting correct ans of current Question
        int toastMessageId;
        // if ans matches with the
        // button clicked

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            answerArray[currentQuestionIndex] = 1;
        } else {
            // showing toast
            // message correct
            toastMessageId = R.string.wrong_answer;
            answerArray[currentQuestionIndex] = 0;
        }

        Toast.makeText(Quiz.this, toastMessageId,
                Toast.LENGTH_SHORT).show();
    }

    private void calcScore(){
        for (int i = 0; i<noOfQuestion; i++){
            correct = correct + answerArray[i];
        }
    }
}