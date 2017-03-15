package com.wildstop.smixxitdemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.rubensousa.floatingtoolbar.FloatingToolbar;

public class FriendProfileActivity extends AppCompatActivity {
    FloatingToolbar mFloatingtoolbar;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_friend_profile);

        Button chatButton=(Button)findViewById(R.id.chat_button);
        final ImageView friendsgridinit=(ImageView)findViewById(R.id.imageview_friends_grid);
        if (chatButton.getText().equals("ADD")){
            friendsgridinit.setImageResource(R.mipmap.pixelated);
        }
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog.Builder dialog = new ProgressDialog.Builder(FriendProfileActivity.this);
                dialog.setTitle("Term's Of Using SMIXX");
                dialog.setMessage("By SMIXX'ing I agree to respect the views of my fellow SMIXXIT users as well as restrain from using abusive language," +
                        "and sending inappropriate content");
                dialog.setCancelable(false);
                dialog.setPositiveButton("I AGREE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(FriendProfileActivity.this,ChatScreen.class);
                        startActivity(intent);
                    }
                });
                dialog.setNegativeButton("I DO NOT AGREE", new DialogInterface.OnClickListener() {
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

        final Button statusofFriendshipButton=(Button)findViewById(R.id.statusoffriendshipButton);
        statusofFriendshipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (statusofFriendshipButton.getText().equals("ADD")){
                    statusofFriendshipButton.setText("FRIENDS");
                }
                else if (statusofFriendshipButton.getText().equals("FRIENDS")){
                    ProgressDialog.Builder dialog = new ProgressDialog.Builder(FriendProfileActivity.this);
                    dialog.setTitle("Unfriend");
                    dialog.setMessage("Are You Sure You Want To Unfriend?");
                    dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            statusofFriendshipButton.setText("ADD");
                        }
                    });
                    dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
                }
            }
        });
        
        final ImageView friendsgrid=(ImageView)findViewById(R.id.imageview_friends_grid);
        friendsgrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (statusofFriendshipButton.getText().equals("ADD")){
                    ProgressDialog.Builder dialog = new ProgressDialog.Builder(FriendProfileActivity.this);
                    dialog.setTitle("Add Teanna First");
                    dialog.setMessage("To See Teanna's Friends, You Must Send Them An Approval Request.");
                    dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(final DialogInterface dialog, int which) {
                            CountDownTimer countDownTimer=new CountDownTimer(3000,100) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    statusofFriendshipButton.setText("FRIENDS");
                                    friendsgrid.setImageResource(R.mipmap.grid_friends);
                                }

                                @Override
                                public void onFinish() {
                                    dialog.dismiss();
                                }
                            }.start();


                        }
                    });

                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).show();
                }
            }
        });







        fab=(FloatingActionButton)findViewById(R.id.fab) ;

        mFloatingtoolbar=(FloatingToolbar)findViewById(R.id.floatingToolbar);
        mFloatingtoolbar.attachFab(fab);

        mFloatingtoolbar.setClickListener(new FloatingToolbar.ItemClickListener() {
            @Override
            public void onItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.earn){
                    Intent intent = new Intent(FriendProfileActivity.this, EarnPoints.class);
                    startActivity(intent);
                }
                if (id==R.id.discover){
                    Intent intent = new Intent(FriendProfileActivity.this,ExploreScreen.class);
                    startActivity(intent);
                }
                if (id==R.id.profile){
                    Intent intent = new Intent(FriendProfileActivity.this,ProfileList.class);
                    startActivity(intent);
                }
                if (id==R.id.navback){
                    return;
                }
                if (id==R.id.home){
                    Intent intent= new Intent(FriendProfileActivity.this,Home.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onItemLongClick(MenuItem item) {

            }
        });


    }


}
