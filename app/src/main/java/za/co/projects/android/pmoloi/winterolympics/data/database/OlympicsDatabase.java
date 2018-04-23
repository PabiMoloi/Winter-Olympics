package za.co.projects.android.pmoloi.winterolympics.data.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

import za.co.projects.android.pmoloi.winterolympics.data.athlete.AthleteDAO;
import za.co.projects.android.pmoloi.winterolympics.data.model.Athlete;
import za.co.projects.android.pmoloi.winterolympics.data.model.Schedule;
import za.co.projects.android.pmoloi.winterolympics.data.model.Sport;
import za.co.projects.android.pmoloi.winterolympics.data.schedule.ScheduleDAO;
import za.co.projects.android.pmoloi.winterolympics.data.sport.SportDAO;

@Database(entities = {Athlete.class, Schedule.class, Sport.class}, version = 1, exportSchema = false)
public abstract class OlympicsDatabase extends RoomDatabase {

    private static OlympicsDatabase INSTANCE;

    public abstract AthleteDAO athleteDAO();
    public abstract SportDAO sportDAO();
    public abstract ScheduleDAO scheduleDAO();

    public synchronized static OlympicsDatabase getINSTANCE(Context context){
        if(INSTANCE == null)
        {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static OlympicsDatabase buildDatabase(final Context context){
        return Room.databaseBuilder(context,
                OlympicsDatabase.class,
                "olympic-database")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getINSTANCE(context).sportDAO().insertAll();
                                getINSTANCE(context).athleteDAO().insertAthletes();
                                getINSTANCE(context).scheduleDAO().insertScheduleEntries();

                            }
                        });
                    }
                })
                .build();
    }
}
