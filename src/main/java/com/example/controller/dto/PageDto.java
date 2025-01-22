package com.example.controller.dto;

import com.example.entity.Page;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PageDto {
    private int id;
    private String word;
    private String celebration;
    private String summation;
    private String contemplation;
    private String pray;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PageDto from(Page page){
        return PageDto.builder()
                .id(page.getId())
                .word(page.getWord())
                .celebration(page.getCelebration())
                .summation(page.getSummation())
                .contemplation(page.getContemplation())
                .pray(page.getPray())
                .image(page.getImage())
                .createdAt(page.getCreatedAt())
                .updatedAt(page.getUpdatedAt())
                .build();
    }
}
