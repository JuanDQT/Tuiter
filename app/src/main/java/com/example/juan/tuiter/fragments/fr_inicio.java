package com.example.juan.tuiter.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juan.tuiter.R;
import com.example.juan.tuiter.adapters.TweetAdapter;
import com.example.juan.tuiter.model.Tweet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fr_inicio extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Tweet> tweets;

    public fr_inicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fr_inicio, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        tweets = new ArrayList<>();
        //
        //    public Tweet(int id, String username, String userUrl, String date, String userPicture, String tweet, int replies, int retweets, int likes) {

        tweets.add(new Tweet(1, "Juan sape", "@juandqt", "2min","https://media.licdn.com/mpr/mpr/shrink_100_100/AAEAAQAAAAAAAAddAAAAJDg0NGZlMTg4LTI2YjUtNDRiOS1iZTIyLWUyODFjYmUxZmE1ZQ.jpg", "china, te sabes la historia de la virgen de guadalupe? la que se agacha y luego te escupe", 3, 2, 25));
        tweets.add(new Tweet(2, "Juan sape", "@juandqt", "2min","https://media.licdn.com/mpr/mpr/shrink_100_100/AAEAAQAAAAAAAAddAAAAJDg0NGZlMTg4LTI2YjUtNDRiOS1iZTIyLWUyODFjYmUxZmE1ZQ.jpg", "probando 2", 31, 2, 5));
        tweets.add(new Tweet(3, "Juan sape", "@juandqt", "2min","https://media.licdn.com/mpr/mpr/shrink_100_100/AAEAAQAAAAAAAAddAAAAJDg0NGZlMTg4LTI2YjUtNDRiOS1iZTIyLWUyODFjYmUxZmE1ZQ.jpg", "sorete", 3, 12, 2));
        tweets.add(new Tweet(4, "Juan sape", "@juandqt", "2min","https://media.licdn.com/mpr/mpr/shrink_100_100/AAEAAQAAAAAAAAddAAAAJDg0NGZlMTg4LTI2YjUtNDRiOS1iZTIyLWUyODFjYmUxZmE1ZQ.jpg", "a 20 el pete", 7, 1, 0));
        tweets.add(new Tweet(5, "Juan sape", "@juandqt", "2min","https://media.licdn.com/mpr/mpr/shrink_100_100/AAEAAQAAAAAAAAddAAAAJDg0NGZlMTg4LTI2YjUtNDRiOS1iZTIyLWUyODFjYmUxZmE1ZQ.jpg", "deci batman sape, que me muero", 3, 2, 1));
        tweets.add(new Tweet(6, "Juan sape", "@juandqt", "2min","https://media.licdn.com/mpr/mpr/shrink_100_100/AAEAAQAAAAAAAAddAAAAJDg0NGZlMTg4LTI2YjUtNDRiOS1iZTIyLWUyODFjYmUxZmE1ZQ.jpg", "adeu", 5, 9, 7));
        //
        TweetAdapter tweetAdapter = new TweetAdapter(getActivity(), tweets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        recyclerView.setAdapter(tweetAdapter);

        return view;
    }


}
