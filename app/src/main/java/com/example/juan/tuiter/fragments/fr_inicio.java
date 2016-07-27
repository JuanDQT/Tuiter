package com.example.juan.tuiter.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.juan.tuiter.R;
import com.example.juan.tuiter.adapters.MySingleton;
import com.example.juan.tuiter.adapters.TweetAdapter;
import com.example.juan.tuiter.model.Tweet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fr_inicio extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Tweet> tweets;
    TweetAdapter tweetAdapter;

    private static final String URL_TWEETS = "http://tuiter.esy.es/php/getTweets.php";

    public fr_inicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fr_inicio, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        tweets = new ArrayList<>();


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, URL_TWEETS, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                System.out.println("BIEN");

                for (int i = 0; i<response.length(); i++) {

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        System.out.println(jsonObject.toString());
                        //    public Tweet(int id, String username, String userUrl, String date, String userPicture, String tweet, int replies, int retweets, int likes) {

                        tweets.add(new Tweet(jsonObject.getInt("user_id"), jsonObject.getString("user_name"), jsonObject.getString("user_url"), jsonObject.getString("dt_tweet"), jsonObject.getString("picture"), jsonObject.getString("content"),1,2,3));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                tweetAdapter = new TweetAdapter(getActivity(), tweets);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

                recyclerView.setAdapter(tweetAdapter);

                Toast.makeText(getActivity(), "SAIZ;: " + tweets.size(), Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("ERROR");
            }
        });

        MySingleton.getInstance(getActivity()).addToRequestQueue(jsonArrayRequest);



        return view;
    }

}
