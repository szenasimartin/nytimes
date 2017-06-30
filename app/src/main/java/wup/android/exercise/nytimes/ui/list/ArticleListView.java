package wup.android.exercise.nytimes.ui.list;

import wup.android.exercise.nytimes.models.MostViewedArticleResponse;

/**
 * Created by mszenasi on 2017. 06. 30..
 */

public interface ArticleListView {
    void showLoading();
    void hideLoading();
    void onShowArticles(MostViewedArticleResponse response);
}
