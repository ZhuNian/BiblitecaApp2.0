package com.twu;

/**
 * Created by ZN on 2015/6/5.
 */
public class Movie extends Item{
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
        System.out.print("name:" + name+";");
        System.out.print("year:" + year+";");
        System.out.print("director:"+director+";");
        System.out.println("movie_rating:"+movie_rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (director != null ? !director.equals(movie.director) : movie.director != null) return false;
        if (movie_rating != null ? !movie_rating.equals(movie.movie_rating) : movie.movie_rating != null) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (movie_rating != null ? movie_rating.hashCode() : 0);
        return result;
    }
}
