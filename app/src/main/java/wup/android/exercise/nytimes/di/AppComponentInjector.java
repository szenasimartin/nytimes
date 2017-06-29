package wup.android.exercise.nytimes.di;

import android.content.Context;

/**
 * Created by mszenasi on 2017. 06. 29..
 */

public class AppComponentInjector {
    private static AppComponent applicationComponent;
    private static AppComponentInjector injector;

    public static AppComponentInjector getDefault() {
        return injector;
    }

    public void makeDefault() {
        injector = this;
    }

    public AppComponent component() {
        if (applicationComponent == null) {
            AppModule appModule = new AppModule();

            applicationComponent = DaggerAppComponent.builder()
                    .appModule(appModule)
                    .build();
        }
        return applicationComponent;
    }
}
