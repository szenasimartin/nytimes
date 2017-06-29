package wup.android.exercise.nytimes.ui.detail;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import wup.android.exercise.nytimes.R;

public class ArticleDetailFragment extends Fragment {
    public static final String ARG_ITEM_URL = "item_url";
    public static final String ARG_ITEM_TITLE = "item_title";
    private String url;
    private String title;

    public ArticleDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_URL) && getArguments().containsKey(ARG_ITEM_TITLE)) {
            url = getArguments().getString(ARG_ITEM_URL);
            title = getArguments().getString(ARG_ITEM_TITLE);
            Activity activity = this.getActivity();
            AppCompatTextView appBarLayout = (AppCompatTextView) activity.findViewById(R.id.tv_title);
            if (appBarLayout != null) {
                appBarLayout.setText(title);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_detail, container, false);


        if (url != null) {
            WebView webView = (WebView) rootView.findViewById(R.id.article_detail);
            webView.loadUrl(url);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setSaveFormData(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.setWebViewClient(new MyWebViewClient());
        }

        return rootView;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}
