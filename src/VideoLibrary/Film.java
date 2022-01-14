package VideoLibrary;

import java.util.Date;

public class Film {

    private String name;
    private String country;
    private Date date;
    private String actors;
    private String producers;

    public Film(String name, String country, Date date, String actors, String producers) {
        this.name = name;
        this.country = country;
        this.date = date;
        this.actors = actors;
        this.producers = producers;
    }

    @Override
    public String toString() {
        return "Film name: " + name + '\n' +
                "Country: " + country + '\n' +
                "Date: " + date + '\n' +
                "Actors: " + actors + '\n' +
                "Producers: " + producers;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getActors() {
        return actors;
    }
    public void setActors(String actors) {
        this.actors = actors;
    }
    public String getProducers() {
        return producers;
    }
    public void setProducers(String producers) {
        this.producers = producers;
    }
}
