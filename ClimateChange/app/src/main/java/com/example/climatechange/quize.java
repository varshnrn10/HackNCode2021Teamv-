package com.example.climatechange;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class quize extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);

        webView =(WebView)findViewById(R.id.quizeWeb);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getPath());
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.setWebViewClient(new WebViewClient());

        //URL gir "....."
        getWebview("https://cleanet.org/clean/literacy/climate/quiz.html");

    }
    public void getWebview(String myurl)
    {





        webView.setWebViewClient(new WebViewClient()
        {


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {


                view.getSettings().setJavaScriptEnabled(true);




                super.onPageFinished(view, url);
            }


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {



                super.onPageStarted(view, url, favicon);
            }





        });
        webView.loadUrl(myurl);



    }



    @Override
    protected void onResume() {
        super.onResume();


    }

}