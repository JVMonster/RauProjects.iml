package com.rau.eventator;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rau.eventator.Models.Rau_Event;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yur on 13.10.2016.
 */

public class Event_Fragment extends Fragment  {
    private Rau_Event mEvent;
    private Map<String,Integer> event_background=new HashMap<String, Integer>();
    public static final String ARGUMENT="event";

    public static Event_Fragment newInstance( Rau_Event event) {
        Event_Fragment eventFragment=new Event_Fragment();
        Bundle args=new Bundle();
        args.putParcelable(ARGUMENT,event);
        eventFragment.setArguments(args);

        return eventFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = (Rau_Event) (getArguments().getParcelable(ARGUMENT));
        if(mEvent.equals(null)){
            Log.i("myLog","nulll");
        }
        else  Log.i("myLog",mEvent.getName());
        event_background.put("Music",R.drawable.music_background);
        event_background.put("Sport",R.drawable.sport_background);
        event_background.put("Culture",R.drawable.culture_background);
        event_background.put("Tech",R.drawable.teach_background);
        event_background.put("Important",R.drawable.important_background);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.row,container,false);

        RelativeLayout layout=(RelativeLayout) view.findViewById(R.id.row);
        layout.setBackground(getResources().getDrawable(event_background.get(mEvent.getType())));
        TextView date=(TextView)view.findViewById(R.id.event_date);
        date.setText(mEvent.getDate());
        date.setTextColor(Color.WHITE);
        TextView place=(TextView)view.findViewById(R.id.event_place);
        place.setText(mEvent.getPlace());
        place.setTextColor(Color.WHITE);
        TextView name=(TextView)view.findViewById(R.id.event_name);
        name.setText(mEvent.getName());
        name.setTextColor(Color.WHITE);
        TextView type=(TextView)view.findViewById(R.id.event_type);
        type.setText(mEvent.getType());
        type.setTextColor(Color.WHITE);

        return view;
    }
}
