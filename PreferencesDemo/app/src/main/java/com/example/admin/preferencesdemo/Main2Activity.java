package com.example.admin.preferencesdemo;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends FragmentActivity {
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //DialogFragment newFragment = new DialogFragment();
       // newFragment.show(ft, "dialog");
        AlertDFragment alertdFragment = new AlertDFragment();
        // Show Alert DialogFragment
        alertdFragment.show(fm, "dialog");;

        //createAlertDialog();
    }
    /*public void createAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Password Successfully Changed");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog.dismiss();
                       //Intent intent = new Intent(Main2Activity.class,PrefsActivity.this);
                        //startActivity(intent);
                    }
                });
        alertDialog.show();
    }*/
}
