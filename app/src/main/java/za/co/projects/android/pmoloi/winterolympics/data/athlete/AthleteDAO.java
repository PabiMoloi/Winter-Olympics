package za.co.projects.android.pmoloi.winterolympics.data.athlete;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import za.co.projects.android.pmoloi.winterolympics.data.model.Athlete;

@Dao
public interface AthleteDAO {
    @Query("SELECT * FROM Athlete")
    LiveData<List<Athlete>> getAllAthletes();

    @Insert
    void insertAthletes(Athlete... athletes);

    @Query("SELECT * FROM Athlete WHERE firstName = :firstName AND secondName = :secondName")
    LiveData<Athlete> findAthleteByNames(String firstName, String secondName);
}
