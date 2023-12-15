package com.example.hygimeter.controller.types;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FileScore {
    // Getters and setters
    private String file;
    private float score;

    // No-argument constructor
    public FileScore() {}

    // Constructor
    public FileScore(String file, float score) {
        this.file = file;
        this.score = score;
    }

    // Optionally, override toString, equals, and hashCode methods
}
