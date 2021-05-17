package com.shalo.studentlabyrunth.repos;

import com.shalo.studentlabyrunth.domain.Way;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WayRepo extends CrudRepository <Way,Integer> {

}
