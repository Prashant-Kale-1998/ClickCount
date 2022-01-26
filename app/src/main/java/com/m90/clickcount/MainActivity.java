package com.m90.clickcount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtCount,txtBgCount;                       //variable declaration
    Button click;
    int buttonCount=0,backgroundCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if( savedInstanceState != null){                                        //check saved Instance State
            buttonCount = savedInstanceState.getInt("COUNT");
            backgroundCount = savedInstanceState.getInt("BGCOUNT");
        }
        setContentView(R.layout.activity_main);                                 //load Activity
        txtCount = (TextView) this.findViewById(R.id.txtCount);                      //find view by id
        txtBgCount = (TextView) this.findViewById(R.id.txtBgCount);
        setView(MainActivity.this);                                           //method call setView(pass activity context)

        click=(Button) findViewById(R.id.btnClick);

        click.setOnClickListener(new View.OnClickListener() {                //button on click
            @Override
            public void onClick(View view) {
                buttonCount++;                                              //button click count increment
                txtCount.setText("" + buttonCount);                         //set on textview
            }
        });
    }

    public void setView(Context ctx){
        txtCount.setText(Integer.toString(buttonCount));                   //set count on text
        txtBgCount.setText(Integer.toString(backgroundCount));
    }

    @Override
    protected void onStop() {
        super.onStop();                                                    //when this method calls backgroundCount increase
        backgroundCount += 1;

    }


    @Override
    protected void onResume() {
        super.onResume();                                                   //when this method calls count set on textview
        txtCount.setText(Integer.toString(buttonCount));
        txtBgCount.setText(Integer.toString(backgroundCount));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);                             //this method save value of count
        outState.putInt("COUNT", buttonCount);
        outState.putInt("BGCOUNT", backgroundCount);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);                  //this method set this count value to the variable
        buttonCount = savedInstanceState.getInt("COUNT");
        backgroundCount = savedInstanceState.getInt("BGCOUNT");
    }

}