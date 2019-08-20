package com.example.bga_s.triosound.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.bga_s.triosound.database.TrioDB;
import com.example.bga_s.triosound.model.Trio;

import java.util.List;


@Dao
public interface TrioDAO {

    @Query("SELECT * FROM trio WHERE trioId = :id")
    Trio getTrioById(long id);

    @Insert
    void insertAll(List<Trio> trios);

}
