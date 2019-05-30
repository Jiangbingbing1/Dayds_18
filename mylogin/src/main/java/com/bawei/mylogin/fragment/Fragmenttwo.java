package com.bawei.mylogin.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bawei.mylogin.R;
import com.bawei.mylogin.view.MyView;

public class Fragmenttwo extends Fragment implements View.OnClickListener {

    private EditText editname;
    private Button ss;
    private TextView textView;
    private MyView myview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.two, container, false);

        initView(inflate);
        return inflate;
    }


    private void initView(View inflate) {
        editname = (EditText) inflate.findViewById(R.id.editname);
        ss = (Button) inflate.findViewById(R.id.ss);

        ss.setOnClickListener(this);
        myview = (MyView) inflate.findViewById(R.id.myview);
        myview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ss:
                String s = editname.getText().toString();
                textView=new TextView(getContext());
                textView.setText(s);
                textView.setTextSize(21);
                textView.setPadding(15, 5, 15, 5);
                textView.setTextColor(Color.BLACK);
                myview.addView(textView);
                break;
        }
    }
}
