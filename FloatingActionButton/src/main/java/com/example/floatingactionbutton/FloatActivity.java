package com.example.floatingactionbutton;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class FloatActivity extends AppCompatActivity implements OnFabClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);

        SuspensionFab fabBottom = (SuspensionFab) findViewById(R.id.fab_bottom);
        SuspensionFab fabRight = (SuspensionFab) findViewById(R.id.fab_right);
        SuspensionFab fabTop = (SuspensionFab) findViewById(R.id.fab_top);
        SuspensionFab fabLeft = (SuspensionFab) findViewById(R.id.fab_left);

        FabAttributes collection = new FabAttributes.Builder()
                .setBackgroundTint(Color.parseColor("#2096F3"))
                .setSrc(getResources().getDrawable(R.drawable.like))
                .setFabSize(FloatingActionButton.SIZE_MINI)
                .setPressedTranslationZ(10)
                .setTag(1)
                .build();

        FabAttributes email = new FabAttributes.Builder()
                .setBackgroundTint(Color.parseColor("#FF9800"))
                .setSrc(getResources().getDrawable(R.drawable.mail))
                .setFabSize(FloatingActionButton.SIZE_MINI)
                .setPressedTranslationZ(10)
                .setTag(2)
                .build();

        FabAttributes news = new FabAttributes.Builder()
                .setBackgroundTint(Color.parseColor("#03A9F4"))
                .setSrc(getResources().getDrawable(R.drawable.news))
                .setFabSize(FloatingActionButton.SIZE_MINI)
                .setPressedTranslationZ(10)
                .setTag(3)
                .build();

        fabBottom.addFab(collection, email, news);
        fabRight.addFab(collection, email, news);
//        fabTop.addFab(collection, email, news);
        fabLeft.addFab(collection, email, news);
        fabTop.setAnimationManager(new FabAlphaAnimate(fabTop));

        fabBottom.setFabClickListener(this);
        fabRight.setFabClickListener(this);
        fabTop.setFabClickListener(this);
        fabLeft.setFabClickListener(this);
    }

    @Override
    public void onFabClick(FloatingActionButton fab, Object tag) {
        String msg="";
        if (tag.equals(1)) {
            msg="收藏";
        }else if (tag.equals(2)){
            msg="邮件";
        } else if (tag.equals(3)){
            msg="消息";
        }
        Toast.makeText(this, "点击了" + msg ,Toast.LENGTH_SHORT).show();
    }
}
