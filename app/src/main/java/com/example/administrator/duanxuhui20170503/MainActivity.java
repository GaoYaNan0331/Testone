package com.example.administrator.duanxuhui20170503;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.duanxuhui.fra.Fragments;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button but1,but2;
    private final String S="sheng";
    private final String J="jiang";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        but1= (Button) findViewById(R.id.but1);
        but2= (Button) findViewById(R.id.but2);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but1:
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frame,new Fragments(S));
                transaction.commit();
                break;
            case R.id.but2:
                FragmentManager manager2 = getSupportFragmentManager();
                FragmentTransaction transaction2 = manager2.beginTransaction();
                transaction2.replace(R.id.frame,new Fragments(J));
                transaction2.commit();
                break;
        }
    }
}
