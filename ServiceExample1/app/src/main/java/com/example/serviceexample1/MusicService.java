package com.example.serviceexample1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    //4
    MediaPlayer mp;



    //2
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    //3
    // making unbounded service sample services no user intraction and no intraction of ui
    //call onstart method but now it is deperacited so use onstartcommand

    // the set of instraction have to perform write inside this method
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

          // taking default ringtone from the use phone
             mp= MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

             // ringtone is of some seconds this method do play ringtone for long time
             mp.setLooping(true);

             //to start services
        mp.start();

        // imp many option is their (3) accourding to set of instraction want to perform
        return START_STICKY;
    }

    //5 use ondestroy method for when to destroy services

    @Override
    public void onDestroy() {

        // when this method is call by service mp will stop
        mp.stop();
        super.onDestroy();
    }
}
