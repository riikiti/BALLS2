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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    int[][] arr = {{1, 0, 1},
            {0, 0, 0},
            {0, 1, 0},};
    int steps = 0;
    Board board = new Board(arr);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void Win() {
        TextView tA1 = findViewById(R.id.textView);
        tA1.setText(String.valueOf(board.getBoard()[0][1]));
        TextView tA2 = findViewById(R.id.textView2);
        tA2.setText(String.valueOf(board.getBoard()[1][1]));
        TextView tA3 = findViewById(R.id.textView3);
        tA3.setText(String.valueOf(board.getBoard()[2][1]));
        TextView tA4 = findViewById(R.id.textView4);
        tA4.setText(String.valueOf(steps));

        if (board.Win()) {
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("steps", steps);
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

        board.Move(0, 0, board.getBoard());

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

        board.Move(0, 1, board.getBoard());


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

        board.Move(1, 0, board.getBoard());


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

        board.Move(1, 1, board.getBoard());

        Win();
    }


    //todo существуют два стека
    // один не с пройденными --> A (при (нажатие на кнопку читов) / создание сразу занесены 4 состояния нажатия кнопок)
    // с пройденными состояниями --> B
    // temp --> в который копируется взятый массив
    // while (!Win()){
    //      из стека A берем readTop() и у него проверяем на совпадение с уже пройденными состояниями и с победой,
    //      если ничего не прошло то создаем от него еще 4 состояния которые заносим в стэк А, а данное состояние заносим в пройденные.
    //      если совпало уже с пройденными состояниями в стеке B, то удаляем это и берем следующее в стеке А
    // }


    //todo Первым делом уже в цикле КОПИРУЕШЬ элемент из стека, то есть тот самый первый, который занёc
    // И у скопированного создаёшь детей, попутно проверяя на наличие таких состояний в А и В
    // После создания дочерей, вытаскиваешь из А тпроверенное состояние и суешь в В
    // И после копирования из А не забудь проверить на конец

    public void Cheats(View view) {
        int mas = 1000;
        Stack A = new Stack(mas); // стек не пройденные
        ArrayList<Board> B = new ArrayList<Board>(); // список пройденные
        // Queue<Board> Road = new LinkedList<Board>(); // очередь для вывода решения
        // Road.add(board);
        Board Temp = board; //заносим текущий борд во временный


        while (!Temp.Win()) {
            B.add(Temp);
            steps++;
            Board temp1 = Temp;
            // создали 4 новых состояния борда аля нажатия клавиш
            A.addElement(Temp.Move(0, 0, board.getBoard()));
            A.addElement(Temp.Move(0, 1, board.getBoard()));
            A.addElement(Temp.Move(1, 0, board.getBoard()));
            A.addElement(Temp.Move(1, 1, board.getBoard()));

            // тоже как то надо проверить но я хз когда
            if (A.isEmpty()) {
                break;
            }
            for (Board el : B) {
                if (Temp.getBoard() == el.getBoard()) {
                    A.deleteElement();
                    // Road.add(Temp);
                } else {
                    Temp = A.readTop();
                }
            }




            TextView tA1 = findViewById(R.id.textView);
            int[][] arr1 = A.readTop().getBoard();
            String s = " ";

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1.length; j++) {
                    s += String.valueOf(arr1[i][j]);

                }
            }
            tA1.setText(s);
            //break;

        }
        board = Temp;
        board.Win();
        /*
        for (int i = 0; i < B.size(); i++){

        }
*/
    }
    /*
    public void Debug(){
        TextView tA1 = findViewById(R.id.textView);
        int [][] arr =A.readTop().getBoard();
        String s = " ";

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                s += String.valueOf(arr[i][j]);

            }
        }

        tA1.setText(s);
    }
     */
}