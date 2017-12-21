package com.creativate.app.mystory;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    StoryFragment storyFragment;
    HomeFragment homeFragment = null;
    ProfileFragment profileFragment = null;
    StoryDetailFragment storyDetailFragment = null;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_story  :
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout, storyFragment).commit();
                    return true;
                case R.id.navigation_home:
                    if (homeFragment == null)
                        homeFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout, homeFragment).commit();
                    return true;
                case R.id.navigation_profile:
                    if (profileFragment == null)
                        profileFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout, profileFragment).commit();
                    return true;
                case R.id.imageViewStory:
                    if (storyDetailFragment == null)
                        storyDetailFragment = new StoryDetailFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout, storyDetailFragment).commit();
                    return true;

            }
            return false;

        }
    };

    private HomeFragment.OnFragmentInteractionListener fragmentInteractionListener
            = new HomeFragment.OnFragmentInteractionListener() {
        @Override
        public void onFragmentInteraction(Uri uri) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializeView();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //remove action bar
        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

        if(!SharedPrefManager.getmInstance(this).isLoggedIn()){

        }


    }

    private void initializeView(){
        storyFragment = new StoryFragment() ;

        getSupportFragmentManager().beginTransaction().replace(R.id.mainlayout, storyFragment).commit();
    }
}
