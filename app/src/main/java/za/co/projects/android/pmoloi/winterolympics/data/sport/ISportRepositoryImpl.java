package za.co.projects.android.pmoloi.winterolympics.data.sport;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import za.co.projects.android.pmoloi.winterolympics.data.model.Sport;

public class ISportRepositoryImpl implements ISportRepository {

    private SportDAO sportDAO;

    public ISportRepositoryImpl(SportDAO sportDAO) {
        this.sportDAO = sportDAO;
    }

    @Override
    public LiveData<List<Sport>> getAllSports() {
        return sportDAO.getAllSports();
    }

    @Override
    public LiveData<Sport> findSportById(int id) {
        return sportDAO.findSportById(id);
    }

    @Override
    public void insertAll(Sport... sports) {
        new InsertAsyncTask(sportDAO).execute(sports);
    }

    private static class InsertAsyncTask extends AsyncTask<Sport, Void, Void> {
        private SportDAO asyncSportDao;

        InsertAsyncTask(SportDAO sportDAO) {
            asyncSportDao = sportDAO;
        }

        @Override
        protected Void doInBackground(final Sport... params) {
            asyncSportDao.insertAll(params[0]);
            return null;
        }
    }

}
