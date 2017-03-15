package com.wildstop.smixxitdemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.cameraview.CameraView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.yqritc.scalablevideoview.ScalableVideoView;

import java.io.IOException;

public class SampleStream extends AppCompatActivity {
    CameraView mCameraView;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_stream);


        mCameraView=(CameraView)findViewById(R.id.videoViewSmall);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Exit Stream", Snackbar.LENGTH_LONG)
                        .setAction("Yes", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                finish();
                            }
                        }).show();
            }
        });

      /* ScalableVideoView mVideoView = (ScalableVideoView) findViewById(R.id.video_view);
        try {
            mVideoView.setRawData(R.raw.kyliee);
            mVideoView.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        */
        CircularImageView sample1= (CircularImageView)findViewById(R.id.testfriend1);
        CircularImageView sample2= (CircularImageView)findViewById(R.id.testfriend2);
        CircularImageView sample3= (CircularImageView)findViewById(R.id.testfriend3);
        CircularImageView sample4= (CircularImageView)findViewById(R.id.testfriend4);
        CircularImageView sample5= (CircularImageView)findViewById(R.id.testfriend5);
        CircularImageView sample6= (CircularImageView)findViewById(R.id.testfriend6);
        CircularImageView sample7= (CircularImageView)findViewById(R.id.testfriend7);
        CircularImageView sample8= (CircularImageView)findViewById(R.id.testfriend8);
        CircularImageView sample9= (CircularImageView)findViewById(R.id.testfriend9);
        CircularImageView sample10= (CircularImageView)findViewById(R.id.testfriend10);
        CircularImageView sample11= (CircularImageView)findViewById(R.id.testfriend11);
        CircularImageView sample12= (CircularImageView)findViewById(R.id.testfriend12);
        CircularImageView sample13= (CircularImageView)findViewById(R.id.testfriend13);
        CircularImageView sample14= (CircularImageView)findViewById(R.id.testfriend14);
        CircularImageView sample15= (CircularImageView)findViewById(R.id.testfriend15);
        CircularImageView sample16= (CircularImageView)findViewById(R.id.testfriend16);
        CircularImageView sample17= (CircularImageView)findViewById(R.id.testfriend17);
        CircularImageView sample18= (CircularImageView)findViewById(R.id.testfriend18);
        CircularImageView sample19= (CircularImageView)findViewById(R.id.testfriend19);
        CircularImageView sample20= (CircularImageView)findViewById(R.id.testfriend20);

        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/originals/38/e0/5a/38e05abd4d36a770409aa6403ac4b330.jpg").into(sample1);
        Picasso.with(getApplicationContext()).load("http://i-cdn.phonearena.com/images/reviews/180213-gallery/Meizu-m2-note-Review-086-selfie-samples.jpg").into(sample2);
        Picasso.with(getApplicationContext()).load("https://thechive.files.wordpress.com/2015/02/10946591_1532674846998361_1464587042_n.jpg?quality=85&strip=info&w=600").into(sample3);
        Picasso.with(getApplicationContext()).load("https://usercontent2.hubstatic.com/12822125_f520.jpg").into(sample4);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/736x/15/51/7c/15517c4adbb618743b9be9ad657e86e3.jpg").into(sample5);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/564x/e6/81/11/e68111de892892fc25b3e72c1ee6a4f6.jpg").into(sample6);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/736x/8b/fd/a5/8bfda5106ae04028c21c9d984720f373.jpg").into(sample7);
        Picasso.with(getApplicationContext()).load("http://hyponik.com/wp-content/uploads/2014/11/tall-black-guy-press-shot.jpg").into(sample8);
        Picasso.with(getApplicationContext()).load("http://www.returnofkings.com/wp-content/uploads/2016/04/white-girl2.png").into(sample9);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/736x/65/9c/ac/659cac43e1402198ff01015415397d4f.jpg").into(sample10);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/736x/ca/a6/3f/caa63f3b95a5dbd8db2b8571cc566cdf.jpg").into(sample11);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/736x/9b/48/10/9b4810a53d6c23c3fc860135fbac321d.jpg").into(sample12);
        Picasso.with(getApplicationContext()).load("http://www.lovely-hairstyles.com/wp-content/uploads/2017/02/Pretty-Black-Girl-with-Long-Hair.jpg").into(sample13);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/736x/94/1f/1f/941f1ffb2c3b9c250df89b4a3ac25fa4.jpg").into(sample14);
        Picasso.with(getApplicationContext()).load("https://exposedmagus.files.wordpress.com/2016/08/austin-h-435.jpg").into(sample15);
        Picasso.with(getApplicationContext()).load("https://consequenceofsound.files.wordpress.com/2014/02/killianyoung.jpg").into(sample16);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/736x/32/d5/12/32d51299118824f694eabf02b67b2c3c.jpg").into(sample17);
        Picasso.with(getApplicationContext()).load("http://hairstyles4men.com/wp-content/uploads/2016/08/10.-guys-hairstyles-for-oval-faces.jpg").into(sample18);
        Picasso.with(getApplicationContext()).load("http://az616578.vo.msecnd.net/files/2016/05/15/6359894036671296301438142285_enhanced-27321-1421785073-2-1.jpg").into(sample19);
        Picasso.with(getApplicationContext()).load("https://c1.staticflickr.com/4/3147/3030821516_793151ecc1_m.jpg").into(sample20);




        sample1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog.Builder dialog = new ProgressDialog.Builder(SampleStream.this);
                dialog.setTitle("Confirm");
                dialog.setMessage("Are you Sure You Want To Smixx This User");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SampleStream.this,ChatInStream.class);
                        startActivity(intent);
                    }
                });
                dialog.setNegativeButton("No, Back To Stream", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        final ProgressDialog.Builder dialogtwo = new ProgressDialog.Builder(getApplicationContext());
                        dialogtwo.setMessage("You will not be able To SMIXX unless you accept the Terms Of USe");
                        dialogtwo.setCancelable(false);
                        dialogtwo.setNegativeButton("I Understand", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                    }
                }).show();

            }
        });

        videoView = (VideoView) findViewById(R.id.video_view);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jenner));
        videoView.start();


    }
    @Override
    protected void onResume() {
        super.onResume();
        mCameraView.start();

    }

    @Override
    protected void onPause() {
        mCameraView.stop();
        super.onPause();
    }

    @Override
    protected void onRestart() {
        mCameraView.start();
        videoView.start();
        super.onRestart();
    }
}


