package com.baylorcsi3372.assignment5;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.concurrent.atomic.AtomicLong;


@Entity
public class TvShow {

    private static final AtomicLong counter = new AtomicLong(0);

    @Id
    private Long id;
    private String title;
    private String runtime;
    private double rating;
    private int showYear;
    private int votes;

    public TvShow() {
        this.id = counter.incrementAndGet();
    }

    public TvShow(String title, String runtime, double rating, int showYear, int votes) {
        this.id = counter.incrementAndGet();
        this.title = title;
        this.runtime = runtime;
        this.rating = rating;
        this.showYear = showYear;
        this.votes = votes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getShowYear() {
        return showYear;
    }

    public void setShowYear(int showYear) {
        this.showYear = showYear;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
