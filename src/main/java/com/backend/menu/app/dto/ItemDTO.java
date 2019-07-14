package com.backend.menu.app.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemDTO implements Serializable {

    String name;

    Double approxPrice;

    String market;

    Boolean done;
}
