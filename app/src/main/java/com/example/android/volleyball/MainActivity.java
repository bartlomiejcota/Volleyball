package com.example.android.volleyball;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.volleyball.R;
public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int playerChangeTeamA = 0;
    int playerChangeTeamB = 0;
    boolean messagePoint = false;
    String text;
    int globalScoreTeamA = 0;
    int globalScoreTeamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void addPointForTeamA(View view) {
        setMessagePoint();
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
        if ((globalScoreTeamA + globalScoreTeamB) == 4 && (scoreTeamA -2) >= scoreTeamB && scoreTeamA >=15){
            globalScoreTeamA += 1;
            setBallB(globalScoreTeamA);
            resetSet();
        }
        if ((scoreTeamA - 2) >= scoreTeamB && scoreTeamA >=25){
            globalScoreTeamA += 1;
            setBallA(globalScoreTeamA);
            resetSet();
            text = "This set won team A";
            displayMessage(text);
            messagePoint = true;
        }
        if(globalScoreTeamA == 3){
            setWinnerInfo("A");
            blockButtons(false);
        }
    }
    public void setBallA (int value){
        ImageView ballView;
        switch(value){
                case 1:
                    ballView = (ImageView) findViewById(R.id.ball_1_team_a);
                    ballView.setVisibility(0);
                    break;
                case 2:
                    ballView = (ImageView) findViewById(R.id.ball_2_team_a);
                    ballView.setVisibility(0);
                    break;
                case 3:
                    ballView = (ImageView) findViewById(R.id.ball_3_team_a);
                    ballView.setVisibility(0);
                    break;
                case 4:
                    ballView = (ImageView) findViewById(R.id.ball_1_team_a);
                    ballView.setVisibility(4);
                    ballView = (ImageView) findViewById(R.id.ball_2_team_a);
                    ballView.setVisibility(4);
                    ballView = (ImageView) findViewById(R.id.ball_3_team_a);
                    ballView.setVisibility(4);
                    break;
        }
    }
    public void changePlayerTeamA(View view) {
        setMessagePoint();
        if (playerChangeTeamA == 6) {
            text = "Max player change is 6.";
            displayMessage(text);
            messagePoint = true;
        }
        if (playerChangeTeamA < 6) playerChangeTeamA += 1;
        displayChangeForTeamA(playerChangeTeamA);
    }
    public void displayChangeForTeamA(int change) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_player_change);
        scoreView.setText(String.valueOf(change));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void addPointForTeamB(View view) {
        setMessagePoint();
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
        if ((globalScoreTeamB + globalScoreTeamA) == 4 && (scoreTeamB -2) >= scoreTeamA && scoreTeamB >=15){
            globalScoreTeamB += 1;
            setBallB(globalScoreTeamB);
            resetSet();
        }
        if ((scoreTeamB -2) >= scoreTeamA && scoreTeamB >=25){
            globalScoreTeamB += 1;
            setBallB(globalScoreTeamB);
            resetSet();
            text = "This set won team B";
            displayMessage(text);
            messagePoint = true;
        }
        if(globalScoreTeamB == 3){
            setWinnerInfo("B");
            blockButtons(false);
        }
    }
    public void setBallB (int value){
        ImageView ballView;
        switch(value){
            case 1:
                ballView = (ImageView) findViewById(R.id.ball_1_team_b);
                ballView.setVisibility(0);
                break;
            case 2:
                ballView = (ImageView) findViewById(R.id.ball_2_team_b);
                ballView.setVisibility(0);
                break;
            case 3:
                ballView = (ImageView) findViewById(R.id.ball_3_team_b);
                ballView.setVisibility(0);
                break;
            case 4:
                ballView = (ImageView) findViewById(R.id.ball_1_team_b);
                ballView.setVisibility(4);
                ballView = (ImageView) findViewById(R.id.ball_2_team_b);
                ballView.setVisibility(4);
                ballView = (ImageView) findViewById(R.id.ball_3_team_b);
                ballView.setVisibility(4);
                break;
        }
    }
    public void changePlayerTeamB(View view) {
        setMessagePoint();
        if (playerChangeTeamB == 6) {
            text = "Max player change is 6.";
            displayMessage(text);
            messagePoint = true;
        }
        if (playerChangeTeamB < 6) playerChangeTeamB += 1;
        displayChangeForTeamB(playerChangeTeamB);
    }
    public void displayChangeForTeamB(int change) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_player_change);
        scoreView.setText(String.valueOf(change));
    }
    public void resetButton(View view) {
        setMessagePoint();
        scoreTeamA = 0;
        scoreTeamB = 0;
        playerChangeTeamA = 0;
        playerChangeTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayChangeForTeamA(playerChangeTeamA);
        displayChangeForTeamB(playerChangeTeamB);
        globalScoreTeamA = 0;
        globalScoreTeamB = 0;
        setBallA(4);
        setBallB(4);
        TextView winnerView = (TextView) findViewById(R.id.winner);
        winnerView.setVisibility(4);
        blockButtons(true);
    }
    public void displayMessage(String text) {
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(String.valueOf(text));
    }
    public void resetSet(){
        scoreTeamA = 0;
        scoreTeamB = 0;
        playerChangeTeamA = 0;
        playerChangeTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayChangeForTeamA(playerChangeTeamA);
        displayChangeForTeamB(playerChangeTeamB);
    }
    public void setMessagePoint(){
        if(messagePoint == true) {
            messagePoint = false;
            text = "";
            displayMessage(text);
        }
    }
    public void blockButtons(boolean value){
        Button blockButton = (Button) findViewById(R.id.addPointForTeamAButton);
        blockButton.setClickable(value);
        blockButton = (Button) findViewById(R.id.addPointForTeamBButton);
        blockButton.setClickable(value);
        blockButton = (Button) findViewById(R.id.changePlayerTeamAButton);
        blockButton.setClickable(value);
        blockButton = (Button) findViewById(R.id.changePlayerTeamBButton);
        blockButton.setClickable(value);
    }
    public void setWinnerInfo(String value){
        TextView winnerInfo = (TextView) findViewById(R.id.winner);
        winnerInfo.setVisibility(0);
        text = "This game won team "+value;
        winnerInfo.setText(String.valueOf(text));
    }
}