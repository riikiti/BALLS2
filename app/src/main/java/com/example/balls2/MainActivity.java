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
import java.util.Stack;

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


    public void Intent(int steps) {

        Intent intent = new Intent(this, Result.class);
        intent.putExtra("steps", steps);
        startActivity(intent);
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
            Intent(steps);
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

        board.Move(0, 0);

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

        board.Move(0, 1);


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

        board.Move(1, 0);


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

        board.Move(1, 1);

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
        Stack<Integer> path = II();
        while (!path.empty()) {
            int btn = path.pop();
            if (btn == 0) {
                Swap1(view);
            }
            if (btn == 1) {
                Swap2(view);
            }
            if (btn == 2) {
                Swap3(view);
            }
            if (btn == 3) {
                Swap4(view);
            }

        }
        Intent(steps);
    }

    public Stack II() {

        Stack<State> O = new Stack(); // стек не пройденные
        Stack<State> C = new Stack(); // список пройденные
        State start = new State(arr);
        //Queue<Board> Road = new LinkedList<Board>(); // очередь для вывода решения
        // Road.add(board);
        //Board Temp = new Board(arr); //заносим текущий борд во временный
        //Board temp1 = new Board(arr);
        O.push(start);
        while (!O.empty()) {

            start = O.pop();

            if (WinP(start.getBoard())) {
                break;
            }

            newState(start, O, C, 0, 0);
            newState(start, O, C, 0, 1);
            newState(start, O, C, 1, 0);
            newState(start, O, C, 1, 1);

            C.push(start);
        }
        Stack stack = new Stack();
        for (; start.getParent() != null; start = start.getParent())
            stack.push(start.getButton());
        return stack;
    }


    public State Check(State temp1, State temp2) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (temp1.getBoard()[i][j] != temp2.getBoard()[i][j]) {
                    return null;
                }
            }
        }
        return temp1;

    }

    public void newState(State parent, Stack<State> O, Stack<State> C, int x, int y) {
        State child = new State(parent, x, y);
        State used = null;

        for (State temp : C) {
            if ((used = Check(temp, child)) != null) {
                break;
            }
        }
        if (used == null) {
            for (State temp : O) {
                if ((used = Check(temp, child)) != null) {
                    break;
                }
            }
        }
        if (used == null) {
            O.push(child);
        }
    }

    public boolean WinP(int[][] arr1) {
        if (arr1[0][0] == 1 && arr1[1][1] == 1 && arr1[2][2] == 1) {
            return true;
        }
        return false;
    }

}