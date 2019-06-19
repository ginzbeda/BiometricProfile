package com.example.biometricprofile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
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
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private SensorManager manager;
    private SensorEventListener listener;
//    ArrayList<Double> points = new ArrayList<>();
//    private double [][] points = new double[100][2];
    private LineGraphSeries<DataPoint> series;
    TextView xValue, yValue, zValue;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.content_main);

//        setContentView(R.layout.content_main);
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


        //Sensor Listening

        manager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        series = new LineGraphSeries<DataPoint>();
        listener = new SensorEventListener() {
//            @SuppressLint("SetTextI18n")

            int count = 0;
            @Override
            public void onSensorChanged(SensorEvent event) {
                Sensor sensor = event.sensor;
                //Accelerometer
                if(sensor.getType() == Sensor.TYPE_ACCELEROMETER){

//                    points.add((double) event.values[0]);
//                    points.add((double)event.values[1]);
//                    points[count][1] = event.values[1];

                    System.out.println(series.findDataPointAtX(count+1));

                    series.appendData(new DataPoint( event.values[0],event.values[1]), false, 500);
                    System.out.println(series.findDataPointAtX(count+1));
                    count++;
                    xValue.setText("xValue: " + event.values[0]);
                    yValue.setText("yValue: " + event.values[1]);
                    zValue.setText("zValue: " + event.values[2]);
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };


        GraphView graph = (GraphView) findViewById(R.id.graph);


//        Double x,y;

//       DataPoint data = new DataPoint(x,y);
//       series.appendData(data, true, 1);
//       System.out.println(graph);
//       graph.addSeries(series);
//        x= 0.5;

//        for(int i  = 0; i<500; i++) {
////            x = x +0.1;
////            y = Math.sin(x);
////            System.out.println("X: " + x + "Y: " + y);
////            series.appendData(new DataPoint(x,y), true, 500);
//        }
        System.out.println("yeeeeeeeeet: " + series.getHighestValueX());

//        if(!series.isEmpty())
            graph.addSeries(series);
//        System.out.println("yeeeeeeeeet2");
//        GraphView graph = (GraphView) findViewById(R.id.graph);
        manager.registerListener(listener, manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_GAME);

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
    public boolean onNavigationItemSelected(MenuItem item) {
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
