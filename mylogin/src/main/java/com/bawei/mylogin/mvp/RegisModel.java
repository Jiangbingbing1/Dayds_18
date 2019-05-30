package com.bawei.mylogin.mvp;

import android.content.Context;

import com.bawei.mylogin.Icout;
import com.bawei.mylogin.util.MyVolley;

import java.util.Map;

public class RegisModel implements Icout.IModel {
    private String phone;
    private String pwd;
    @Override
    public void setData(Context context, String url, Icout.ICallback iCallback) {
        MyVolley.getInstance().getVolley(context,url,iCallback);
       // MyVolley.getInstance().setVolley(context,url,iCallback);
    }
}
