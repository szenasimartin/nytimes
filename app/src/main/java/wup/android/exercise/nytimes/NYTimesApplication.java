package wup.android.exercise.nytimes;

import android.app.Application;

import wup.android.exercise.nytimes.di.AppComponent;
import wup.android.exercise.nytimes.di.AppComponentInjector;

/**
 * Created by mszenasi on 2017. 06. 29..
 */

public class NYTimesApplication extends Application {
    @Override
    public void onCreate() {
        new AppComponentInjector().makeDefault();
        super.onCreate();
    }
}
