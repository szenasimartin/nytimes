package wup.android.exercise.nytimes.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import wup.android.exercise.nytimes.R;
import wup.android.exercise.nytimes.ui.list.ArticleListActivity;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(ArticleDetailFragment.ARG_ITEM_URL,
                    getIntent().getStringExtra(ArticleDetailFragment.ARG_ITEM_URL));
            arguments.putString(ArticleDetailFragment.ARG_ITEM_TITLE,
                    getIntent().getStringExtra(ArticleDetailFragment.ARG_ITEM_TITLE));
            ArticleDetailFragment fragment = new ArticleDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.article_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            supportFinishAfterTransition();
            navigateUpTo(new Intent(this, ArticleListActivity.class));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
