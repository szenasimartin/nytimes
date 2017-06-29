package wup.android.exercise.nytimes.di;

/**
 * Created by mszenasi on 2017. 06. 29..
 */

import javax.inject.Singleton;

import dagger.Component;
import wup.android.exercise.nytimes.ui.list.ArticleListActivity;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(ArticleListActivity articleListActivity);
}
