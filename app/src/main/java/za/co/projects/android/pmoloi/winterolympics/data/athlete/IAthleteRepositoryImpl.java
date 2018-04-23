package za.co.projects.android.pmoloi.winterolympics.data.athlete;

import android.arch.lifecycle.LiveData;
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
        athleteDAO.insertAthletes(athletes);
    }

    @Override
    public LiveData<Athlete> findAthleteByNames(String firstName, String secondName) {
        return athleteDAO.findAthleteByNames(firstName,secondName);
    }
}
