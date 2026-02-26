package com.example.webviewexample;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //2
        WebView webView = findViewById(R.id.web);
     //3 connect first website open in app
        webView.loadUrl("https://www.google.com/");

     // to load ever website in app
     webView.setWebViewClient(new WebViewClient());

     // 4  to load java script website (morden website to load in app)
        //.enable setting
        WebSettings webSettings = webView.getSettings();
        // enable javascript
        webSettings.setJavaScriptEnabled(true);


        //5 on back press handle previous website  to  open
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                if(webView.canGoBack()){
                    webView.goBack();
                }else {
                    finish();
                }

            }
        });












    }
}