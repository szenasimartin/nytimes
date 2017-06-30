package wup.android.exercise.nytimes.repository;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import wup.android.exercise.nytimes.models.Article;
import wup.android.exercise.nytimes.models.MostViewedArticleResponse;

/**
 * Created by mszenasi on 2017. 06. 29..
 */

public interface NYTimesApi {
    @GET("mostviewed/{section}/{period}.json")
    Observable<MostViewedArticleResponse> getMostViewedArticles(@Path("section") String section, @Path("period") int period, @Query("api_key") String apiKey);
}
