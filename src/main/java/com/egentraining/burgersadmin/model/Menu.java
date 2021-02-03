package com.egentraining.burgersadmin.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "items")
public class Menu {
    @Id
    private @NonNull String name;
    private String description;
    private @NonNull Double price;
    private @NonNull String category;

}
