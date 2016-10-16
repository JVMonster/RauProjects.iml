package com.rau.eventator.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rau.eventator.Models.Events_list_Fragment;
import com.rau.eventator.Models.Rau_Event;
import com.rau.eventator.R;

import java.util.ArrayList;

/**
 * Created by Yur on 17.10.2016.
 */

public class EventsListAdapter extends RecyclerView.Adapter<com.rau.eventator.Adapters.EventsListAdapter.ViewHolder> {
    ArrayList<Rau_Event>  mEvents=new ArrayList<>();
    Events_list_Fragment.OnListFragmentInteractionListener mListener;

    public EventsListAdapter(ArrayList<Rau_Event> events,Events_list_Fragment.OnListFragmentInteractionListener listener) {
        this.mEvents=events;
        this.mListener=listener;
    }

    @Override
    public com.rau.eventator.Adapters.EventsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_element, parent, false);

        return new com.rau.eventator.Adapters.EventsListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final com.rau.eventator.Adapters.EventsListAdapter.ViewHolder holder, int position) {

            holder.mEventHeader.setText(mEvents.get(position).getName());
            holder.mEventDesc.setText(mEvents.get(position).getDesc());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mEventIcon;
        private TextView mEventHeader;
        private TextView mEventDesc;
        private View mView;


        public ViewHolder(View view) {
            super(view);
             mEventIcon =(ImageView)view.findViewById(R.id.eventIcon);
             mEventHeader =(TextView)view.findViewById(R.id.eventHeader);
             mEventDesc =(TextView)view.findViewById(R.id.eventDesc);
             mView=(View)view.findViewById(R.id.lay);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
