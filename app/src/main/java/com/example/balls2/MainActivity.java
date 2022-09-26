package com.example.balls2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Swap1(View view) {
        ImageView img1= (ImageView) findViewById(R.id.imageView1);
        // img1.getDrawable();
        ImageView img2= (ImageView) findViewById(R.id.imageView2);
        ImageView img3= (ImageView) findViewById(R.id.imageView4);
        ImageView img4= (ImageView) findViewById(R.id.imageView5);
        // img1.setImageResource();


        Drawable myDrawable1 = img1.getDrawable();
        Drawable myDrawable2 = img2.getDrawable();
        Drawable myDrawable3 = img4.getDrawable();
        Drawable myDrawable4 = img3.getDrawable();


        img2.setImageDrawable(myDrawable1);
        img4.setImageDrawable(myDrawable2);
        img3.setImageDrawable(myDrawable3);
        img1.setImageDrawable(myDrawable4);
        //TextView tA1= findViewById(R.id.textView);
        //tA1.setText( String.valueOf(myDrawable) );

    }

    public void Swap2(View view) {
        ImageView img1= (ImageView) findViewById(R.id.imageView2);
        ImageView img2= (ImageView) findViewById(R.id.imageView3);
        ImageView img3= (ImageView) findViewById(R.id.imageView5);
        ImageView img4= (ImageView) findViewById(R.id.imageView6);

        Drawable myDrawable1 = img1.getDrawable();
        Drawable myDrawable2 = img2.getDrawable();
        Drawable myDrawable3 = img4.getDrawable();
        Drawable myDrawable4 = img3.getDrawable();


        img2.setImageDrawable(myDrawable1);
        img4.setImageDrawable(myDrawable2);
        img3.setImageDrawable(myDrawable3);
        img1.setImageDrawable(myDrawable4);
    }

    public void Swap3(View view) {
        ImageView img1= (ImageView) findViewById(R.id.imageView4);
        ImageView img2= (ImageView) findViewById(R.id.imageView5);
        ImageView img3= (ImageView) findViewById(R.id.imageView7);
        ImageView img4= (ImageView) findViewById(R.id.imageView8);

        Drawable myDrawable1 = img1.getDrawable();
        Drawable myDrawable2 = img2.getDrawable();
        Drawable myDrawable3 = img4.getDrawable();
        Drawable myDrawable4 = img3.getDrawable();


        img2.setImageDrawable(myDrawable1);
        img4.setImageDrawable(myDrawable2);
        img3.setImageDrawable(myDrawable3);
        img1.setImageDrawable(myDrawable4);
    }

    public void Swap4(View view) {
        ImageView img1= (ImageView) findViewById(R.id.imageView5);
        ImageView img2= (ImageView) findViewById(R.id.imageView6);
        ImageView img3= (ImageView) findViewById(R.id.imageView8);
        ImageView img4= (ImageView) findViewById(R.id.imageView9);

        Drawable myDrawable1 = img1.getDrawable();
        Drawable myDrawable2 = img2.getDrawable();
        Drawable myDrawable3 = img4.getDrawable();
        Drawable myDrawable4 = img3.getDrawable();


        img2.setImageDrawable(myDrawable1);
        img4.setImageDrawable(myDrawable2);
        img3.setImageDrawable(myDrawable3);
        img1.setImageDrawable(myDrawable4);
    }
}