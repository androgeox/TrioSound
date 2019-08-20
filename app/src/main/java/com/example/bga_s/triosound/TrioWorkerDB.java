package com.example.bga_s.triosound;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.JsonReader;
import android.util.Log;

import com.example.bga_s.triosound.model.Trio;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import static android.content.ContentValues.TAG;

public class TrioWorkerDB extends Worker {

    Context applicationContext;

    public TrioWorkerDB(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(new InputStreamReader(applicationContext.getAssets().open("trio.json")));

            ArrayList<Trio> trioList = new ArrayList<>();

            jsonReader.beginObject();
            while(jsonReader.hasNext()) {
                Trio trio = gson.fromJson(String.valueOf(jsonReader), Trio.class);
                trioList.add(trio);
            }
            jsonReader.endObject();
            jsonReader.close();

            App appInstance = App.getAppInstance();
            appInstance.trioDB.TrioDAO().insertAll(trioList);

            return Result.success();

        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Error seeding database", e);
            return Result.failure();
        }
    }
}
