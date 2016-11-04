package com.androidstudio.shi.androidnewwidget.DrawerLayout;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidstudio.shi.androidnewwidget.R;

public class DrawerLayoutActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);


        mDrawerToggle.syncState();

        View headerView = mNavigationView.inflateHeaderView(R.layout.layout_navigation_header);
        ImageView iv_GaussianBlurBackground = (ImageView) headerView.findViewById(R.id.iv_GaussianBlurBackground);
        View view_GaussianBlur =  headerView.findViewById(R.id.view_GaussianBlur);
        GaussianBlurUtil.applyBlur(iv_GaussianBlurBackground,view_GaussianBlur);

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
            return;
        }
        super.onBackPressed();
    }
}
