package za.co.projects.android.pmoloi.winterolympics.data.schedule;

import android.arch.lifecycle.LiveData;
import java.util.Date;
import java.util.List;
import za.co.projects.android.pmoloi.winterolympics.data.model.Schedule;

public class IScheduleRepositoryImpl implements IScheduleRepository {

    private ScheduleDAO scheduleDAO;

    public IScheduleRepositoryImpl(ScheduleDAO scheduleDAO) {
        this.scheduleDAO = scheduleDAO;
    }

    @Override
    public LiveData<List<Schedule>> getScheduleEntries() {
        return scheduleDAO.getScheduleEntries();
    }

    @Override
    public void insertScheduleEntries(Schedule... scheduleEntries) {
        scheduleDAO.insertScheduleEntries(scheduleEntries);
    }

    @Override
    public LiveData<Schedule> findScheduleEntryByDate(Date date) {
        return scheduleDAO.findScheduleEntryByDate(date);
    }
}
