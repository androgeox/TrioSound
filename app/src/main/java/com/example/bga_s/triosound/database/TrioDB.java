package com.example.bga_s.triosound.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.bga_s.triosound.TrioWorkerDB;
import com.example.bga_s.triosound.dao.TrioDAO;
import com.example.bga_s.triosound.model.Trio;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

@Database(entities = {Trio.class}, version = 1)
public abstract class TrioDB extends RoomDatabase {
    public abstract TrioDAO TrioDAO();

    public TrioDB feelDB(Context context) {

        TrioDB feelTrioDB = Room.databaseBuilder(context, TrioDB.class, "Trio.db").build();
        OneTimeWorkRequest dbWorker = new OneTimeWorkRequest.Builder(TrioWorkerDB.class).build();
        WorkManager.getInstance().enqueue(dbWorker);
        return feelTrioDB;
    }
}

