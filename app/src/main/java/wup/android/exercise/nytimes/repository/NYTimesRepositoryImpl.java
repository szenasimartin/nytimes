package wup.android.exercise.nytimes.repository;

import rx.Observable;
import wup.android.exercise.nytimes.models.Article;
import wup.android.exercise.nytimes.models.MostViewedArticleResponse;

/**
 * Created by mszenasi on 2017. 06. 29..
 */

public interface NYTimesRepositoryImpl {
    Observable<MostViewedArticleResponse> getMostViewedArticles(String section, int period);
}
