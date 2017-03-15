package com.wildstop.smixxitdemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class EarnPoints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn_points);
        ImageView ad1=(ImageView)findViewById(R.id.ad1);
        ImageView ad2=(ImageView)findViewById(R.id.ad2);
        ImageView ad3=(ImageView)findViewById(R.id.ad3);
        ImageView ad4=(ImageView)findViewById(R.id.ad4);
        ImageView imagviewAckCeleb= (ImageView)findViewById(R.id.clickable);



        imagviewAckCeleb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ProgressDialog.Builder dialog = new ProgressDialog.Builder(EarnPoints.this);
                dialog.setTitle("Confirm Acknowledgment Request To Kylie Jenner  ");
                dialog.setMessage("Would You Like To Proceed Using Coins Or Paying With Cash .");
                dialog.setPositiveButton("Pay With Points", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        final CharSequence[] items = {" Text (10,0000 Points) "," Image (30,0000 Points) "," Audio (50,0000 Points) "," Video (150,000 Points) "};
// arraylist to keep the selected items
                        final ArrayList seletedItems=new ArrayList();

                        final AlertDialog dialog2 = new AlertDialog.Builder(EarnPoints.this)
                                .setTitle("Select Acknowledgment Pack.")
                                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                        if (isChecked) {
                                            // If the user checked the item, add it to the selected items
                                            seletedItems.add(indexSelected);
                                        } else if (seletedItems.contains(indexSelected)) {
                                            // Else, if the item is already in the array, remove it
                                            seletedItems.remove(Integer.valueOf(indexSelected));
                                        }
                                    }
                                }).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                      final ProgressDialog progressDialog= new ProgressDialog(EarnPoints.this);
                                        progressDialog.setTitle("Confirming");
                                        progressDialog.setMessage("Confirming Your Purchase");
                                        progressDialog.setCancelable(false);
                                        progressDialog.show();
                                        new CountDownTimer(5000,100){
                                            ProgressDialog.Builder dialog = new ProgressDialog.Builder(EarnPoints.this);
                                            @Override
                                            public void onTick(long millisUntilFinished) {
                                            progressDialog.setTitle("You've Payed 50,0000 Points");
                                                progressDialog.setMessage("Please wait....");
                                                progressDialog.setCancelable(false);
                                                progressDialog.show();
                                            }

                                            @Override
                                            public void onFinish() {
                                                progressDialog.dismiss();

                                                dialog.setTitle("Acknowledgment Confirmed.");
                                                dialog.setCancelable(false);
                                                dialog.setMessage("Your Acknowledgement Is Confirmed. We We Will Alert You When Kylie Sends Out Your Acknowledgement.");
                                                dialog.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                });
                                                dialog.show();



                                            }
                                        }.start();

                                    }
                                }
                                ).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        //  Your code when user clicked on Cancel
                                    }
                                }).create();
                        dialog2.show();
                    }
                });

                dialog.setNegativeButton("Pay With Cash", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();


                    }
                }).show();


            }
        });



        ad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EarnPoints.this,Ad1.class);
                startActivity(intent);
            }
        });
        ad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EarnPoints.this,Ad2.class);
                startActivity(intent);
            }
        });
        ad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EarnPoints.this,Ad3.class);
                startActivity(intent);

            }
        });
        ad4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EarnPoints.this,Ad4.class);
                startActivity(intent);

            }
        });

    }
}
