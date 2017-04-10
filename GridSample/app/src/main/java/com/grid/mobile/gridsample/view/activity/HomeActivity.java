package com.grid.mobile.gridsample.view.activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.grid.mobile.gridsample.util.ItemDecorationAlbumColumns;
import com.grid.mobile.gridsample.view.adapter.NavigationAdapter;
import com.grid.mobile.gridsample.R;
import com.grid.mobile.gridsample.model.NavigationProp;
import com.grid.mobile.gridsample.view.adapter.VideoAdapter;
import com.grid.mobile.gridsample.web.WebHandling;
import com.grid.mobile.gridsample.web.handler.Categery;
import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView_Navigation)
    RecyclerView recyclerView_Navigation;
    @BindView(R.id.recyclerView_Video)
    RecyclerView recyclerView_Video;
    private NavigationAdapter navigationAdapter;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        WebHandling.getInstance().getcategory(new Categery() {
            @Override
            public void onResponse(NavigationProp navigationProp) {
                if (navigationProp.getResult().getStatus() > 0) {
                    navigationAdapter = new NavigationAdapter(HomeActivity.this, navigationProp.getResult().getData());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView_Navigation.setLayoutManager(layoutManager);
                    recyclerView_Navigation.setItemAnimator(new DefaultItemAnimator());
                    recyclerView_Navigation.setAdapter(navigationAdapter);
                    navigationAdapter.SetOnItemClickListener(new NavigationAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            drawer.closeDrawer(GravityCompat.START);
                        }
                    });
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        recyclerView_Video.setLayoutManager(new GridLayoutManager(HomeActivity.this,2));
        recyclerView_Video.addItemDecoration(new ItemDecorationAlbumColumns(10, 10));
        VideoAdapter video_adapter=new VideoAdapter(HomeActivity.this);
        recyclerView_Video.setAdapter(video_adapter);


    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   /* rv_home=(RecyclerView)findViewById(R.id.rv_home);
    rv_home.setLayoutManager(new GridLayoutManager(activity,2));
    rv_home.addItemDecoration(new ItemDecorationAlbumColumns(10, 10));
    homeAdapter = new HomeAdapter(activity,body.getResult());
    rv_home.setAdapter(homeAdapter);*/
}
