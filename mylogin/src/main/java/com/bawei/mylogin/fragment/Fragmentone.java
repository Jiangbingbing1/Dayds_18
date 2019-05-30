package com.bawei.mylogin.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.mylogin.Icout;
import com.bawei.mylogin.R;
import com.bawei.mylogin.adapter.MyAdapter;
import com.bawei.mylogin.adapter.MyAdapter2;
import com.bawei.mylogin.bean.UserBean;
import com.bawei.mylogin.bean.UserBean2;
import com.bawei.mylogin.mvp.RegisPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Fragmentone extends Fragment implements Icout.IView {

    private RecyclerView recycle;
    private RecyclerView recycleview;
    private Icout.IPresenter iPresenter;
    private List<UserBean2.ResultBean> list=new ArrayList<>();
    private String paht="http://172.17.8.100/small/commodity/v1/findFirstCategory?firstCategoryId=1001002";
    private String path="http://172.17.8.100/small/commodity/v1/findCommodityByCategory?categoryId=1001004002&page=1&count=5";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.one, container, false);

        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        recycle = (RecyclerView) inflate.findViewById(R.id.recycle);
        recycleview = (RecyclerView) inflate.findViewById(R.id.recycleview);
        iPresenter=new RegisPresenter(this);
        iPresenter.startFromData(getContext(),paht);

    }

    @Override
    public void getData(final String json) {
        Gson gson=new Gson();
        Log.i("sss",json);
        UserBean userBean = gson.fromJson(json, UserBean.class);
        final List<UserBean.ResultBean> result = userBean.getResult();
        Log.i("sss",result.size()+"");
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recycle.setLayoutManager(linearLayoutManager);

        MyAdapter adapter=new MyAdapter(result,getContext());
        recycle.setAdapter(adapter);

        adapter.OnsetItem(new MyAdapter.setOnClick() {
            @Override
            public void OnClickitem(View view, int position) {
                getData2(json);
                     iPresenter.startFromData2(getContext(),path);

            }
        });

    }

    @Override
    public void getData2(String json) {
        Gson gson=new Gson();
        Log.i("sss",json);
        UserBean2 userBean2 = gson.fromJson(json, UserBean2.class);
        list = userBean2.getResult();

        GridLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),3);
        recycleview.setLayoutManager(linearLayoutManager);

        MyAdapter2 adapter=new MyAdapter2(list,getContext());
        recycleview.setAdapter(adapter);
    }
}
