package com.wildstop.smixxitdemo;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.rubensousa.floatingtoolbar.FloatingToolbar;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProfileList extends AppCompatActivity {
    FloatingToolbar mFloatingtoolbarProfile;
    FloatingActionButton fabProfile;
    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);
        CircularImageView jb=(CircularImageView)findViewById(R.id.justinbieber_img);
        CircularImageView chance=(CircularImageView)findViewById(R.id.chance_img);
        CircularImageView bonjovi=(CircularImageView)findViewById(R.id.jovi_img);
        CircularImageView chrisbrown=(CircularImageView)findViewById(R.id.chrisbrown_img);
        CircularImageView coldplay=(CircularImageView)findViewById(R.id.coldplay_img);
        CircularImageView kanye=(CircularImageView)findViewById(R.id.kanye_west);
        CircularImageView kimkardashian=(CircularImageView)findViewById(R.id.kim_kardashian_img);
        CircularImageView kylie=(CircularImageView)findViewById(R.id.kylie);
        CircularImageView kenosha=(CircularImageView)findViewById(R.id.kenosha);
        CircularImageView metro=(CircularImageView)findViewById(R.id.metro_boomin);
        CircularImageView nickiminaj=(CircularImageView)findViewById(R.id.nicki_img);
        CircularImageView raeshremmurd=(CircularImageView)findViewById(R.id.rae_shremmurd_img);
        CircularImageView tyer=(CircularImageView)findViewById(R.id.tyler_img);
        CircularImageView usher=(CircularImageView)findViewById(R.id.usher_img);
        ImageView imageviewone=(ImageView)findViewById(R.id.imageview_list_one);
        ImageView imageviewtwo=(ImageView)findViewById(R.id.imageview_list_two);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> permissionsNeeded = new ArrayList<String>();

            final List<String> permissionsList = new ArrayList<String>();
            if (!addPermission(permissionsList, android.Manifest.permission.ACCESS_FINE_LOCATION))
                permissionsNeeded.add("GPS");
            if (!addPermission(permissionsList, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
                permissionsNeeded.add("Write to storage");
            if (!addPermission(permissionsList, android.Manifest.permission.CAMERA))
                permissionsNeeded.add("Camera");
            if (!addPermission(permissionsList, android.Manifest.permission.RECORD_AUDIO))
                permissionsNeeded.add("Audio");
            if (!addPermission(permissionsList, android.Manifest.permission.ACCESS_FINE_LOCATION))
                permissionsNeeded.add("Location");

            if (permissionsList.size() > 0) {
                if (permissionsNeeded.size() > 0) {
                    requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                            REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                }
            }
        }


        fabProfile=(FloatingActionButton)findViewById(R.id.fab_profile) ;

        mFloatingtoolbarProfile=(FloatingToolbar)findViewById(R.id.floatingToolbar_profile);
        mFloatingtoolbarProfile.attachFab(fabProfile);

        mFloatingtoolbarProfile.setClickListener(new FloatingToolbar.ItemClickListener() {
            @Override
            public void onItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.earn){
                  Intent intent = new Intent(ProfileList.this, EarnPoints.class);
                    startActivity(intent);
                }
                if (id==R.id.discover){
                    Intent intent = new Intent(ProfileList.this,ExploreScreen.class);
                    startActivity(intent);
                }
                if (id==R.id.profile){
                    Intent intent = new Intent(ProfileList.this,ProfileList.class);

                }
                if (id==R.id.navback){
                    return;
                }
                if ((id==R.id.home)){
                    Intent intent= new Intent(ProfileList.this,Home.class);
                }
        }

            @Override
            public void onItemLongClick(MenuItem item) {

            }
        });






        final Dialog dialog = new Dialog(ProfileList.this);
        dialog.setContentView(R.layout.welcome_to_smixxit);
        dialog.setTitle("Title...");
        dialog.show();




        Picasso.with(getApplicationContext()).load("http://www.wallpapermade.com/images/wallpapers/originals/justin-bieber-with-earrings-wallpaper-5309.jpg").into(jb);
        Picasso.with(getApplicationContext()).load("https://s-media-cache-ak0.pinimg.com/originals/71/4f/d7/714fd784c2453c2195a663234f74b81a.png").into(chance);
        Picasso.with(getApplicationContext()).load("http://images2.wikia.nocookie.net/__cb20100807050131/doblaje/es/images/7/73/Jon_Bon_Jovi.jpg").into(bonjovi);
        Picasso.with(getApplicationContext()).load("http://a.abcnews.com/images/Entertainment/GTY_chris_brown_3_jt_160102_12x5_1600.jpg").into(chrisbrown);
        Picasso.with(getApplicationContext()).load("http://img.aceshowbiz.com/images/photo/coldplay.jpg").into(coldplay);
        Picasso.with(getApplicationContext()).load("http://cdn3.pitchfork.com/news/63330/9b813a8d.jpg").into(kanye);
        Picasso.with(getApplicationContext()).load("https://peopledotcom.files.wordpress.com/2015/06/kim-kardashian-01-600x800.jpg").into(kimkardashian);
        Picasso.with(getApplicationContext()).load("http://i.dailymail.co.uk/i/pix/2015/12/30/19/2FACF3EE00000578-3379286-image-a-67_1451504482840.jpg").into(kylie);
        Picasso.with(getApplicationContext()).load(R.mipmap.kenoimg).into(kenosha);
        Picasso.with(getApplicationContext()).load("http://origin-blog-us.napster.com/wp-content/uploads/2016/05/MetroBoomin-1.jpg").into(metro);
        Picasso.with(getApplicationContext()).load("http://www.billboard.com/files/styles/article_main_image/public/media/nicki-minaj-press-2014-650.jpg").into(nickiminaj);
        Picasso.with(getApplicationContext()).load("http://cache.umusic.com/_sites/_halo/raesremmurd/images/share.jpg").into(raeshremmurd);
        Picasso.with(getApplicationContext()).load("http://www.busyworksbeats.com/wp-content/uploads/2015/03/tyler-the-creator-tamale-1.jpg").into(tyer);
        Picasso.with(getApplicationContext()).load("http://vatalent.com/uploads/sitePics/usher_416x416.jpg").into(usher);

        kylie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startJustinBierberActivityIntent= new Intent(ProfileList.this,KylieJennerActivity.class);
                startActivity(startJustinBierberActivityIntent);
            }
        });

        kenosha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startKenoActivityIntent= new Intent(ProfileList.this,KenoActivity.class);
                startActivity(startKenoActivityIntent);

            }
        });

        Picasso.with(getApplicationContext()).load(R.mipmap.uno).into(imageviewone);
        Picasso.with(getApplicationContext()).load(R.mipmap.uno).into(imageviewtwo);

        imageviewone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ProfileList.this,FriendProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imageviewtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ProfileList.this,FriendProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });










    }
    private boolean addPermission(List<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }
        return true;
    }
}
