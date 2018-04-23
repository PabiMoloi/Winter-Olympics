package za.co.projects.android.pmoloi.winterolympics.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Sport {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public Sport(int id, String sportName) {
        this.id = id;
        this.sportName = sportName;
    }

    public int getId() {
        return id;
    }

    public String getSportName() {
        return sportName;
    }

    private String sportName;
}

