package com.backend.menu.app.repository;

import com.backend.menu.app.model.FoodEntity;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends DatastoreRepository<FoodEntity, Long>{

    List<FoodEntity> findByName(String name);

}
