package za.co.projects.android.pmoloi.winterolympics.data.schedule;

import android.arch.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

import za.co.projects.android.pmoloi.winterolympics.data.model.Schedule;

public interface IScheduleRepository {

    LiveData<List<Schedule>> getScheduleEntries();
    void insertScheduleEntries(Schedule... scheduleEntries);
    LiveData<Schedule> findScheduleEntryByDate(Date date);
}
