package com.bawei.mylogin;

import android.content.Context;

public interface Icout {

    interface IView{
        void getData(String json);
        void getData2(String json);
    }
    interface IModel{
        void setData(Context context, String url,ICallback iCallback);
    }
    interface IPresenter{
        void onAttach(IView iView);
        void startFromData(Context context,String url);
        void startFromData2(Context context,String url);
        void onDeach();
    }
    interface ICallback{
        void getData(String json);
    }

}
