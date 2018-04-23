package za.co.projects.android.pmoloi.winterolympics.data.sport;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
import za.co.projects.android.pmoloi.winterolympics.data.model.Sport;

@Dao
public interface SportDAO {

    @Query("SELECT * FROM Sport")
    LiveData<List<Sport>> getAllSports();

    @Insert
    void insertAll(Sport... sports);

    @Query("SELECT * FROM Sport WHERE id = :id")
    LiveData<Sport> findSportById(int id);
}
