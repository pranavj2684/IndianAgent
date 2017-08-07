package in.itechvalley.indianagent;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import in.itechvalley.indianagent.Constants.Constants;

public class WebviewActivity extends AppCompatActivity
{
    WebView webView;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_webview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//        {
//            getWindow().setEnterTransition(new Slide());
//            getWindow().setExitTransition(new Slide());
//        }

        webView = findViewById(R.id.webView);

        final ProgressBar progressBar = findViewById(R.id.contentLoadingProgressBar);
        progressBar.setScaleY(3f);
        progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#ff0099cc"), PorterDuff.Mode.SRC_IN);

        final String url = getIntent().getStringExtra(Constants.KEY_URL);
        getSupportActionBar().setTitle(getIntent().getStringExtra(Constants.KEY_HEADING));

        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUserAgentString("Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1");
        webSettings.setBuiltInZoomControls(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDisplayZoomControls(false);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                webView.loadUrl(url);
            }
        }, 1000);

        webView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress)
            {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
            }
        });

        //noinspection deprecation
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url)
            {
                progressBar.setProgress(100);
                progressBar.setVisibility(View.GONE);

                if (view.getTitle() != null)
                {
                    assert getSupportActionBar() != null;
                    getSupportActionBar().setTitle(view.getTitle());
                }
            }


            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error)
            {
                handler.proceed();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, final String failingUrl)
            {
                view.loadUrl("https://www.google.co.in");
                Toast.makeText(WebviewActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
            {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
