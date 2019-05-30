package com.bawei.mylogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText zh;
    private EditText mm;
    private Button dl;
    private Button zc;
    private Button dsdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        zh = (EditText) findViewById(R.id.zh);
        mm = (EditText) findViewById(R.id.mm);
        dl = (Button) findViewById(R.id.dl);
        zc = (Button) findViewById(R.id.zc);
        dsdl = (Button) findViewById(R.id.dsdl);

        dl.setOnClickListener(this);
        zc.setOnClickListener(this);
        dsdl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dl:
                Intent intent=new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
                break;
            case R.id.zc:

                break;
            case R.id.dsdl:

                break;
        }
    }

    private void submit() {
        // validate
        String zhString = zh.getText().toString().trim();
        if (TextUtils.isEmpty(zhString)) {
            Toast.makeText(this, "账号：", Toast.LENGTH_SHORT).show();
            return;
        }

        String mmString = mm.getText().toString().trim();
        if (TextUtils.isEmpty(mmString)) {
            Toast.makeText(this, "密码：", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
