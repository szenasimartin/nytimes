package wup.android.exercise.nytimes.ui.list;

import android.content.Context;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import wup.android.exercise.nytimes.models.MostViewedArticleResponse;
import wup.android.exercise.nytimes.repository.NYTimesRepository;

/**
 * Created by mszenasi on 2017. 06. 30..
 */

public class ArticleListPresenterImpl implements ArticleListPresenter {
    ArticleListView view;
    NYTimesRepository nyTimesRepository;

    public ArticleListPresenterImpl(NYTimesRepository nyTimesRepository) {
        this.nyTimesRepository = nyTimesRepository;
    }

    @Override
    public void attachView(ArticleListView view) {
        this.view = view;
    }

    @Override
    public void deattachView() {
        this.view = null;
    }

    @Override
    public void getMostViewedArticles(Context context) {
        view.showLoading();
        nyTimesRepository.getMostViewedArticles("all-sections", 7)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(new Action0() {
                    @Override
                    public void call() {
                        view.hideLoading();
                    }
                })
                .compose(((RxAppCompatActivity)context).<MostViewedArticleResponse>bindToLifecycle())
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
                        view.onShowArticles(mostViewedArticleResponse);
                    }
                });
    }
}
