package com.example.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class Page {
    private int id;
    private String word;
    private String celebration;
    private String summation;
    private String contemplation;
    private String pray;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
