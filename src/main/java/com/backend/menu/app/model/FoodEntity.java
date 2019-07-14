package com.backend.menu.app.model;

import lombok.Data;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Data
@Entity(name = "Food")
public class FoodEntity {

    @Id
    Long id;

    String name;

    Double approxPrice;

    String market;

    Boolean done;
}
