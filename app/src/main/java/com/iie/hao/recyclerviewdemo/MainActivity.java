package com.iie.hao.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.Toast;

import com.iie.hao.recyclerviewdemo.adapter.StaggeredHomeAdapter;
import com.iie.hao.recyclerviewdemo.utils.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    //private HomeAdapter mAdapter;
    private StaggeredHomeAdapter mStaggeredHomeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_main);

        initData();

        mRecyclerView = findViewById(R.id.id_recyclerview);
        mStaggeredHomeAdapter = new StaggeredHomeAdapter(this,mDatas);

        //设置布局的样式有3种， 线性  网格  瀑布流 Linearlayout  grid StaggeredGridLayout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
       // mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));

        //mRecyclerView.addItemDecoration(new com.iie.hao.recyclerviewdemo.utils.DividerItemDecoration(this,
        //        com.iie.hao.recyclerviewdemo.utils.DividerItemDecoration.VERTICAL_LIST));

        //网格布局的分割线
        //mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        //瀑布流 瀑布流布局需要注意每一个条目的宽度。
        //第二个参数表示布局的方向
        mRecyclerView.setLayoutManager( new
                StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL)
        );
        mRecyclerView.setAdapter(mStaggeredHomeAdapter);

        //添加Item动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //mRecyclerView.setAdapter(mAdapter = new HomeAdapter());

        initEvent();//初始化点击事件



    }

    //初始化事件
    private void initEvent(){

        mStaggeredHomeAdapter.setOnItemClickListener(new StaggeredHomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,
                        position + " click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this,
                        position + " long click", Toast.LENGTH_SHORT).show();
            }
        });
    }



    //生成显示用的字母
    protected void initData(){
        mDatas = new ArrayList<String>();
        for (int i = 'A' ; i < 'z' ; i++){
            mDatas.add("" + (char)i);
        }
        System.out.println(mDatas);
    }


    //添加点击事件和删除事件




    //内部类
    /*class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{



        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MainActivity.this).inflate(R.layout.layout_item,parent,
                    false));

            //加载设置条目的布局

            return holder;
        }


        //holder空指针异常
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));

        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends ViewHolder{

            TextView tv;
            public MyViewHolder(View view){
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }

        }


    }*/

}








