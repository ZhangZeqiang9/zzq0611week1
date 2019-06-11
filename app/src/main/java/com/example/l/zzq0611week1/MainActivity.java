package com.example.l.zzq0611week1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.l.zzq0611week1.adpter.PAdpter;
import com.example.l.zzq0611week1.bean.ManBean;
import com.example.l.zzq0611week1.presenter.PresenterImpl;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;
/*
* 展示
*/
public class MainActivity extends AppCompatActivity implements Contract.IView {

    private PullToRefreshListView m_ptrlv;
    public static Context mcontext;
    private int page = 1;
    private PresenterImpl presenter;
    private List<ManBean.Data> lists = new ArrayList<>();
    private PAdpter pAdpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mcontext=MainActivity.this;
        presenter = new PresenterImpl(this);
        presenter.getdata(page);
        pullto();
    }

    private void initView() {
        m_ptrlv = (PullToRefreshListView) findViewById(R.id.m_ptrlv);
    }
    public void pullto(){
        m_ptrlv.setMode(PullToRefreshBase.Mode.BOTH);

        m_ptrlv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                page++;
                presenter.getdata(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                page=1;
                presenter.getdata(page);
            }
        });

    }
    @Override
    public void getResult(String data) {
        Log.e("Tag",data);
        Gson gson = new Gson();
        ManBean manBean = gson.fromJson(data, ManBean.class);
        List<ManBean.Data> data1 = manBean.getData();
        if(page==1){
            lists.clear();
        }
        lists.addAll(data1);
        pAdpter = new PAdpter(lists, this);
        m_ptrlv.setAdapter(pAdpter);
        pAdpter.notifyDataSetChanged();
        m_ptrlv.onRefreshComplete();
    }
}
