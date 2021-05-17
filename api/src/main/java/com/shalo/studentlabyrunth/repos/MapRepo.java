package com.shalo.studentlabyrunth.repos;

import com.shalo.studentlabyrunth.domain.Map;
import org.springframework.data.repository.CrudRepository;

public interface MapRepo extends CrudRepository <Map,Integer> {

    Map findByName(String name);
}
