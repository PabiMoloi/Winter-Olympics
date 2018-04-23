package za.co.projects.android.pmoloi.winterolympics.data.athlete;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import java.util.List;
import za.co.projects.android.pmoloi.winterolympics.data.model.Athlete;

public class IAthleteRepositoryImpl implements IAthleteRepository {

    private AthleteDAO athleteDAO;

    @Override
    public LiveData<List<Athlete>> getAllAthletes() {
        return athleteDAO.getAllAthletes();
    }

    @Override
    public void insertAthletes(Athlete... athletes) {
        new InsertAsyncTask(athleteDAO).execute(athletes);
    }

    @Override
    public LiveData<Athlete> findAthleteByNames(String firstName, String secondName) {
        return athleteDAO.findAthleteByNames(firstName,secondName);
    }

    private static class InsertAsyncTask extends AsyncTask<Athlete, Void, Void> {
        private AthleteDAO asyncAthleteDao;

        InsertAsyncTask(AthleteDAO athleteDAO) {
            asyncAthleteDao = athleteDAO;
        }

        @Override
        protected Void doInBackground(final Athlete... params) {
            asyncAthleteDao.insertAthletes(params[0]);
            return null;
        }
    }
}
