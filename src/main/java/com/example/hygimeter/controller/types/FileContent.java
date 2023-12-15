package com.example.hygimeter.controller.types;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class FileContent {
    // Getters and setters
    private String name;
    private String content;
    private String video;
    private String image;
    private Map<String, String> parameters;

    // No-argument constructor
    public FileContent() {}

    // Constructor
    public FileContent(String name, String content, String video, String image, Map<String, String> parameters) {
        this.name = name;
        this.content = content;
        this.video = video;
        this.image = image;
        this.parameters = parameters;
    }

    // Optionally, override toString, equals, and hashCode methods
}
