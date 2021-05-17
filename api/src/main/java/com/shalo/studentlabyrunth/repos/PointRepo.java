package com.shalo.studentlabyrunth.repos;

import com.shalo.studentlabyrunth.domain.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface PointRepo extends CrudRepository <Point,Integer> {

    @Query (
            nativeQuery = true,
            value = "select p.id, p.name, p.x, p.y, p.status from point p" +
                    " join point_links pl on p.id = pl.point_id" +
                    " where way_id = ?1"
    )
    List<Point> findByMapID(Integer map_id);
}
