package za.co.projects.android.pmoloi.winterolympics.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import za.co.projects.android.pmoloi.winterolympics.data.utils.Country;
import za.co.projects.android.pmoloi.winterolympics.data.utils.Medal;

@Entity
public class Athlete {

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Country getCountry() {
        return country;
    }

    public Sport getSport() {
        return sport;
    }

    public String getBiography() {
        return biography;
    }

    public Medal getMedal() {
        return medal;
    }

    public int getPoints() {
        return points;
    }

    @PrimaryKey
    private int id;
    private String firstName;
    private String secondName;
    private Country country;
    private Sport sport;
    private String biography;
    private Medal medal;
    private int points;

    public Athlete(int id, String firstName, String secondName, Country country, Sport sport, String biography, Medal medal, int points) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.country = country;
        this.sport = sport;
        this.biography = biography;
        this.medal = medal;
        this.points = points;
    }
}
