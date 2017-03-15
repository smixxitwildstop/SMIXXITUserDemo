package com.wildstop.smixxitdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rubensousa.floatingtoolbar.FloatingToolbar;

import pl.kitek.timertextview.TimerTextView;

public class KenoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
      /*  SnapUpCountDownTimerView rushBuyCountDownTimerView = (SnapUpCountDownTimerView) findViewById(R.id.RushBuyCountDownTimerView);
        rushBuyCountDownTimerView.setTime(0,1,0);//设置小时，分钟，秒。注意不能大于正常值，否则会抛出异常
        rushBuyCountDownTimerView.start();//开始倒计时
       */

        long futureTimestamp = System.currentTimeMillis() + (20000);
        final TimerTextView timerText = (TimerTextView) findViewById(R.id.timerText);
        timerText.setEndTime(futureTimestamp);
        final TextView textLive=(TextView)findViewById(R.id.textLIVE);
        final Button joinStreamButton =(Button)findViewById(R.id.joinStreamButton) ;

        FloatingActionButton fabProfile=(FloatingActionButton)findViewById(R.id.fab_stream) ;

        FloatingToolbar mFloatingtoolbarProfile=(FloatingToolbar)findViewById(R.id.floatingToolbar_stream);
        mFloatingtoolbarProfile.attachFab(fabProfile);

        mFloatingtoolbarProfile.setClickListener(new FloatingToolbar.ItemClickListener() {
            @Override
            public void onItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.earn){
                    Intent intent = new Intent(KenoActivity.this, EarnPoints.class);
                    startActivity(intent);
                }
                if (id==R.id.discover){
                    Intent intent = new Intent(KenoActivity.this,ExploreScreen.class);
                    startActivity(intent);
                }
                if (id==R.id.profile){
                    Intent intent = new Intent(KenoActivity.this,ProfileList.class);
                    startActivity(intent);
                }
                if (id==R.id.navback){
                    return;
                }
                if (id==R.id.home){
                    Intent intent= new Intent(KenoActivity.this,Home.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onItemLongClick(MenuItem item) {

            }
        });





        CountDownTimer timer = new CountDownTimer(20000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Toast.makeText(KenoActivity.this, "Begin The Test Steam", Toast.LENGTH_SHORT).show();
                timerText.setVisibility(View.INVISIBLE);
                textLive.setVisibility(View.VISIBLE);
                textLive.setBackgroundColor(Color.RED);
                joinStreamButton.setVisibility(View.VISIBLE);
            }
        };

        timer.start();
        joinStreamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(KenoActivity.this,SampleStreamKeno.class);
                startActivity(intent);
            }
        });

    }
}
