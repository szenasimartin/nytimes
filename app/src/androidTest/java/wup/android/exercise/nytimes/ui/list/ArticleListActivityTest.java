package wup.android.exercise.nytimes.ui.list;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ArticleListActivityTest {

    @Rule
    public ActivityTestRule<ArticleListActivity> mActivityTestRule = new ActivityTestRule<>(ArticleListActivity.class);

    @Test
    public void articleListActivityTest() {
    }

}
