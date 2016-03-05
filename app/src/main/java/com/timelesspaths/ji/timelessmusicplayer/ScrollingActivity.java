package com.timelesspaths.ji.timelessmusicplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.ToxicBakery.viewpager.transforms.TabletTransformer;
import com.timelesspaths.ji.timelessmusicplayer.fragment.AlbumFragment;
import com.timelesspaths.ji.timelessmusicplayer.fragment.ArtistFragment;
import com.timelesspaths.ji.timelessmusicplayer.fragment.DiscoverFragment;
import com.timelesspaths.ji.timelessmusicplayer.fragment.GenreFragment;
import com.timelesspaths.ji.timelessmusicplayer.fragment.PlaylistFragment;
import com.timelesspaths.ji.timelessmusicplayer.fragment.SongFragment;

public class ScrollingActivity extends AppCompatActivity {

    //Setting up Viewpager and Adapter

    public ViewPager pager;
    public CustomPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Attaching id to Viewpager and adapter

        pager = (ViewPager) findViewById(R.id.view_pager);
        mAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(mAdapter);
        pager.setPageTransformer(true, new TabletTransformer());

        //Creating Tab layout

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);




    }


    // Creating custom adapter for fragments

    public class CustomPagerAdapter extends FragmentPagerAdapter {

        public CustomPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private Fragment mSongsFragment;
        private Fragment mArtistsFragment;
        private Fragment mAlbumsFragment;
        private Fragment mGenresFragment;
        private Fragment mPlayListsFragment;
        private Fragment mDiscoverFragment;

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    //Discover
                    if (mDiscoverFragment == null) {
                        mDiscoverFragment = new DiscoverFragment();
                    }
                    return mDiscoverFragment;
                case 1:
                    //Album
                    if (mAlbumsFragment == null) {
                        mAlbumsFragment = new AlbumFragment();
                    }
                    return mAlbumsFragment;
                case 2:
                    //Artist
                    if (mArtistsFragment == null) {
                        mArtistsFragment = new ArtistFragment();
                    }
                    return mArtistsFragment;
                case 3:
                    //Song
                    if (mSongsFragment == null) {
                        mSongsFragment = new SongFragment();
                    }
                    return mSongsFragment;
                case 4:
                    //Playlist
                    if (mPlayListsFragment == null) {
                        mPlayListsFragment = new PlaylistFragment();
                    }
                    return mPlayListsFragment;
                case 5:
                    //Genre
                    if (mGenresFragment == null) {
                        mGenresFragment = new GenreFragment();
                    }
                    return mGenresFragment;

            }
            return new Fragment();
        }


        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {

                case 0:
                    return getResources().getString(R.string.discover_frag);
                case 1:
                    return getResources().getString(R.string.album_frag);
                case 2:
                    return getResources().getString(R.string.artist_frag);
                case 3:
                    return getResources().getString(R.string.song_frag);
                case 4:
                    return getResources().getString(R.string.playlist_frag);
                case 5:
                    return getResources().getString(R.string.genre_frag);
                default:
                    return "tab: " + position;
            }
        }


    }



    // Menu Options

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
