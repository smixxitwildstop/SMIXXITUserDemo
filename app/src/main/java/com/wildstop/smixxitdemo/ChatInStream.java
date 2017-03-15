package com.wildstop.smixxitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class ChatInStream extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_in_stream);
        CircularImageView sample1= (CircularImageView)findViewById(R.id.chat_img);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/originals/38/e0/5a/38e05abd4d36a770409aa6403ac4b330.jpg").into(sample1);

        Button exitChat= (Button)findViewById(R.id.exit_chat);
        exitChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
