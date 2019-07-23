package com.android.biometricprofile ;

import java.util.Timer;

public class Profile {
    private static long heartBeat;
    private static int heartRate;
    private static int bloodPressure =0;
    private static int[] accel;
    private static String name;

    private static long beat =-1;

    Profile(){
        name = "";
        heartBeat =0;
        heartRate =0;
        accel = new int[]{0,0,0};
    }

    public static int getAccel() {
        return accel[0];
    }

    public static void setAccel(int x, int y, int z) {
        accel[0] = x;
        accel[1] = y;
        accel[2] = z;

    }

    public static int getBloodPressure() {
        return bloodPressure;
    }

    public static void setBloodPressure(int data) {
        bloodPressure = data;
    }

    public static int getHeartRate() {
        return heartRate;
    }

    public static void setHeartRate(int data) { heartRate = data;}


    public static long getHeartBeat() {


        return heartBeat;
    }

    public static void setHeartBeat(long data) { heartBeat = data;}
}
