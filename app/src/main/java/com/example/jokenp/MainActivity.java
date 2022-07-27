package com.example.jokenp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    String myChoise;
    String[] options = {"rock", "paper", "scissor"};
    String computerChoise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void choseRock(View view) {
        myChoise = "rock";
        play();
    }

    public void chosePaper(View view) {
        myChoise = "paper";
        play();
    }

    public void choseScissor(View view) {
        myChoise = "scissor";
        play();
    }

    public void play() {
        Random random = new Random();
        int randomChoice = random.nextInt(3);
        computerChoise = options[randomChoice];
        changeImage(randomChoice);
        changeTextAndSetWinner();
    }

    public void changeTextAndSetWinner() {
        TextView resultDescription = findViewById(R.id.resultDescription);
            if (myChoise == computerChoise) {
                resultDescription.setText("Vocês empataram!");
            } else if ( (myChoise == "rock" && computerChoise == "scissor") ||
                        (myChoise == "scissor" && computerChoise == "paper") ||
                        (myChoise == "paper" && computerChoise == "rock")) {
                resultDescription.setText("Você ganhou!");
            }else {
                resultDescription.setText("Você perdeu!!");
            }
    }

    public void changeImage(int choice) {
        imageView = findViewById(R.id.computerChoice);
        switch (choice){
            case 0 :
                imageView.setImageResource(R.drawable.pedra);
                break;
            case 1 :
                imageView.setImageResource(R.drawable.papel);
                break;
            case 2 :
                imageView.setImageResource(R.drawable.tesoura);
                break;
            default:
                imageView.setImageResource(R.drawable.padrao);
        }
    }

}
