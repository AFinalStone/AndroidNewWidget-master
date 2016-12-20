package com.androidstudio.shi.androidnewwidget.Toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidstudio.shi.androidnewwidget.R;

public class ToolBarActivity_02 extends AppCompatActivity implements View.OnClickListener {


    private ImageView ic_menu_back;
    private ImageView ic_menu_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_02);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ic_menu_back = (ImageView) findViewById(R.id.ic_menu_back);
        ic_menu_setting = (ImageView) findViewById(R.id.ic_menu_setting);
        ic_menu_back.setOnClickListener(this);
        ic_menu_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ic_menu_back:
                Toast.makeText(ToolBarActivity_02.this,"返回按钮被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ic_menu_setting:
                Toast.makeText(ToolBarActivity_02.this,"设置按钮被点击",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
