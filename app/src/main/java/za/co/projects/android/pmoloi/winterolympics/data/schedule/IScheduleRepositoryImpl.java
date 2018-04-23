package za.co.projects.android.pmoloi.winterolympics.data.schedule;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

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
        new InsertAsyncTask(scheduleDAO).execute(scheduleEntries);
    }

    @Override
    public LiveData<Schedule> findScheduleEntryByDate(Date date) {
        return scheduleDAO.findScheduleEntryByDate(date);
    }

    private static class InsertAsyncTask extends AsyncTask<Schedule, Void, Void> {
        private ScheduleDAO asyncScheduleDao;

        InsertAsyncTask(ScheduleDAO scheduleDAO) {
            asyncScheduleDao = scheduleDAO;
        }

        @Override
        protected Void doInBackground(final Schedule... params) {
            asyncScheduleDao.insertScheduleEntries(params[0]);
            return null;
        }
    }
}
