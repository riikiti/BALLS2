package com.example.balls2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    int[][] arr = {{0, 1, 0},
            {0, 1, 0},
            {0, 1, 0},};
    int[][] arr1 = {{0, 0, 0},
            {0, 0, 0},
            {1, 1, 1},};
    int[][] arr2 = {{0, 0, 1},
            {1, 0, 0},
            {0, 1, 0},};
    int[][] arr3 = {{0, 0, 0},
            {0, 0, 1},
            {1, 1, 0},};
    int steps = 0;
    Board board = new Board(arr);
    boolean Rand = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleDraw();


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

        if (WinP(board.getBoard())) {
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


    public void CircleDraw() {
        ImageView img;
        int[][] arr = board.getBoard();
        if (arr[0][0] == 1) {
            img = (ImageView) findViewById(R.id.imageView1);
            img.setImageResource(R.drawable.circle);
        } else {
            img = (ImageView) findViewById(R.id.imageView1);
            img.setImageResource(R.drawable.empty);
        }

        if (arr[0][1] == 1) {
            img = (ImageView) findViewById(R.id.imageView2);
            img.setImageResource(R.drawable.circle);
        } else {
            img = (ImageView) findViewById(R.id.imageView2);
            img.setImageResource(R.drawable.empty);
        }
        if (arr[0][2] == 1) {
            img = (ImageView) findViewById(R.id.imageView3);
            img.setImageResource(R.drawable.circle);
        } else {
            img = (ImageView) findViewById(R.id.imageView3);
            img.setImageResource(R.drawable.empty);
        }
        if (arr[1][0] == 1) {
            img = (ImageView) findViewById(R.id.imageView4);
            img.setImageResource(R.drawable.circle);
        } else {
            img = (ImageView) findViewById(R.id.imageView4);
            img.setImageResource(R.drawable.empty);
        }
        if (arr[1][1] == 1) {
            img = (ImageView) findViewById(R.id.imageView5);
            img.setImageResource(R.drawable.circle);
        } else {
            img = (ImageView) findViewById(R.id.imageView5);
            img.setImageResource(R.drawable.empty);
        }
        if (arr[1][2] == 1) {
            img = (ImageView) findViewById(R.id.imageView6);
            img.setImageResource(R.drawable.circle);
        } else {
            img = (ImageView) findViewById(R.id.imageView6);
            img.setImageResource(R.drawable.empty);
        }
        if (arr[2][0] == 1) {
            img = (ImageView) findViewById(R.id.imageView7);
            img.setImageResource(R.drawable.circle);
        } else {
            img = (ImageView) findViewById(R.id.imageView7);
            img.setImageResource(R.drawable.empty);
        }
        if (arr[2][1] == 1) {
            img = (ImageView) findViewById(R.id.imageView8);
            img.setImageResource(R.drawable.circle);
        } else {
            img = (ImageView) findViewById(R.id.imageView8);
            img.setImageResource(R.drawable.empty);
        }
        if (arr[2][2] == 1) {
            img = (ImageView) findViewById(R.id.imageView9);
            img.setImageResource(R.drawable.circle);
        } else {
            img = (ImageView) findViewById(R.id.imageView9);
            img.setImageResource(R.drawable.empty);
        }

    }

    public void Board1(View view) {
        CheckBox ch = (CheckBox) findViewById(R.id.checkBox);
        if (ch.isChecked()) {
            Rand = true;
        }

        board = new Board(arr);
        CircleDraw();
        Cheats(view);
    }

    public void Board2(View view) {
        CheckBox ch = (CheckBox) findViewById(R.id.checkBox);
        if (ch.isChecked()) {
            Rand = true;
        }
        board = new Board(arr1);
        CircleDraw();
        Cheats(view);
    }

    public void Board3(View view) {
        CheckBox ch = (CheckBox) findViewById(R.id.checkBox);
        if (ch.isChecked()) {
            Rand = true;
        }
        board = new Board(arr2);
        CircleDraw();
        Cheats(view);
    }

    public void Board4(View view) {
        CheckBox ch = (CheckBox) findViewById(R.id.checkBox);
        if (ch.isChecked()) {
            Rand = true;
        }
        board = new Board(arr3);
        CircleDraw();
        heuristic();
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
        int count = path.size();
        new CountDownTimer(count * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                if (!path.empty()) {
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

            }

            public void onFinish() {
                // Intent(steps);
            }

        }.start();


    }

    public Stack II() {

        Stack<State> O = new Stack(); // стек не пройденные
        Stack<State> C = new Stack(); // список пройденные
        State start = new State(board.getBoard());
        //Queue<Board> Road = new LinkedList<Board>(); // очередь для вывода решения
        // Road.add(board);
        //Board Temp = new Board(arr); //заносим текущий борд во временный
        //Board temp1 = new Board(arr);


        // TODO: 23.10.2022 Для каждой точки рассчитывается F = G + H. G — расстояние от старта до точки, H — примерное расстояние от точки до цели.
        //  Ограничить количество выделяемой памяти(удалять далекие?) тоесть если больше какого то значения F то просто не добавлять в стек
        //  эврестическая оценка - растояние от точки начальной до точки назначения

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

    public ArrayList heuristic() {
        ArrayList<State> O = new ArrayList<State>();// лист не пройденные
        ArrayList<State> C = new ArrayList<State>();// лист пройденные
        State start = new State(board.getBoard());
        State[] mas = {};
        int steps = 0;
        while (!O.isEmpty() || C.size() < 10) {
            O.add(start);

            if (WinP(start.getBoard())) {
                break;
            }

            mas[0] = newStateHeuristic(start, O, C, 0, 0, steps);
            mas[1] = newStateHeuristic(start, O, C, 0, 1, steps);
            mas[2] = newStateHeuristic(start, O, C, 1, 0, steps);
            mas[3] = newStateHeuristic(start, O, C, 1, 1, steps);

            Arrays.sort(mas);


            C.add(start);
            steps++;
        }


        return C;
    }

    public int heuristicValue(State state, int G) {
        int F = 0;
        int H = 0;
        int[][] board = state.getBoard();
        // находим ближайшие точки текущего состояния и проверяем насколько кажадя из них далека от ближней точки победного состояния
        int[][] arr1 = state.getBoard();
        if (arr1[1][0] == 1 && arr1[1][1] == 1 && arr1[1][2] == 1) {
            H = 0;
        } else {

        }

        return F = G + H;
    }


    public State newStateHeuristic(State parent, ArrayList<State> O, ArrayList<State> C, int x, int y, int steps) {
        State child = new State(parent, x, y);
        int F = heuristicValue(child, steps);
        child.setF(F);
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
            O.add(child);
        }
        return child;
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
        int a = (int) (Math.random() * 3);

        if (Rand == true) {
            switch (a) {
                case 0:
                    if (arr1[1][0] == 1 && arr1[0][0] == 1 && arr1[1][2] == 1) {
                        return true;
                    }
                case 1:
                    if (arr1[1][1] == 1 && arr1[2][1] == 1 && arr1[1][2] == 1) {
                        return true;
                    }
                case 2:
                    if (arr1[1][2] == 1 && arr1[1][1] == 1 && arr1[2][2] == 1) {
                        return true;
                    }

            }

        } else if (arr1[1][0] == 1 && arr1[1][1] == 1 && arr1[1][2] == 1) {
            return true;
        }
        return false;
    }

}