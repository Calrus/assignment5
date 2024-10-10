package com.baylorcsi3372.assignment5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TvShowController {

    @Autowired
    private TvShowRepository tvShowRepository;

    @GetMapping("/initialize")
    public List<TvShow> initializeDatabase() {
        String csvFile = "tv_shows_data.csv";
        String line;
        String csvSplitBy = ",";

        List<TvShow> tvShows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                TvShow tvShow = new TvShow();
                tvShow.setTitle(data[0]);
                tvShow.setShowYear(Integer.parseInt(data[1]));
                tvShow.setRuntime(data[2]);
                tvShow.setRating(Double.parseDouble(data[3]));
                tvShow.setVotes(Integer.parseInt(data[4]));

                tvShowRepository.save(tvShow);

                tvShows.add(tvShow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tvShows;
    }

    @GetMapping("/top_tv_show")
    public List<TvShow> getTopTvShows(@RequestParam(name = "count", required = false, defaultValue = "10") int count) {
        return tvShowRepository.findTopTvShows(count);
    }


}
