package com.example.toolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartToolBar01(View view) {
        startActivity(new Intent(this,ToolBarActivity_01.class));
    }

    public void onStartToolBar02(View view) {
        startActivity(new Intent(this,ToolBarActivity_02.class));
    }
}
