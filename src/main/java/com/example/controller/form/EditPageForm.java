package com.example.controller.form;

import com.example.entity.Page;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class EditPageForm {
    private int id;
    private String word;
    private String celebration;
    private String summation;
    private String contemplation;
    private String pray;

    public static EditPageForm from(Page page) {
        return EditPageForm.builder()
                .id(page.getId())
                .word(page.getWord())
                .celebration(page.getCelebration())
                .summation(page.getSummation())
                .contemplation(page.getContemplation())
                .pray(page.getPray())
                .build();
    }
}
