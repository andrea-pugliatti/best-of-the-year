package org.lessons.java.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("name", "Andrea");
        return "index";
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    private ArrayList<Movie> getBestMovies() {
        return new ArrayList<>(
                List.of(new Movie(123, "Movie 1"), new Movie(1233, "Movie 2"), new Movie(1234, "Movie 3")));
    }

    private ArrayList<Song> getBestSongs() {
        return new ArrayList<>(List.of(new Song(15353, "Song 1"), new Song(12, "Song 2"), new Song(3414, "Song 3")));
    }

}
