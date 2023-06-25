package com.example.tictacto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Button>allButton = new ArrayList<>();
    Button  btn_1 , btn_2, btn_3, btn_4,btn_5,btn_6,btn_7,btn_8,btn_9, resetBtn;
    TextView winnerView;
    final Boolean[] currentValue = {false};
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        winnerView = findViewById(R.id.winnerView);
        initializeButton();

        for(Button btn : allButton){
            ticMaker(btn);
        }

//      Resetting Game
        resetBtn.setOnClickListener(v -> {
//          Resetting all buttons to play new Game!
            resetAll();
        });


    }
    private void initializeButton(){
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        resetBtn = findViewById(R.id.resetBtn);
        allButton.add(btn_1);
        allButton.add(btn_2);
        allButton.add(btn_3);
        allButton.add(btn_4);
        allButton.add(btn_5);
        allButton.add(btn_6);
        allButton.add(btn_7);
        allButton.add(btn_8);
        allButton.add(btn_9);
//        allButton.add(resetBtn);

    }

    private void ticMaker(Button btn){
        btn.setOnClickListener(v->{

            if(!currentValue[0]){
                btn.setText("❌");
            }else{
                btn.setText("⚽");
            }

            checkWinner(btn);

            v.setEnabled(false);
            currentValue[0] = !currentValue[0];

        });
    }

    private void resetAll(){
        for(Button btn : allButton){
            btn.setText("");
            btn.setEnabled(true);
        }
        winnerView.setText("");
    }

    @SuppressLint("SetTextI18n")
    private void checkWinner(Button winBtnDetect){
        if(!allButton.get(0).getText().toString().equals("") && allButton.get(0).getText().toString().equals(allButton.get(1).getText().toString()) && allButton.get(0).getText().toString().equals(allButton.get(2).getText().toString())){
            Log.d("my msg", "Winner R1");
            winnerView.setText("Winner is: "+ winBtnDetect.getText());
            disableAllBtn();
        }
        else if(!allButton.get(3).getText().toString().equals("") && allButton.get(3).getText().toString().equals(allButton.get(4).getText().toString()) && allButton.get(3).getText().toString().equals(allButton.get(5).getText().toString())){
            Log.d("my msg", "Winner R2");
            winnerView.setText("Winner is: "+ winBtnDetect.getText());
            disableAllBtn();
        }else if(!allButton.get(6).getText().toString().equals("") && allButton.get(6).getText().toString().equals(allButton.get(7).getText().toString()) && allButton.get(6).getText().toString().equals(allButton.get(8).getText().toString())){
            Log.d("my msg", "Winner R3");
            winnerView.setText("Winner is: "+ winBtnDetect.getText());
            disableAllBtn();
        }
        else if(!allButton.get(0).getText().toString().equals("") && allButton.get(0).getText().toString().equals(allButton.get(3).getText().toString()) && allButton.get(0).getText().toString().equals(allButton.get(6).getText().toString())){
            Log.d("my msg", "Winner C1");
            winnerView.setText("Winner is: "+ winBtnDetect.getText());
            disableAllBtn();
        }else if(!allButton.get(1).getText().toString().equals("") && allButton.get(1).getText().toString().equals(allButton.get(4).getText().toString()) && allButton.get(1).getText().toString().equals(allButton.get(7).getText().toString())){
            Log.d("my msg", "Winner C2");
            winnerView.setText("Winner is: "+ winBtnDetect.getText());
            disableAllBtn();
        }else if(!allButton.get(2).getText().toString().equals("") && allButton.get(2).getText().toString().equals(allButton.get(5).getText().toString()) && allButton.get(2).getText().toString().equals(allButton.get(8).getText().toString())){
            Log.d("my msg", "Winner C3");
            winnerView.setText("Winner is: "+ winBtnDetect.getText());
            disableAllBtn();
        }else if(!allButton.get(0).getText().toString().equals("") && allButton.get(0).getText().toString().equals(allButton.get(4).getText().toString()) && allButton.get(0).getText().toString().equals(allButton.get(8).getText().toString())){
            Log.d("my msg", "Winner Diagonal 1");
            winnerView.setText("Winner is: "+ winBtnDetect.getText());
            disableAllBtn();
        }else if(!allButton.get(2).getText().toString().equals("") && allButton.get(2).getText().toString().equals(allButton.get(4).getText().toString()) && allButton.get(2).getText().toString().equals(allButton.get(6).getText().toString())){
            Log.d("my msg", "Winner Diagonal 2");
            winnerView.setText("Winner is: "+ winBtnDetect.getText());
            disableAllBtn();
        }

    }

    public void disableAllBtn(){
        for(Button btn : allButton){
            btn.setEnabled(false);
        }
    }
}