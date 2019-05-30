package com.bawei.mylogin.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.bawei.mylogin.R;

public class Fragmentthree extends Fragment implements View.OnClickListener {

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private WebView webview;
    private String path="file:///C:/Users/win10/Desktop/%E7%94%B5%E5%95%86%E9%A1%B9%E7%9B%AE%E5%AE%9E%E6%88%98%E6%9C%88%E8%80%83%E6%A8%A1%E6%8B%9F%E9%A2%98/%E7%94%B5%E5%95%86%E9%A1%B9%E7%9B%AE%E5%AE%9E%E6%88%98%E6%9C%88%E8%80%83%E6%A8%A1%E6%8B%9F%E9%A2%98/html/about.html";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.three, container, false);


        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        bt1 = (Button) inflate.findViewById(R.id.bt1);
        bt2 = (Button) inflate.findViewById(R.id.bt2);
        bt3 = (Button) inflate.findViewById(R.id.bt3);
        bt4 = (Button) inflate.findViewById(R.id.bt4);
        webview = (WebView) inflate.findViewById(R.id.webview);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

        webview.loadUrl(path);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(path);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:

                break;
            case R.id.bt2:

                break;
            case R.id.bt3:

                break;
            case R.id.bt4:

                break;
        }
    }
}
