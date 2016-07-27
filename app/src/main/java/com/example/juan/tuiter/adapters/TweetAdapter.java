package com.example.juan.tuiter.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juan.tuiter.R;
import com.example.juan.tuiter.model.Tweet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Juan on 23/07/2016.
 */
public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {
    private ArrayList<Tweet> tweets;
    private Activity activity;

    public TweetAdapter(Activity activity, ArrayList<Tweet> tweets) {
        this.activity = activity;
        this.tweets = tweets;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_layout, parent, false);
        return new ViewHolder(view);
    }

    public String getTime(String sdate, String time) {
        System.out.println("DATE: "+ sdate);
        System.out.println("TIME: "+ time);

        Calendar dCurrent = Calendar.getInstance();
        Calendar dCreated = Calendar.getInstance();
        dCreated.set(Calendar.DAY_OF_YEAR, Integer.valueOf(sdate.substring(8)));
        String t_mont = sdate.substring(5, 7);
        dCreated.add(Calendar.MONTH, Integer.valueOf(t_mont)-1);//-1

        System.out.println("LELGADA: "+ dCreated.get(Calendar.YEAR));
        System.out.println("CUSTOM: "+ dCurrent.get(Calendar.YEAR));

        if (dCurrent.get(Calendar.YEAR) == dCreated.get(Calendar.YEAR) && dCurrent.get(Calendar.MONTH) == dCreated.get(Calendar.MONTH)&&dCurrent.get(Calendar.DAY_OF_MONTH) == dCreated.get(Calendar.DAY_OF_MONTH)) {
            //LAS FECHAS SON EL MISMO DIA, MOSTREAREMOS: HORA, O MIN
            System.out.println("IGUALES SAPE");

        } else {
            //SE MOSTRARA AYER, MARTES, MIEROLES... DOMINO, 13-12-3312..
        }


        return null;
        //
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_username.setText(tweets.get(position).getUsername());
        holder.tv_userUrl.setText(tweets.get(position).getUserUrl());


        String sdate = tweets.get(position).getDate().substring(0,10);
        String time = tweets.get(position).getDate().substring(10);

        String date = getTime(sdate, time);

        //

        holder.tv_date.setText(date);


        holder.tv_tweet.setText(tweets.get(position).getTweet());

        if (tweets.get(position).getReplies() > 0)
            holder.tv_replies.setText(String.valueOf(tweets.get(position).getReplies()));


        if (tweets.get(position).getRetweets() > 0)
            holder.tv_retweets.setText(String.valueOf(tweets.get(position).getRetweets()));

        if (tweets.get(position).getLikes() > 0)
            holder.tv_likes.setText(String.valueOf(tweets.get(position).getLikes()));

        System.out.println(tweets.get(position).getUserPicture());
        Picasso.with(activity).load(tweets.get(position).getUserPicture()).into(holder.iv_picture);

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_picture;
        TextView tv_username;
        TextView tv_userUrl;
        TextView tv_date;
        TextView tv_tweet;
        TextView tv_replies;
        TextView tv_retweets;
        TextView tv_likes;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_picture = (ImageView) itemView.findViewById(R.id.iv_picture);
            tv_username = (TextView) itemView.findViewById(R.id.tv_username);
            tv_userUrl = (TextView) itemView.findViewById(R.id.tv_userurl);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_tweet = (TextView) itemView.findViewById(R.id.tv_tweet);
            tv_replies = (TextView) itemView.findViewById(R.id.tv_replies);
            tv_retweets = (TextView) itemView.findViewById(R.id.tv_retweets);
            tv_likes = (TextView) itemView.findViewById(R.id.tv_likes);
        }
    }
}
