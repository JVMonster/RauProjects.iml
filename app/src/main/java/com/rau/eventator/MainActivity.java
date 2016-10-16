package com.rau.eventator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rau.eventator.Adapters.EventPagerAdapter;
import com.rau.eventator.Models.Rau_Event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Map<Integer,ArrayList<Rau_Event>> mEvents=new HashMap<Integer, ArrayList<Rau_Event>>();
    private ArrayList<Rau_Event> musicEvents=new ArrayList<>();
    private ArrayList<Rau_Event> sportEvents=new ArrayList<>();;
    private ArrayList<Rau_Event> culturalEvents=new ArrayList<>();;
    private ArrayList<Rau_Event> techEvents=new ArrayList<>();;
    private ArrayList<Rau_Event> importantEvents=new ArrayList<>();;
    public static final int SPORT=3;
    public static final int CULTURAL=4;
    public static final int IMPORTANT=1;
    public static final int TECH=5;
    public static final int MUSIC=2;

    private ViewPager musicPager;
    private ViewPager sportPager;
    private ViewPager culturePager;
    private ViewPager techPager;
    private ViewPager importantPager;

    private EventPagerAdapter musicAdapter;
    private EventPagerAdapter sportAdapter;
    private EventPagerAdapter techAdapter;
    private EventPagerAdapter culturalAdapter;
    private EventPagerAdapter importantAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setPager();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    private void setPager() {
        musicEvents.add(new Rau_Event("PAty","26.10.16","Rau","Music","","Party in Rau",true));
        musicEvents.add(new Rau_Event("MASQUARADE","14.10.16","DOWNTOWN","Music","","Masquarade in downtown",false));
        musicEvents.add(new Rau_Event("CONCERT","12.11.16","BLUE_HALL","Music","","Concert in Blue hall",false));

        sportEvents.add(new Rau_Event("Football","26.10.16","Rau","Sport","","Football in Rau",false));
        sportEvents.add(new Rau_Event("Basketball","14.10.16","Rau","Sport","","Basketball in Rau",false));
        sportEvents.add(new Rau_Event("Tennis","12.11.16","InCourt","Sport","","Tennis in InCourt",true));

        culturalEvents.add(new Rau_Event("Theatre","26.10.16","Rau","Culture","","Theatre in Rau",false));
        culturalEvents.add(new Rau_Event("Romeo & Juliet","14.10.16","DOWNTOWN","Culture","","Romeo in downtown",false));
        culturalEvents.add(new Rau_Event("CONCERT","12.11.16","Rau","Culture","","Concert in Rau",false));

        techEvents.add(new Rau_Event("Silicon volley","26.10.16","Rau","Tech","","Silicon in Rau",false));
        techEvents.add(new Rau_Event("Brain Ring","14.10.16","YSU","Tech","","Brain in YSU",true));
        techEvents.add(new Rau_Event("IT","12.11.16","BLUE_HALL","Tech","","IT in Blue hall",false));

        importantEvents.add(new Rau_Event("PAty","26.10.16","Rau","Music","","party",true));
        importantEvents.add(new Rau_Event("Brain Ring","14.10.16","YSU","Tech","","brain",true));
        importantEvents.add(new Rau_Event("Tennis","12.11.16","Incourt","Sport","","Tennis",true));

        mEvents.put(1,importantEvents);
        mEvents.put(2,musicEvents);
        mEvents.put(3,sportEvents);
        mEvents.put(4,culturalEvents);
        mEvents.put(5,techEvents);

        musicPager=(ViewPager)findViewById(R.id.music_pager);
        sportPager=(ViewPager)findViewById(R.id.sport_pager);
        culturePager=(ViewPager)findViewById(R.id.culture_pager);
        techPager=(ViewPager)findViewById(R.id.teach_pager);
        importantPager=(ViewPager)findViewById(R.id.important_pager);

        importantAdapter=new EventPagerAdapter(getSupportFragmentManager(),mEvents,IMPORTANT);
        importantPager.setAdapter(importantAdapter);

        musicAdapter=new EventPagerAdapter(getSupportFragmentManager(),mEvents,MUSIC);
        musicPager.setAdapter(musicAdapter);

        sportAdapter=new EventPagerAdapter(getSupportFragmentManager(),mEvents,SPORT);
        sportPager.setAdapter(sportAdapter);

        culturalAdapter=new EventPagerAdapter(getSupportFragmentManager(),mEvents,CULTURAL);
        culturePager.setAdapter(culturalAdapter);

        techAdapter=new EventPagerAdapter(getSupportFragmentManager(),mEvents,TECH);
        techPager.setAdapter(techAdapter);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onPagersClick(View v){
        Intent intent=new Intent(this,TabbedActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("allEvents", (Serializable) mEvents);
        startActivity(intent);

    }
}
