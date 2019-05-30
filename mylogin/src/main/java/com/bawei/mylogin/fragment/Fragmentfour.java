package com.bawei.mylogin.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.mylogin.R;
import com.bawei.mylogin.view.Myviews;

public class Fragmentfour extends Fragment {

    private Myviews myviewsss;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.four, container, false);


        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        myviewsss = (Myviews) inflate.findViewById(R.id.myviewsss);
         myviewsss.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(myviewsss,"translationY",0f,10f);
                 ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(myviewsss,"ScaleX",0f,30f);
                 ObjectAnimator objectAnimator3=ObjectAnimator.ofFloat(myviewsss,"scaleY",0f,-50f);

                 AnimatorSet animatorSet=new AnimatorSet();
                 animatorSet.play(objectAnimator).with(objectAnimator2).with(objectAnimator3);
                 animatorSet.setDuration(3000);
                 animatorSet.start();
             }
         });



    }
}
