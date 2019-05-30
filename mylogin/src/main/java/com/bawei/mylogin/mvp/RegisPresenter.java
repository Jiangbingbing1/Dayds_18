package com.bawei.mylogin.mvp;

import android.content.Context;

import com.bawei.mylogin.Icout;

public class RegisPresenter implements Icout.IPresenter {

    private Icout.IModel iModel;
    private Icout.IView iView;

    public RegisPresenter(Icout.IView iView){
         iModel=new RegisModel();
         this.iView=iView;
    }
    @Override
    public void onAttach(Icout.IView iView) {
        this.iView=iView;
    }

    @Override
    public void startFromData(Context context, String url) {
           iModel.setData(context, url, new Icout.ICallback() {
               @Override
               public void getData(String json) {
                    iView.getData(json);
               }
           });
    }

    @Override
    public void startFromData2(Context context, String url) {
        iModel.setData(context, url, new Icout.ICallback() {
            @Override
            public void getData(String json) {
                iView.getData2(json);
            }
        });
    }

    @Override
    public void onDeach() {
             if (iModel!=null){
                  iModel=null;
             }
             if (iView!=null){
                 iView=null;
             }
    }
}
