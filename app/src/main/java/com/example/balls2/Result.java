package com.example.balls2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle arguments = getIntent().getExtras();
        int steps=0;
        if (arguments != null) {
             steps = arguments.getInt("steps");
        }
        TextView tA4 = findViewById(R.id.textView7);
        tA4.setText(String.valueOf(steps));
    }

    public void NewGame(View view) {
        int[][] arr = {{1, 0, 1},
                {0, 0, 0},
                {0, 1, 0},};
        int steps = 0;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("steps",steps);
        intent.putExtra("arr",arr);
        startActivity(intent);
    }
}