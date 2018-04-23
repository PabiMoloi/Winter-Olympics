package za.co.projects.android.pmoloi.winterolympics.data.sport;

import android.arch.lifecycle.LiveData;
import java.util.List;
import za.co.projects.android.pmoloi.winterolympics.data.model.Sport;

public interface ISportRepository {

    LiveData<List<Sport>> getAllSports();
    LiveData<Sport> findSportById(int id);
    void insertAll(Sport... sports);
}
