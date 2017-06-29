package wup.android.exercise.nytimes.di;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import wup.android.exercise.nytimes.BuildConfig;
import wup.android.exercise.nytimes.Constants;
import wup.android.exercise.nytimes.json.ArticleDeserializer;
import wup.android.exercise.nytimes.models.Article;

@Module
public class AppModule {

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.registerTypeAdapter(Article.class, new ArticleDeserializer()).create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if(BuildConfig.DEBUG){
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }else{
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

    }

    @Singleton
    @Provides
    public Converter.Factory provideConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Singleton
    @Provides
    public CallAdapter.Factory provideCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Converter.Factory converterFactory, CallAdapter.Factory callAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }
}
