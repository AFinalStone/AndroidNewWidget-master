package com.androidstudio.shi.androidnewwidget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidstudio.shi.androidnewwidget.AppBarLayout.AppBarLayoutActivity;
import com.androidstudio.shi.androidnewwidget.CoordinatorLayout.CoordinatorLayoutActivity;
import com.androidstudio.shi.androidnewwidget.DrawerLayout.DrawerLayoutActivity;
import com.androidstudio.shi.androidnewwidget.StateBar.SystemStateBarColorActivity;
import com.androidstudio.shi.androidnewwidget.Toolbar.ToolBarActivity_01;
import com.androidstudio.shi.androidnewwidget.Toolbar.ToolBarActivity_02;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;

    MyAdapter myAdapter;
    private List<String> listData = new ArrayList<String>();
    private final String Name_CoordinatorLayoutActivity = "CoordinatorLayoutActivity";
    private final String Name_ToolBarActivity_01 = "ToolBarActivity_01";
    private final String Name_ToolBarActivity_02 = "ToolBarActivity_02";
    private final String Name_AppBarLayoutActivity = "AppBarLayoutActivity";
    private final String Name_DrawerLayoutActivity = "DrawerLayoutActivity";
    private final String Name_SystemStateBarActivity = "SystemStateBarActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        listData.add(Name_CoordinatorLayoutActivity);
        listData.add(Name_ToolBarActivity_01);
        listData.add(Name_ToolBarActivity_02);
        listData.add(Name_AppBarLayoutActivity);
        listData.add(Name_DrawerLayoutActivity);
        listData.add(Name_SystemStateBarActivity);
        // 设置布局管理器

        // 线性布局管理器
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        // 九宫格布局管理器
//        GridLayoutManager glm = new GridLayoutManager(this, 3);
//        glm.setOrientation(LinearLayoutManager.VERTICAL);
//        rv.setLayoutManager(glm);

        //瀑布流
//        StaggeredGridLayoutManager sgl = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        rv.setLayoutManager(llm);

        // 设置数据适配器
        myAdapter = new MyAdapter();
        myAdapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                if(Name_CoordinatorLayoutActivity.equals(listData.get(position))){
                    Intent intent = new Intent(MainActivity.this, CoordinatorLayoutActivity.class);
                    startActivity(intent);
                    return;
                }
                if(Name_ToolBarActivity_01.equals(listData.get(position))){
                    Intent intent = new Intent(MainActivity.this, ToolBarActivity_01.class);
                    startActivity(intent);
                    return;
                }
                if(Name_ToolBarActivity_02.equals(listData.get(position))){
                    Intent intent = new Intent(MainActivity.this, ToolBarActivity_02.class);
                    startActivity(intent);
                    return;
                }
                if(Name_AppBarLayoutActivity.equals(listData.get(position))){
                    Intent intent = new Intent(MainActivity.this, AppBarLayoutActivity.class);
                    startActivity(intent);
                    return;
                }
                if(Name_DrawerLayoutActivity.equals(listData.get(position))){
                    Intent intent = new Intent(MainActivity.this, DrawerLayoutActivity.class);
                    startActivity(intent);
                    return;
                }
                if(Name_SystemStateBarActivity.equals(listData.get(position))){
                    Intent intent = new Intent(MainActivity.this, SystemStateBarColorActivity.class);
                    startActivity(intent);
                    return;
                }
            }
        });
        rv.setAdapter(myAdapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        protected OnItemClickLitener mOnItemClickLitener;

        public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
            this.mOnItemClickLitener = mOnItemClickLitener;
        }

        @Override
        public int getItemCount() {
            return listData.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, null);
            return new MyViewHolder(view);
        }


        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            // 如果设置了回调，则设置点击事件
            if (mOnItemClickLitener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickLitener.onItemClick(holder.itemView, position);
                    }
                });

            }
            holder.tv.setText(listData.get(position));
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{

            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }
}
