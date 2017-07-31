package in.itechvalley.indianagent;

import android.app.ActivityOptions;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeClipBounds;
import android.transition.Explode;
import android.transition.Slide;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import in.itechvalley.indianagent.Adapter.RailwayAdapter;
import in.itechvalley.indianagent.Fragments.RailwayFragment;

public class WebviewActivity extends AppCompatActivity
{
    WebView webView;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_webview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setEnterTransition(new Slide());
            getWindow().setExitTransition(new Slide());
        }

        webView = findViewById(R.id.webView);

        final ProgressBar progressBar = findViewById(R.id.contentLoadingProgressBar);
        progressBar.setScaleY(3f);
        progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#ff0099cc"), PorterDuff.Mode.SRC_IN);

        final String url = getIntent().getStringExtra(RailwayAdapter.KEY_URL);
        getSupportActionBar().setTitle(getIntent().getStringExtra(RailwayAdapter.KEY_HEADING));

        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
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
            public void onProgressChanged(WebView view, int newProgress) {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
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
}
