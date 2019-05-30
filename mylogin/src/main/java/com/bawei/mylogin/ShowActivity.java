package com.bawei.mylogin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.mylogin.fragment.Fragmentfive;
import com.bawei.mylogin.fragment.Fragmentfour;
import com.bawei.mylogin.fragment.Fragmentone;
import com.bawei.mylogin.fragment.Fragmentthree;
import com.bawei.mylogin.fragment.Fragmenttwo;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private RadioGroup group;
    private List<Fragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();


    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        group = (RadioGroup) findViewById(R.id.group);

        list.add(new Fragmentone());
        list.add(new Fragmenttwo());
        list.add(new Fragmentthree());
        list.add(new Fragmentfour());
        list.add(new Fragmentfive());

        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                   switch (checkedId){
                       case R.id.btn1:
                              viewpager.setCurrentItem(0);
                           break;
                       case R.id.btn2:
                           viewpager.setCurrentItem(1);
                           break;
                       case R.id.btn3:
                           viewpager.setCurrentItem(2);
                           break;
                       case R.id.btn4:
                           viewpager.setCurrentItem(3);
                           break;
                       case R.id.btn5:
                           viewpager.setCurrentItem(4);
                           break;
                   }
            }
        });



    }
}
