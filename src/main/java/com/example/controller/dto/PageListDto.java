package com.example.controller.dto;

import com.example.entity.Page;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class PageListDto {
    private List<PageDto> pageList;

    public static PageListDto from(List<Page> pageList) {
        return PageListDto.builder()
                .pageList(pageList.stream()
                        .map(PageListDto::from)
                        .collect(java.util.stream.Collectors.toList()))
                .build();
    }

    @Builder
    @Getter
    public static class PageDto {
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

    private static PageDto from(Page page){
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
