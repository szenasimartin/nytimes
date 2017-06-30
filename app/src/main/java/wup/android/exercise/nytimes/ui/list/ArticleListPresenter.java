package wup.android.exercise.nytimes.ui.list;

import android.content.Context;

/**
 * Created by mszenasi on 2017. 06. 30..
 */

public interface ArticleListPresenter {
    void attachView(ArticleListView view);
    void deattachView();
    void getMostViewedArticles(Context context);
}
