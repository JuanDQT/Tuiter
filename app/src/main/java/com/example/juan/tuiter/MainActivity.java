package com.example.juan.tuiter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.juan.tuiter.adapters.PageAdapter;
import com.example.juan.tuiter.fragments.fr_cuenta;
import com.example.juan.tuiter.fragments.fr_inicio;
import com.example.juan.tuiter.fragments.fr_mensajes;
import com.example.juan.tuiter.fragments.fr_notificaciones;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.mi_toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.mi_tablayout);
        viewPager = (ViewPager) findViewById(R.id.mi_viewpager);
        setSupportViewPager();

    }



    protected ArrayList<Fragment> addFragmentsViewPager() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new fr_inicio());
        fragments.add(new fr_notificaciones());
        fragments.add(new fr_mensajes());
        fragments.add(new fr_cuenta());

        return fragments;
    }

    public void setSupportViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragmentsViewPager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.notification_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.message_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.contact_icon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.m_buscar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
