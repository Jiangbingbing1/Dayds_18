package com.bawei.mylogin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class MyView extends ViewGroup {

    private int mleftmagin=20;
    private int mtopmagin=20;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);

        int leftmagin=mleftmagin;
        int topmagin=mtopmagin;

        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);


        switch (heightmode){
            case MeasureSpec.AT_MOST:
                int measuredHeight=0;
                     for (int i=0;i<getChildCount();i++){
                         int measuredWidth = getChildAt(i).getMeasuredWidth();
                         measuredHeight = getChildAt(i).getMeasuredHeight();
                         if (leftmagin+measuredWidth+mleftmagin>getWidth()){
                             leftmagin=mleftmagin;
                             topmagin+=mtopmagin+measuredHeight;
                         }
                         leftmagin+=mleftmagin+measuredWidth;
                     }
                topmagin+=mtopmagin+measuredHeight;
                break;
        }
             setMeasuredDimension(widthsize,topmagin);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int leftmagin=mleftmagin;
        int topmagin=mtopmagin;
        for (int i=0;i<getChildCount();i++){
            int measuredWidth = getChildAt(i).getMeasuredWidth();
           int measuredHeight = getChildAt(i).getMeasuredHeight();
            if (leftmagin+measuredWidth+mleftmagin>getWidth()){
                leftmagin=mleftmagin;
                topmagin+=mtopmagin+measuredHeight;
                getChildAt(i).layout(leftmagin,topmagin,leftmagin+measuredWidth,topmagin+measuredWidth);
            }else {
                getChildAt(i).layout(leftmagin,topmagin,leftmagin+measuredWidth,topmagin+measuredWidth);
            }
            leftmagin+=mleftmagin+measuredWidth;
        }
    }
}
