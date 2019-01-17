package com.example.tmaya.tictactoy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AutoPlayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_play);

        findViewById(R.id.restore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Reset();


            }
        });

    }

    public void BtnClick(View view) {
        Button button= (Button) view;
        int cellId=0;
        switch ((button.getId())) {
            case R.id.btn1:
                cellId = 1;
                break;
            case R.id.btn2:
                cellId = 2;
                break;
            case R.id.btn3:
                cellId = 3;
                break;
            case R.id.btn4:
                cellId = 4;
                break;
            case R.id.btn5:
                cellId = 5;
                break;
            case R.id.btn6:
                cellId = 6;
                break;
            case R.id.btn7:
                cellId = 7;
                break;
            case R.id.btn8:
                cellId = 8;
                break;
            case R.id.btn9:
                cellId = 9;
                break;
        }
        PlayGame(cellId,button);
    }


    int activePlayer=1;
    ArrayList<Integer> player1=new ArrayList<Integer>();
    ArrayList<Integer> player2=new ArrayList<Integer>();
    void PlayGame(int cellId,Button btn){
        Log.d("Player",String.valueOf(cellId));
        if(activePlayer==1){
            btn.setText("X");
            btn.setBackgroundColor(Color.GREEN);
            player1.add(cellId);
            activePlayer=2;

            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AutoPlay();
                }
            },600);

        }else if(activePlayer==2){
            btn.setText("0");
            btn.setBackgroundColor(Color.rgb(238, 129, 15  ));
            player2.add(cellId);
            activePlayer=1;
        }
        btn.setEnabled(false);
        Winner();

    }

    void Winner(){
        int winner=-1;

        //row 1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner=1;
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner=2;
        }

        //row 2
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner=1;
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner=2;
        }

        //row 3
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner=1;
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner=2;
        }

        //col 1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner=1;
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner=2;
        }

        //col2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner=1;
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner=2;
        }

        //col 3
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner=1;
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner=2;
        }

        //diagonal 1
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner=1;
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner=2;
        }
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner=1;
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner=2;
        }


        if (winner!=-1){
            if (winner==1){
                Toast.makeText(this, "Player 1 is winner", Toast.LENGTH_LONG).show();
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Reset();

                    }
                }, 600);

            }
            if (winner==2){
                Toast.makeText(this, "Player 2 is winner", Toast.LENGTH_LONG).show();

                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 2s = 2000ms
                        Reset();

                    }
                }, 600);

            }
        }

    }

    void Reset(){
        Button btn1= findViewById(R.id.btn1);
        btn1.setBackgroundColor(Color.WHITE);
        btn1.setText("");
        btn1.setEnabled(true);
        findViewById(R.id.btn2).setBackgroundColor(Color.WHITE);
        findViewById(R.id.btn2).setEnabled(true);
        findViewById(R.id.btn3).setBackgroundColor(Color.WHITE);
        findViewById(R.id.btn3).setEnabled(true);
        findViewById(R.id.btn4).setBackgroundColor(Color.WHITE);
        findViewById(R.id.btn4).setEnabled(true);
        findViewById(R.id.btn5).setBackgroundColor(Color.WHITE);
        findViewById(R.id.btn5).setEnabled(true);
        findViewById(R.id.btn6).setBackgroundColor(Color.WHITE);
        findViewById(R.id.btn6).setEnabled(true);
        findViewById(R.id.btn7).setBackgroundColor(Color.WHITE);
        findViewById(R.id.btn7).setEnabled(true);
        findViewById(R.id.btn8).setBackgroundColor(Color.WHITE);
        findViewById(R.id.btn8).setEnabled(true);
        findViewById(R.id.btn9).setBackgroundColor(Color.WHITE);
        findViewById(R.id.btn9).setEnabled(true);
        Button btn2=findViewById(R.id.btn2);
        Button btn3=findViewById(R.id.btn3);
        Button btn4=findViewById(R.id.btn4);
        Button btn5=findViewById(R.id.btn5);
        Button btn6=findViewById(R.id.btn6);
        Button btn7=findViewById(R.id.btn7);
        Button btn8=findViewById(R.id.btn8);
        Button btn9=findViewById(R.id.btn9);
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        player1.clear();
        player2.clear();
    }


    void AutoPlay(){
        ArrayList<Integer> EmptyCell=new ArrayList<>();

        for (int cellId=1;cellId<10;cellId++){
            if(!(player1.contains(cellId)||player2.contains(cellId))){
                EmptyCell.add(cellId);
            }
        }
//        Collections.shuffle(EmptyCell);
//        int cellId=(EmptyCell.get(0));

        Random r = new Random();
        int cellId=(EmptyCell.get(r.nextInt(EmptyCell.size())));
        Button button;
        switch (cellId) {
            case 1:
                button=findViewById(R.id.btn1);
                break;
            case 2:
                button=findViewById(R.id.btn2);
                break;
            case 3:
                button=findViewById(R.id.btn3);
                break;
            case 4:
                button=findViewById(R.id.btn4);
                break;
            case 5:
                button=findViewById(R.id.btn5);
                break;
            case 6:
                button=findViewById(R.id.btn6);
                break;
            case 7:
                button=findViewById(R.id.btn7);
                break;
            case 8:
                button=findViewById(R.id.btn8);
                break;
            case 9:
                button=findViewById(R.id.btn9);
                break;
            default:
                button=findViewById(R.id.btn1);
        }
        PlayGame(cellId,button);

    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AutoPlayActivity.this,Main2Activity.class));
        finish();
    }
}
