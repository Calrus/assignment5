package com.baylorcsi3372.assignment5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TvShowRepository extends JpaRepository<TvShow, Long> {
    @Query(value = "SELECT * FROM tv_show ORDER BY rating DESC, votes DESC LIMIT :count", nativeQuery = true)
    List<TvShow> findTopTvShows(@Param("count") int count);
}
