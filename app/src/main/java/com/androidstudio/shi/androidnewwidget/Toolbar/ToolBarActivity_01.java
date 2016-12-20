package com.androidstudio.shi.androidnewwidget.Toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.androidstudio.shi.androidnewwidget.R;

public class ToolBarActivity_01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_01);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)  {
                switch (item.getItemId()){
                    case R.id.action_edit:
                        Toast.makeText(ToolBarActivity_01.this,"编辑被点击",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(ToolBarActivity_01.this,"分享被点击",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings01:
                        Toast.makeText(ToolBarActivity_01.this,"设置01被点击",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings02:
                        Toast.makeText(ToolBarActivity_01.this,"设置02被点击",Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolBarActivity_01.this,"返回按钮被点击",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 为toolbar创建Menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}


