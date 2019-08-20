package com.example.bga_s.triosound.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Trio {

    @PrimaryKey
    private long trioId;

    private String name;
    private String tonika;
    private String terciya;
    private String kvinta;

    public Trio(String tonika, String terciya, String kvinta) {
        this.tonika = tonika;
        this.terciya = terciya;
        this.kvinta = kvinta;
    }

    public Trio() {
    }

    public long getTrioId() {
        return trioId;
    }

    public void setTrioId(long trioId) {
        this.trioId = trioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTonika() {
        return tonika;
    }

    public void setTonika(String tonika) {
        this.tonika = tonika;
    }

    public String getTerciya() {
        return terciya;
    }

    public void setTerciya(String terciya) {
        this.terciya = terciya;
    }

    public String getKvinta() {
        return kvinta;
    }

    public void setKvinta(String kvinta) {
        this.kvinta = kvinta;
    }
}
