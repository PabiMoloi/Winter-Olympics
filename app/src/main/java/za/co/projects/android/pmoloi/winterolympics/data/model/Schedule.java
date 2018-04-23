package za.co.projects.android.pmoloi.winterolympics.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class Schedule {

    public Schedule(int id, Date date, String time, Sport[] sports) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.sports = sports;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
    public Sport[] getSports() {
        return sports;
    }

    @PrimaryKey
    private int id;
    private Date date;
    private String time;
    private Sport[] sports;

}
