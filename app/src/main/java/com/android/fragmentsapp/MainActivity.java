package com.android.fragmentsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_fragment1;
    private Button btn_fragment2;
    private Button btn_navigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_fragment1 = findViewById(R.id.btn_fragment1);
        btn_fragment2 = findViewById(R.id.btn_fragment2);
        btn_navigate = findViewById(R.id.btn_navigate);

        btn_navigate.setOnClickListener(this);

        btn_navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NavigationActivity.class);
                startActivity(intent);
            }
        });


        btn_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Message");
                alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });
                alertDialog.show();

                FragmentOne fragmentOne = new FragmentOne();
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,fragmentOne);
                fragmentTransaction.commit();
            }
        });

        btn_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTwo fragmentTwo = new FragmentTwo();
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,fragmentTwo);
                fragmentTransaction.commit();
            }
        });
    }


    @Override
    public void onClick(View v) {

    }
}
