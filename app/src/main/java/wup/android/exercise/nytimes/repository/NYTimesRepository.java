package wup.android.exercise.nytimes.repository;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import wup.android.exercise.nytimes.Constants;
import wup.android.exercise.nytimes.models.Article;
import wup.android.exercise.nytimes.models.MostViewedArticleResponse;

/**
 * Created by mszenasi on 2017. 06. 29..
 */

public class NYTimesRepository implements NYTimesRepositoryImpl {
    NYTimesApi nyTimesApi;

    @Inject
    public NYTimesRepository(Retrofit retrofit) {
        nyTimesApi = retrofit.create(NYTimesApi.class);
    }

    @Override
    public Observable<MostViewedArticleResponse> getMostViewedArticles(String section, int period) {
        return nyTimesApi.getMostViewedArticles(section, period, Constants.NYTIMES_API_KEY);
    }
}
