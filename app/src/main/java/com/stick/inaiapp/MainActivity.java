package com.stick.inaiapp;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

public class MainActivity extends ActionBarActivity {
    static Context context;
    AppSectionsPagerAdapter1 mAppSectionsPagerAdapter;
    SlidingTabLayout tabs;
    ViewPager mPager;
    LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter1(getSupportFragmentManager());

        mPager = (ViewPager) findViewById(R.id.pager);
        new setAdapterTaskPager().execute();
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tab_colorizer);
            }
        });
        new setAdapterTask().execute();
    }

    public class AppSectionsPagerAdapter1 extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter1(FragmentManager fragment) {
            super(fragment);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return new Monitoreo();
                case 1:
                    return new InicioFragment();
                case 2:
                    return new Ajustes();
                default:
                    return new InicioFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return "MONITOREO";
                case 1:
                    return "INICIO";
                case 2:
                    return "AJUSTES";
                default:
                    return "";
            }
        }

    }
    private class setAdapterTask extends AsyncTask<Void,Void,Void> {
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            tabs.setViewPager(mPager);
        }
    }
    private class setAdapterTaskPager extends AsyncTask<Void,Void,Void> {
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mPager.setAdapter(mAppSectionsPagerAdapter);
            mPager.setCurrentItem(1);
        }
    }

}
