package com.apy.apyworkout.model.Room.converters;

import androidx.room.TypeConverter;

import java.util.UUID;

public class UUIDConverter {
    @TypeConverter
    public static UUID fromStringToUUID(String value) {
        return UUID.fromString(value);
    }

    @TypeConverter
    public static String fromUUIDToString(UUID value) {
        return value.toString();
    }
}
