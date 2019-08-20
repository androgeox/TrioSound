package com.example.bga_s.triosound;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.bga_s.triosound.database.TrioDB;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;


public class App extends Application {

    public static App appInstance;

    public TrioDB trioDB;

    public static App getAppInstance() {
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        trioDB = Room.databaseBuilder(this, TrioDB.class, "trio.json").build();
    }

    public TrioDB getTrioDB() {
        return trioDB;
    }

    public TrioDB feelDB(Context context) {
        TrioDB feelTrioDB = Room.databaseBuilder(context, TrioDB.class, "Trio.db").build();
        OneTimeWorkRequest dbWorker = new OneTimeWorkRequest.Builder(TrioWorkerDB.class).build();
        WorkManager.getInstance().enqueue(dbWorker);
        return feelTrioDB;
    }

}
