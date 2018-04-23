package za.co.projects.android.pmoloi.winterolympics.data.schedule;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

import za.co.projects.android.pmoloi.winterolympics.data.model.Schedule;

@Dao
public interface ScheduleDAO {

    @Query("SELECT * FROM Schedule")
    LiveData<List<Schedule>> getScheduleEntries();

    @Insert
    void insertScheduleEntries(Schedule... scheduleEntries);

    @Query("SELECT * FROM Schedule WHERE date = :date")
    LiveData<Schedule> findScheduleEntryByDate(Date date);

}
