package club.plus1.staffsharing.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(version = 12, exportSchema = false, entities = {User.class})
public abstract class Database extends RoomDatabase {

    public abstract UserDao userDao();

    private static Database mInstance;

    public static Database getLocalDatabase(Context context) {
        if (context.getApplicationContext() == null){
            return null;
        }
        if (mInstance == null) {
            mInstance = Room
                    .databaseBuilder(context.getApplicationContext(), Database.class, "db")
                    .fallbackToDestructiveMigration()
                    .build();
        } else {
            return null;
        }
        return mInstance;
    }

    public static void destroyInstance() {
        mInstance = null;
    }
}
