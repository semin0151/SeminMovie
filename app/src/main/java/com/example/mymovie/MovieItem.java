package com.example.mymovie;

import java.text.DecimalFormat;

public class MovieItem {
    private String moiveRank;
    private String movieName;
    private String moviePeople;
    private String movieUpDown;
    private int flagColor = 0;

    public void setMoiveRank(String moiveRank) {
        this.moiveRank = moiveRank;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMoviePeople(String moviePeople) {
        DecimalFormat format = new DecimalFormat("###,###");
        this.moviePeople = "누적 관객 수 : " + format.format(Integer.parseInt(moviePeople)) + "명";
    }

    public void setMovieUpDown(String movieUpDown) {
        if( Integer.parseInt(movieUpDown) > 0 ) {
            this.movieUpDown = "↑" + movieUpDown;
            flagColor = 1;
        }
        else if ( Integer.parseInt(movieUpDown) < 0) {
            this.movieUpDown = "↓" + Integer.toString(Integer.parseInt(movieUpDown) * -1);
            flagColor = 2;
        }
        else
            this.movieUpDown = "―";

    }

    public String getMoiveRank() {
        return moiveRank;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMoviePeople() {
        return moviePeople;
    }

    public String getMovieUpDown() {
        return movieUpDown;
    }

    public int setColor(){
        return flagColor;
    }

}
