package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView wvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wvMain = findViewById(R.id.wv);

        //Local URL
        //wvMain.loadUrl("file:///android_asset/test.html");

        //Network URL
        wvMain.getSettings().setJavaScriptEnabled(true); //Enable Js
        wvMain.setWebViewClient(new MyWebViewClient()); // to prevent open with browser
        wvMain.setWebChromeClient(new MyWebChromeClient());
        wvMain.loadUrl("https://m.baidu.com/");
    }

    //Load the URL without using browser
    public class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView", "onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView", "onPageFinished...");

            //Show alert with javascript
            //wvMain.loadUrl("javascript:alert('onPageFinished')");
            wvMain.evaluateJavascript("javascript:alert('onPageFinished')", null);
        }

    }

    public class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK && wvMain.canGoBack()){
            wvMain.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
