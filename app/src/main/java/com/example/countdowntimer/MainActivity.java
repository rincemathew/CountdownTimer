package com.example.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView timer;

    //timer time = 15 sec
    MyCountDownTimer firstTimer = new MyCountDownTimer(15000,1000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=findViewById(R.id.timer);

        //start the timer
        firstTimer.start();


    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }
        @Override
        public void onFinish() {
            //what happens when the timer is finish
            Toast.makeText(getApplicationContext(),"finish",Toast.LENGTH_SHORT).show();
            firstTimer.start();
        }
        @Override
        public void onTick(long millisUntilFinished) {
            //what happens when the timer is running
            timer.setText("" + millisUntilFinished / 1000);

        }
        //always use this for stop the timer otherwise timer is running in the background
        //firstTimer.cancel();

    }
}
