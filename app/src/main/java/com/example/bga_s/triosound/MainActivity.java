package com.example.bga_s.triosound;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bga_s.triosound.model.Trio;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> array = new ArrayList<>();
    private HashMap<Integer, Trio> map = new HashMap<>();
    private TextView mTextMessage;
    private Button b1;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private TextView t5;
    private TextView t6;
    private TextView t7;
    private TextView t8;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        b1 = findViewById(R.id.b1);

        map.put(1, new Trio("do", "mi", "sol"));
        t5.setText((CharSequence) App.getAppInstance().trioDB.TrioDAO().getTrioById(5));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.t1:
                t1.setBackgroundColor(Color.GREEN);
                array.add(String.valueOf(t1.getText()));
//                for (String s : array) {
//                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.t2:
                t2.setBackgroundColor(Color.GREEN);
                array.add(String.valueOf(t2.getText()));
//                for (String s : array) {
//                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.t3:
                t3.setBackgroundColor(Color.GREEN);
                array.add(String.valueOf(t3.getText()));
//                for (String s : array) {
//                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.b1:
//                b1.setBackgroundColor(Color.GREEN);
//                array.add(String.valueOf(t1.getText()));
//                for (String s : array) {
//                    t2.setText(s);
//                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//                }

                check(map, array);

                break;
            case R.id.navigation_dashboard:
                check(map, array);
                break;
            default:
                break;
        }
    }

    protected void check(HashMap<Integer, Trio> map, ArrayList<String> array){
        ArrayList<String> trioValue = new ArrayList<>();
        for (Map.Entry entry :
                map.entrySet()) {
            Trio trio = (Trio) entry.getValue();
            trioValue.add(trio.getTonika());
            trioValue.add(trio.getTerciya());
            trioValue.add(trio.getKvinta());
        }

        if(array.equals(trioValue)){
            mTextMessage.setText("Правильно");
            mTextMessage.setBackgroundColor(Color.GREEN);
        }else {
            mTextMessage.setText("не правильно");
            mTextMessage.setBackgroundColor(Color.RED);
        }

//        ArrayList<Trio> trioList = new ArrayList<>(map.values());
//        if(array.equals(trioList)){
//            mTextMessage.setText("Right");
//        }

    }
}
