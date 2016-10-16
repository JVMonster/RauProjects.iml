package com.rau.eventator.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rau.eventator.Event_Fragment;
import com.rau.eventator.Models.Events_list_Fragment;
import com.rau.eventator.Models.Rau_Event;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Yur on 09.10.2016.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    int type;
    ArrayList<Rau_Event> eventsList=new ArrayList<>();
    public static final int COUNT=5;
    public Events_list_Fragment.OnListFragmentInteractionListener listener;

    public TabsPagerAdapter(FragmentManager fm, Map<Integer,ArrayList<Rau_Event>> events,int type) {
        super(fm);
        this.type=type;
        this.eventsList=events.get(type);
    }

    @Override
    public Fragment getItem(int position) {

        return Events_list_Fragment.newInstance(eventsList,position);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 1:
                return "Tech";
            case 2:
                return "Music";
            case 3:
                return "Important";
            case 4:
                return "Sport";
            case 5:
                return "Cultural";
        }
        return null;
    }
}
