package za.co.projects.android.pmoloi.winterolympics.data.athlete;

import android.arch.lifecycle.LiveData;
import java.util.List;
import za.co.projects.android.pmoloi.winterolympics.data.model.Athlete;

public interface IAthleteRepository {

    LiveData<List<Athlete>> getAllAthletes();
    void insertAthletes(Athlete... athletes);
    LiveData<Athlete> findAthleteByNames(String firstName, String secondName);
}
