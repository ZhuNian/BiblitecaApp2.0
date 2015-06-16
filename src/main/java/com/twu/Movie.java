package com.twu;

/**
 * Created by 88888888 on 2015/6/16.
 */
public class Movie {
    private String name;
    private String year;
    private String director;
    private String movie_rating;

    public Movie(String name, String year, String director, String movie_rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movie_rating = movie_rating;
    }

    public void show() {
        System.out.print("name:" + "name"+";");
        System.out.print("year:" + year+";");
        System.out.print("director:"+director+";");
        System.out.println("movie_rating:"+movie_rating);
    }
}
