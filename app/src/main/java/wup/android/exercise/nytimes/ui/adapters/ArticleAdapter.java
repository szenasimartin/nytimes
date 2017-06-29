package wup.android.exercise.nytimes.ui.adapters;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import wup.android.exercise.nytimes.R;
import wup.android.exercise.nytimes.models.Article;
import wup.android.exercise.nytimes.ui.detail.ArticleDetailActivity;
import wup.android.exercise.nytimes.ui.detail.ArticleDetailFragment;

/**
 * Created by mszenasi on 2017. 06. 29..
 */

public class ArticleAdapter
        extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article> values;
    private final List<Article> itemsCopy;
    private Context context;
    private boolean twoPane;

    public ArticleAdapter(Context activity, boolean twoPane, List<Article> items) {
        this.context = activity;
        this.twoPane = twoPane;
        values = items;
        itemsCopy = new ArrayList<>(items);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item = values.get(position);
        holder.title.setText(values.get(position).getTitle());
        if (values.get(position).getByline()!=null) {
            holder.created.setText(values.get(position).getByline());
        }

        holder.date.setText(values.get(position).getPublishedDate());
        if (!values.get(position).getMedia().isEmpty()) {
            if (!values.get(position).getMedia().get(0).getMediaMetadata().isEmpty()) {
                Picasso.with(context).load(values.get(position).getMedia().get(0).getMediaMetadata().get(0).getUrl()).into(holder.image);
            }
        }


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (twoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ArticleDetailFragment.ARG_ITEM_URL, holder.item.getUrl());
                    arguments.putString(ArticleDetailFragment.ARG_ITEM_TITLE, holder.item.getTitle());
                    ArticleDetailFragment fragment = new ArticleDetailFragment();
                    fragment.setArguments(arguments);
                    ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.article_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ArticleDetailActivity.class);
                    intent.putExtra(ArticleDetailFragment.ARG_ITEM_URL, holder.item.getUrl());
                    intent.putExtra(ArticleDetailFragment.ARG_ITEM_TITLE, holder.item.getTitle());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((AppCompatActivity)context, holder.title, holder.title.getTransitionName());
                        context.startActivity(intent, options.toBundle());
                    } else {
                        context.startActivity(intent);
                    }


                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView title;
        public final TextView date;
        public final TextView created;
        public final CircleImageView image;
        public Article item;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
            created = (TextView) view.findViewById(R.id.created);
            image = (CircleImageView) view.findViewById(R.id.profile_image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + date.getText() + "'";
        }
    }

    public void filter(String text) {
        values.clear();
        if(text.isEmpty()){
            values.addAll(itemsCopy);
        } else{
            text = text.toLowerCase();
            for(Article item: itemsCopy){
                if(item.getTitle().toLowerCase().contains(text)){
                    values.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
