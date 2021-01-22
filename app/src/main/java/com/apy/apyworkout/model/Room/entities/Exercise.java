package com.apy.apyworkout.model.Room.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class Exercise {
    @PrimaryKey
    @NonNull
    private final UUID uuid;
    private String name;


    @Ignore
    public Exercise() {
        this.uuid = UUID.randomUUID();
    }

    @Ignore
    public Exercise(String name) {
        this();
        this.name = name;
    }

    public Exercise(@NonNull UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }


    public @NonNull
    UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
