package com.example.balls2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int[][] arr = {{1, 0, 1},
            {0, 0, 0},
            {0, 1, 0},};
    int steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void Win() {
        TextView tA1 = findViewById(R.id.textView);
        tA1.setText(String.valueOf(arr[0][1]));
        TextView tA2 = findViewById(R.id.textView2);
        tA2.setText(String.valueOf(arr[1][1]));
        TextView tA3 = findViewById(R.id.textView3);
        tA3.setText(String.valueOf(arr[2][1]));
        TextView tA4 = findViewById(R.id.textView4);
        tA4.setText(String.valueOf(steps));
        if (arr[0][1] == 1 && arr[1][1] == 1 && arr[2][1] == 1) {
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("steps",steps);
            startActivity(intent);
        }
    }

    public void Swap1(View view) {
        steps++;
        ImageView img1 = (ImageView) findViewById(R.id.imageView1);
        // img1.getDrawable();
        ImageView img2 = (ImageView) findViewById(R.id.imageView2);
        ImageView img3 = (ImageView) findViewById(R.id.imageView4);
        ImageView img4 = (ImageView) findViewById(R.id.imageView5);
        // img1.setImageResource();


        Drawable myDrawable1 = img1.getDrawable();
        Drawable myDrawable2 = img2.getDrawable();
        Drawable myDrawable3 = img4.getDrawable();
        Drawable myDrawable4 = img3.getDrawable();


        img2.setImageDrawable(myDrawable1);
        img4.setImageDrawable(myDrawable2);
        img3.setImageDrawable(myDrawable3);
        img1.setImageDrawable(myDrawable4);

        int temp1 = arr[0][0];
        int temp2 = arr[0][1];
        int temp3 = arr[1][0];
        int temp4 = arr[1][1];

        arr[0][0] = temp3;
        arr[0][1] = temp1;
        arr[1][0] = temp4;
        arr[1][1] = temp2;

        //TextView tA1= findViewById(R.id.textView);
        //tA1.setText( String.valueOf(myDrawable) );
        Win();
    }

    public void Swap2(View view) {
        steps++;
        ImageView img1 = (ImageView) findViewById(R.id.imageView2);
        ImageView img2 = (ImageView) findViewById(R.id.imageView3);
        ImageView img3 = (ImageView) findViewById(R.id.imageView5);
        ImageView img4 = (ImageView) findViewById(R.id.imageView6);

        Drawable myDrawable1 = img1.getDrawable();
        Drawable myDrawable2 = img2.getDrawable();
        Drawable myDrawable3 = img4.getDrawable();
        Drawable myDrawable4 = img3.getDrawable();


        img2.setImageDrawable(myDrawable1);
        img4.setImageDrawable(myDrawable2);
        img3.setImageDrawable(myDrawable3);
        img1.setImageDrawable(myDrawable4);


        int temp1 = arr[0][1];
        int temp2 = arr[0][2];
        int temp3 = arr[1][1];
        int temp4 = arr[1][2];

        arr[0][1] = temp3;
        arr[0][2] = temp1;
        arr[1][1] = temp4;
        arr[1][2] = temp2;
        Win();
    }

    public void Swap3(View view) {
        steps++;
        ImageView img1 = (ImageView) findViewById(R.id.imageView4);
        ImageView img2 = (ImageView) findViewById(R.id.imageView5);
        ImageView img3 = (ImageView) findViewById(R.id.imageView7);
        ImageView img4 = (ImageView) findViewById(R.id.imageView8);

        Drawable myDrawable1 = img1.getDrawable();
        Drawable myDrawable2 = img2.getDrawable();
        Drawable myDrawable3 = img4.getDrawable();
        Drawable myDrawable4 = img3.getDrawable();


        img2.setImageDrawable(myDrawable1);
        img4.setImageDrawable(myDrawable2);
        img3.setImageDrawable(myDrawable3);
        img1.setImageDrawable(myDrawable4);

        int temp1 = arr[1][0];
        int temp2 = arr[1][1];
        int temp3 = arr[2][0];
        int temp4 = arr[2][1];

        arr[1][0] = temp3;
        arr[1][1] = temp1;
        arr[2][0] = temp4;
        arr[2][1] = temp2;
        Win();
    }

    public void Swap4(View view) {
        steps++;
        ImageView img1 = (ImageView) findViewById(R.id.imageView5);
        ImageView img2 = (ImageView) findViewById(R.id.imageView6);
        ImageView img3 = (ImageView) findViewById(R.id.imageView8);
        ImageView img4 = (ImageView) findViewById(R.id.imageView9);

        Drawable myDrawable1 = img1.getDrawable();
        Drawable myDrawable2 = img2.getDrawable();
        Drawable myDrawable3 = img4.getDrawable();
        Drawable myDrawable4 = img3.getDrawable();


        img2.setImageDrawable(myDrawable1);
        img4.setImageDrawable(myDrawable2);
        img3.setImageDrawable(myDrawable3);
        img1.setImageDrawable(myDrawable4);


        int temp1 = arr[1][1];
        int temp2 = arr[1][2];
        int temp3 = arr[2][1];
        int temp4 = arr[2][2];

        arr[1][1] = temp3;
        arr[1][2] = temp1;
        arr[2][1] = temp4;
        arr[2][2] = temp2;
        Win();
    }
}