package wup.android.exercise.nytimes.ui.list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;


import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import wup.android.exercise.nytimes.R;
import wup.android.exercise.nytimes.di.AppComponentInjector;
import wup.android.exercise.nytimes.models.MostViewedArticleResponse;
import wup.android.exercise.nytimes.repository.NYTimesRepository;
import wup.android.exercise.nytimes.ui.adapters.ArticleAdapter;

import javax.inject.Inject;

public class ArticleListActivity extends RxAppCompatActivity {

    @Inject
    NYTimesRepository nyTimesRepository;

    private boolean twoPane;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        AppComponentInjector.getDefault().component().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.article_list);
        nyTimesRepository.getMostViewedArticles("all-sections", 7)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(new Action0() {
                    @Override
                    public void call() {
                        //progressView.visibility = View.GONE;
                    }
                })
                .compose(this.<MostViewedArticleResponse>bindToLifecycle())
                .subscribe(new Observer<MostViewedArticleResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(MostViewedArticleResponse mostViewedArticleResponse) {
                        setupRecyclerView(mostViewedArticleResponse);
                    }
                });

        if (findViewById(R.id.article_detail_container) != null) {
            twoPane = true;
        }
    }

    private void setupRecyclerView(MostViewedArticleResponse mostViewedArticleResponse) {
        recyclerView.setAdapter(new ArticleAdapter(this, twoPane,mostViewedArticleResponse.getResults()));
    }


}
