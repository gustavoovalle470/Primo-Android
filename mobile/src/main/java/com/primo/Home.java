package com.primo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private TextView mTextMessage;
    private WebView primo_web_view;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    primo_web_view.loadUrl("http://192.168.0.8:7001/manhattan/");
                    return true;
                case R.id.navigation_dashboard:
                    primo_web_view.loadUrl("http://www.google.com");
                    return true;
                case R.id.navigation_notifications:
                    primo_web_view.loadUrl("http://www.facebook.com");
                    return true;
                default:
                    return true;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        primo_web_view = findViewById(R.id.home_visor);
        //habilitamos javascript y el zoom
        primo_web_view.getSettings().setJavaScriptEnabled(true);
        primo_web_view.getSettings().setBuiltInZoomControls(true);
        primo_web_view.loadUrl("http://192.168.0.8:7001/manhattan/");
        mTextMessage = (TextView) findViewById(R.id.message);
        primo_web_view.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                return false;
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(0);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
