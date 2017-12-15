package com.example.floatingactionbutton;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isMenuVisible = false;
    ImageView menu_draft;
    ImageView menu_get;
    ImageView menu_new;
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.mFloatingActionButton);
        menu_draft = (ImageView) findViewById(R.id.menu_draft);
        menu_get = (ImageView) findViewById(R.id.menu_get);
        menu_new = (ImageView) findViewById(R.id.menu_new);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMenuVisible) {
                    closeAnimator();
                    isMenuVisible = false;
                } else {
                    startAnimator();
                    isMenuVisible = true;
                }

            }
        });
    }

    private void startAnimator() {
        ObjectAnimator objAnim_float_rotation = ObjectAnimator.ofFloat(mFloatingActionButton, "rotation", 0f, 180f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(objAnim_float_rotation)
                .with(getOpenObjectAnimator(menu_draft, "alpha"))  //和play动画同时执行
                .with(getOpenObjectAnimator(menu_draft, "scaleX"))  //和play动画同时执行
                .with(getOpenObjectAnimator(menu_draft, "scaleY"))  //和play动画同时执行
                .with(getOpenObjectAnimator(menu_get, "alpha"))  //和play动画同时执行
                .with(getOpenObjectAnimator(menu_get, "scaleX"))  //和play动画同时执行
                .with(getOpenObjectAnimator(menu_get, "scaleY"))  //和play动画同时执行
                .with(getOpenObjectAnimator(menu_new, "alpha"))  //和play动画同时执行
                .with(getOpenObjectAnimator(menu_new, "scaleX"))  //和play动画同时执行
                .with(getOpenObjectAnimator(menu_new, "scaleY"));  //和play动画同时执行
        animSet.start();
    }

    private void closeAnimator() {
        ObjectAnimator objAnim_float_rotation = ObjectAnimator.ofFloat(mFloatingActionButton, "rotation", 180f, 0f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(objAnim_float_rotation)
                .with(getCloseObjectAnimator(menu_draft, "alpha"))  //和play动画同时执行
                .with(getCloseObjectAnimator(menu_draft, "scaleX"))  //和play动画同时执行
                .with(getCloseObjectAnimator(menu_draft, "scaleY"))  //和play动画同时执行
                .with(getCloseObjectAnimator(menu_get, "alpha"))  //和play动画同时执行
                .with(getCloseObjectAnimator(menu_get, "scaleX"))  //和play动画同时执行
                .with(getCloseObjectAnimator(menu_get, "scaleY"))  //和play动画同时执行
                .with(getCloseObjectAnimator(menu_new, "alpha"))  //和play动画同时执行
                .with(getCloseObjectAnimator(menu_new, "scaleX"))  //和play动画同时执行
                .with(getCloseObjectAnimator(menu_new, "scaleY"));  //和play动画同时执行
        animSet.start();
    }

    private ObjectAnimator getOpenObjectAnimator(View view, String animatorType) {
        return ObjectAnimator.ofFloat(view, animatorType, 0f, 1f);
    }

    private ObjectAnimator getCloseObjectAnimator(View view, String animatorType) {
        return ObjectAnimator.ofFloat(view, animatorType, 1f, 0f);
    }

}
