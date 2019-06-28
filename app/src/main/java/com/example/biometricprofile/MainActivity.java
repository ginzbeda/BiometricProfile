package com.example.biometricprofile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.example.biometricprofile.Profile.setAccel;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private SensorManager manager;
    private SensorEventListener listener;
    private Profile prof;
    private long beat = -1; //heartbeat time


    private LineGraphSeries<DataPoint> series;
    TextView xValue, yValue, zValue, heartBeat;
    int lastX = 0;

    public MainActivity() {
        prof = new Profile();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Take Reading", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Position
        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        zValue = findViewById(R.id.zValue);
        heartBeat = findViewById(R.id.heartBeat);


//        GraphView graph = findViewById(R.id.graph);


        //Sensor Listening

        manager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        series = new LineGraphSeries<>();
        listener = new SensorEventListener() {


            int count = 0;
            @SuppressLint("SetTextI18n")
            @Override
            public void onSensorChanged(SensorEvent event) {
                Sensor sensor = event.sensor;

                //Accelerometer
                if(sensor.getType() == Sensor.TYPE_ACCELEROMETER){

                    count++;
                    setAccel((int)event.values[0],(int) event.values[1],(int) event.values[2]);
                    series.appendData(new DataPoint(lastX++,event.values[0]), true, 500);
                    xValue.setText("xValue: " + (int) event.values[0]);
                    yValue.setText("yValue: " + (int) event.values[1]);
                    zValue.setText("zValue: " + (int) event.values[2]);
//                    System.out.println("accel: "+ Profile.getAccel());
                }
                else if(sensor.getType() == Sensor.TYPE_HEART_BEAT){
                    System.out.println(event.values);

                    if(beat!=-1) {
                        System.out.println("WHAT IS HAPPENING");
                        heartBeat.setText("heartBeat: " + event.values);
                        prof.setHeartBeat(beat - System.currentTimeMillis());

//                        Profile.setHeartBeat((int) event.values[0]);
                    }
                    else{
                        System.out.println("OK WE OK");
                        heartBeat.setText("heartBeat: " + 0);
                        prof.setHeartBeat(beat - System.currentTimeMillis());
                    }
                    System.out.println(prof.getHeartBeat());
                    beat = System.currentTimeMillis();
                }
                else if(sensor.getType() == Sensor.TYPE_HEART_RATE){
                    prof.setHeartRate((int) event.values[0]);
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
//        GraphView graph = findViewById(R.id.graph);
        //Display Graph
//        graph.addSeries(series);

        manager.registerListener(listener, manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_GAME);
        manager.registerListener(listener,manager.getDefaultSensor(Sensor.TYPE_HEART_BEAT), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        menu.add("About Us");
        menu.add("Terms and Conditions");
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
