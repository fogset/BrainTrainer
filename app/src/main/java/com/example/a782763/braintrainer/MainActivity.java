package com.example.a782763.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int a,b,wrongAnswer;
    Button GoButton;
    TextView sumTextView,timeText;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int[]answerlist = new int[4];
    int locationOfCorrectAnswer;
    TextView resultTextView, scoreText;
    int score = 0;
    int numberOfQuestions = 0;
    Button button0,button1,button2,button3;

    public void start(View view){
        GoButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoButton = findViewById(R.id.goButton);
        sumTextView =findViewById(R.id.sumText);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        resultTextView = findViewById(R.id.resultTextview);
        scoreText = findViewById(R.id.scoreText);
        timeText = findViewById(R.id.timerText);

        randomAnswers();
        timer(30);
    }

    public void chooseAnswer(View view){
        if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            resultTextView.setText("Correct!");
            score++;
        }else{
            resultTextView.setText("Wrong :(");
        }
        numberOfQuestions++;
        scoreText.setText(Integer.toString(score) + " / " +Integer.toString(numberOfQuestions));
        randomAnswers();

    }


    public void randomAnswers(){
        Random random = new Random();
        a = random.nextInt(21);
        b = random.nextInt(21);
        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = random.nextInt(4);
        for (int i = 0; i<4; i++){
            if(i == locationOfCorrectAnswer){
                //answers.add(a+b);
                answerlist[i] =a + b;
            }else{
                wrongAnswer = random.nextInt(41);
                while(wrongAnswer == a+b ){
                    wrongAnswer = random.nextInt(41);
                }
                //answers.add(wrongAnswer);
                answerlist[i] =wrongAnswer;
            }
        }
        button0.setText(Integer.toString(answerlist[0]));
        button1.setText(Integer.toString(answerlist[1]));
        button2.setText(Integer.toString(answerlist[2]));
        button3.setText(Integer.toString(answerlist[3]));

    }
    private void timer(int maxTime){
        new CountDownTimer(maxTime*1000, 1000){
            public void onTick(long millisecondsUntilDone){
                long y = millisecondsUntilDone/1000;
                Log.i("Second Left!",String.valueOf(millisecondsUntilDone/1000 ));
                timeText.setText(String.valueOf(y) + " s");
                //timer.setText(String.valueOf(millisecondsUntilDone/1000 ));

            }
            public void onFinish(){
                Log.i("We are done!", "No more countdown");
                //mediaPlayer.start();
            }
        }.start();
    }
}
