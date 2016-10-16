package com.rau.eventator.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.ArrayAdapter;


import com.rau.eventator.Event_Fragment;
import com.rau.eventator.Models.Rau_Event;
import com.rau.eventator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yur on 13.10.2016.
 */

public class EventPagerAdapter extends FragmentPagerAdapter  {
    private Map<Integer,ArrayList<Rau_Event>> events=new HashMap<>();/*
    private ArrayList<Rau_Event> musicEvents=new ArrayList();
    private ArrayList<Rau_Event> sportEvents=new ArrayList();
    private ArrayList<Rau_Event> cultureEvents=new ArrayList();
    private ArrayList<Rau_Event> techEvents=new ArrayList();
    private ArrayList<Rau_Event> importantEvents=new ArrayList();*/
    private ArrayList<Rau_Event> eventsList=new ArrayList<>();

   // private int size;
    private int type;
    public EventPagerAdapter(FragmentManager fm, Map<Integer,ArrayList<Rau_Event>> events,int type) {
        super(fm);
        this.events=events;
        this.type=type;
        this.eventsList=events.get(type);
        Log.i("myLog",String.valueOf(type));
    }

   /* private void sortEvents(Map<Integer, ArrayList<Rau_Event>> events) {

            importantEvents=events.get(type);
            Log.i("imp",String.valueOf(importantEvents.size()));
            musicEvents=events.get(2);
            Log.i("mus",String.valueOf(musicEvents.size()));
            sportEvents=events.get(3);
            Log.i("s",String.valueOf(sportEvents.size()));
            cultureEvents=events.get(4);
            Log.i("mus",String.valueOf(cultureEvents.size()));
            techEvents=events.get(5);
            Log.i("te",String.valueOf(techEvents.size()));

    }*/

    @Override
    public Fragment getItem(int position) {
        Event_Fragment fragment;
        fragment=Event_Fragment.newInstance(eventsList.get(position));
        Log.w("my",String.valueOf(type));
        /*switch (type){
            case 1:
                size=importantEvents.size();
                fragment= Event_Fragment.newInstance(importantEvents.get(position));
            case 2:
                size=musicEvents.size();
                fragment=Event_Fragment.newInstance(musicEvents.get(position));
            case 3:
                size=sportEvents.size();
                fragment=Event_Fragment.newInstance(sportEvents.get(position));
            case 4:
                size=cultureEvents.size();
                fragment= Event_Fragment.newInstance(cultureEvents.get(position));
            case 5:
                size=techEvents.size();
                fragment= Event_Fragment.newInstance(techEvents.get(position));
            default:
                fragment=Event_Fragment.newInstance(importantEvents.get(position));
        }*/
        return fragment;
    }

    @Override
    public int getCount() {
        Log.i("musi",String.valueOf(eventsList.size()));
        return eventsList.size();
    }
}
