package com.apy.apyworkout.model.Room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.apy.apyworkout.model.Room.converters.UUIDConverter;
import com.apy.apyworkout.model.Room.daos.ExerciseDAO;
import com.apy.apyworkout.model.Room.entities.Exercise;

@Database(entities = {
        Exercise.class,
}, version = 1, exportSchema = false)
@TypeConverters({
        UUIDConverter.class
})
abstract class AppDatabase extends RoomDatabase {
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Propriété constante statique
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private static final String DB_NAME = "APYWorkoutDatabase.db";


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Propriété statique volatile
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private static AppDatabase instance;


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Constructeur & Accesseur d'instance
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    protected AppDatabase() {
    }

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Méthode statique privée
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    private static AppDatabase create(final Context context) {
        return Room
                .databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // Liste des DAOs
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public abstract ExerciseDAO getExerciseDAO();

}
